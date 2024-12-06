package edu.wgu.d387_sample_code.threads;

import java.util.concurrent.Callable;

public class WelcomeThreadHandler implements Callable<String> {

    private final String propertyName;

    public WelcomeThreadHandler(String propertyName) {
        this.propertyName = propertyName;
        System.out.println("Creating " + propertyName);
    }

     @Override
    public String call() throws Exception {
        System.out.println("Running " + propertyName);
        WelcomeMessage language = new WelcomeMessage(propertyName);
        return language.getWelcomeMessage();
    }
}
