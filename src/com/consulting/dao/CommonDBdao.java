package com.consulting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.consulting.ajax.City;
import com.consulting.ajax.State;
import com.consulting.db.ConnectionFactory;

public class CommonDBdao {
	Logger log = Logger.getLogger(this.getClass());

	private List<State> states = new ArrayList<State>();

	private Map stateCityMap;

	private Connection con = null;

	public CommonDBdao() {

	}

	public List getAllStates() {
		       con = ConnectionFactory.getConnection();
		      
		       try {
			
			String strQ = "select * from state_master where STATUS='Y'  order by STATE_NAME  ASC";
			Statement stmt = con.createStatement();
			ResultSet rSet = stmt.executeQuery(strQ);
			while (rSet.next()) {
				State state = new State();
				state.setId(rSet.getInt("STATE_ID") == 0 ? 0 : rSet
						.getInt("STATE_ID"));
				state.setName(rSet.getString("STATE_NAME") == null ? "" : rSet
						.getString("STATE_NAME"));
				states.add(state);
			}

		} catch (Exception e) {
			log.error("Error in getting state list" + e);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				log.error("Error in closing" + e);
			}
		}

		return states;
	}

	public Map getAllCitiesState() {
		con = ConnectionFactory.getConnection();
		
		try {
			stateCityMap = new HashMap();
			 
			String strQ = "select * from city_master where STATUS='Y'";
			Statement stmt = con.createStatement();
			ResultSet rSet = stmt.executeQuery(strQ);
			while (rSet.next()) {
				List cities = new ArrayList();
				cities.add(new City(rSet.getString("CITY_NAME") == null ? ""
						: rSet.getString("CITY_NAME"),
						rSet.getInt("CITY_ID") == 0 ? 0 : rSet
								.getInt("CITY_ID")));
				stateCityMap.put(rSet.getInt("STATE_ID") == 0 ? 0 : rSet
						.getInt("STATE_ID"), cities);
			}

		} catch (Exception e) {
			log.error("Error in getting state city list" + e);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				log.error("Error in closing" + e);
			}
		}

		return stateCityMap;
	}

	public int getPrevLastDay() {
		int retVal = 0;
		con = ConnectionFactory.getConnection();
		try {

			 
			String strQ = "SELECT  DATE_FORMAT(SUBDATE(CURDATE(), INTERVAL 1 MONTH), '%m')    as last_day ";
			Statement stmt = con.createStatement();
			ResultSet rSet = stmt.executeQuery(strQ);
			if (rSet.next()) {
				retVal = rSet.getInt("last_day");

			}
		} catch (Exception e) {
			log.error("Error in getting last_day " + e);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				log.error("Error in closing" + e);
			}
		}

		return retVal;
	}

	public int getPrevYear() {
		int retVal = 0;
		con = ConnectionFactory.getConnection();
		try {

			 
			String strQ = "SELECT  DATE_FORMAT(SUBDATE(CURDATE(), INTERVAL 1 YEAR), '%Y')    as last_day ";
			Statement stmt = con.createStatement();
			ResultSet rSet = stmt.executeQuery(strQ);
			if (rSet.next()) {
				retVal = rSet.getInt("last_day");

			}
		} catch (Exception e) {
			log.error("Error in getting last_day " + e);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				log.error("Error in closing" + e);
			}
		}

		return retVal;
	}
	
	
	public boolean acessLogin(String userID,String sessionId,String Date,String ipAddress) {
		String strQ="INSERT INTO acess_log 	(user_id,session_id,DATE,ip_address) VALUES(?,?,?,?)";
		boolean flag=false;
		con = ConnectionFactory.getConnection();
		try {
			 
			PreparedStatement preparedStatement=con.prepareStatement(strQ);
			preparedStatement.setString(1,userID);
			preparedStatement.setString(2,sessionId);
			preparedStatement.setString(3,Date);
			preparedStatement.setString(4,ipAddress);
			int i=preparedStatement.executeUpdate();
			if(i>0)
			{
				flag=true;
			}
			else
			{
				flag=false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error in acessLog function" + e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					log.error("Error in acessLog final" + e);
					e.printStackTrace();
				}
			}

		}
		return flag;
	}

	public boolean acessLogOut(String sessionId,String Date) {
		System.out.println("123456789");
		String strQ=" update acess_log " 
	               + " SET logout_time = now()"
	               + " WHERE session_id= ?  and  date =? ";
		con = ConnectionFactory.getConnection();
		boolean flag=false;
		try {
			 
//			PreparedStatement preparedStatement=con.prepareStatement(strQ);
//			preparedStatement.setString(1,sessionId);
//			preparedStatement.setString(2,Date);
//			int i=preparedStatement.executeUpdate();
//			if(i>0)
//			{
//				flag=true;
//			}
//			else
//			{
//				flag=false;
//			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error in acessLogOut function" + e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					log.error("Error in acessLog final" + e);
					e.printStackTrace();
				}
			}

		}
		return flag;
	}

	
	
}
