package com.qsi.utility;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

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
import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;

import com.quartz.*;
public class DoRestartServlet extends HttpServlet {
	Scheduler scheduler = null;
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			
		
		Logger logger = Logger.getLogger(DoRestartServlet.class);	
	        response.setContentType("text/html");
	        ServletOutputStream out = response.getOutputStream();
	        
		
			logger.info("TEST...Restart....");
		
            try {
                // Setup the Job class and the Job group
                JobDetail job = newJob(QuartzJob.class).withIdentity(
                                "CronQuartzJob", "Group").build();

                // Create a Trigger that fires every 5 minutes.
                Trigger trigger = newTrigger()
                .withIdentity("TriggerName", "Group")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/30 * * * * ?"))
                .build();

                // Setup the Job and Trigger with Scheduler & schedule jobs
                scheduler = new StdSchedulerFactory().getScheduler();
                scheduler.start();
                scheduler.scheduleJob(job, trigger);
                

        }
            catch (SchedulerException e) {
                e.printStackTrace();
        }
			

			
			
			
			
			out.print("<BR><A HREF='./index.html'>Job Schedule Shutdown...Back To Home Page</A><BR>");
	}

}
