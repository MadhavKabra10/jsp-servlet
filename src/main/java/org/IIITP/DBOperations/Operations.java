package org.IIITP.DBOperations;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.IIITP.Users.*;
import org.IIITP.connect.*;

public class Operations {
	public static List<User> listAllUsers() throws Exception{
		List<User> allUsers = new ArrayList<>();
		Connection connect = DBConnection.getConnection();
		java.sql.Statement st = null;
		ResultSet set = null;
		String query = "SELECT * FROM Users";
		try {
			st =  connect.createStatement();
			set =  st.executeQuery(query);
			while(set.next()) {
				allUsers.add(new User(set.getInt("user_id"),set.getString("username"),set.getString("email")));
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		connect.close();
		return allUsers;
	}
	public static void addUser(User newUser){
		Connection connect = null;
		PreparedStatement st = null;
		try {
			connect = DBConnection.getConnection();
			String username = newUser.getUsername();
			String email = newUser.getEmail();
			int user_id = newUser.getUser_id();
			String query = "INSERT INTO USERS VALUES(?,?,?)";
			st = connect.prepareStatement(query);
			st.setInt(1, user_id);
			st.setString(2,username);
			st.setString(3, email);
			st.execute();
			connect.close();
		}catch(SQLException e) {
			System.out.println("Bakwaas coder");
		} catch (Exception e) {
			System.out.print("Bekar Coder!");
		}
	}
	public static void UpdateUser(User currUser){
		Connection connection = null;
		PreparedStatement statement = null;
		try{
			connection = DBConnection.getConnection();
			String username = currUser.getUsername();
			String email = currUser.getEmail();
			int user_id = currUser.getUser_id();
			String query = "UPDATE USERS SET username = ?, email = ? where user_id = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1,username);
			statement.setString(2,email);
			statement.setInt(3, user_id);
			statement.execute();
			connection.close();
		} catch (Exception e) {
			System.out.println("No connection obj found");
        }
    }
	public static int getUserId(User currUser) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = DBConnection.getConnection();
			String username = currUser.getUsername();
			String email = currUser.getEmail();
			int user_id = -1;
			String query = "SELECT user_id FROM Users WHERE username = ? AND email = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, email);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user_id = resultSet.getInt("user_id");
			}
			connection.close();
			return user_id;
		} catch (SQLException e) {
			System.out.print("SQL Exception");
		} catch (Exception e) {
			System.out.print("Exception!!!!!");
		}
		return -1;
	}
	public static void deleteUser(User currUser){
		Connection connection = null;
		PreparedStatement statement = null;
		try{
			connection = DBConnection.getConnection();
			int id = currUser.getUser_id();
			String query = "DELETE FROM Users WHERE user_id = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1,id);
			statement.execute();
			connection.close();
		} catch (Exception e) {
			System.out.println("Connection object not found");
        }
    }
}
