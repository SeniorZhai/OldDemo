package com.zoe.netwrok;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import android.os.Handler;
import android.os.Message;

public class ClientThread implements Runnable {
	private Socket socket;
	private Handler handler;
	BufferedReader br = null;

	public ClientThread(String IP, int port, Handler handler) throws Exception {
		socket = new Socket(IP, port);
		this.handler = handler;
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

	@Override
	public void run() {
		try {
			String content = null;
			while ((content = br.readLine()) != null) {
				Message msg = new Message();
				msg.what = 0x1233;
				msg.obj = content;
				handler.sendMessage(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
