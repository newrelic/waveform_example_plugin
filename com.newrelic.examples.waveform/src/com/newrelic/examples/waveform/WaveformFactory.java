package com.newrelic.examples.waveform;

import com.newrelic.datain.Agent;
import com.newrelic.datain.AgentFactory;
import com.newrelic.datain.Runner;

public class WaveformFactory extends AgentFactory {

	public WaveformFactory(Runner runner) {
		super(runner);
	}

	@Override
	public Agent createAgent() {
		return new Waveform();
	}
}
