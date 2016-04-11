package com.qsi.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

public class DaoFunc {
	private Logger logger = Logger.getLogger(DaoFunc.class);

	public void Update_tc_pna_file(String TC_PNAUSER_Value){
		
        PreparedStatement pstmt;
        Connection conn;
        try {
        	DBConnector dbConn =new DBConnector();
        	conn = dbConn.getConnection("jdbc/gpErpDs");

			if(conn!=null){
			conn.setAutoCommit(false);
			Statement stamt=conn.createStatement();
			stamt.execute("ALTER SESSION SET CURRENT_SCHEMA=QSS");
			if (stamt!=null)  stamt.close();       	
        	
            pstmt = conn.prepareStatement("UPDATE tc_pna_file set TC_PNAUSER='"+TC_PNAUSER_Value+"' where　TC_PNA01='SPO1-1601000001'");
            logger.info("update submmit");
            pstmt.executeUpdate();
            conn.commit();
            
            pstmt.close();
            conn.close();
            
			}

        } catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		
	}
	
	
	
public void Query_tc_pna_file(){
		StringBuffer sbSQL = new StringBuffer();
        Connection conn;
        try {
        	DBConnector dbConn =new DBConnector();
        	conn = dbConn.getConnection("jdbc/gpErpDs");

			if(conn!=null){
			conn.setAutoCommit(false);
			Statement stamt=conn.createStatement();
			stamt.execute("ALTER SESSION SET CURRENT_SCHEMA=QSS");
			if (stamt!=null)  stamt.close();       	
        	
			logger.info("Success to get data source connection");
			sbSQL.append("select PMM01,PMM09,PMD07 from pmm_file,tc_pnb_file,pmd_file　where tc_pnb01=pmm01 and　PMD01=PMM09 and PMM01='SPO1-1601000001'");
            
		    PreparedStatement pst_pmcs = conn.prepareStatement(sbSQL.toString());
		    ResultSet rs_pmcs = pst_pmcs.executeQuery();
		    
		    StringBuffer sbBodyColumn    = new StringBuffer();
		    StringBuffer sbBodyContent   = new StringBuffer();
		    int i=0;
			      while (rs_pmcs.next())  {
			    	  	
			    	  
						logger.info("mail address:"+rs_pmcs.getString("PMM01"));
						logger.info("po:"+rs_pmcs.getString("PMM09"));
						logger.info("vendor:"+rs_pmcs.getString("PMD07"));
						
						
					    sbBodyColumn.append("<div style='margin-top:10px'>&nbsp;</div>\n");
					    sbBodyColumn.append("<table border='1' cellspacing='0' cellpadding='3' class='tbFrame'>\n");
					    sbBodyColumn.append("<tr>\n");
					    sbBodyColumn.append("  <th class='tbHeader' nowrap>廠商回覆備註說明</th>\n");
					    sbBodyColumn.append("  <th class='tbHeader' nowrap>變更日期</th>\n");
					    sbBodyColumn.append("  <th class='tbHeader' nowrap>變更原因</th>\n");
					    sbBodyColumn.append("  <th class='tbHeader' nowrap>採購單號</th>\n");
					    sbBodyColumn.append("  <th class='tbHeader' nowrap>變更序號</th>\n");
					    sbBodyColumn.append("  <th class='tbHeader' nowrap>採購單項次</th>\n");
					    sbBodyColumn.append("  <th class='tbHeader' nowrap>原採購單料號</th>\n");
					    sbBodyColumn.append("  <th class='tbHeader' nowrap>變更前品名規格</th>\n");
					    sbBodyColumn.append("  <th class='tbHeader' nowrap>變更後採購單料號</th>\n");
					    sbBodyColumn.append("  <th class='tbHeader' nowrap>變更後品名規格</th>\n");
					    sbBodyColumn.append("  <th class='tbHeader' nowrap>原訂單量</th>\n");
					    sbBodyColumn.append("  <th class='tbHeader' nowrap>變更後訂單量</th>\n");
					    sbBodyColumn.append("  <th class='tbHeader' nowrap>原單位稅單價</th>\n");
					    sbBodyColumn.append("  <th class='tbHeader' nowrap>變更後未稅單價</th>\n");
					    sbBodyColumn.append("  <th class='tbHeader' nowrap>原交期</th>\n");
					    sbBodyColumn.append("  <th class='tbHeader' nowrap>變更後交期</th>\n");
					    sbBodyColumn.append("</tr>\n");		
					    
					    
					    
						
						//i++;
			      }
		
			}

        } catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		
	}
	
	
}
