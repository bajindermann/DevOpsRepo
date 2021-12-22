package com.consulting.dao;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.apache.log4j.Logger;
import com.consulting.common.vo.sendMail;
import com.consulting.db.ConnectionFactory;
import com.consulting.vo.User;

public class UserManagerDBdao {

	private Connection con = null;
	private static final Logger log = Logger.getLogger(UserManagerDBdao.class);
	User usrdtls = new User();
	public static final String AES = "AES";

	private static byte[] hexStringToByteArray(String s) {
		byte[] b = new byte[s.length() / 2];
		for (int i = 0; i < b.length; i++) {
			int index = i * 2;
			int v = Integer.parseInt(s.substring(index, index + 2), 16);
			b[i] = (byte) v;
		}
		return b;
	}

	private static String byteArrayToHexString(byte[] b) {
		StringBuffer sb = new StringBuffer(b.length * 2);
		for (int i = 0; i < b.length; i++) {
			int v = b[i] & 0xff;
			if (v < 16) {
				sb.append('0');
			}
			sb.append(Integer.toHexString(v));
		}
		return sb.toString().toUpperCase();
	}

	public User authenticate(String userId, String userPassword) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, IOException
    { 
     String key = "DB99A2A8EB6904F492E9DF0595ED683C";
     byte[] bytekey = hexStringToByteArray(key);
     SecretKeySpec sks = new SecretKeySpec(bytekey, UserManagerDBdao.AES);
     Cipher cipher = Cipher.getInstance(UserManagerDBdao.AES);
     cipher.init(Cipher.ENCRYPT_MODE, sks, cipher.getParameters());
     byte[] encrypted = cipher.doFinal(userPassword.getBytes());
     String encryptedpwd = byteArrayToHexString(encrypted);
     System.out.println("encryptedpwd"+encryptedpwd);   
     cipher.init(Cipher.DECRYPT_MODE, sks);
     byte[] decrypted = cipher.doFinal(hexStringToByteArray(encryptedpwd));
     String OriginalPassword = new String(decrypted);
     System.out.println("****************  Original Password  ****************");
     System.out.println(OriginalPassword);
	 User user=null;
     con = ConnectionFactory.getConnection();
     String strQ = "SELECT * FROM user_master WHERE  LOGIN_ID=? "
	    + "AND BINARY PASSWORD=?";   
   
    try {
		PreparedStatement preparedStatement=con.prepareStatement(strQ);
	    preparedStatement.setString(1,userId);
	    preparedStatement.setString(2,encryptedpwd);	     
	    ResultSet resultSet=preparedStatement.executeQuery();  
	    System.out.println("userid"+strQ);
	    if(resultSet.next())
	    {
	     
	    	user=new User();
				user.setUserId(String.valueOf(resultSet.getInt("USER_ID")));
				user.setUserName(resultSet.getString("USER_NAME") == null ? ""
						: resultSet.getString("USER_NAME")); 
			 user.setAddress(resultSet.getString("LOGIN_ID") == null ? ""
						: resultSet.getString("LOGIN_ID"));
			 user.setRole(resultSet.getString("ROLE") == null ? ""
						: resultSet.getString("ROLE"));
  
		}			 
 
	} catch (Exception e) {
	    
	    e.printStackTrace();
	    log.error("Error in Authencation"+e);
	}
	finally{
	    if(con!=null)
	    {
		try {
		    con.close();
		} catch (SQLException e) {
		   
		    e.printStackTrace();
		    log.error("Error in Closing"+e);
		}
	    }
	    
	}

	return user;
    }
	public User authenticateuser(String userId) {
		User user = null;
		con = ConnectionFactory.getConnection();
		String strQ = "SELECT * FROM user_master  WHERE  LOGIN_ID=?" + "  AND STATUS='Y'";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(strQ);
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user = new User();
				user.setUserId(String.valueOf(resultSet.getInt("USER_ID")));

				user.setUserName(resultSet.getString("USER_NAME") == null ? "" : resultSet.getString("USER_NAME"));
				user.setAddress(resultSet.getString("LOGIN_ID") == null ? "" : resultSet.getString("LOGIN_ID"));
				user.setEmail(resultSet.getString("email") == null ? "" : resultSet.getString("email"));
				user.setRole(resultSet.getString("role") == null ? "" : resultSet.getString("role"));
				user.setLocation(resultSet.getString("location") == null ? "" : resultSet.getString("location"));
			}

		} catch (Exception e) {

			e.printStackTrace();
			log.error("Error in Authencation" + e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
					log.error("Error in Closing" + e);
				}
			}

		}
		return user;
	}

	public List<User> viewUser() {
		List<User> userlist = new ArrayList<User>();
		User user = null;
		con = ConnectionFactory.getConnection();
		String strQ = "SELECT * FROM user_master";

		try {
			PreparedStatement preparedStatement = con.prepareStatement(strQ);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				user = new User();

				/*
				 * String key = "DB99A2A8EB6904F492E9DF0595ED683C"; byte[] bytekey =
				 * hexStringToByteArray(key); SecretKeySpec sks = new SecretKeySpec(bytekey,
				 * UserManagerDBdao.AES); Cipher cipher =
				 * Cipher.getInstance(UserManagerDBdao.AES); cipher.init(Cipher.ENCRYPT_MODE,
				 * sks, cipher.getParameters()); //byte[] encrypted =
				 * cipher.doFinal(userPassword.getBytes()); //String encryptedpwd =
				 * byteArrayToHexString(encrypted); //
				 * System.out.println("encryptedpwd"+encryptedpwd);
				 * cipher.init(Cipher.DECRYPT_MODE, sks); byte[] decrypted =
				 * cipher.doFinal(hexStringToByteArray(resultSet.getString("PASSWORD"))); String
				 * OriginalPassword = new String(decrypted);
				 * System.out.println("decrepted password---"+OriginalPassword);
				 */

				user.setUserId(String.valueOf(resultSet.getInt("USER_ID")));
				user.setUserName(resultSet.getString("USER_NAME") == null ? "" : resultSet.getString("USER_NAME"));
				user.setLoginId(resultSet.getString("LOGIN_ID") == null ? "" : resultSet.getString("LOGIN_ID"));
				user.setEmail(resultSet.getString("EMAIL") == null ? "" : resultSet.getString("EMAIL"));
				user.setMobile(resultSet.getString("MOBILE") == null ? "" : resultSet.getString("MOBILE"));
				user.setStatus(resultSet.getString("STATUS") == null ? "" : resultSet.getString("STATUS"));
				user.setRole(resultSet.getString("role") == null ? "" : resultSet.getString("role"));
				user.setDesignation(resultSet.getString("DESIGNATION") == null ? "" : resultSet.getString("DESIGNATION"));
				userlist.add(user);
			}

		} catch (Exception e) {

			e.printStackTrace();
			log.error("Error in Authencation" + e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
					log.error("Error in Closing" + e);
				}
			}

		}

		return userlist;
	}

	public User editUser(int userId) {
		User user = null;
		con = ConnectionFactory.getConnection();
		String strQ = "SELECT * FROM user_master where USER_ID=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(strQ);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				user = new User();
				user.setUserId(String.valueOf(resultSet.getInt("USER_ID")));
				user.setUserName(resultSet.getString("USER_NAME") == null ? "" : resultSet.getString("USER_NAME"));
				user.setLoginId(resultSet.getString("LOGIN_ID") == null ? "" : resultSet.getString("LOGIN_ID"));
				user.setEmail(resultSet.getString("EMAIL") == null ? "" : resultSet.getString("EMAIL"));
				user.setMobile(resultSet.getString("MOBILE") == null ? "" : resultSet.getString("MOBILE"));
				user.setStatus(resultSet.getString("STATUS") == null ? "" : resultSet.getString("STATUS"));
				user.setDesignation(
						resultSet.getString("DESIGNATION") == null ? "" : resultSet.getString("DESIGNATION"));
				user.setRole(resultSet.getString("role") == null ? "" : resultSet.getString("role"));				 
				System.out.println(user.getUserName());
			}

		} catch (Exception e) {

			e.printStackTrace();
			log.error("Error in Authencation" + e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
					log.error("Error in Closing" + e);
				}
			}

		}

		return user;
	}

	public boolean chekUser(String userId)

	{
		boolean flag = false;
		con = ConnectionFactory.getConnection();
		try {
			String strQMaster = "SELECT * FROM user_master  WHERE  LOGIN_ID=?";
			PreparedStatement ptstmt = con.prepareStatement(strQMaster);
			ptstmt.setString(1, userId.replaceAll("[^a-zA-Z0-9@\\-_.]+","").trim());
			ResultSet rs = ptstmt.executeQuery();
			if (rs.next()) {
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {

			}
		}
		return flag;
	}

	public int chekUsercount()

	{
		int total = 0;
		con = ConnectionFactory.getConnection();
		try {
			String strQMaster = "SELECT count(*) as totaluser FROM user_master";
			PreparedStatement ptstmt = con.prepareStatement(strQMaster);
			ResultSet rs = ptstmt.executeQuery();
			if (rs.next()) {
				total = rs.getInt("totaluser");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {

			}
		}
		System.out.println("total--" + total);
		return total;
	}

	public boolean chekoldpassword(String userId, String oldpassword)

	{
		boolean flag = false;
		con = ConnectionFactory.getConnection();
		try {
			String strQMaster = "SELECT * FROM user_master  WHERE  USER_ID=? and PASSWORD=?";
			String key = "DB99A2A8EB6904F492E9DF0595ED683C";
			byte[] bytekey = hexStringToByteArray(key);
			SecretKeySpec sks = new SecretKeySpec(bytekey, UserManagerDBdao.AES);
			Cipher cipher = Cipher.getInstance(UserManagerDBdao.AES);
			cipher.init(Cipher.ENCRYPT_MODE, sks, cipher.getParameters());
			byte[] encrypted = cipher.doFinal(oldpassword.getBytes());
			String encryptedpwd = byteArrayToHexString(encrypted);

			PreparedStatement ptstmt = con.prepareStatement(strQMaster);
			ptstmt.setInt(1, Integer.parseInt(userId));
			ptstmt.setString(2, encryptedpwd);
			ResultSet rs = ptstmt.executeQuery();
			if (rs.next()) {
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {

			}
		}
		return flag;
	}

	public boolean updateoldPassword(String userId, String oldpassword, String newpassword)

	{
		boolean flag = false;
		con = ConnectionFactory.getConnection();
		try {
			String strQMaster = "update user_master set PASSWORD=?  WHERE  USER_ID=? and PASSWORD=?";
			String key = "DB99A2A8EB6904F492E9DF0595ED683C";
			byte[] bytekey = hexStringToByteArray(key);
			SecretKeySpec sks = new SecretKeySpec(bytekey, UserManagerDBdao.AES);
			Cipher cipher = Cipher.getInstance(UserManagerDBdao.AES);
			cipher.init(Cipher.ENCRYPT_MODE, sks, cipher.getParameters());
			byte[] encrypted = cipher.doFinal(oldpassword.getBytes());
			byte[] encryptednpass = cipher.doFinal(newpassword.getBytes());
			String encryptedpwd = byteArrayToHexString(encrypted);
			String encryptednewpwd = byteArrayToHexString(encryptednpass);

			PreparedStatement ptstmt = con.prepareStatement(strQMaster);
			ptstmt.setString(1, encryptednewpwd);
			ptstmt.setInt(2, Integer.parseInt(userId));
			ptstmt.setString(3, encryptedpwd);
			int k = ptstmt.executeUpdate();
			if (k > 0) {
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {

			}
		}
		return flag;
	}

	public boolean chekUsertwo(User userdetails)

	{
		boolean flag = false;
		con = ConnectionFactory.getConnection();
		int i = 0;
		try {
			String strQMaster = "SELECT * FROM user_master  WHERE  LOGIN_ID=?";
			PreparedStatement ptstmt = con.prepareStatement(strQMaster);
			ptstmt.setString(1, userdetails.getLoginId().replaceAll("[^a-zA-Z0-9@\\-_.]+","").trim());	
			ResultSet rs = ptstmt.executeQuery();
			while (rs.next()) {
				if (Integer.parseInt(userdetails.getUserId()) == rs.getInt("USER_ID")) {

				} else {
					flag = true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {

			}
		}
		return flag;
	}

	public boolean adduser(String userName, String userId, String mobNo, String email, String designation,
			String role, String status)

	{
		boolean flag = false;
		con = ConnectionFactory.getConnection();
		try {
			Random rand = new Random();
			int value = rand.nextInt(900) + 100;
			String key = "DB99A2A8EB6904F492E9DF0595ED683C";
			byte[] bytekey = hexStringToByteArray(key);
			SecretKeySpec sks = new SecretKeySpec(bytekey, UserManagerDBdao.AES);
			Cipher cipher = Cipher.getInstance(UserManagerDBdao.AES);
			cipher.init(Cipher.ENCRYPT_MODE, sks, cipher.getParameters());
			byte[] encrypted = cipher.doFinal((userId.replaceAll("[+^:,$&%!*#=(){}]", "").replaceAll(" ", "").trim()
					+ "@" + String.valueOf(value)).getBytes());
			String encryptedpwd = byteArrayToHexString(encrypted);
			System.out.println("encryptedpwd" + encryptedpwd);
			cipher.init(Cipher.DECRYPT_MODE, sks);
			byte[] decrypted = cipher.doFinal(hexStringToByteArray(encryptedpwd));
			String OriginalPassword = new String(decrypted);
			System.out.println("****************  Original Password  ****************");
			System.out.println(OriginalPassword);

			con.setAutoCommit(false);
			String strQMaster = "insert into user_master (LOGIN_ID,PASSWORD,USER_NAME,STATUS,EMAIL,MOBILE,ROLE,DESIGNATION)"
					+ "VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement ptstmt = con.prepareStatement(strQMaster);
			ptstmt.setString(1, userId.replaceAll("[^a-zA-Z0-9@\\-_.]+","").trim());			
			ptstmt.setString(2, encryptedpwd);
			ptstmt.setString(3, userName.replaceAll("[^a-zA-Z0-9\\s.]+","").trim());
			ptstmt.setString(4, status.replaceAll("[^A-Z]+", "").trim());
			ptstmt.setString(5, email.replaceAll("[^a-zA-Z0-9@\\-_.]+","").trim());
			ptstmt.setString(6, mobNo.replaceAll("[^0-9]+", "").trim());
			ptstmt.setString(7, role);
			ptstmt.setString(8, designation.replaceAll("[^a-zA-Z0-9\\s.]+","").trim());			 
			int k = ptstmt.executeUpdate();
			System.out.println("Execution Done!!!");
			if (k > 0) {
				flag = true;
			}
			con.commit();
			StringBuffer body = new StringBuffer();
			body.append(userId.replaceAll("[+^:,$&%!*#=(){}]", "").trim() + "  and password "
					+ (userId.replaceAll("[+^:,$&%!*#=(){}]", "").replaceAll(" ", "").trim() + "@"
							+ String.valueOf(value)));
			sendMail smail = new sendMail();
			/*
			 * if (smail.sendmail(email.trim(), "rms.sislinfotech.com", "GOVT-Sales",
			 * "Govt-Sales App authorization", body.toString(), userName.trim())) {
			 * 
			 * }
			 */
		} catch (Exception e) {
			e.printStackTrace();

		}

		finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {

			}
		}
		return flag;
	}

	public boolean updateuser(User userdetails)

	{
		boolean flag = false;
		con = ConnectionFactory.getConnection();
		try {
			con.setAutoCommit(false);
			String strQMaster = "update user_master set LOGIN_ID=?,USER_NAME=?,STATUS=?,EMAIL=?,MOBILE=?,DESIGNATION=?,ROLE=? where USER_ID=?";
			PreparedStatement ptstmt = con.prepareStatement(strQMaster);
			ptstmt.setString(1, userdetails.getLoginId().replaceAll("[^a-zA-Z0-9@\\-_.]+","").trim());	
			ptstmt.setString(2, userdetails.getUserName().replaceAll("[^a-zA-Z0-9\\s.]+","").trim());
			ptstmt.setString(3, userdetails.getStatus().replaceAll("[^A-Z]+", "").trim());
			ptstmt.setString(4, userdetails.getEmail().replaceAll("[^a-zA-Z0-9@\\-_.]+","").trim());
			ptstmt.setString(5, userdetails.getMobile().replaceAll("[^0-9]+", "").trim());
			ptstmt.setString(6, userdetails.getDesignation().replaceAll("[^a-zA-Z0-9\\s.]+","").trim());
			ptstmt.setString(7, userdetails.getRole().replaceAll("[^a-zA-Z\\-]+","").trim());
			ptstmt.setInt(8, Integer.parseInt(userdetails.getUserId().trim()));

			int k = ptstmt.executeUpdate();
			System.out.println("Execution Done!!!");
			if (k > 0) {
				flag = true;
			}
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();

		}

		finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {

			}
		}
		return flag;
	}

	public List<User> viewUserDetails(User user) {
		List<User> userList = new ArrayList<>();
		try {

			con = ConnectionFactory.getConnection();

			String str = "select * from user_master where 1=1";
			// System.out.println(user.getRole()+"role");
			if (user != null) {
				if (user.getUserName() != null && user.getUserName().length() != 0) {
					str += " and UPPER(user_Name) LIKE '" + user.getUserName().toUpperCase() + "%'";
				}
				if (user.getEmail() != null && user.getEmail().length() != 0) {
					str += " and UPPER(email) LIKE '" + user.getEmail().toUpperCase() + "%'";
				}
				if (user.getRole() != null && user.getRole().length() != 0) {
					str += " and LOWER(role) LIKE '" + user.getRole() + "%'";
				} // WHY ERROR WHEN NO %
			}
			PreparedStatement pstmt = con.prepareStatement(str);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				User userdtls = new User();
				userdtls.setUserId(String.valueOf(rs.getInt("USER_ID")));
				userdtls.setUserName(rs.getString("USER_NAME") == null ? "" : rs.getString("USER_NAME"));
				userdtls.setAddress(rs.getString("LOGIN_ID") == null ? "" : rs.getString("LOGIN_ID"));
				userdtls.setEmail(rs.getString("email") == null ? "" : rs.getString("email"));
				userdtls.setMobile(rs.getString("mobile") == null ? "" : rs.getString("mobile"));
				userdtls.setPhoto(rs.getString("photo") == null ? "" : rs.getString("photo"));
				userdtls.setRole(rs.getString("role") == null ? "" : rs.getString("role"));
				userList.add(userdtls);
			}
		} catch (Exception e) {
			e.printStackTrace();

			log.error("Error in closing" + e);
		} finally {

			try {

				if (con != null) {

					con.close();

				}

			} catch (Exception e) {

				log.error("Error in closing" + e);

			}

		}
		System.out.println("List size" + userList.size());
		return userList;
	}

	public boolean save(User user) {
		boolean flag = false;
		con = ConnectionFactory.getConnection();
		try {
			con.setAutoCommit(false);
			String strQMaster = "insert into user_master (LOGIN_ID,LOGIN_PASSWORD,USER_NAME,STATUS,EMAIL,PHOTO,MOBILE,ROLE)"
					+ "VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement ptstmt = con.prepareStatement(strQMaster);
			ptstmt.setString(1, user.getLoginId());
			ptstmt.setString(2, user.getLoginId() + user.getUserId());
			ptstmt.setString(3, user.getUserName());
			ptstmt.setString(4, "Y");
			ptstmt.setString(5, user.getEmail());
			ptstmt.setString(6, user.getPhoto());
			ptstmt.setString(7, user.getMobile());
			ptstmt.setString(8, user.getRole());
			System.out.println("User name " + user.getUserName());

			int k = ptstmt.executeUpdate();
			System.out.println("Execution Done!!!");

			if (k > 0) {
				flag = true;

			}
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();

		}

		finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {

			}
		}
		return flag;
	}

	public boolean acessLogin(int userID, String sessionId, String Date, String ipAddress) {
		String strQ = "INSERT INTO acess_log 	(user_id,session_id,DATE,ip_address) VALUES(?,?,?,?)";
		boolean flag = false;
		con = ConnectionFactory.getConnection();
		try {

			PreparedStatement preparedStatement = con.prepareStatement(strQ);
			preparedStatement.setInt(1, userID);
			preparedStatement.setString(2, sessionId);
			preparedStatement.setString(3, Date);
			preparedStatement.setString(4, ipAddress);
			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				flag = true;
			} else {
				flag = false;
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

}
