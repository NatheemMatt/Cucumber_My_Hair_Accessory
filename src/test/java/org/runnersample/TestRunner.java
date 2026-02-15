package org.runnersample;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/FeatureFiles/Register.feature", glue = "org.step", tags = "@dataTable",
dryRun = false)

public class TestRunner extends AbstractTestNGCucumberTests {

}
