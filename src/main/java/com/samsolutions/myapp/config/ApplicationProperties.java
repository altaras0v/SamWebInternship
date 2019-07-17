package com.samsolutions.myapp.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

public class ApplicationProperties {


		private final static Logger LOGGER = LoggerFactory.getLogger(ApplicationProperties.class);

		private final Properties properties;


		/**
		 * Method loads properties from file.
		 */
		public ApplicationProperties() {
			properties = new Properties();
			try {
				properties.load(getClass().getClassLoader().getResourceAsStream("app.properties"));
			}
			catch (IOException e) {
				LOGGER.error("Can't read properties from app.properties");
			}
		}

		/**
		 * Method gets EXAMS_AMOUNT value.
		 *
		 * @return exams amount.
		 */
		public String getExamAmount() {
			return properties.getProperty("EXAMS_AMOUNT");
		}

	public String getProperty(String property) {
		return properties.getProperty(property);
	}
	}

