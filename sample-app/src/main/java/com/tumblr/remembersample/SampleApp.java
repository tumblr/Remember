package com.tumblr.remembersample;

import android.app.Application;
import com.tumblr.remember.Remember;

/**
 * Created by mlapadula on 5/6/15.
 */
public class SampleApp extends Application {

	private static final String PREFS_NAME = "com.remember.example";

	@Override
	public void onCreate() {
		super.onCreate();

		Remember.init(getApplicationContext(), PREFS_NAME);
	}
}
