package com.newrelic.examples.waveform;

import com.newrelic.metrics.publish.Agent;
import com.newrelic.metrics.publish.processors.EpochCounter;
import com.newrelic.metrics.publish.processors.Processor;

public class Waveform extends Agent {
	private String name = "Default";
	private int sawtoothMax;
	private int sawtouthCounter = 0;
	private int squarewaveMax;
	private int squarewaveCounter = 0;
	private Processor sawRate = new EpochCounter();
	
    public Waveform(String name, int sawtoothMax, int squarewaveMax) {
    	super("com.newrelic.examples.waveform", "0.0.1");
    	this.name = name;
    	this.sawtoothMax = sawtoothMax;
    	this.squarewaveMax = squarewaveMax;
    }
    
	@Override
	public String getComponentHumanLabel() {
		return name;
	}
	
	@Override
	public void pollCycle() {
		int nextSawTooth = nextSawtouthNumber();
		reportMetric("Waveforms/Sawtooth", "value", nextSawTooth);
		reportMetric("Waveforms/Square", "value", nextSquareNumber());
		reportMetric("Waveforms/Sawtooth Rate", "value/sec", sawRate.process(nextSawTooth).floatValue());
	}
	
	private int nextSawtouthNumber() {
		sawtouthCounter = sawtouthCounter + 1;
		if(sawtouthCounter > sawtoothMax) {
			sawtouthCounter = 0;
		}
		return sawtouthCounter;
	}
	
	private int nextSquareNumber() {
		int returnValue = 0;
		squarewaveCounter = squarewaveCounter + 1;
		if(squarewaveCounter < squarewaveMax / 2) {
			returnValue = 0;
		} else {
			returnValue = squarewaveMax;
		}
		if(squarewaveCounter > squarewaveMax) {
			squarewaveCounter = 0;
		}
		return returnValue;
	}

}

