package br.com.portal.model;

import java.util.Objects;

public class User {

	 private Long user_id;
	    private String user_name;
	    private String user_password;
	    private String user_role;

	    public User(Long user_id, String user_name, String user_password, String user_role) {
	        this.user_id = user_id;
	        this.user_name = user_name;
	        this.user_password = user_password;
	        this.user_role = user_role;
	    }

	    public User(String user_name, String user_password, String user_role) {
	        this.user_name = user_name;
	        this.user_password = user_password;
	        this.user_role = user_role;
	    }

	    public User() {
	    }

	    public Long getUser_id() {
	        return this.user_id;
	    }

	    public void setUser_id(Long user_id) {
	        this.user_id = user_id;
	    }

	    public String getUser_name() {
	        return this.user_name;
	    }

	    public void setUser_name(String user_name) {
	        this.user_name = user_name;
	    }

	    public String getUser_password() {
	        return this.user_password;
	    }

	    public void setUser_password(String user_password) {
	        this.user_password = user_password;
	    }

	    public String getUser_role() {
	        return this.user_role;
	    }

	    public void setUser_role(String user_role) {
	        this.user_role = user_role;
	    }

	    public boolean equals(Object o) {
	        if (this == o) {
	            return true;
	        } else if (o != null && this.getClass() == o.getClass()) {
	            User user = (User)o;
	            return Objects.equals(this.user_id, user.user_id);
	        } else {
	            return false;
	        }
	    }

	    public int hashCode() {
	        return Objects.hash(new Object[]{this.user_id});
	    }

	    public String toString() {
	        return "User{user_id=" + this.user_id + ", user_name='" + this.user_name + "', user_password='" + this.user_password + "', user_role='" + this.user_role + "'}";
	    }
	}

