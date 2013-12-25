package com.zoe.weather;

import java.io.IOException;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.zoe.date.AutoCompleteAdater;
import com.zoe.date.DataBaseHelper;
import com.zoe.slidingmenu.view.SlidingMenu;
import com.zoe.slidingmenu.view.SlidingState;

public class MainActivity extends Activity {

	private SlidingMenu slidingMenu;
	private SharedPreferences preferences;
	private SharedPreferences.Editor editor;
	private TextView dataText, cityName, temp, temp1,weatherText,windText,humidityText,uvbText,tourText;
	private String title[] = { "1111", "2222" };
	private MyApplication application;
	private Renew_2 renew_2;
	private Renew_1 renew_1;
	private Renew_3 renew_3;
	private DataBaseHelper myDbHelper;
	private AutoCompleteTextView autoCompleteTextView;
	private Button searchButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.home);

		preferences = getSharedPreferences("zoe", MODE_PRIVATE);
		editor = preferences.edit();

		// ���ݿ��ʼ��
		myDbHelper = new DataBaseHelper(this);
		try {
			myDbHelper.createDataBase();
			myDbHelper.openDataBase();
		} catch (IOException ioe) {
			throw new Error("Unable to create database");
		}

		application = (MyApplication) getApplication();
		slidingMenu = (SlidingMenu) findViewById(R.id.slidingMenu);
		ViewGroup leftView = (ViewGroup) getLayoutInflater().inflate(
				R.layout.left_v, null);
		ViewGroup rightView = (ViewGroup) getLayoutInflater().inflate(
				R.layout.right_v, null);
		ViewGroup centerView = (ViewGroup) getLayoutInflater().inflate(
				R.layout.center_v, null);
		autoCompleteTextView = (AutoCompleteTextView) rightView
				.findViewById(R.id.autoCompleteTextView);
		dataText = (TextView) centerView.findViewById(R.id.dataView);
		cityName = (TextView) centerView.findViewById(R.id.cityView);
		temp = (TextView) centerView.findViewById(R.id.temperature);
		temp1 = (TextView) centerView.findViewById(R.id.temperatureText);
		weatherText = (TextView) centerView.findViewById(R.id.weatherText);
		windText = (TextView) centerView.findViewById(R.id.windText);
		humidityText = (TextView) centerView.findViewById(R.id.humidityText);
		uvbText = (TextView) centerView.findViewById(R.id.uvbText);
		tourText = (TextView) centerView.findViewById(R.id.tourText);
		
		slidingMenu.setCenterView(centerView);
		int leftWidth = (int) getResources()
				.getDimension(R.dimen.leftViewWidth);
		int rightWidth = (int) getResources().getDimension(
				R.dimen.rightViewWidth);
		slidingMenu.setLeftView(leftView, leftWidth);
		slidingMenu.setRightView(rightView, rightWidth);
		searchButton = (Button) rightView.findViewById(R.id.search);

		// ��ʼ���Զ���ȫ��
		AutoCompleteAdater cursorAdapter = new AutoCompleteAdater(this,
				android.R.layout.simple_dropdown_item_1line, null, "name",
				android.R.id.text1, myDbHelper);
		autoCompleteTextView.setAdapter(cursorAdapter);

		// ���ݳ�ʼ��
		String city = preferences.getString("city", null);
		application.city = city == null ? "����" : city;
		String city_id = preferences.getString("city_id", null);
		application.city_id = city_id == null ? "101010100" : city_id;
		//
		dataText.setText(getDate());

		// ʵ����������
		renew_1 = new Renew_1(application);
		renew_2 = new Renew_2(application);
		renew_3 = new Renew_3(application);
		renew_1.start();
		renew_2.start();
		renew_3.start();

		final Handler handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				if (msg.what == 0x123) {
					cityName.setText(application.city);
					temp.setText(application.myData_1.weatherinfo.temp + "��");
					temp1.setText("�¶�:"
							+ (application.myData_2.weatherinfo.temp1 + "-" + application.myData_2.weatherinfo.temp2)
									.replace("��", "") + "��");
					weatherText.setText(application.myData_2.weatherinfo.weather);
					windText.setText(application.myData_1.weatherinfo.WD+":"+application.myData_1.weatherinfo.WS);
					humidityText.setText(application.myData_1.weatherinfo.SD);
					uvbText.setText("������:"+application.myData_3.weatherinfo.index_uv);		
					tourText.setText("����ָ��:"+application.myData_3.weatherinfo.index_tr);		
				}
			}
		};
		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				Message msg = new Message();
				msg.what = 0x123;
				handler.sendMessage(msg);
			}
		}, 0, 1000);

		View ivRight = centerView.findViewById(R.id.settingView);

		ivRight.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.d("S", "������ұ����ð�ť");
				if (slidingMenu.getCurrentUIState() == SlidingState.SHOWRIGHT) {
					slidingMenu.showViewState(SlidingState.SHOWCENTER);
				} else {
					slidingMenu.showViewState(SlidingState.SHOWRIGHT);
				}
			}
		});
		View ivLeft = centerView.findViewById(R.id.menuView);

		ivLeft.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.d("S", "�����������ð�ť");
				if (slidingMenu.getCurrentUIState() == SlidingState.SHOWLEFT) {
					slidingMenu.showViewState(SlidingState.SHOWCENTER);
				} else {
					slidingMenu.showViewState(SlidingState.SHOWLEFT);
				}
			}
		});

		// ������ߵ�listview
		ListView lvLeft = (ListView) leftView.findViewById(R.id.lvLeft);

		lvLeft.setAdapter(new ArrayAdapter<String>(this, R.layout.item,
				R.id.tv_item, title));
		lvLeft.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Log.d("S", "�������ߵ�" + arg2);
			}
		});
		searchButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String city = autoCompleteTextView.getText().toString();
				Cursor cursor = myDbHelper.getReadableDatabase().rawQuery(
						"select id from user where " + "name = \"" + city
								+ "\"", null);
				while (cursor.moveToNext()) {
					String id = cursor.getString(cursor.getColumnIndex("id"));
					application.city_id = id;
					application.city = city;
				}
				slidingMenu.showViewState(SlidingState.SHOWCENTER);
			}
		});

	}

	private String getDate() {
		final Calendar c = Calendar.getInstance();
		String mMonth, mDay, mWay;
		c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
		// mYear = String.valueOf(c.get(Calendar.YEAR)); // ��ȡ��ǰ���
		mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);// ��ȡ��ǰ�·�
		mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));// ��ȡ��ǰ�·ݵ����ں���
		mWay = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
		if ("1".equals(mWay)) {
			mWay = "����";
		} else if ("2".equals(mWay)) {
			mWay = "��һ";
		} else if ("3".equals(mWay)) {
			mWay = "�ܶ�";
		} else if ("4".equals(mWay)) {
			mWay = "����";
		} else if ("5".equals(mWay)) {
			mWay = "����";
		} else if ("6".equals(mWay)) {
			mWay = "����";
		} else if ("7".equals(mWay)) {
			mWay = "����";
		}
		return mMonth + "." + mDay + "/" + mWay;
	}
}