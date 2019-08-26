package com.entity;
public class User {

   private int uid;
   private String username;
   private String phone;
   private String email;
   private int gender;
   
   @Override
   public String toString() {
	   return "User [uid=" + uid + ", username=" + username + ", phone=" + phone + ", email=" + email + ", gender="
			+ gender + "]";
    }
   public int getUid() {
	   return uid;
    }
   public void setUid(int uid) {
	   this.uid = uid;
    }
	public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

   public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPhone() {
        return phone;
    }

   public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

   public void setGender(int gender) {
        this.gender = gender;
    }
    public int getGender() {
        return gender;
    }

}
