package org.librucha.lamer.home;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.*;
import org.librucha.lamer.R;

public class HomeFragment extends Fragment {

  public static HomeFragment newInstance() {
	HomeFragment fragment = new HomeFragment();
	return fragment;
  }

  public HomeFragment() {
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	View rootView = inflater.inflate(R.layout.fragment_home, container, false);
	return rootView;
  }

  @Override
  public void onAttach(Activity activity) {
	super.onAttach(activity);
  }
}
