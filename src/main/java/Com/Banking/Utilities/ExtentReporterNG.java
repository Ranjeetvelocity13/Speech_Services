package Com.Banking.Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import freemarker.template.SimpleDate;
import net.bytebuddy.utility.RandomString;

public class ExtentReporterNG {

	

	static ExtentReports extent;
	
	public static ExtentReports getReportObject()
	{
	
        String Timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    	String Name = "ExtentReport -"+Timestamp;
        String path = System.getProperty("user.dir")+"/Reports/"+Name+""+".html";
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
		reporter.config().setReportName("23July Framework Extent Report");
		reporter.config().setDocumentTitle("(23July Automation Execution Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA Automation Engineer", "Ranjeet Kendre");
		return extent;
		
	}
	   
	 
	 
}
