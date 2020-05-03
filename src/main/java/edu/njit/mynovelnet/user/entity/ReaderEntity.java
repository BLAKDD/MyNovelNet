package edu.njit.mynovelnet.user.entity;

import java.io.Serializable;


public class ReaderEntity implements Serializable {

    private static final long serialVersionUID = 6498208305133128318L;
    //user_uuid
    private String userUuid;
    //user_id
    private String userId;
    //username
    private String username;
    //gender
    private Character gender;
    //user_month_ticket
    private Integer userMonthTicket;
    //user_recom_ticket
    private Integer userRecomTicket;
    //xp经验值
    private Integer xp;
    //level
    private Integer level;
    //book_coin
    private Integer bookCoin;


    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Integer getUserMonthTicket() {
        return userMonthTicket;
    }

    public void setUserMonthTicket(Integer userMonthTicket) {
        this.userMonthTicket = userMonthTicket;
    }

    public Integer getUserRecomTicket() {
        return userRecomTicket;
    }

    public void setUserRecomTicket(Integer userRecomTicket) {
        this.userRecomTicket = userRecomTicket;
    }

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getBookCoin() {
        return bookCoin;
    }

    public void setBookCoin(Integer bookCoin) {
        this.bookCoin = bookCoin;
    }

    @Override
    public String toString() {
        return "ReaderEntity{" +
                "userUuid='" + userUuid + '\'' +
                ", userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", gender=" + gender +
                ", userMonthTicket=" + userMonthTicket +
                ", userRecomTicket=" + userRecomTicket +
                ", xp=" + xp +
                ", level=" + level +
                ", bookCoin=" + bookCoin +
                '}';
    }
}
