package com.zoe.weather;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.zoe.data.AutoCompleteAdater;
import com.zoe.data.DataBaseHelper;
import com.zoe.slidingmenu.view.SlidingMenu;
import com.zoe.slidingmenu.view.SlidingState;

public class MainActivity extends Activity implements SensorEventListener {

	private SensorManager sensorManager;
	private MediaPlayer player;
	private SharedPreferences preferences;
	private SharedPreferences.Editor editor;

	private MyApplication application;
	private Refresh refresh;
	private DataBaseHelper myDbHelper;

	private SlidingMenu slidingMenu;
	private FrameLayout frameLayout;
	private TextView dataText, cityName, temp, temp1, weatherText, windText,
			humidityText, uvbText, tourText;
	private ImageView weather;
	private AutoCompleteTextView autoCompleteTextView;
	private ListView rightList, leftList_1, leftList_2;
	private Button addButton;

	private Handler handler;

	private ArrayList<String> cityList;
	private ArrayAdapter<String> cityAdapter;
	private ArrayList<String> weatherList_1;
	private ArrayAdapter<String> weatherAdapter_1;
	private ArrayList<String> weatherList_2;
	private ArrayAdapter<String> weatherAdapter_2;

	private int i = 0, j = 0;
	private int color[][] = new int[][] {
			{ R.color.c1_1, R.color.c1_2, R.color.c1_3, R.color.c1_4 },
			{ R.color.c2_1, R.color.c2_2, R.color.c2_3, R.color.c2_4 },
			{ R.color.c3_1, R.color.c3_2, R.color.c3_3, R.color.c3_4 },
			{ R.color.c4_1, R.color.c4_2, R.color.c4_3, R.color.c4_4 },
			{ R.color.c5_1, R.color.c5_2, R.color.c5_3, R.color.c5_4 },
			{ R.color.c6_1, R.color.c6_2, R.color.c6_3, R.color.c6_4 },
			{ R.color.c7_1, R.color.c7_2, R.color.c7_3, R.color.c7_4 },
			{ R.color.c8_1, R.color.c8_2, R.color.c8_3, R.color.c8_4 },
			{ R.color.c9_1, R.color.c9_2, R.color.c9_3, R.color.c9_4 },
			{ R.color.c10_1, R.color.c10_2, R.color.c10_3, R.color.c10_4 },
			{ R.color.c11_1, R.color.c11_2, R.color.c11_3, R.color.c11_4 },
			{ R.color.c12_1, R.color.c12_2, R.color.c12_3, R.color.c12_4 } };

