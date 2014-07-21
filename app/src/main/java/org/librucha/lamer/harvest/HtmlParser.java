package org.librucha.lamer.harvest;

import org.htmlcleaner.*;
import org.librucha.lamer.domain.Quote;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import static java.lang.String.format;

public class HtmlParser {

  private HtmlParser() {
  }

  public void getIndex() throws IOException {
	Set<Integer> quoteIds = new TreeSet<Integer>();
	getOnePageIndex(quoteIds, "http://www.lamer.cz/quote/latest/", 1);
  }

  private void getOnePageIndex(Set<Integer> quoteIds, String url, int pageNumber) throws IOException {
	URL source = new URL(url + pageNumber);
	TagNode page = new HtmlCleaner(createProperties()).clean(source);
	List<TagNode> quotes = new ArrayList<TagNode>(10);
	quotes.add(page.findElementByAttValue("class", "quote first", true, false));
	quotes.addAll(page.getElementListByAttValue("class", "quote", true, false));
	for (TagNode quoteDiv : quotes) {
	  quoteIds.add(getQuoteId(quoteDiv));
	}
	TagNode next = page.findElementByAttValue("rel", "next", true, false);
	if (next != null) {
	  String href = next.getAttributeByName("href");
	  int nextPageNumber = Integer.valueOf(href.substring(href.lastIndexOf("/") + 1));
	  getOnePageIndex(quoteIds, url, nextPageNumber);
	}
  }

  public Quote parseOneQuote(int quoteNumber) {
	try {
	  URL source = new URL("http://www.lamer.cz/quote/" + quoteNumber);
	  TagNode page = new HtmlCleaner(createProperties()).clean(source);
	  TagNode quoteDiv = page.findElementByAttValue("class", "quote", true, false);
	  int id = getQuoteId(quoteDiv);
	  String text = getQuoteText(quoteDiv);
	  return new Quote(id, text);
	} catch (IOException e) {
	  throw new RuntimeException(format("Error during parse quote number %s", quoteNumber));
	}
  }

  private CleanerProperties createProperties() {
	CleanerProperties props = new CleanerProperties();
	props.setTranslateSpecialEntities(true);
	props.setTransResCharsToNCR(true);
	props.setOmitComments(true);

	return props;
  }

  private int getQuoteId(TagNode quoteDiv) {
	TagNode[] heading = quoteDiv.getElementsByAttValue("class", "heading", false, false);
	CharSequence header = heading[0].getElementsByName("a", true)[0].getText();
	return Integer.valueOf(header.toString().substring(1)).intValue();
  }

  private String getQuoteText(TagNode quoteDiv) {
	return quoteDiv.getElementsByAttValue("class", "text", true, false)[0].getText().toString();
  }

  private static class SingletonHolder {
	public static final HtmlParser INSTANCE = new HtmlParser();
  }

  public static HtmlParser getInstance() {
	return SingletonHolder.INSTANCE;
  }
}