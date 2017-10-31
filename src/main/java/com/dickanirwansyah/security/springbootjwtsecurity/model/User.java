package com.dickanirwansyah.security.springbootjwtsecurity.model;

public class User {

    private String userName;
    private long id;
    private String role;

    public String getUserName(){
        return userName;
    }

    public  void setUsername(String UserName)
    {
        this.userName = userName;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role){
        this.role = role;
    }
}
