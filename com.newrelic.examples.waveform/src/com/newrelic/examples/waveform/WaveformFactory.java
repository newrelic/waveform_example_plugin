package com.newrelic.examples.waveform;

import java.util.Map;

import com.newrelic.data.in.Agent;
import com.newrelic.data.in.AgentFactory;
import com.newrelic.data.in.Runner;

public class WaveformFactory extends AgentFactory {

	public WaveformFactory(Runner runner) {
		super(runner, "com.newrelic.examples.waveform");
	}
	
	@Override
	public Agent createConfiguredAgent(Map<String, Object> properties) {
		String name = (String) properties.get("name");
		int sawtoothMax = ((Long) properties.get("sawtoothMax")).intValue();
		int squarewaveMax = ((Long) properties.get("squarewaveMax")).intValue();
		
		return new Waveform(this, name, sawtoothMax, squarewaveMax);
	}
}
