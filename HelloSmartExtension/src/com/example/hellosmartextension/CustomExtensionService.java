package com.example.hellosmartextension;

import com.sonyericsson.extras.liveware.extension.util.ExtensionService;
import com.sonyericsson.extras.liveware.extension.util.control.ControlExtension;
import com.sonyericsson.extras.liveware.extension.util.registration.RegistrationInformation;

public class CustomExtensionService extends ExtensionService{

	public CustomExtensionService() {
		super(EXTENSION_KEY);
	}

	final static String EXTENSION_KEY = "com.example.hellosmartextension.key";

	@Override
	protected RegistrationInformation getRegistrationInformation() {
		return new CustomRegistrationInformation(this);
	}

	@Override
	protected boolean keepRunningWhenConnected() {
		return false;
	}

	@Override
	public ControlExtension createControlExtension(String hostAppPackageName) {
		return new CustomControlExtension(this, hostAppPackageName);
	}

}
