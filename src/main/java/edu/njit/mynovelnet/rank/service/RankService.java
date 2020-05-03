package edu.njit.mynovelnet.rank.service;

import edu.njit.mynovelnet.book.entity.NovelRankShowEntity;
import edu.njit.mynovelnet.rank.entity.RankEntity;

import java.util.List;

public interface RankService {
    Boolean addKVS(String key, String value, int score);

    Long remove(String key, String value);

    Integer incrScore(String key, String value, int score);

    Integer getScore(String key, String value);

    /**
     * 整合上周7天的推荐票榜
     *
     * @return
     */
    Long combineWeekRecomTick();

    /**
     * 整合上个月的推荐票榜
     *
     * @return
     */
    Long combineMonthRecomTick();

    /**
     * 根据zset的key获取前n的排名，value，score
     *
     * @param key
     * @param n
     * @return
     */
    List<RankEntity> getTopNRanks(String key, int n);

    List<RankEntity> getRanksByRank(String key, int front, int after);

    /**
     * @return
     */
    Long combineLastMonthTicket();

    Long combineUpdateRank();

    List<NovelRankShowEntity> getRankShows(String key, int front, int after);
}
