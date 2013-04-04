package com.newrelic.examples.waveform;

import java.io.IOException;

import com.newrelic.datain.AgentFactory;
import com.newrelic.datain.ConfigurationException;
import com.newrelic.datain.Runner;


public class Main {	
    public static void main(String[] args) {
    	    	
    	Runner runner = new Runner();
    	AgentFactory factory = new WaveformFactory(runner);
    	
		try {
			factory.createConfiguredAgents();
		} catch (IOException e) {
			e.printStackTrace();
    		System.err.println("Missing agent class to launch");
    		System.exit(-1);
		} catch (ConfigurationException e) {
			e.printStackTrace();
    		System.err.println("Missing agent class to launch");
    		System.exit(-1);
		}
    	
    	//Never returns
    	runner.setupAndRun();
    }
}
