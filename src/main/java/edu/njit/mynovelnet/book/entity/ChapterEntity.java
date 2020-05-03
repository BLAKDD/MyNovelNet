package edu.njit.mynovelnet.book.entity;

import java.io.Serializable;

/**
 * 章节实体类
 */
public class ChapterEntity implements Serializable {
    private static final long serialVersionUID = -2136025054965432730L;

    private String chapterUuid;

    private String volumeUuid;

    private String chapterName;

    private Integer chapterRank;

    private Integer chapterWordCount;

    private Character ifVip;

    private String modtime;

    public String getChapterUuid() {
        return chapterUuid;
    }

    public void setChapterUuid(String chapterUuid) {
        this.chapterUuid = chapterUuid;
    }

    public String getVolumeUuid() {
        return volumeUuid;
    }

    public void setVolumeUuid(String volumeUuid) {
        this.volumeUuid = volumeUuid;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public Integer getChapterRank() {
        return chapterRank;
    }

    public void setChapterRank(Integer chapterRank) {
        this.chapterRank = chapterRank;
    }

    public Integer getChapterWordCount() {
        return chapterWordCount;
    }

    public void setChapterWordCount(Integer chapterWordCount) {
        this.chapterWordCount = chapterWordCount;
    }

    public Character getIfVip() {
        return ifVip;
    }

    public void setIfVip(Character ifVip) {
        this.ifVip = ifVip;
    }

    public String getModtime() {
        return modtime;
    }

    public void setModtime(String modtime) {
        this.modtime = modtime;
    }

    @Override
    public String toString() {
        return "ChapterEntity{" +
                "chapterUuid='" + chapterUuid + '\'' +
                ", volumeUuid='" + volumeUuid + '\'' +
                ", chapterName='" + chapterName + '\'' +
                ", chapterRank=" + chapterRank +
                ", chapterWordCount=" + chapterWordCount +
                ", ifVip=" + ifVip +
                ", modtime='" + modtime + '\'' +
                '}';
    }
}
