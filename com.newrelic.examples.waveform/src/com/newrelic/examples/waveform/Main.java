package com.newrelic.examples.waveform;

import com.newrelic.data.in.ConfigurationException;
import com.newrelic.data.in.Runner;


public class Main {	
    public static void main(String[] args) {
    	Runner runner = new Runner();
    	new WaveformFactory(runner);
    	
		try {
	    	//Never returns
	    	runner.setupAndRun();
		} catch (ConfigurationException e) {
			e.printStackTrace();
    		System.err.println("Error configuring");
    		System.exit(-1);
		}
    	
    }
}
