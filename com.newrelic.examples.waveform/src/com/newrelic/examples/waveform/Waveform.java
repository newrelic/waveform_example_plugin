package com.newrelic.examples.waveform;

import com.newrelic.data.in.Agent;
import com.newrelic.data.in.AgentFactory;

public class Waveform extends Agent {
	private String name = "Default";
	private int sawtoothMax = 20;
	private int sawtouthCounter = 0;
	private int squarewaveMax = 20;
	private int squarewaveCounter = 0;
	
    public Waveform(AgentFactory factory, String name, int sawtoothMax, int squarewaveMax) {
    	super(factory, "0.0.1");
    	this.name = name;
    	this.sawtoothMax = sawtoothMax;
    	this.squarewaveMax = squarewaveMax;
    }
    
	@Override
	public String getComponentHumanLabel() {
		return name + ":" + sawtoothMax + "," + squarewaveMax;
	}

	@Override
	public void pollCycle() {
		reportMetric("Waveforms/Sawtooth", "value", nextSawtouthNumber());
		reportMetric("Waveforms/Square", "value", nextSquareNumber());
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

