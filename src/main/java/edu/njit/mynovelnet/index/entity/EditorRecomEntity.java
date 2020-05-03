package edu.njit.mynovelnet.index.entity;

import java.io.Serializable;

public class EditorRecomEntity implements Serializable {

    private static final long serialVersionUID = -326015619056203693L;

    private String novelUuid;
    private String novelName;
    private String intro;

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

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Override
    public String toString() {
        return "EditorRecomEntity{" +
                "novelUuid='" + novelUuid + '\'' +
                ", novelName='" + novelName + '\'' +
                ", intro='" + intro + '\'' +
                '}';
    }
}
