package com.lalit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserService {
	UsersDao userDao = null;
	public UserService() {
		userDao = new UsersDao();
	}
	
	public Map<Integer, Users> getAllUsers(){
		return userDao.getUsers();
	}
	public List<Users> getUserAsList(){
		ArrayList< Users> userList= new ArrayList<>(userDao.getUsers().values());
		return userList;
	}
	public Users getUser(int id){
		return userDao.getUsers().get(id);
	}
	
	public boolean createUser(Users user){
		return userDao.insertUsers(user);
	}
	
	public boolean updateUsers(Users user){
		return userDao.updateUsers(user);
	}
	public boolean deleteUsers(int id){
		return userDao.deleteUsers(id);
	}
}
