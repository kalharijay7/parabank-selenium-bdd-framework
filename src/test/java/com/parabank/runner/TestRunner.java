package com.parabank.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/features",     // path to your .feature files
	    glue = {
	    		"com.parabank.stepdefinitions", 
	    		"com.parabank.base",
	    		"com.parabank.hooks"  // packages containing step defs & hooks
	    		},          
	    plugin = {
	        "pretty",                                 // readable console output
	        "html:target/cucumber-reports.html",      // HTML report
	        "json:target/cucumber.json"               // JSON report (optional)
	    },
	    monochrome = true,                            // cleaner console output
	    publish = true                               // optional (publishes online Cucumber report)
//	    tags = "@Login"                               // optional: run specific scenarios
	)

public class TestRunner extends AbstractTestNGCucumberTests {
    // No code needed here — TestNG will handle execution
}

