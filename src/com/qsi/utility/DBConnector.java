package com.qsi.utility;


import java.io.IOException;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

//import org.apache.log4j.Logger;


public class DBConnector {
   
  //private Logger logger = Logger.getLogger(DBConnection.class);
	
	
	  /**
	  * @author Nimbus of Advtek Crop.
	  * 
	  * @return ��o weblogic DataSource ���s�u
	  **/
	  public Connection getConnection(String sJNDI) throws NamingException, SQLException {
	    Context context = new InitialContext();
	    javax.sql.DataSource ds = (javax.sql.DataSource) context.lookup(sJNDI);
	    return ds.getConnection();
	  }
	
	
	
	
	
//  
//  /**
//   * Constructor
//   */
//  public DBConnector() {}
//  
//  //----------------------------------------------------------------------------
//  public Connection getErpConnection() throws Exception { 
//    String sDataSource = "jdbc/gpErpDs";
//    return getConnection(sDataSource); 
//  }
//  
//  //----------------------------------------------------------------------------
//  public Connection getConnection(String sDataSource) throws SQLException {
//    Connection conn = null;
//    
//    try {
//      InitialContext ic = new InitialContext();
//      javax.sql.DataSource ds=(javax.sql.DataSource) ic.lookup(sDataSource);
//      conn = ds.getConnection();
//    }    
//    catch (Exception e) {  
//      //logger.error("====makeConnection====");      
//      //logger.error(e.toString());
//    }
//    finally {
//      if (conn!=null) {
//        conn.setAutoCommit(false);
//        Statement stamt = conn.createStatement();
//        stamt.execute("ALTER SESSION SET CURRENT_SCHEMA=qss");
//        if (stamt!=null)  stamt.close();
//      }        
//    }
//    
//    return conn;
//  }
} 