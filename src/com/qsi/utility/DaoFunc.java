package com.qsi.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

/*
 * Author: Louie
 * Description: DB DAO Class 
 * 
 * */

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
	
	
	
public String Query_tc_pna_file(){
		StringBuffer sbSQL = new StringBuffer();
        Connection conn;
        String msgcontent = null;
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
						
						
						sbBodyColumn.append("<html>\n");
						sbBodyColumn.append("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>\n");
						sbBodyColumn.append("<body>\n");
						sbBodyColumn.append("<div style='margin-top:10px'>&nbsp;</div>\n");
					    sbBodyColumn.append("<table border='1' cellspacing='0' cellpadding='3' class='tbFrame'>\n");
					    sbBodyColumn.append("<tr>\n");
					    
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
					    sbBodyColumn.append("<tr class='tbBody' align='center'>");
					    sbBodyColumn.append("<td nowrap class='td_column' align='center'>2016-02-02 00:00:00.0</td>");
					    sbBodyColumn.append("<td nowrap class='td_column' align='center'>??</td>");
					    sbBodyColumn.append("<td nowrap class='td_column' align='center'>SPO1-1601000010</td>");
					    sbBodyColumn.append("<td nowrap class='td_column' align='center'>1</td>");
					    sbBodyColumn.append("<td nowrap class='td_column' align='center'>1</td>");
					    sbBodyColumn.append("<td nowrap class='td_column' align='center'>SPO1-1601000010</td>");
					    sbBodyColumn.append("<td nowrap class='td_column' align='center'>MEMORY IC,132BGA,32GB,64GBMA1YEX3 2P,4D,KK,PBF,CSS,SDSS HELEN - OEM(MHF)</td>");
					    sbBodyColumn.append("<td nowrap class='td_column' align='center'>7SD54-82-05444-032G</td>");
					    sbBodyColumn.append("<td nowrap class='td_column' align='center'>MEMORY IC,132BGA,32GB,64GBMA1YEX3 2P,4D,KK,PBF,CSS,SDSS HELEN - OEM(MHF)</td>");
					    sbBodyColumn.append("<td nowrap class='td_column' align='center'>5941.0</td>");
					    sbBodyColumn.append("<td nowrap class='td_column' align='center'>0.0</td>");
					    sbBodyColumn.append("<td nowrap class='td_column' align='center'>3.7228</td>");
					    sbBodyColumn.append("<td nowrap class='td_column' align='center'>3.0</td>");
					    sbBodyColumn.append("<td nowrap class='td_column' align='center'>2016-01-16 00:00:00.0</td>");
					    sbBodyColumn.append("<td nowrap class='td_column' align='center'>2016</td>");			    
					    
					    sbBodyColumn.append("</tr>\n");						    
					    sbBodyColumn.append("</table>\n");
					    sbBodyColumn.append("</div>\n");
					    sbBodyColumn.append("</body>\n");
					    sbBodyColumn.append("</html>\n");	
					    
					    
					    msgcontent=sbBodyColumn.toString();
					    
					    
						
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
		return msgcontent; 	
		
	}
	
	
}
