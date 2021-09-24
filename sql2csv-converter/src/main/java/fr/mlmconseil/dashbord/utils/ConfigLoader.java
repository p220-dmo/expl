package fr.mlmconseil.dashbord.utils;

import static fr.mlmconseil.dashbord.utils.Constants.DB_PWD_KEY;
import static fr.mlmconseil.dashbord.utils.Constants.DB_USER_KEY;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConfigLoader {
	final static Logger logger = Logger.getLogger(ConfigLoader.class);
	private static Properties prop = new Properties();

	/**
	 * Static bloc that load params on start up
	 */
	static {
		InputStream input = null;
		try {
			String filename = "config.properties";
			input = ConfigLoader.class.getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				logger.info("Sorry, unable to find " + filename);
				System.exit(0);
			}
			prop.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 
	 */
	public static String getParamByKey(String key) {
		if(key == null || key.isEmpty()) {
			logger.error("Key param can't be null");
			return null;
		}
		String param = prop.getProperty(key);
		if(param == null || param.isEmpty()) {
			logger.error("No mapping value for key : " + key);
			return null;
		}
		return param;
	}
	/**
	 * 
	 * @return
	 */
	public static Properties getDataBaseConfig() {
		Properties prop = new Properties();
		prop.put(DB_USER_KEY, ConfigLoader.prop.get(DB_USER_KEY));
		prop.put(DB_PWD_KEY, ConfigLoader.prop.get(DB_PWD_KEY));
		
		return prop;
	}
	/**
	 * 
	 * @return
	 */
	public static Properties getGlobalSettings() {
		Properties prop = new Properties();
		//prop.put("key", ConfigLoader.prop.get("key"));
		
		return prop;
	}
}
