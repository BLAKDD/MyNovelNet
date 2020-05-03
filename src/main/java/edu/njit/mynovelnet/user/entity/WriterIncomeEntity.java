package edu.njit.mynovelnet.user.entity;

public class WriterIncomeEntity {
    private String userUuid;
    private String novelUuid;
    private Integer subscribeIncome;
    private Integer rewardIncome;
    private String yearMonth;

    public WriterIncomeEntity() {
    }

    public WriterIncomeEntity(String userUuid, String novelUuid, Integer subscribeIncome, Integer rewardIncome, String yearMonth) {
        this.userUuid = userUuid;
        this.novelUuid = novelUuid;
        this.subscribeIncome = subscribeIncome;
        this.rewardIncome = rewardIncome;
        this.yearMonth = yearMonth;
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

    public Integer getSubscribeIncome() {
        return subscribeIncome;
    }

    public void setSubscribeIncome(Integer subscribeIncome) {
        this.subscribeIncome = subscribeIncome;
    }

    public Integer getRewardIncome() {
        return rewardIncome;
    }

    public void setRewardIncome(Integer rewardIncome) {
        this.rewardIncome = rewardIncome;
    }

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    @Override
    public String toString() {
        return "WriterIncomeEntity{" +
                "userUuid='" + userUuid + '\'' +
                ", novelUuid='" + novelUuid + '\'' +
                ", subscribeIncome=" + subscribeIncome +
                ", rewardIncome=" + rewardIncome +
                ", yearMonth='" + yearMonth + '\'' +
                '}';
    }
}
