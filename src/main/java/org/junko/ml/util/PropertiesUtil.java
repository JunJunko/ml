package org.junko.ml.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	private String FilePath;

	public PropertiesUtil(String FilePath) {
		this.FilePath = FilePath;
	}

	public String ReadProperties(String ProperKey) {
		Properties prop = new Properties();
		String Relust = new String();

		try {
			prop.load(new FileInputStream(FilePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Relust = prop.getProperty(ProperKey);

		return Relust;
	}
}