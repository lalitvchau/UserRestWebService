package com.lalit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UsersDao {

	private static Connection con = null;
	PreparedStatement pSt = null;
	ResultSet rs = null;

	public void  createDBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demodb", "root", "root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public void closeConnection() {

		try {
			if (con != null)
				con.close();
			if (pSt != null)
				pSt.close();
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean insertUsers(Users user) {
		try {
			createDBConnection();
			pSt = con.prepareStatement("insert into tb_web_user(id,name,addr) values(?,?,?)");
			pSt.setInt(1, user.getId());
			pSt.setString(2, user.getName());
			pSt.setString(3, user.getAddr());
			if (pSt.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}

		return false;
	}

	public boolean updateUsers(Users user) {
		try {
			createDBConnection();
			pSt = con.prepareStatement("update tb_web_user set name =?, addr =? where id =?");
			pSt.setInt(3, user.getId());
			pSt.setString(1, user.getName());
			pSt.setString(2, user.getAddr());
			if (pSt.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}

		return false;
	}

	public boolean deleteUsers(int user) {
		try {
			createDBConnection();
			pSt = con.prepareStatement("delete from  tb_web_user  where id =?");
			pSt.setInt(1, user);

			if (pSt.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}

		return false;
	}
	public Map<Integer,Users> getUsers(){
		Map<Integer,Users> map = new HashMap<>();
		createDBConnection();
		try {
			pSt = con.prepareStatement("select * from tb_web_user");
			rs=pSt.executeQuery();
			while(rs.next()){
				Users user= new Users();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setAddr(rs.getString("addr"));
				map.put(rs.getInt("id"), user);
			}
			return map;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}
		return null;
	}
}
