package com.demo.api.listeners;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final Logger Logger = LogManager.getLogger(TestListener.class);

    public void onStart(ITestContext context) {

        Logger.info("Test Suite Started...");

    }

    public void onFinish(ITestContext context) {

        Logger.info("Test Suite Completed...");
    }

    public void onTestStart(ITestResult result) {

        Logger.info("Test Started "+ result.getMethod().getMethodName());
        Logger.info("Description "+result.getMethod().getDescription());

    }

    public void onTestSuccess(ITestResult result) {

        Logger.info("Test passed "+result.getMethod().getMethodName());

    }

    public void onTestFailure(ITestResult result) {

        Logger.error("Test failed "+result.getMethod().getMethodName());
    }

    public void onTestSkipped(ITestResult result) {

        Logger.info("Test skipped "+result.getMethod().getMethodName());

    }

}
