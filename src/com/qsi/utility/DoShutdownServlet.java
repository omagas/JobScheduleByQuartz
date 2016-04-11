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
import java.sql.SQLException;
import java.util.Enumeration;

import java.sql.*;
import javax.sql.*;

import org.apache.log4j.Logger;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.quartz.impl.StdSchedulerFactory;

import com.quartz.*;
public class DoShutdownServlet extends HttpServlet {
	
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			
		
		Logger logger = Logger.getLogger(DoShutdownServlet.class);	
	        response.setContentType("text/html");
	        ServletOutputStream out = response.getOutputStream();
	        
			String updatevalue = request.getParameter("updatevalue");			
			logger.info("TEST..."+updatevalue);
		
			
			

			
			
			
			
			out.print("<BR><A HREF='./index.html'>Back To Home Page</A><BR>");
	}

}
