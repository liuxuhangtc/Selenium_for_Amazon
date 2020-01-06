package Listener;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
 
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;
 
public class NegativeListener implements IReporter{
 
public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		
		for(ISuite ist : suites){
			
			Map<String, ISuiteResult> resultMap = ist.getResults();
			
			Set<String> key = resultMap.keySet();
			
			for(String k : key){
				
				ITestContext cntx = resultMap.get(k).getTestContext();
				
				System.out.println("Suite Name- "+cntx.getName()
									+"\n Report Directory- "+cntx.getOutputDirectory()
									+"\n Test Suite Name- "+cntx.getSuite().getName()
									+ "\n Start Date and Time of Execution- "+cntx.getStartDate()
									+ "\n End Date and Time of Execution- "+cntx.getEndDate());
				
				IResultMap failedTest = cntx.getFailedTests();
				
				System.out.println("------Failed Test Case-----");
				
				for(ITestResult imr : failedTest.getAllResults()) {
					
					System.out.println("Test Case Name- "+imr.getMethod().getMethodName()
					+"\n Description- "+imr.getMethod().getDescription()
					+"\n Priority- "+imr.getMethod().getPriority()
					+ "\n Date- "+new Date(imr.getMethod().getDate())
					+"\n Error Message- "+imr.getThrowable().getMessage()
					
							);
					
				}
				
				
				
				
				
				
				BufferedWriter bw;
				try {
					bw = new BufferedWriter(new FileWriter("NewReport2.html"));
					bw.write("<html> <head><title>New Page</title><h1>Generated Report</h1></head> <body> <h2>Negative Test Cases</h2> <table border = 1> <tr> <th>Test Name</th> <th>Description</th> <th>Priority</th> <th> Expected </th> <th> Actual </th> <th> Status </th> </tr>");
					//for loop goes here
					for(ITestResult imr : failedTest.getAllResults()) {
						bw.write("<tr> <td>"+imr.getMethod().getMethodName()+"</td> <td>"+imr.getMethod().getDescription()+"</td>  <td>"+imr.getMethod().getPriority()+"</td> <td>"+ (imr.getThrowable().getMessage()).split("but")[0] +"</td> <td> "+(imr.getThrowable().getMessage()).split("but")[1]+" </td> <td> Fail </td> </tr>");
					
					}
					
					bw.write("</table><h2>Positive Test Cases</h2><table border = 1> <tr> <th>Test Name</th> <th>Description</th> <th>Priority</th> <th>Status</th></tr>");
					
					IResultMap passedTest = cntx.getPassedTests();
					
					
					Collection<ITestNGMethod> passedMethods = passedTest.getAllMethods();
					
					//System.out.println("------Passed Test Case-----");
					
					for(ITestNGMethod imd1 : passedMethods){
						
						bw.write("<tr> <td>"+imd1.getMethodName()+"</td> <td>"+imd1.getDescription()+"</td> <td>"+imd1.getPriority()+"</td> <td>Pass</td> </tr>");
						
						
					}
					
					
					
					
					bw.write("</table></body></html>");
					
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				
				
				//Collection<ITestNGMethod> failedMethods = failedTest.getAllMethods();
				
				
				
				//for(ITestNGMethod imd : failedMethods){
					
				//	System.out.println("Test Case Name- "+imd.getMethodName()
				//	+"\n Description- "+imd.getDescription()
				//	+"\n Priority- "+imd.getPriority()
				//	+ "\n Date- "+new Date(imd.getDate()));
					
					
				//}
				
				
				IResultMap passedTest = cntx.getPassedTests();
				
				
				Collection<ITestNGMethod> passedMethods = passedTest.getAllMethods();
				
				System.out.println("------Passed Test Case-----");
				
				for(ITestNGMethod imd1 : passedMethods){
					
					System.out.println("Test Case Name- "+imd1.getMethodName()
					+"\n Description- "+imd1.getDescription()
					+"\n Priority- "+imd1.getPriority()
					+ "\n Date- "+new Date(imd1.getDate())
					
					
							
							);
					
					
				}
			}
		}
		
		
		
		
	}
 
}