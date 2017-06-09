package com.senips.automation;

import cucumber.runtime.*;
import cucumber.runtime.xstream.LocalizedXStreams;
import gherkin.I18n;
import gherkin.formatter.Argument;
import gherkin.formatter.model.Step;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by senips on 6/8/17.
 */
public class ExtRuntimeGlue extends RuntimeGlue {

    final Map<String, StepDefinition> stepDefinitionsByPattern = new TreeMap<String, StepDefinition>();
    private UndefinedStepsTracker tracker;
    private LocalizedXStreams localizedXStreams;

    public ExtRuntimeGlue(UndefinedStepsTracker tracker, LocalizedXStreams localizedXStreams) {
        super(tracker, localizedXStreams);
        this.tracker = tracker;
        this.localizedXStreams = localizedXStreams;
    }

    @Override
    public void addStepDefinition(StepDefinition stepDefinition) {
        super.addStepDefinition(stepDefinition);
        stepDefinitionsByPattern.put(stepDefinition.getPattern(), stepDefinition);
    }

    @Override
    public StepDefinitionMatch stepDefinitionMatch(String featurePath, Step step, I18n i18n) {
        List<StepDefinitionMatch> matches = stepDefinitionMatches(featurePath, step);
        try {
            if (matches.isEmpty()) {
                this.tracker.addUndefinedStep(step, i18n);
                return null;
            }
            if (matches.size() == 1) {
                return matches.get(0);
            } else {
                throw new AmbiguousStepDefinitionsException(matches);
            }
        } finally {
            this.tracker.storeStepKeyword(step, i18n);
        }
    }

    private List<StepDefinitionMatch> stepDefinitionMatches(String featurePath, Step step) {
        List<StepDefinitionMatch> result = new ArrayList<StepDefinitionMatch>();
        for (StepDefinition stepDefinition : stepDefinitionsByPattern.values()) {
            List<Argument> arguments = stepDefinition.matchedArguments(step);
            if (arguments != null) {
                result.add(new ExtStepDefinitionMatch(arguments, stepDefinition, featurePath, step, this.localizedXStreams));
            }
        }
        return result;
    }
}
