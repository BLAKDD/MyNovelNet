package edu.njit.mynovelnet.book.entity;

import java.io.Serializable;

public class SearchEntity implements Serializable {
    private static final long serialVersionUID = 5757565537957855756L;
    private Integer pCategoryId;
    private Integer state;
    private String ifVip;
    private Integer minWordCount;
    private Integer maxWordCount;
    private Integer front;
    private Integer after;

    public Integer getpCategoryId() {
        return pCategoryId;
    }

    public void setpCategoryId(Integer pCategoryId) {
        this.pCategoryId = pCategoryId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getIfVip() {
        return ifVip;
    }

    public void setIfVip(String ifVip) {
        this.ifVip = ifVip;
    }

    public Integer getMinWordCount() {
        return minWordCount;
    }

    public void setMinWordCount(Integer minWordCount) {
        this.minWordCount = minWordCount;
    }

    public Integer getMaxWordCount() {
        return maxWordCount;
    }

    public void setMaxWordCount(Integer maxWordCount) {
        this.maxWordCount = maxWordCount;
    }

    public Integer getFront() {
        return front;
    }

    public void setFront(Integer front) {
        this.front = front;
    }

    public Integer getAfter() {
        return after;
    }

    public void setAfter(Integer after) {
        this.after = after;
    }

    @Override
    public String toString() {
        return "SearchEntity{" +
                "pCategoryId='" + pCategoryId + '\'' +
                ", state='" + state + '\'' +
                ", ifVip='" + ifVip + '\'' +
                ", minWordCount=" + minWordCount +
                ", maxWordCount=" + maxWordCount +
                ", front=" + front +
                ", after=" + after +
                '}';
    }
}
