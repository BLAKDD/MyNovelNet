package edu.njit.mynovelnet.rank.entity;

import java.io.Serializable;

public class RankEntity implements Serializable {

    private static final long serialVersionUID = -2992262938016696731L;
    /**
     * 排名
     */
    private Long rank;

    /**
     * 积分
     */
    private Float score;

    /**
     * 书uuid
     */
    private String bookUuid;

    public RankEntity() {
    }

    public RankEntity(Long rank, Float score, String bookUuid) {
        this.rank = rank;
        this.score = score;
        this.bookUuid = bookUuid;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getBookUuid() {
        return bookUuid;
    }

    public void setBookUuid(String bookUuid) {
        this.bookUuid = bookUuid;
    }

    @Override
    public String toString() {
        return "RankEntity{" +
                "rank=" + rank +
                ", score=" + score +
                ", bookUuid='" + bookUuid + '\'' +
                '}';
    }
}
