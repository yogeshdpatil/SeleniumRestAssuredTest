package com.rest.utils;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Listeners extends TestListenerAdapter {
	private ExtentSparkReporter htmlReporter;
	private ExtentReports extent;
	private ExtentTest test;

	public void onStart(ITestContext testContext) {
		// Specify location of the report
		htmlReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "//Reports//RestAssured_Practise_Report.html");

		htmlReporter.config().setDocumentTitle("API Automation Report"); // Tile of report
		htmlReporter.config().setReportName("Rest API Testing Report- Excel Read"); // Name of the report
		htmlReporter.config().setTheme(Theme.STANDARD); // Set Theme for extent html report

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Project Name", "Excel Read");
		extent.setSystemInfo("Host name", "Yogesh-Pt");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "yogeshd.patil");

	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName()); // create new entry in the report
		test.log(Status.PASS, "Test Case PASSED " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName()); // create new entry in the report
		test.log(Status.FAIL, "TEST CASE FAILED " + result.getName()); // to add name in extent report
		test.log(Status.FAIL, "TEST CASE FAILED " + result.getThrowable()); // to add error/exception in extent report
	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName()); // create new entry in the report
		test.log(Status.SKIP, "Test Case SKIPPED " + result.getName());
	}

	public void onFinish(ITestContext testContext) {
		extent.flush();
	}

}
