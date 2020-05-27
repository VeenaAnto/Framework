package com.auto.cloud.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro;

	public ConfigDataProvider() throws IOException {

		File src = new File("./Config/Config.properties");
		try {

			FileInputStream fin = new FileInputStream(src);
			pro = new Properties();
			pro.load(fin);

		} catch (FileNotFoundException e) {

			System.out.println(e.getMessage());
		}

	}

	public String getBrowserData() {
		return pro.getProperty("Browser");
	}

	public String getURLData() {

		return pro.getProperty("AppqaURL");
	}
}
