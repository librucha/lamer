package org.librucha.lamer;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import org.librucha.lamer.domain.Quote;
import org.librucha.lamer.navigation.PlaceholderFragment;
import org.librucha.lamer.pagging.SectionsPagerAdapter;
import org.librucha.lamer.storage.DatabaseHelper;

import java.util.List;

public class MainActivity extends FragmentActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {

  /**
   * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
   */
  private NavigationDrawerFragment navigationDrawerFragment;

  /**
   * Used to store the last screen title. For use in {@link #restoreActionBar()}.
   */
  private CharSequence lastTitle;

  private SectionsPagerAdapter sectionsPagerAdapter;
  private ViewPager viewPager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);

	navigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.navigation_drawer);
	lastTitle = getTitle();

	// Set up the drawer.
	navigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));

	// Create the adapter that will return a fragment for each of the primary sections of the activity.
	sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());

	// Set up the ViewPager with the sections adapter.
	viewPager = (ViewPager) findViewById(R.id.pager);
	viewPager.setAdapter(sectionsPagerAdapter);

	DatabaseHelper helper = new DatabaseHelper(this);
	RuntimeExceptionDao<Quote, Integer> quoteDataDao = helper.getQuoteDataDao();
	List<Quote> quotes = quoteDataDao.queryForAll();
	System.out.println(quotes);
	helper.close();
  }

  @Override
  public void onNavigationDrawerItemSelected(int position) {
	// update the main content by replacing fragments
	FragmentManager fragmentManager = getFragmentManager();
	fragmentManager.beginTransaction()
			.replace(R.id.pager, PlaceholderFragment.newInstance(position + 1))
			.commit();
  }

  public void onSectionAttached(int number) {
	switch (number) {
	  case 1:
		lastTitle = getString(R.string.title_newest);
		break;
	  case 2:
		lastTitle = getString(R.string.title_best);
		break;
	  case 3:
		lastTitle = getString(R.string.title_random);
		break;
	  case 4:
		lastTitle = getString(R.string.title_all);
		break;
	  case 5:
		lastTitle = getString(R.string.title_queue);
		break;
	}
	Toast.makeText(this, lastTitle, Toast.LENGTH_SHORT).show();
  }

  public void restoreActionBar() {
	ActionBar actionBar = getActionBar();
	actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
	actionBar.setDisplayShowTitleEnabled(true);
	actionBar.setTitle(lastTitle);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
	if (!navigationDrawerFragment.isDrawerOpen()) {
	  // Only show items in the action bar relevant to this screen
	  // if the drawer is not showing. Otherwise, let the drawer
	  // decide what to show in the action bar.
	  getMenuInflater().inflate(R.menu.main, menu);
	  restoreActionBar();
	  return true;
	}
	return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
	// Handle action bar item clicks here. The action bar will
	// automatically handle clicks on the Home/Up button, so long
	// as you specify a parent activity in AndroidManifest.xml.
	int id = item.getItemId();
	if (id == R.id.action_settings) {
	  return true;
	}
	return super.onOptionsItemSelected(item);
  }

  public void openSettings(MenuItem item) {
	Intent intent = new Intent(this, SettingsActivity.class);
	startActivity(intent);
  }
}
