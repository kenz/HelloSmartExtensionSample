package com.example.hellosmartextension;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.text.TextPaint;
import android.util.DisplayMetrics;

import com.sonyericsson.extras.liveware.extension.util.SmartWirelessHeadsetProUtil;
import com.sonyericsson.extras.liveware.extension.util.control.ControlExtension;

public class CustomControlExtension extends ControlExtension {

	public CustomControlExtension(Context context, String hostAppPackageName) {
		super(context, hostAppPackageName);
	}

	@Override
	public void onResume() {
		Bitmap bitmap = Bitmap.createBitmap(128,22 , Bitmap.Config.RGB_565);
		bitmap.setDensity(DisplayMetrics.DENSITY_DEFAULT);
		Canvas canvas = new Canvas(bitmap);
		canvas.drawColor(Color.BLACK);
		TextPaint mTextPaint = SmartWirelessHeadsetProUtil.createTextPaint(mContext);
		String value ="HelloWatch";		
		canvas.drawText(value, 0, value.length(), 0, 22, mTextPaint);
        showBitmap(bitmap, 0, 0);
	}
}
