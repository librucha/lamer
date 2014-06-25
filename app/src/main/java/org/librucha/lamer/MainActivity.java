package org.librucha.lamer;

import android.app.*;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.*;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

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
	sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

	// Set up the ViewPager with the sections adapter.
	viewPager = (ViewPager) findViewById(R.id.pager);
	viewPager.setAdapter(sectionsPagerAdapter);
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

  /**
   * A placeholder fragment containing a simple view.
   */
  public static class PlaceholderFragment extends Fragment {
	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	private static final String ARG_SECTION_NUMBER = "section_number";

	/**
	 * Returns a new instance of this fragment for the given section
	 * number.
	 */
	public static PlaceholderFragment newInstance(int sectionNumber) {
	  PlaceholderFragment fragment = new PlaceholderFragment();
	  Bundle args = new Bundle();
	  args.putInt(ARG_SECTION_NUMBER, sectionNumber);
	  fragment.setArguments(args);
	  return fragment;
	}

	public PlaceholderFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	  View rootView = inflater.inflate(R.layout.fragment_main, container, false);
	  return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
	  super.onAttach(activity);
	  ((MainActivity) activity).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER));
	}
  }

  /**
   * A {@link android.support.v13.app.FragmentPagerAdapter} that returns a fragment corresponding to
   * one of the sections/tabs/pages.
   */
  public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

	public SectionsPagerAdapter(android.support.v4.app.FragmentManager fm) {
	  super(fm);
	}

	@Override
	public android.support.v4.app.Fragment getItem(int position) {
	  // getItem is called to instantiate the fragment for the given page.
	  // Return a PlaceholderFragment (defined as a static inner class below).
	  return QuoteFragment.newInstance(position + 1);
	}

	@Override
	public int getCount() {
	  return 100;
	}

	@Override
	public CharSequence getPageTitle(int position) {
	  Locale l = Locale.getDefault();
	  return getString(R.string.title_section, position).toUpperCase(l);
	}
  }

  public static class QuoteFragment extends android.support.v4.app.Fragment {
	/**
	 * The fragment argument representing the section number for this fragment.
	 */
	private static final String ARG_SECTION_NUMBER = "section_number";

	/**
	 * Returns a new instance of this fragment for the given section number.
	 */
	public static QuoteFragment newInstance(int sectionNumber) {
	  QuoteFragment fragment = new QuoteFragment();
	  Bundle args = new Bundle();
	  args.putInt(ARG_SECTION_NUMBER, sectionNumber);
	  fragment.setArguments(args);
	  return fragment;
	}

	public QuoteFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	  View rootView = inflater.inflate(R.layout.fragment_quote, container, false);
	  ((TextView) rootView.findViewById(R.id.quoteText)).setText(getString(R.string.title_section, getArguments().getInt(ARG_SECTION_NUMBER)));
	  return rootView;
	}
  }
}
