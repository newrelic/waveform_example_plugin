package com.newrelic.examples.waveform;

import com.newrelic.data.in.Agent;
import com.newrelic.data.in.AgentFactory;
import com.newrelic.data.in.Runner;

public class WaveformFactory extends AgentFactory {

	public WaveformFactory(Runner runner) {
		super(runner);
	}

	@Override
	public Agent createAgent() {
		return new Waveform();
	}
}
