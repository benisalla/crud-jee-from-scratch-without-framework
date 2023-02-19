package Models;

import java.util.ArrayList;
import java.util.List;

import MetierLayer.User;

public class UserModel {
	
	private List<User> users = new ArrayList<User>();

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
