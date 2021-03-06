package com.xamry.springboot.restful.springbootrestfulws.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class UserDaoService {
	
	private static List<User> userList = new ArrayList<>();
	
	private static int userCount = 3;
	
	static {
		userList.add(new User(1, "Adam", new Date()));
		userList.add(new User(2, "Eve", new Date()));
		userList.add(new User(3, "Jack", new Date()));		
	}
	
	public List<User> findAllUsers() {
		return userList;
	}
	
	public User addUser(User user) {
		if(user.getId() == null) {
			user.setId(++userCount);
		}
		userList.add(user);
		return user;		
	}
	
	public User findUser(Integer id) {
		for(User user : userList) {
			if(user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteUser(Integer id) {
		Iterator<User> iter = userList.iterator();
		
		while(iter.hasNext()) {
			User user = iter.next();
			
			if(user.getId().equals(id)) {
				iter.remove();
				return user;
			}
		}
		
		return null;
	}

}
