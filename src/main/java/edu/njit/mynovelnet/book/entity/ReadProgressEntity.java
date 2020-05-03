package edu.njit.mynovelnet.book.entity;

public class ReadProgressEntity {
    private String userUuid;
    private String novelUuid;
    private String chapterUuid;

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getNovelUuid() {
        return novelUuid;
    }

    public void setNovelUuid(String novelUuid) {
        this.novelUuid = novelUuid;
    }

    public String getChapterUuid() {
        return chapterUuid;
    }

    public void setChapterUuid(String chapterUuid) {
        this.chapterUuid = chapterUuid;
    }

    @Override
    public String toString() {
        return "ReadProgressEntity{" +
                "userUuid='" + userUuid + '\'' +
                ", novelUuid='" + novelUuid + '\'' +
                ", chapterUuid='" + chapterUuid + '\'' +
                '}';
    }
}
