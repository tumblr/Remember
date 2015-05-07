package com.tumblr.remembersample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.tumblr.remember.Remember;

/**
 * A simple activity that counts how many times it's been resumed via {@link Remember}.
 */
public class RememberSample extends ActionBarActivity {

	private static final String KEY = "test_key";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_remember_sample);
	}

	@Override
	protected void onResume() {
		super.onResume();

		int howMany = Remember.getInt(KEY, 1);

		TextView textView = (TextView) findViewById(R.id.text_view);
		String testString = getApplicationContext().getResources().getQuantityString(R.plurals.youve_resumed, howMany,
				howMany);
		textView.setText(testString);

		Remember.putInt(KEY, howMany + 1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_remember_sample, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
