package org.librucha.lamer.quote;

import android.os.Bundle;
import android.view.*;
import android.widget.TextView;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import org.librucha.lamer.R;
import org.librucha.lamer.domain.Quote;
import org.librucha.lamer.storage.DatabaseHelper;
import org.librucha.lamer.storage.QuoteRegister;

import java.util.List;

public class QuoteFragment extends android.support.v4.app.Fragment {
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
	((TextView) rootView.findViewById(R.id.quote_text)).setText(QuoteRegister.getInstance().getQuote(getArguments().getInt(ARG_SECTION_NUMBER)).getText());
	return rootView;
  }
}
