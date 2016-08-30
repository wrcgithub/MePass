package com.pass.wrc.com.mepass.view;


import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.pass.wrc.com.mepass.R;


public class MyToast {
	public static void showToast(Context context, String message,int duration) {

		LayoutInflater inflater = LayoutInflater.from(context);
		View view = inflater.inflate(R.layout.my_toast, null);
		TextView messageTV = (TextView) view.findViewById(R.id.message);
		messageTV.setText(message);

		Toast toast = new Toast(context);
		toast.setGravity(Gravity.TOP, 0, 420);
		toast.setDuration(duration);
		toast.setView(view);
		toast.show();
	}
}
