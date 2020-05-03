package edu.njit.mynovelnet.book.entity;

public class ReadShowEntity {
    private String novelUuid;
    private String novelName;
    private String writerUuid;
    private String writerName;
    private String pCategory;
    private String category;
    private String chapterUuid;
    private String chapterName;
    private String updateTime;
    private Integer chapterWordCount;
    private Integer chapterRank;
    private Integer ifVip;
    private Integer ifInbookstore;
    private Integer cost;
    private Integer ifBuy;

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

    public String getWriterUuid() {
        return writerUuid;
    }

    public void setWriterUuid(String writerUuid) {
        this.writerUuid = writerUuid;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public String getpCategory() {
        return pCategory;
    }

    public void setpCategory(String pCategory) {
        this.pCategory = pCategory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getChapterUuid() {
        return chapterUuid;
    }

    public void setChapterUuid(String chapterUuid) {
        this.chapterUuid = chapterUuid;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getChapterWordCount() {
        return chapterWordCount;
    }

    public void setChapterWordCount(Integer chapterWordCount) {
        this.chapterWordCount = chapterWordCount;
    }

    public Integer getChapterRank() {
        return chapterRank;
    }

    public void setChapterRank(Integer chapterRank) {
        this.chapterRank = chapterRank;
    }

    public Integer getIfVip() {
        return ifVip;
    }

    public void setIfVip(Integer ifVip) {
        this.ifVip = ifVip;
    }

    public Integer getIfInbookstore() {
        return ifInbookstore;
    }

    public void setIfInbookstore(Integer ifInbookstore) {
        this.ifInbookstore = ifInbookstore;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getIfBuy() {
        return ifBuy;
    }

    public void setIfBuy(Integer ifBuy) {
        this.ifBuy = ifBuy;
    }

    @Override
    public String toString() {
        return "ReadShowEntity{" +
                "novelUuid='" + novelUuid + '\'' +
                ", novelName='" + novelName + '\'' +
                ", writerUuid='" + writerUuid + '\'' +
                ", writerName='" + writerName + '\'' +
                ", pCategory='" + pCategory + '\'' +
                ", category='" + category + '\'' +
                ", chapterUuid='" + chapterUuid + '\'' +
                ", chapterName='" + chapterName + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", chapterWordCount=" + chapterWordCount +
                ", chapterRank=" + chapterRank +
                ", ifVip=" + ifVip +
                ", ifInbookstore='" + ifInbookstore + '\'' +
                ", cost=" + cost +
                ", ifBuy='" + ifBuy + '\'' +
                '}';
    }
}
