package com.zoe.ideaspace;

import android.app.Application;

public class MyApplication extends Application {
	public DataModel dataModel;
	@Override
	public void onCreate() {
		super.onCreate();
		dataModel = new DataModel();
	}
}
