package com.senips.automation;

import cucumber.runtime.StepDefinition;
import cucumber.runtime.StepDefinitionMatch;
import cucumber.runtime.xstream.LocalizedXStreams;
import gherkin.I18n;
import gherkin.formatter.Argument;
import gherkin.formatter.model.Step;

import java.util.List;

/**
 * Created by senips on 6/8/17.
 */
public class ExtStepDefinitionMatch extends StepDefinitionMatch {


    private List<Argument> arguments;
    private StepDefinition stepDefinition;
    private String featurePath;
    private Step step;
    private LocalizedXStreams localizedXStreams;

    public ExtStepDefinitionMatch(List<Argument> arguments, StepDefinition stepDefinition, String featurePath, Step step, LocalizedXStreams localizedXStreams) {
        super(arguments, stepDefinition, featurePath, step, localizedXStreams);
        this.arguments = arguments;
        this.stepDefinition = stepDefinition;
        this.featurePath = featurePath;
        this.step = step;
        this.localizedXStreams = localizedXStreams;
    }

    @Override
    public void runStep(I18n i18n) throws Throwable {
        if (1 == 1) //no custom arguments
        {
            super.runStep(i18n);
        } else {
            stepDefinition.execute(i18n, new Object[]{});
        }

    }


}
