package edu.njit.mynovelnet.index.entity;

import java.io.Serializable;

public class CoverRecomEntity implements Serializable {
    private static final long serialVersionUID = -1291898543250377695L;

    private String novelUuid;
    private String novelName;
    private Long startTime;

    public String getNovelUuid() {
        return novelUuid;
    }

    public void setNovelUuid(String novelUuid) {
        this.novelUuid = novelUuid;
    }

    public String getNovelName() {
        return novelName;
    }

    public void setNovelName(String novelName) {
        this.novelName = novelName;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "CoverRecomEntity{" +
                "novelUuid='" + novelUuid + '\'' +
                ", novelName='" + novelName + '\'' +
                ", startTime=" + startTime +
                '}';
    }
}
