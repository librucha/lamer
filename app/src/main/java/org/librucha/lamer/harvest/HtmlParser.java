package org.librucha.lamer.harvest;

import org.htmlcleaner.*;
import org.librucha.lamer.domain.Quote;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HtmlParser {

  private HtmlParser() {
  }

  public Map<Integer, Quote> parseHtml(String url) throws IOException {

	URL source = new URL(url);
	Map<Integer, Quote> quotes = new HashMap<Integer, Quote>(10);

	CleanerProperties props = new CleanerProperties();
	props.setTranslateSpecialEntities(true);
	props.setTransResCharsToNCR(true);
	props.setOmitComments(true);

	TagNode page = new HtmlCleaner(props).clean(source);
	TagNode[] quotesDiv = page.getElementsByAttValue("id", "quotes", true, false);
	TagNode[] quoteDivs = quotesDiv[0].getElementsByName("div", false);
	for (TagNode quoteDiv : quoteDivs) {
	  if (!"square".equals(quoteDiv.getAttributeByName("class"))) {
		int quoteId = getQuoteId(quoteDiv);
		String text = getQuoteText(quoteDiv);

		Quote quote = new Quote(quoteId, text);
		quotes.put(quoteId, quote);
	  }
	}

	return quotes;
  }

  public int getLastQuote(String url) {
	// TODO Implemetnt it!
	return 72392;
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