	@SuppressLint("HandlerLeak")
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);

		application = (MyApplication) getApplication();

		preferences = getSharedPreferences("zoe", MODE_PRIVATE);
		editor = preferences.edit();

		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE); // 获取传感器管理服务
		player = MediaPlayer.create(this, R.raw.shake);

		// 数据库初始化
		myDbHelper = new DataBaseHelper(this);
		try {
			myDbHelper.createDataBase();
			myDbHelper.openDataBase();
		} catch (IOException ioe) {
			throw new Error("Unable to create database");
		}

		slidingMenu = (SlidingMenu) findViewById(R.id.slidingMenu);

		ViewGroup leftView = (ViewGroup) getLayoutInflater().inflate(
				R.layout.left_v, null);
		ViewGroup rightView = (ViewGroup) getLayoutInflater().inflate(
				R.layout.right_v, null);
		ViewGroup centerView = (ViewGroup) getLayoutInflater().inflate(
				R.layout.center_v, null);

		autoCompleteTextView = (AutoCompleteTextView) rightView
				.findViewById(R.id.autoCompleteTextView);
		frameLayout = (FrameLayout) centerView.findViewById(R.id.frameLayout);
		weather = (ImageView) centerView.findViewById(R.id.weather);
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

		leftList_1 = (ListView) leftView.findViewById(R.id.lvLeft_1);
		leftList_2 = (ListView) leftView.findViewById(R.id.lvLeft_2);
		addButton = (Button) rightView.findViewById(R.id.addButton);
		rightList = (ListView) rightView.findViewById(R.id.lvRight);

		cityList = new ArrayList<String>();
		weatherList_1 = new ArrayList<String>();
		weatherList_2 = new ArrayList<String>();

		cityAdapter = new ArrayAdapter<String>(this, R.layout.item_2,
				R.id.tv_item_2, cityList);
		rightList.setAdapter(cityAdapter);

		weatherAdapter_1 = new ArrayAdapter<String>(this, R.layout.item_1,
				R.id.tv_item_1, weatherList_1);
		leftList_1.setAdapter(weatherAdapter_1);

		weatherAdapter_2 = new ArrayAdapter<String>(this, R.layout.item_1,
				R.id.tv_item_1, weatherList_2);
		leftList_2.setAdapter(weatherAdapter_2);

		// 初始化自动补全框
		AutoCompleteAdater cursorAdapter = new AutoCompleteAdater(this,
				android.R.layout.simple_dropdown_item_1line, null, "name",
				android.R.id.text1, myDbHelper);
		autoCompleteTextView.setAdapter(cursorAdapter);

		// 获得刷新线程引用
		refresh = application.refresh;
		// 刷新界面
		reNew();

		// 刷新日期
		dataText.setText(getDate());

		handler = new Handler() {
			public void handleMessage(Message msg) {

				if (msg.what == 0x123) {
					refresh.setFlag();
					reNew();
				}
				if (msg.what == 0x111) {
					j++;
					if (j > 3) {
						j = 0;
						i++;
					}
					if (i > 11)
						i = 0;
					frameLayout.setBackgroundResource(color[i][j]);
				}
			}
		};

		View ivRight = centerView.findViewById(R.id.settingView);

		ivRight.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

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

				if (slidingMenu.getCurrentUIState() == SlidingState.SHOWLEFT) {
					slidingMenu.showViewState(SlidingState.SHOWCENTER);
				} else {
					slidingMenu.showViewState(SlidingState.SHOWLEFT);
				}
			}
		});

		addButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String city = autoCompleteTextView.getText().toString();
				if (!city.equals("")) {
					Cursor cursor = myDbHelper.myDataBase.rawQuery(
							"select id from user where " + "name = \"" + city
									+ "\"", null);
					while (cursor.moveToNext()) {
						String id = cursor.getString(cursor
								.getColumnIndex("id"));
						application.city_id = id;
						application.city = city;
						cityList.add(city);
						cityAdapter.notifyDataSetChanged();
						Message msg = new Message();
						msg.what = 0x123;
						handler.sendMessage(msg);
						// slidingMenu.showViewState(SlidingState.SHOWCENTER);
					}
				}
			}

		});
	}

	private void reNew() {
		refresh.setFlag();
		cityName.setText(application.city);
		editor.putString("city", application.city);
		editor.commit();
		if (application.myData_1.weatherinfo.temp != null)
			temp.setText(application.myData_1.weatherinfo.temp + "°");

		if (application.myData_2.weatherinfo.temp1 != null
				&& application.myData_2.weatherinfo.temp2 != null)
			temp1.setText("温度:"
					+ (application.myData_2.weatherinfo.temp1 + "-" + application.myData_2.weatherinfo.temp2)
							.replace("℃", "") + "℃");
		if (application.myData_2.weatherinfo.weather != null) {
			if (application.myData_2.weatherinfo.weather.startsWith("晴"))
				weather.setImageResource(R.drawable.sunny);
			else if (application.myData_2.weatherinfo.weather.startsWith("多云"))
				weather.setImageResource(R.drawable.cloudy);
			else if (application.myData_2.weatherinfo.weather.startsWith("小雨"))
				weather.setImageResource(R.drawable.light_rain);
			else if (application.myData_2.weatherinfo.weather.startsWith("大雨"))
				weather.setImageResource(R.drawable.heavy_rain);
			else if (application.myData_2.weatherinfo.weather.startsWith("中雨"))
				weather.setImageResource(R.drawable.moderate_rain);
			else if (application.myData_2.weatherinfo.weather.startsWith("暴雨"))
				weather.setImageResource(R.drawable.torrential_rain);
			else if (application.myData_2.weatherinfo.weather.startsWith("阵雨")
					|| application.myData_2.weatherinfo.weather
							.startsWith("雷阵雨"))
				weather.setImageResource(R.drawable.torrential_rain);
			else if (application.myData_2.weatherinfo.weather.startsWith("雨夹雪"))
				weather.setImageResource(R.drawable.snow_and_rain);
			else if (application.myData_2.weatherinfo.weather.startsWith("阴"))
				weather.setImageResource(R.drawable.overcast);
			else if (application.myData_2.weatherinfo.weather.startsWith("冰雹"))
				weather.setImageResource(R.drawable.hail);
			else if (application.myData_2.weatherinfo.weather.startsWith("雾"))
				weather.setImageResource(R.drawable.fog);
			else if (application.myData_2.weatherinfo.weather.startsWith("小雪"))
				weather.setImageResource(R.drawable.light_snow);
			else if (application.myData_2.weatherinfo.weather.startsWith("中雪"))
				weather.setImageResource(R.drawable.moderate_snow);
			else if (application.myData_2.weatherinfo.weather.startsWith("大雪")
					|| application.myData_2.weatherinfo.weather
							.startsWith("暴雪"))
				weather.setImageResource(R.drawable.heavy_snow);
			else if (application.myData_2.weatherinfo.weather.startsWith("浮尘"))
				weather.setImageResource(R.drawable.floating_dust);
			else if (application.myData_2.weatherinfo.weather.startsWith("扬沙"))
				weather.setImageResource(R.drawable.dust_blowing);
			else if (application.myData_2.weatherinfo.weather.startsWith("沙尘暴"))
				weather.setImageResource(R.drawable.dust_devil);
			else if (application.myData_2.weatherinfo.weather
					.startsWith("强沙尘暴"))
				weather.setImageResource(R.drawable.severe_dust_devil);
		}
		if (application.myData_2.weatherinfo.weather != null)
			weatherText.setText(application.myData_2.weatherinfo.weather);
		if (application.myData_1.weatherinfo.WD != null
				&& application.myData_1.weatherinfo.WS != null)
			windText.setText(application.myData_1.weatherinfo.WD + ":"
					+ application.myData_1.weatherinfo.WS);
		if (application.myData_1.weatherinfo.SD != null)
			humidityText.setText("湿度:" + application.myData_1.weatherinfo.SD);
		if (application.myData_3.weatherinfo.index_uv != null)
			uvbText.setText("紫外线:" + application.myData_3.weatherinfo.index_uv);
		if (application.myData_3.weatherinfo.index_tr != null)
			tourText.setText("旅游指数:"
					+ application.myData_3.weatherinfo.index_tr);

		weatherList_1.clear();
		weatherList_1.add(application.myData_3.weatherinfo.weather1);
		weatherList_1.add(application.myData_3.weatherinfo.weather2);
		weatherList_1.add(application.myData_3.weatherinfo.weather3);
		weatherList_1.add(application.myData_3.weatherinfo.weather4);
		weatherList_1.add(application.myData_3.weatherinfo.weather5);
		weatherList_1.add(application.myData_3.weatherinfo.weather6);
		weatherAdapter_1.notifyDataSetChanged();

		weatherList_2.clear();
		weatherList_2.add(application.myData_3.weatherinfo.temp1.replace("℃",
				"") + "℃");
		weatherList_2.add(application.myData_3.weatherinfo.temp2.replace("℃",
				"") + "℃");
		weatherList_2.add(application.myData_3.weatherinfo.temp3.replace("℃",
				"") + "℃");
		weatherList_2.add(application.myData_3.weatherinfo.temp4.replace("℃",
				"") + "℃");
		weatherList_2.add(application.myData_3.weatherinfo.temp5.replace("℃",
				"") + "℃");
		weatherList_2.add(application.myData_3.weatherinfo.temp6.replace("℃",
				"") + "℃");
		weatherAdapter_2.notifyDataSetChanged();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if (sensorManager != null) {// 注册监听器
			sensorManager.registerListener(this,
					sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
					SensorManager.SENSOR_DELAY_UI);
			// 第一个参数是Listener，第二个参数是所得传感器类型，第三个参数值获取传感器信息的频率
		}
	}

	@Override
	protected void onStop() {
		sensorManager.unregisterListener(this);
		super.onStop();
		player.stop();
	}

	@Override
	protected void onPause() {
		sensorManager.unregisterListener(this);
		super.onPause();
	}

	private String getDate() {
		final Calendar c = Calendar.getInstance();
		String mMonth, mDay, mWay;
		c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
		// mYear = String.valueOf(c.get(Calendar.YEAR)); // 获取当前年份
		mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);// 获取当前月份
		mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));// 获取当前月份的日期号码
		mWay = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
		if ("1".equals(mWay)) {
			mWay = "周日";
		} else if ("2".equals(mWay)) {
			mWay = "周一";
		} else if ("3".equals(mWay)) {
			mWay = "周二";
		} else if ("4".equals(mWay)) {
			mWay = "周三";
		} else if ("5".equals(mWay)) {
			mWay = "周四";
		} else if ("6".equals(mWay)) {
			mWay = "周五";
		} else if ("7".equals(mWay)) {
			mWay = "周六";
		}
		return mMonth + "." + mDay + "/" + mWay;
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {

	}

	@Override
	public void onSensorChanged(SensorEvent event) {

		float[] values = event.values;
		float x = values[0];
		float y = values[1];
		float z = values[2];
		// 三个方向的重力加速度达到18就达到了摇晃手机的状态。
		float medumValue = 19.2f;
		if (Math.abs(x) > medumValue || Math.abs(y) > medumValue
				|| Math.abs(z) > medumValue) {
			Log.d("msg", "x=" + x + "y=" + y + "z=" + z);
			player.start();
			player.setOnCompletionListener(new OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mp) {
					player.pause();
					player.seekTo(0);
				}
			});
			Message msg = new Message();
			msg.what = 0x111;
			handler.sendMessage(msg);
		}
	}
}