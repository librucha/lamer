package org.librucha.lamer.storage;

import android.content.Context;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import org.librucha.lamer.domain.Quote;
import org.librucha.lamer.harvest.HtmlParser;

public class QuoteRepository {

  private final HtmlParser htmlParser = HtmlParser.getInstance();
  private RuntimeExceptionDao<Quote, Integer> quoteDataDao;

  private QuoteRepository(Context context) {
	quoteDataDao = new DatabaseHelper(context).getQuoteDataDao();
  }

  public Quote getQuote(int quoteNumber) {
	Quote quote = quoteDataDao.queryForId(quoteNumber);
	if (quote == null) {
	  quote = htmlParser.parseOneQuote(quoteNumber);
	  quoteDataDao.createIfNotExists(quote);
	}
	return quote;
  }

  public int getQuotesCount() {
	return 100;
  }

  private static class SingletonHolder {
	public static final QuoteRepository INSTANCE(Context context) {
	  return new QuoteRepository(context);
	}
  }

  public static QuoteRepository getInstance(Context context) {
	QuoteRepository quoteRepository = SingletonHolder.INSTANCE(context);
	return quoteRepository;
  }
}