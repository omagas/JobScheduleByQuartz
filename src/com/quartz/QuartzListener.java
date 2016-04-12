package com.quartz;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;


import java.util.Date;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;

public class QuartzListener implements ServletContextListener {
    Scheduler scheduler = null;

    @Override
    public void contextInitialized(ServletContextEvent servletContext) {
            System.out.println("Context Initialized");
            Logger logger = Logger.getLogger(QuartzListener.class);	
            logger.info(".........Context Initialized.........");
            
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
    }

    public Scheduler getScheduler() {
		return scheduler;
	}

	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}

	@Override
    public void contextDestroyed(ServletContextEvent servletContext) {
            System.out.println("Context Destroyed");
            try 
            {
                    scheduler.shutdown();
            } 
            catch (SchedulerException e) 
            {
                    e.printStackTrace();
            }
    }
}
