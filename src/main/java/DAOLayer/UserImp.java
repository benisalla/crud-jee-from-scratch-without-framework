package DAOLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import MetierLayer.User;

public class UserImp implements IUserDao {

	@Override
	public User save(User user) {
		Connection connection = SinglotonContext.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("insert into user(name,gender,email,profession) values (?,?,?,?)");
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getGender());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getProfession());
			ps.executeUpdate();
			ps.close();
			
			PreparedStatement ps1 = connection.prepareStatement("select max(id) as lastID from user");
			ResultSet rs1  = ps1.executeQuery();
			if(rs1 != null) {
				while(rs1.next()) {
					user.setId(rs1.getInt("lastID"));
				}
			}
			return user;
		} catch (SQLException e) {
			System.out.println("error in save");
			return null;
		}
	}

	@Override
	public User getUser(int id) {
		Connection connection = SinglotonContext.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from user where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			User user = new User();
			if(rs != null) {
				while(rs.next()) {
					user.setId(rs.getInt("id"));
					user.setName(rs.getString("name"));
					user.setEmail(rs.getString("email"));
					user.setGender(rs.getString("gender"));
					user.setProfession(rs.getString("profession"));
				}
				return user;
			}else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("error in getUser");
			return null;
		}
	}
	
	@Override
	public List<User> getUsers() {
		Connection connection = SinglotonContext.getConnection();
		List<User> users = new ArrayList<User>();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from user");
			ResultSet rs = ps.executeQuery();
			if(rs != null) {
				while(rs.next()) {
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setName(rs.getString("name"));
					user.setEmail(rs.getString("email"));
					user.setGender(rs.getString("gender"));
					user.setProfession(rs.getString("profession"));
					users.add(user);
				}
				return users;
			}else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("error in getUsers");
			return null;
		}
	}

	@Override
	public int deleteUser(int id) {
		Connection connection = SinglotonContext.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("delete from user where id = ?");
			ps.setInt(1, id);
			int result = ps.executeUpdate();
			ps.close();
			return result;
		} catch (SQLException e) {
			System.out.println("error in deleteUser");
			return -1;
		}
	}

	@Override
	public User UpdateUser(User user) {
		Connection connection = SinglotonContext.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("update user set name=?, gender=?, email=?, profession=? where id = ?");
			ps.setString(1, user.getName());
			ps.setString(2, user.getGender());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getProfession());
			ps.setInt(5, user.getId());
			
			ps.executeUpdate();
			ps.close();
			return getUser(user.getId());
		} catch (SQLException e) {
			System.out.println("error in updateUser");
			return null;
		}
	}

	@Override
	public List<User> SearchByHint(String hint) {
		Connection connection = SinglotonContext.getConnection();
		List<User> users = new ArrayList<User>();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from user where name like ? or email like ? or profession like ? or id like ?");
			ps.setString(1, hint);
			ps.setString(2, hint);
			ps.setString(3, hint);
			ps.setString(4, hint);
			ResultSet rs = ps.executeQuery();
			if(rs != null) {
				while(rs.next()) {
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setName(rs.getString("name"));
					user.setEmail(rs.getString("email"));
					user.setGender(rs.getString("gender"));
					user.setProfession(rs.getString("profession"));
					users.add(user);
				}
				return users;
			}else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("error in search users");
			return null;
		}
	}
	

//	public static void main(String[] args) {
//		UserImp userImp = new UserImp();
//		
//		System.out.println(userImp.SearchByHint("%36%"));
//	}

}
