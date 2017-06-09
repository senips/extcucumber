package com.senips.automation;

import cucumber.runtime.Runtime;
import cucumber.runtime.junit.FeatureRunner;
import cucumber.runtime.junit.JUnitReporter;
import cucumber.runtime.model.CucumberFeature;
import org.junit.runners.model.InitializationError;

/**
 * Created by senips on 6/8/17.
 */
public class ExtFeatureRunner extends FeatureRunner {
    public ExtFeatureRunner(CucumberFeature cucumberFeature, Runtime runtime, JUnitReporter jUnitReporter) throws InitializationError {
        super(cucumberFeature, runtime, jUnitReporter);
    }
}
