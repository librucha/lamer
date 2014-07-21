package org.librucha.lamer;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.*;

public class OfflineActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
	setContentView(R.layout.activity_offline);
	if (savedInstanceState == null) {
	  getFragmentManager().beginTransaction()
			  .add(R.id.container, new PlaceholderFragment())
			  .commit();
	}
  }

  public void startDownloading(View view) {
	setProgressBarIndeterminateVisibility(true);
  }

  public static class PlaceholderFragment extends Fragment {

	public PlaceholderFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	  View rootView = inflater.inflate(R.layout.fragment_offline, container, false);
	  return rootView;
	}
  }
}
