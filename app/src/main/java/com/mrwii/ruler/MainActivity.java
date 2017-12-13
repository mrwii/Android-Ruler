package com.mrwii.ruler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

	@BindView(R.id.tv_info)
	TextView mInfo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		ButterKnife.bind(this);

		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int width = dm.widthPixels;
		int height = dm.heightPixels;
		double wi = (double) width / (double) dm.xdpi;
		double hi = (double) height / (double) dm.ydpi;
		double x = Math.pow(wi, 2);
		double y = Math.pow(hi, 2);
		double screenInches = Math.sqrt(x + y);
//		double inches = round(screenInches);

		mInfo.setText(Html.fromHtml("Density: <b>" + getString(R.string.density) + "</b><br /><br />" +
				width + " x " + height + " pixels<br /><br />" +
				round(screenInches, 2) + " inch"));
	}

	public static double round(double value, int places) {
		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}
}
