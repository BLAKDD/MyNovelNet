package edu.njit.mynovelnet.book.entity;

import java.io.Serializable;

public class ChapterContextEntity implements Serializable {
    private static final long serialVersionUID = 7539439233685571142L;

    private String chapterUuid;
    private String postscript;
    private String context;

    public String getChapterUuid() {
        return chapterUuid;
    }

    public void setChapterUuid(String chapterUuid) {
        this.chapterUuid = chapterUuid;
    }

    public String getPostscript() {
        return postscript;
    }

    public void setPostscript(String postscript) {
        this.postscript = postscript;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "ChapterContextEntity{" +
                "chapterUuid='" + chapterUuid + '\'' +
                ", postscript='" + postscript + '\'' +
                ", context='" + context + '\'' +
                '}';
    }
}
