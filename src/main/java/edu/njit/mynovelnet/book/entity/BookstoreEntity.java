package edu.njit.mynovelnet.book.entity;

import java.io.Serializable;

public class BookstoreEntity implements Serializable {
    private static final long serialVersionUID = -3385785735336295807L;
    private String userUuid;
    private String novelUuid;
    private Long time;
    private Integer ifInBookStore;
    private Integer ifAutoOrder;

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

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getIfInBookStore() {
        return ifInBookStore;
    }

    public void setIfInBookStore(Integer ifInBookStore) {
        this.ifInBookStore = ifInBookStore;
    }

    public Integer getIfAutoOrder() {
        return ifAutoOrder;
    }

    public void setIfAutoOrder(Integer ifAutoOrder) {
        this.ifAutoOrder = ifAutoOrder;
    }

    @Override
    public String toString() {
        return "BookstoreEntity{" +
                "userUuid='" + userUuid + '\'' +
                ", novelUuid='" + novelUuid + '\'' +
                ", time=" + time +
                ", ifInBookStore=" + ifInBookStore +
                ", ifAutoOrder=" + ifAutoOrder +
                '}';
    }
}
