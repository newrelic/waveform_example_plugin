package com.newrelic.examples.waveform;

import java.util.Map;
import java.util.logging.Logger;

import com.newrelic.data.in.Agent;
import com.newrelic.data.in.AgentFactory;

public class WaveformFactory extends AgentFactory {

	public WaveformFactory() {
		super("com.newrelic.examples.waveform");
	}
	
	@Override
	public Agent createConfiguredAgent(Map<String, Object> properties) {
		String name = (String) properties.get("name");
		int sawtoothMax = ((Long) properties.get("sawtoothMax")).intValue();
		int squarewaveMax = ((Long) properties.get("squarewaveMax")).intValue();
		
		return new Waveform(this, name, sawtoothMax, squarewaveMax);
	}
}
