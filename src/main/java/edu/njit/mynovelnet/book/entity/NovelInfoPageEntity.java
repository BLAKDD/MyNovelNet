package edu.njit.mynovelnet.book.entity;

import java.io.Serializable;

public class NovelInfoPageEntity implements Serializable {
    private static final long serialVersionUID = 2151637665531809802L;
    private String novelName;
    private String pCategory;
    private String category;
    private String writerName;
    private String writerUuid;
    private String introduction;
    private Integer state;
    private Character ifVip;
    private Character ifSigning;
    private Integer wordCount;

    public String getNovelName() {
        return novelName;
    }

    public void setNovelName(String novelName) {
        this.novelName = novelName;
    }

    public String getpCategory() {
        return pCategory;
    }

    public void setpCategory(String pCategory) {
        this.pCategory = pCategory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Character getIfVip() {
        return ifVip;
    }

    public void setIfVip(Character ifVip) {
        this.ifVip = ifVip;
    }

    public Integer getWordCount() {
        return wordCount;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Character getIfSigning() {
        return ifSigning;
    }

    public void setIfSigning(Character ifSigning) {
        this.ifSigning = ifSigning;
    }

    @Override
    public String toString() {
        return "NovelInfoPageEntity{" +
                "novelName='" + novelName + '\'' +
                ", pCategory='" + pCategory + '\'' +
                ", category='" + category + '\'' +
                ", writerName='" + writerName + '\'' +
                ", writerUuid='" + writerUuid + '\'' +
                ", introduction='" + introduction + '\'' +
                ", state=" + state +
                ", ifVip=" + ifVip +
                ", ifSigning=" + ifSigning +
                ", wordCount=" + wordCount +
                '}';
    }
}
