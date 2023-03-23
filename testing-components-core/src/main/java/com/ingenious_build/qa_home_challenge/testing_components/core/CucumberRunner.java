package com.ingenious_build.qa_home_challenge.testing_components.core;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features")
public abstract class CucumberRunner extends AbstractTestNGCucumberTests {}
