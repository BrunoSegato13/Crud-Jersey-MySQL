package br.com.portal.repository;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.portal.connection.ConnectionFactory;
import br.com.portal.model.User;

public class UserRepository {
	
	 public UserRepository() {
	 }
	 
	 public User save(User user) {
		 
		 String sql = "INSERT INTO user (user_name, user_password, user_role) VALUES (?,?,?)";
	     Connection connection = ConnectionFactory.getConnection();
	     
	     try {
	            PreparedStatement pst = connection.prepareStatement(sql);
	            pst.setString(1, user.getUser_name());
	            pst.setString(2, user.getUser_password());
	            pst.setString(3, user.getUser_role());
	            int executeSuccess = pst.executeUpdate();
	            if (executeSuccess > 0) {
	                System.out.println("Created User: " + user.getUser_name());
	                System.out.println(executeSuccess);
	                return user;
	            }
	            ConnectionFactory.close(connection, pst);
	        } catch (SQLException var5) {
	            var5.printStackTrace();
	            return null;
	        }
		return null;
	     
	 }
	 
	 public User update(Long id, User user) {
		  if (user != null && id != null) {
	            String sql = "UPDATE user SET user_name=?, user_password=?, user_role=? WHERE (user_id=?)";
	            Connection connection = ConnectionFactory.getConnection();

	            try {
	                PreparedStatement pst = connection.prepareStatement(sql);
	                pst.setString(1, user.getUser_name());
	                pst.setString(2, user.getUser_password());
	                pst.setString(3, user.getUser_role());
	                pst.setString(4, String.valueOf(id));
	                int executeSuccess = pst.executeUpdate();
	               if (executeSuccess > 0) {
	                    System.out.println("Updated User: " + user.getUser_name());
	                    System.out.println(executeSuccess);
	                    return user;
	                }
	               ConnectionFactory.close(connection, pst);
	            } catch (SQLException var5) {
	                var5.printStackTrace();
	            }

	        } else {
	            System.out.println("User not found");
	        }
		  return null;
	 }
	 
	 public void delete(Long id) {
		 if (id != null) {
	            String sql = "DELETE FROM user WHERE (user_id = ?)";
	            Connection connection = ConnectionFactory.getConnection();

	            try {
	                PreparedStatement pst = connection.prepareStatement(sql);
	                pst.setString(1, String.valueOf(id));
	                int executeSuccess = pst.executeUpdate();
	              if (executeSuccess > 0) {
	                   
	                    System.out.println(executeSuccess);
	                }
	              ConnectionFactory.close(connection, pst);
	            } catch (SQLException var5) {
	                var5.printStackTrace();
	            }

	        } else {
	            System.out.println("User not found!");
	        }
	 }
	 
	   public static List<User> findAll() {
	        String sql = "SELECT user_id, user_name, user_password, user_role FROM user";
	        Connection connection = ConnectionFactory.getConnection();
	        ArrayList userList = new ArrayList<User>();

	        try {
	            PreparedStatement pst = connection.prepareStatement(sql);
	            ResultSet rs = pst.executeQuery();

	            while(rs.next()) {
	                userList.add(new User(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4)));
	            }

	            ConnectionFactory.close(connection, pst, rs);
	            return userList;
	            
	        } catch (SQLException var5) {
	            var5.printStackTrace();
	            return null;
	        }
	    }
	 
	   public  User findById(Long id) {
	        String sql = "SELECT user_id, user_name, user_password, user_role FROM user WHERE (user_id=?)";
	        Connection connection = ConnectionFactory.getConnection();
	        User user = new User();

	        try {
	            PreparedStatement pst = connection.prepareStatement(sql);
	            pst.setString(1,String.valueOf(id));
	            ResultSet rs = pst.executeQuery();

	            while(rs.next()) {
	               user = new User(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4));
	            }
	            ConnectionFactory.close(connection, pst, rs);

	            return user;
	        } catch (SQLException var5) {
	            var5.printStackTrace();
	            return null;
	        }
	    }

}
