package org.librucha.lamer.pagging;

import android.app.Activity;
import android.support.v4.app.FragmentStatePagerAdapter;
import org.librucha.lamer.R;
import org.librucha.lamer.quote.QuoteFragment;
import org.librucha.lamer.storage.QuoteRegister;

import java.util.Locale;

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
	return QuoteFragment.newInstance(position);
  }

  @Override
  public int getCount() {
	return QuoteRegister.getInstance().getQuotesCount();
  }

  @Override
  public CharSequence getPageTitle(int position) {
	Locale l = Locale.getDefault();
	return activity.getString(R.string.title_section, QuoteRegister.getInstance().getQuote(position).getId()).toUpperCase(l);
  }
}
