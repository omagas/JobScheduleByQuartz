package com.qsi.utility;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.naming.NamingException;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

import java.sql.*;
import javax.sql.*;

import org.apache.log4j.Logger;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;

import com.quartz.*;
public class DoShutdownServlet extends HttpServlet {
	
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			
		
		Logger logger = Logger.getLogger(DoShutdownServlet.class);	
	        response.setContentType("text/html");
	        ServletOutputStream out = response.getOutputStream();
	        
			String updatevalue = request.getParameter("updatevalue");			
			logger.info("TEST..."+updatevalue);
		
			try {
				//Sample to show the   [jobName] : CronQuartzJob [groupName] : Group - Tue Apr 12 16:04:30 CST 2016
				Scheduler scheduler = new StdSchedulerFactory().getScheduler();
				   for (String groupName : scheduler.getJobGroupNames()) {

					     for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {
									
						  String jobName = jobKey.getName();
						  String jobGroup = jobKey.getGroup();
									
						  //get job's trigger
						  List<Trigger> triggers = (List<Trigger>) scheduler.getTriggersOfJob(jobKey);
						  java.util.Date nextFireTime =  triggers.get(0).getNextFireTime(); 

							System.out.println("[jobName] : " + jobName + " [groupName] : "
								+ jobGroup + " - " + nextFireTime);

						  }
					      logger.info("Try to scheduler.shutdown....");
					      scheduler.shutdown();

					    }				
				
				
				
				
				
			} catch (SchedulerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.info(e);
			}
			

			
			
			
			
			out.print("<BR><A HREF='./index.html'>Job Schedule Shutdown...Back To Home Page</A><BR>");
	}

}
