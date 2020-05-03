package edu.njit.mynovelnet.user.entity;

public class User {
    private Integer Id;
    private String UserId;
    private String Password;
    private Character Identity;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Character getIdentity() {
        return Identity;
    }

    public void setIdentity(Character identity) {
        Identity = identity;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", UserId='" + UserId + '\'' +
                ", Password='" + Password + '\'' +
                ", Identity=" + Identity +
                '}';
    }
}
