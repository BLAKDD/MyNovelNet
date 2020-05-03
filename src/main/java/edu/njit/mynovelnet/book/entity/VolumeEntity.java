package edu.njit.mynovelnet.book.entity;

import java.io.Serializable;

/**
 * 小说卷实体类；
 */
public class VolumeEntity implements Serializable {
    private static final long serialVersionUID = 8956195827955992920L;
    private String volumeUuid;

    private String novelUuid;

    private String volumeName;

    private Integer volumeRank;

    private Integer chapterCount;

    private Integer volumeWorkCount;

    private Character ifVip;

    public String getVolumeUuid() {
        return volumeUuid;
    }

    public void setVolumeUuid(String volumeUuid) {
        this.volumeUuid = volumeUuid;
    }

    public String getNovelUuid() {
        return novelUuid;
    }

    public void setNovelUuid(String novelUuid) {
        this.novelUuid = novelUuid;
    }

    public String getVolumeName() {
        return volumeName;
    }

    public void setVolumeName(String volumeName) {
        this.volumeName = volumeName;
    }

    public Integer getVolumeRank() {
        return volumeRank;
    }

    public void setVolumeRank(Integer volumeRank) {
        this.volumeRank = volumeRank;
    }

    public Integer getChapterCount() {
        return chapterCount;
    }

    public void setChapterCount(Integer chapterCount) {
        this.chapterCount = chapterCount;
    }

    public Integer getVolumeWorkCount() {
        return volumeWorkCount;
    }

    public void setVolumeWorkCount(Integer volumeWorkCount) {
        this.volumeWorkCount = volumeWorkCount;
    }

    public Character getIfVip() {
        return ifVip;
    }

    public void setIfVip(Character ifVip) {
        this.ifVip = ifVip;
    }

    @Override
    public String toString() {
        return "VolumeEntity{" +
                "volumeUuid='" + volumeUuid + '\'' +
                ", novelUuid='" + novelUuid + '\'' +
                ", volumeName='" + volumeName + '\'' +
                ", volumeRank=" + volumeRank +
                ", chapterCount=" + chapterCount +
                ", volumeWorkCount=" + volumeWorkCount +
                ", ifVip=" + ifVip +
                '}';
    }
}
