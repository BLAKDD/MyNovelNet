package edu.njit.mynovelnet.user.entity;

import java.io.Serializable;

/**
 * 作者实体类
 *
 * @author BLAKD
 * @date 2020/3/31
 */
public class WriterEntity implements Serializable {

    private static final long serialVersionUID = 3091695159659817724L;

    //user_uuid 用户uuid
    private String userUuid;
    //novel_count
    private Integer novelCount;
    //word_count
    private Integer wordCount;
    //update_count 写作天数
    private Integer updateCount;
    //bewriter_time
    private String bewriterTime;

    private Integer writerXp;

    private Integer writerLevel;

    private String userName;

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public Integer getNovelCount() {
        return novelCount;
    }

    public void setNovelCount(Integer novelCount) {
        this.novelCount = novelCount;
    }

    public Integer getWordCount() {
        return wordCount;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }

    public Integer getUpdateCount() {
        return updateCount;
    }

    public void setUpdateCount(Integer updateCount) {
        this.updateCount = updateCount;
    }

    public String getBewriterTime() {
        return bewriterTime;
    }

    public void setBewriterTime(String bewriterTime) {
        this.bewriterTime = bewriterTime;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getWriterXp() {
        return writerXp;
    }

    public void setWriterXp(Integer writerXp) {
        this.writerXp = writerXp;
    }

    public Integer getWriterLevel() {
        return writerLevel;
    }

    public void setWriterLevel(Integer writerLevel) {
        this.writerLevel = writerLevel;
    }

    @Override
    public String toString() {
        return "WriterEntity{" +
                "userUuid='" + userUuid + '\'' +
                ", novelCount=" + novelCount +
                ", wordCount=" + wordCount +
                ", updateCount=" + updateCount +
                ", bewriterTime='" + bewriterTime + '\'' +
                ", writerXp=" + writerXp +
                ", writerLevel=" + writerLevel +
                ", userName='" + userName + '\'' +
                '}';
    }
}
