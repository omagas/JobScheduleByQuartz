package com.quartz;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

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
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/60 * * * * ?"))
                    .build();

                    // Setup the Job and Trigger with Scheduler & schedule jobs
                    scheduler = new StdSchedulerFactory().getScheduler();
                    scheduler.start();
                    scheduler.scheduleJob(job, trigger);
                    
                    for (String groupName : scheduler.getJobGroupNames()) {

                        for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {
                   				
                   	  String jobName = jobKey.getName();
                   	  String jobGroup = jobKey.getGroup();
                   				
                   	  //get job's trigger
                   	  List<Trigger> triggers = (List<Trigger>) scheduler.getTriggersOfJob(jobKey);
                   	  Date nextFireTime = triggers.get(0).getNextFireTime(); 

                   		System.out.println("[jobName] : " + jobName + " [groupName] : "
                   			+ jobGroup + " - " + nextFireTime);

                   	  }

                    }
            }
            catch (SchedulerException e) {
                    e.printStackTrace();
            }
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
