package com.quartz;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;

import com.qsi.utility.DBConnector;
import com.qsi.utility.DaoFunc;
import com.qsi.utility.mail;

public class QuartzJob implements Job {
	public void execute(JobExecutionContext context)                        
	throws JobExecutionException {   
	 PreparedStatement	stamt;
	 Statement stamt1;
	 Logger logger = Logger.getLogger(QuartzJob.class);	
		
	//System.out.println("Java web application + Quartz 2.2.1"); 	
	logger.info("Java web application + Quartz 2.2.1");
	
	String sPmd07="omaga1130@gmail.com";

	
	DaoFunc QueryDao=new DaoFunc();
	//String msgcontent=QueryDao.Query_tc_pna_file();
	String msgcontent="Take a Break...";
	mail nn=new mail();
	nn.doSendVendorMail(sPmd07,msgcontent);	
	logger.info("Mail Sended to :"+sPmd07);
	

	}
}