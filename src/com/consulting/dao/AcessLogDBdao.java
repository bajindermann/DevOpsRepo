package com.consulting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.consulting.common.CommonUtil;
import com.consulting.db.ConnectionFactory;
import com.consulting.vo.AcessLog;

public class AcessLogDBdao {

	Logger log = Logger.getLogger(this.getClass());

	private Connection con = null;

	private List<AcessLog> acesslog = new ArrayList<AcessLog>();

	public List getAllList(AcessLog acessLog) {

		con = ConnectionFactory.getConnection();
		StringBuilder builder = new StringBuilder();

		builder
				.append(" SELECT um.USER_NAME,um.ROLE, al.ip_address,al.DATE, TIME(al.login_time) AS logintime ,");
		builder.append(" TIME(al.logout_time) AS logouttime, ");
		builder.append(" TIMEDIFF(TIME(al.logout_time),TIME(al.login_time)) AS duration ");
		builder
				.append(" FROM acess_log al ,user_master um WHERE al.user_id=um.user_id  ");

		try { 
			PreparedStatement preparedStatement = con.prepareStatement(builder
					.toString());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				acessLog = new AcessLog();
				acessLog
						.setUserName(CommonUtil.capitalizeFirstLettersTokenizer(resultSet.getString("um.USER_NAME").toLowerCase()) == null ? ""
								: CommonUtil.capitalizeFirstLettersTokenizer(resultSet.getString("um.USER_NAME").toLowerCase()));
				acessLog.setRole(resultSet.getString("um.ROLE") == null ? ""
						: resultSet.getString("um.ROLE"));
				acessLog
						.setIpAddress(resultSet.getString("al.ip_address") == null ? ""
								: resultSet.getString("al.ip_address"));
				acessLog
						.setLoginTime(resultSet.getString("logintime") == null ? ""
								: resultSet.getString("logintime"));
				acessLog
						.setLogOutTime(resultSet.getString("logouttime")== null ? " Still logged in"
								: resultSet.getString("logouttime"));
				
	acessLog
						.setDuration(resultSet.getString("duration") == null ? ""
								: resultSet.getString("duration"));
			
				
				
				acessLog
				.setDate(resultSet.getString("al.DATE") == null ? ""
						: resultSet.getString("al.DATE"));

				acesslog.add(acessLog);
			}
		} catch (SQLException e) {

			e.printStackTrace();
			log.error("Error" + e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					log.equals("Error in closing connection" + e);
				}
			}
		}

		return acesslog;
	}
	
	public AcessLog getCurrentUsers(AcessLog acessLog)
	{
		
	String strQ=" SELECT count(*) as total FROM acess_log 	WHERE 		logout_time IS  NULL " ;
	con = ConnectionFactory.getConnection();
	try {
		PreparedStatement preparedStatement=con.prepareStatement(strQ);
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next())
		{
			acessLog =new AcessLog();
			
			acessLog.setTotalUsers(resultSet.getInt("total")==0 ? 0 : resultSet.getInt("total"));
			
			
			
			
		}
	} catch (SQLException e) {
		 
		e.printStackTrace();
		log.info("Error in "+e);
	}
	finally{
		
		if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				 
				log.info("Error in "+e);
			}
		}
		
		
	}
	
		
	return acessLog;
	}
	
	
}
