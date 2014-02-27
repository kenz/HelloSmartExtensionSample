package com.example.hellosmartextension;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class CustomBroadcastReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(final Context context, final Intent intent) {
		intent.setClass(context, CustomExtensionService.class);
		context.startService(intent);
	}
}
