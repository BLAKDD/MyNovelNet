package edu.njit.mynovelnet.book.entity;

import java.io.Serializable;

/**
 * 小说实体类
 *
 * @author BLAKD
 * @date 2020/3/31
 */
public class NovelEntity implements Serializable {

    private static final long serialVersionUID = -8255844271108325291L;
    //novel_uuid
    private String novelUuid;
    //user_uuid作者uuid
    private String userUuid;
    //novel_name
    private String novelName;
    //introduction
    private String introduction;
    //state
    private Integer state;
    //category
    private Integer category;
    //ifvip
    private Character ifvip;
    //word_count
    private Integer wordCount;
    //modtime
    private String modtime;

    public NovelEntity() {
    }

    public String getNovelUuid() {
        return novelUuid;
    }

    public void setNovelUuid(String novelUuid) {
        this.novelUuid = novelUuid;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getNovelName() {
        return novelName;
    }

    public void setNovelName(String novelName) {
        this.novelName = novelName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Character getIfvip() {
        return ifvip;
    }

    public void setIfvip(Character ifvip) {
        this.ifvip = ifvip;
    }

    public Integer getWordCount() {
        return wordCount;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }

    public String getModtime() {
        return modtime;
    }

    public void setModtime(String modtime) {
        this.modtime = modtime;
    }

    @Override
    public String toString() {
        return "NovelEntity{" +
                "novelUuid='" + novelUuid + '\'' +
                ", userUuid='" + userUuid + '\'' +
                ", novelName='" + novelName + '\'' +
                ", introduction='" + introduction + '\'' +
                ", state=" + state +
                ", category=" + category +
                ", ifvip=" + ifvip +
                ", wordCount=" + wordCount +
                ", modtime='" + modtime + '\'' +
                '}';
    }
}
