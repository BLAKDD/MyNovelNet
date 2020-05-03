package edu.njit.mynovelnet.book.entity;

import java.io.Serializable;

public class NovelRankShowEntity implements Serializable {
    private static final long serialVersionUID = 6707572555811935867L;
    private String novelUuid;
    private String novelName;
    private String writerUuid;
    private String writerName;
    private String pCategory;
    private String status;
    private String introduction;
    private String newestChapterUuid;
    private String newestChapterName;
    private Float score;
    private Long rank;
    /**
     * 最后更新时间
     */
    private String updateTime;
    /**
     * 加入书架时间或书架中最后阅读时间
     */
    private Long lastTime;

    public NovelRankShowEntity() {
    }

    public NovelRankShowEntity(String novelUuid, String novelName, String writerUuid, String writerName, String pCategory, String status, String introduction, String newestChapterUuid, String newestChapterName, Float score, Long rank, String updateTime, Long lastTime) {
        this.novelUuid = novelUuid;
        this.novelName = novelName;
        this.writerUuid = writerUuid;
        this.writerName = writerName;
        this.pCategory = pCategory;
        this.status = status;
        this.introduction = introduction;
        this.newestChapterUuid = newestChapterUuid;
        this.newestChapterName = newestChapterName;
        this.score = score;
        this.rank = rank;
        this.updateTime = updateTime;
        this.lastTime = lastTime;
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

    public String getWriterUuid() {
        return writerUuid;
    }

    public void setWriterUuid(String writerUuid) {
        this.writerUuid = writerUuid;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public String getpCategory() {
        return pCategory;
    }

    public void setpCategory(String pCategory) {
        this.pCategory = pCategory;
    }


    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getNewestChapterUuid() {
        return newestChapterUuid;
    }

    public void setNewestChapterUuid(String newestChapterUuid) {
        this.newestChapterUuid = newestChapterUuid;
    }

    public String getNewestChapterName() {
        return newestChapterName;
    }

    public void setNewestChapterName(String newestChapterName) {
        this.newestChapterName = newestChapterName;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Long getLastTime() {
        return lastTime;
    }

    public void setLastTime(Long lastTime) {
        this.lastTime = lastTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "NovelRankShowEntity{" +
                "novelUuid='" + novelUuid + '\'' +
                ", novelName='" + novelName + '\'' +
                ", writerUuid='" + writerUuid + '\'' +
                ", writerName='" + writerName + '\'' +
                ", pCategory='" + pCategory + '\'' +
                ", status='" + status + '\'' +
                ", introduction='" + introduction + '\'' +
                ", newestChapterUuid='" + newestChapterUuid + '\'' +
                ", newestChapterName='" + newestChapterName + '\'' +
                ", score=" + score +
                ", rank=" + rank +
                ", updateTime='" + updateTime + '\'' +
                ", lastTime=" + lastTime +
                '}';
    }
}
