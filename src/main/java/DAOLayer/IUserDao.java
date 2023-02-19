package DAOLayer;

import java.util.List;

import MetierLayer.User;

public interface IUserDao {
	public User save(User user);
	public User getUser(int id);
	public List<User> getUsers();
	public int deleteUser(int id);
	public User UpdateUser(User user);
	public List<User> SearchByHint(String hint);
}
