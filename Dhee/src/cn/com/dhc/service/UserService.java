package cn.com.dhc.service;

import java.sql.Connection;
import java.util.ArrayList;



import cn.com.dhc.bean.User;
import cn.com.dhc.dao.UserDaoImp;
import cn.com.dhc.utils.DButils;

public class UserService {
	public static boolean registerService(User u) {
		boolean flag = false;
		if(UserDaoImp.isName(u.getName())){
			UserDaoImp.insert(u);
			System.out.println("Service");
			flag = true;
		}
		return flag;
	}
	
	public static User loginService(String name) {
		User u = UserDaoImp.select_name(name);
		return u;
	}
	
	public static ArrayList<User> selectService(){
		ArrayList<User> list = UserDaoImp.selectDep();
		return list;  
	}
	
	public static boolean deleteService (String name ) {
		
		return UserDaoImp.delete(name);
	}
}
