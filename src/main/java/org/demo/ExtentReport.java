package org.demo;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;



public class ExtentReport implements IReporter {
	
	ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentTest paretntTest;
	public static ExtentTest childTest;
	public static InetAddress localhost;
	
	
	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		
		try {
			localhost = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		File file = new File(outputDirectory +"AutomationReport.html");
		htmlReporter = new ExtentHtmlReporter(file);
		
		/*//extent = new ExtentReports(outputDirectory + File.separator
				+ "Extent.html", true);*/
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("Hostname", localhost.getHostName());
		extent.setSystemInfo("IPAddress", localhost.getHostAddress().trim());
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Tester", System.getProperty("user.name"));

		htmlReporter.config().setDocumentTitle("GET Automation Document");
		htmlReporter.config().setReportName("GET Automation Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		

		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();
			
			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();

				buildTestNodes(context.getPassedTests(), Status.PASS);
				buildTestNodes(context.getFailedTests(), Status.FAIL);
				buildTestNodes(context.getSkippedTests(), Status.SKIP);		
			}
						
		}
		extent.flush();
	}
		
		private void buildTestNodes(IResultMap tests, Status status) {
			
			if (tests.size() > 0) {
				for (ITestResult result : tests.getAllResults()) {
					
					paretntTest = extent.createTest(result.getInstanceName());
					childTest = paretntTest.createNode(result.getMethod().getMethodName());
					childTest.assignCategory(result.getClass().getName());
					//paretntTest.log(Status.INFO, MarkupHelper.createLabel("Starting Test Case to verify Header of the page.", ExtentColor.CYAN));

					//childTest.setStartedTime(getTime(result.getStartMillis()));
					//childTest.setEndedTime(getTime(result.getEndMillis()));
					

					for (String group : result.getMethod().getGroups())
						childTest.assignCategory(group);

					if (result.getThrowable() != null) {
						childTest.log(status, result.getThrowable());
					} else {
						childTest.log(status, "Test " + status.toString().toLowerCase()
								+ "ed");
					}

					extent.flush();
				}
			}
		}

		/*private Date getTime(long millis) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(millis);
			return calendar.getTime();
		}*/
		
		
	}


