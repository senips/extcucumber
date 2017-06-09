package com.senips.automation;

import cucumber.runtime.*;
import cucumber.runtime.Runtime;
import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;
import cucumber.runtime.xstream.LocalizedXStreams;

import java.util.Collection;

/**
 * Created by senips on 6/8/17.
 */
public class ExtRuntime extends Runtime {

private RuntimeGlue glue;

    final UndefinedStepsTracker undefinedStepsTracker = new UndefinedStepsTracker();

    public ExtRuntime(ResourceLoader resourceLoader, ClassFinder classFinder, ClassLoader classLoader, RuntimeOptions runtimeOptions) {
        super(resourceLoader, classLoader, loadBackends(resourceLoader, classFinder), runtimeOptions,  new ExtRuntimeGlue(new UndefinedStepsTracker(), new LocalizedXStreams(classLoader)));
    }


    private static Collection<? extends Backend> loadBackends(ResourceLoader resourceLoader, ClassFinder classFinder) {
        Reflections reflections = new Reflections(classFinder);
        return reflections.instantiateSubclasses(Backend.class, "cucumber.runtime", new Class[]{ResourceLoader.class}, new Object[]{resourceLoader});
    }
}
