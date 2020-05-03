package edu.njit.mynovelnet.book.entity;

import java.io.Serializable;

public class AllWorkShowEntity implements Serializable {

    private static final long serialVersionUID = 8895510837703862941L;

    private String novelUuid;
    private String novelName;
    private String writerUuid;
    private String writerName;
    private String pCategory;
    private String category;
    private String state;
    private String intro;
    private String wordCount;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getWordCount() {
        return wordCount;
    }

    public void setWordCount(String wordCount) {
        this.wordCount = wordCount;
    }

    @Override
    public String toString() {
        return "AllWorkShowEntity{" +
                "novelUuid='" + novelUuid + '\'' +
                ", novelName='" + novelName + '\'' +
                ", writerUuid='" + writerUuid + '\'' +
                ", writerName='" + writerName + '\'' +
                ", pCategory='" + pCategory + '\'' +
                ", category='" + category + '\'' +
                ", state='" + state + '\'' +
                ", intro='" + intro + '\'' +
                ", wordCount='" + wordCount + '\'' +
                '}';
    }
}
