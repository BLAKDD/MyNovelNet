package edu.njit.mynovelnet.index.entity;

import java.io.Serializable;

public class RecomEntity implements Serializable {
    private static final long serialVersionUID = -2906321504654989448L;
    /**
     * 主分类，如玄幻
     */
    private String pCategory;

    private String novelUuid;

    private String novelName;

    private String writerName;

    private String writerUuid;

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

    @Override
    public String toString() {
        return "RecomEntity{" +
                "pCategory='" + pCategory + '\'' +
                ", novelUuid='" + novelUuid + '\'' +
                ", novelName='" + novelName + '\'' +
                ", writerName='" + writerName + '\'' +
                ", writerUuid='" + writerUuid + '\'' +
                '}';
    }
}
