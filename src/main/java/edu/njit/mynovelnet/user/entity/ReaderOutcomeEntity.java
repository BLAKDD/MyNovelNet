package edu.njit.mynovelnet.user.entity;

public class ReaderOutcomeEntity {
    private String userUuid;
    private String novelUuid;
    private String chapterUuid;
    private Integer subscribeOutcome;
    private Integer rewardOutcome;
    private String outcomeTime;

    public ReaderOutcomeEntity() {
    }

    public ReaderOutcomeEntity(String userUuid, String novelUuid, String chapterUuid, Integer subscribeOutcome, Integer rewardOutcome, String outcomeTime) {
        this.userUuid = userUuid;
        this.novelUuid = novelUuid;
        this.chapterUuid = chapterUuid;
        this.subscribeOutcome = subscribeOutcome;
        this.rewardOutcome = rewardOutcome;
        this.outcomeTime = outcomeTime;
    }

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

    public Integer getSubscribeOutcome() {
        return subscribeOutcome;
    }

    public void setSubscribeOutcome(Integer subscribeOutcome) {
        this.subscribeOutcome = subscribeOutcome;
    }

    public Integer getRewardOutcome() {
        return rewardOutcome;
    }

    public void setRewardOutcome(Integer rewardOutcome) {
        this.rewardOutcome = rewardOutcome;
    }

    public String getOutcomeTime() {
        return outcomeTime;
    }

    public void setOutcomeTime(String outcomeTime) {
        this.outcomeTime = outcomeTime;
    }

    @Override
    public String toString() {
        return "ReaderOutcomeEntity{" +
                "userUuid='" + userUuid + '\'' +
                ", novelUuid='" + novelUuid + '\'' +
                ", chapterUuid='" + chapterUuid + '\'' +
                ", subscribeOutcome=" + subscribeOutcome +
                ", rewardOutcome=" + rewardOutcome +
                ", outcomeTime='" + outcomeTime + '\'' +
                '}';
    }
}
