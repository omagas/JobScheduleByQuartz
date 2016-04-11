package com.quartz;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;



import com.qsi.utility.*;

public class QuartzJob implements Job {
	public void execute(JobExecutionContext context)                        
	throws JobExecutionException {   
		
	 Logger logger = Logger.getLogger(QuartzJob.class);	
		
	//System.out.println("Java web application + Quartz 2.2.1"); 	
	logger.info("Java web application + Quartz 2.2.1");
	
	String sPmd07="omaga1130@gmail.com";

	
	
	
	
	mail nn=new mail();
	nn.doSendVendorMail(sPmd07);	
	
	logger.info("Mail Sended to"+sPmd07);
	
	}
}