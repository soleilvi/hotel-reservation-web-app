package edu.wgu.d387_sample_code.threads;

import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.Properties;

public class WelcomeMessage {

    private final String propertyName;

    public WelcomeMessage(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getWelcomeMessage() {

        Properties properties = new Properties();

        try {
            InputStream inputStream = new ClassPathResource(propertyName).getInputStream();

            properties.load(inputStream);

            return properties.getProperty("welcome");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return "failed";
    }
}
