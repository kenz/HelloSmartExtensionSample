package com.example.hellosmartextension;

import android.content.ContentValues;
import android.content.Context;

import com.sonyericsson.extras.liveware.aef.registration.Registration;
import com.sonyericsson.extras.liveware.extension.util.ExtensionUtils;
import com.sonyericsson.extras.liveware.extension.util.registration.RegistrationInformation;

public class CustomRegistrationInformation extends RegistrationInformation {
	private Context mContext;

	protected CustomRegistrationInformation(Context context) {
		if (context == null) {
			throw new IllegalArgumentException("context == null");
		}
		mContext = context;
	}

	@Override
	public ContentValues getExtensionRegistrationConfiguration() {
		ContentValues values = new ContentValues();

		String appName = mContext.getString(R.string.app_name);
		values.put(Registration.ExtensionColumns.NAME, appName);
		values.put(Registration.ExtensionColumns.CONFIGURATION_TEXT, appName);

		String icon = ExtensionUtils.getUriString(mContext, R.drawable.ic_launcher);
		String extensionIcon = ExtensionUtils.getUriString(mContext, R.drawable.icon);
		String extensionIcon48 = ExtensionUtils.getUriString(mContext, R.drawable.icon48);
		String extensionIconbw = ExtensionUtils.getUriString(mContext, R.drawable.iconbw);
		values.put(Registration.ExtensionColumns.HOST_APP_ICON_URI, icon);
		values.put(Registration.ExtensionColumns.EXTENSION_ICON_URI, extensionIcon);
		values.put(Registration.ExtensionColumns.EXTENSION_48PX_ICON_URI, extensionIcon48);
		values.put(Registration.ExtensionColumns.EXTENSION_ICON_URI_BLACK_WHITE, extensionIconbw);
		values.put(Registration.ExtensionColumns.EXTENSION_KEY, CustomExtensionService.EXTENSION_KEY);

		values.put(Registration.ExtensionColumns.NOTIFICATION_API_VERSION, getRequiredNotificationApiVersion());
		values.put(Registration.ExtensionColumns.PACKAGE_NAME, mContext.getPackageName());

		return values;
	}

	@Override
	public int getRequiredSensorApiVersion() {
		return API_NOT_REQUIRED;
	}

	@Override
	public int getRequiredNotificationApiVersion() {
		return 0;
	}

	@Override
	public int getRequiredWidgetApiVersion() {
		return 0;
	}

	@Override
	public boolean isDisplaySizeSupported(int width, int height) {
		return true;
	}

	@Override
	public int getRequiredControlApiVersion() {
		return 1;
	}

}
