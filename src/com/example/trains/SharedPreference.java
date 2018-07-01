package com.example.trains;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPreference {

	public static final String PREFS_NAME = "Gamer_DATA";
	public static final String LOg_VALID = "valid";
	public static final String STUDENT_NAME = "name";
	public static final String STUDENT_PASSWORD = "pass";
	public static final String STUDENT_EMAIL = "email";
	public static final String STUDENT_lang = "lang";

	public SharedPreference() {
		super();
	}

	public void save(Context context, String name, String email, String pass, String v) {
		SharedPreferences settings;
		Editor editor;
		settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); // 1
		editor = settings.edit(); // 2
		editor.putString(STUDENT_NAME, name); // 3
		editor.putString(STUDENT_EMAIL, email);
		editor.putString(STUDENT_PASSWORD, pass);
		editor.putString(LOg_VALID, v);
		editor.commit(); // 4
	}

	public void setlangValue(Context context, String lang) {
		SharedPreferences settings;
		Editor editor;
		// settings = PreferenceManager.getDefaultSharedPreferences(context);
		settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); // 1
		editor = settings.edit(); // 2
		editor.putString(STUDENT_lang, lang); // 3

		editor.commit(); // 4

	}

	public void setValid(Context context) {
		SharedPreferences settings;
		Editor editor;

		settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		editor = settings.edit();

		editor.remove(LOg_VALID);
		editor.putString(LOg_VALID, "0");
		editor.commit();

	}

	public String getnameValue(Context context) {
		SharedPreferences settings;
		String text;
		settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		text = settings.getString(STUDENT_NAME, null);
		return text;
	}

	public String getpassValue(Context context) {
		SharedPreferences settings;
		String text;

		// settings = PreferenceManager.getDefaultSharedPreferences(context);
		settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		text = settings.getString(STUDENT_PASSWORD, null);
		return text;
	}

	public String getlangValue(Context context) {
		SharedPreferences settings;
		String text;

		// settings = PreferenceManager.getDefaultSharedPreferences(context);
		settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		text = settings.getString(STUDENT_lang, null);
		return text;
	}

	public String getemailValue(Context context) {
		SharedPreferences settings;
		String text;

		// settings = PreferenceManager.getDefaultSharedPreferences(context);
		settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		text = settings.getString(STUDENT_EMAIL, null);
		return text;
	}

	public String getvalidValue(Context context) {
		SharedPreferences settings;
		String text;

		// settings = PreferenceManager.getDefaultSharedPreferences(context);
		settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		text = settings.getString(LOg_VALID, null);
		return text;
	}

	public void clearSharedPreference(Context context) {
		SharedPreferences settings;
		Editor editor;

		// settings = PreferenceManager.getDefaultSharedPreferences(context);
		settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		editor = settings.edit();

		editor.clear();
		editor.commit();
	}

	public void removeValid(Context context) {
		SharedPreferences settings;
		Editor editor;

		settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		editor = settings.edit();

		editor.remove(LOg_VALID);
		editor.putString(LOg_VALID, "1");
		editor.commit();
	}
}