package org.librucha.lamer.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import org.librucha.lamer.R;
import org.librucha.lamer.domain.Quote;

import java.sql.SQLException;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

  private static final String DATABASE_NAME = "lamer.cz.db";
  private static final int DATABASE_VERSION = 1;

  // the DAO object we use to access the Quote table
  private Dao<Quote, Integer> quoteDao = null;
  private RuntimeExceptionDao<Quote, Integer> quoteRuntimeDao = null;

  public DatabaseHelper(Context context) {
	super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
  }

  /**
   * This is called when the database is first created. Usually you should call createTable statements here to create
   * the tables that will store your data.
   */
  @Override
  public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
	try {
	  Log.i(DatabaseHelper.class.getName(), "onCreate");
	  TableUtils.createTable(connectionSource, Quote.class);
	} catch (SQLException e) {
	  Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
	  throw new RuntimeException(e);
	}

	// here we try inserting data in the on-create as a test
	RuntimeExceptionDao<Quote, Integer> dao = getQuoteDataDao();
	long millis = System.currentTimeMillis();
	// create some entries in the onCreate
	Quote quote = new Quote();
	quote.setId(0);
	quote.setText("Lorem ipsum");
	dao.create(quote);
	Log.i(DatabaseHelper.class.getName(), "created new entries in onCreate: " + millis);
  }

  /**
   * This is called when your application is upgraded and it has a higher version number. This allows you to adjust
   * the various data to match the new version number.
   */
  @Override
  public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
	try {
	  Log.i(DatabaseHelper.class.getName(), "onUpgrade");
	  TableUtils.dropTable(connectionSource, Quote.class, true);
	  // after we drop the old databases, we create the new ones
	  onCreate(db, connectionSource);
	} catch (SQLException e) {
	  Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
	  throw new RuntimeException(e);
	}
  }

  /**
   * Returns the Database Access Object (DAO) for our SimpleData class. It will create it or just give the cached
   * value.
   */
  public Dao<Quote, Integer> getDao() throws SQLException {
	if (quoteDao == null) {
	  quoteDao = getDao(Quote.class);
	}
	return quoteDao;
  }

  /**
   * Returns the RuntimeExceptionDao (Database Access Object) version of a Dao for our SimpleData class. It will
   * create it or just give the cached value. RuntimeExceptionDao only through RuntimeExceptions.
   */
  public RuntimeExceptionDao<Quote, Integer> getQuoteDataDao() {
	if (quoteRuntimeDao == null) {
	  quoteRuntimeDao = getRuntimeExceptionDao(Quote.class);
	}
	return quoteRuntimeDao;
  }

  /**
   * Close the database connections and clear any cached DAOs.
   */
  @Override
  public void close() {
	super.close();
	quoteDao = null;
	quoteRuntimeDao = null;
  }
}