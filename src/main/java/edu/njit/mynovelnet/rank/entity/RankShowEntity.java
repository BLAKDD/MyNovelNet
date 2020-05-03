package edu.njit.mynovelnet.rank.entity;

import edu.njit.mynovelnet.index.entity.RecomEntity;

import java.io.Serializable;

public class RankShowEntity implements Serializable {
    private static final long serialVersionUID = -4925433460784277757L;
    private String pCategory;

    private String novelUuid;

    private String novelName;

    private String writerName;

    private String writerUuid;

    private Integer score;

    public RankShowEntity() {
    }

    public RankShowEntity(RecomEntity recomEntity, Integer score) {
        this.pCategory = recomEntity.getpCategory();
        this.novelUuid = recomEntity.getNovelUuid();
        this.novelName = recomEntity.getNovelName();
        this.writerName = recomEntity.getWriterName();
        this.writerUuid = recomEntity.getWriterUuid();
        this.score = score;
    }

    public RankShowEntity(String pCategory, String novelUuid, String novelName, String writerName, String writerUuid, Integer score) {
        this.pCategory = pCategory;
        this.novelUuid = novelUuid;
        this.novelName = novelName;
        this.writerName = writerName;
        this.writerUuid = writerUuid;
        this.score = score;
    }

    public String getpCategory() {
        return pCategory;
    }

    public void setpCategory(String pCategory) {
        this.pCategory = pCategory;
    }

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

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public String getWriterUuid() {
        return writerUuid;
    }

    public void setWriterUuid(String writerUuid) {
        this.writerUuid = writerUuid;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "RankShowEntity{" +
                "pCategory='" + pCategory + '\'' +
                ", novelUuid='" + novelUuid + '\'' +
                ", novelName='" + novelName + '\'' +
                ", writerName='" + writerName + '\'' +
                ", writerUuid='" + writerUuid + '\'' +
                ", score=" + score +
                '}';
    }
}
