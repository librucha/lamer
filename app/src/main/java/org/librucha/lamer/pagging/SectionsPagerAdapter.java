package org.librucha.lamer.pagging;

import android.app.Activity;
import android.support.v4.app.FragmentStatePagerAdapter;
import org.librucha.lamer.R;
import org.librucha.lamer.home.HomeFragment;
import org.librucha.lamer.quote.QuoteFragment;
import org.librucha.lamer.storage.QuoteRepository;

/**
 * A {@link android.support.v13.app.FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

  private Activity activity;

  public SectionsPagerAdapter(Activity activity, android.support.v4.app.FragmentManager fm) {
	super(fm);
	this.activity = activity;
  }

  @Override
  public android.support.v4.app.Fragment getItem(int position) {
	if (position == 0) {
	  return HomeFragment.newInstance();
	}
	return QuoteFragment.newInstance(position + 1);
  }

  @Override
  public int getCount() {
	return QuoteRepository.getInstance(activity).getQuotesCount();
  }

  @Override
  public CharSequence getPageTitle(int position) {
	if (position == 0) {
	  return activity.getString(R.string.title_home);
	}
	return activity.getString(R.string.title_section, QuoteRepository.getInstance(activity).getQuote(position + 1).getId());
  }
}
