package com.senips.automation;

import cucumber.runtime.RuntimeGlue;
import cucumber.runtime.StepDefinition;
import cucumber.runtime.StepDefinitionMatch;
import cucumber.runtime.UndefinedStepsTracker;
import cucumber.runtime.xstream.LocalizedXStreams;
import gherkin.formatter.Argument;
import gherkin.formatter.model.Step;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by senips on 6/8/17.
 */
public class ExtRuntimeGlue extends RuntimeGlue {

    public ExtRuntimeGlue(UndefinedStepsTracker tracker, LocalizedXStreams localizedXStreams) {
        super(tracker, localizedXStreams);
    }


}
