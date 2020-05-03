package edu.njit.mynovelnet.rank.service.serviceimpl;

import edu.njit.mynovelnet.book.dao.NovelDao;
import edu.njit.mynovelnet.book.entity.NovelRankShowEntity;
import edu.njit.mynovelnet.myutil.DateUtil;
import edu.njit.mynovelnet.myutil.redis.RedisComponent;
import edu.njit.mynovelnet.rank.entity.RankEntity;
import edu.njit.mynovelnet.rank.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service("rankService")
public class RankServiceImpl implements RankService {
    private static String[] categorys = {"xuanhuan", "qihuan", "kehuan", "wuxia", "xianxia", "dushi", "yanqing", "lishi", "junshi", "youxi", "tiyu", "lingyi", "danmei", "erciyuan"};
    @Autowired
    private RedisComponent redisComponent;

    @Autowired
    private NovelDao novelDao;

    private List<RankEntity> buildRedisRankToRankEntity(Set<ZSetOperations.TypedTuple<String>> result, long offset) {
        List<RankEntity> rankList = new ArrayList<>(result.size());
        long rank = offset;
        for (ZSetOperations.TypedTuple<String> sub : result) {
            rankList.add(new RankEntity(rank++, Math.abs(sub.getScore().floatValue()), sub.getValue()));
        }
        return rankList;
    }

    private List<NovelRankShowEntity> getNovelRankShowEntityByLists(List<NovelRankShowEntity> novelRankShowEntities, List<RankEntity> rankEntities) {
        List<NovelRankShowEntity> result = new ArrayList<>();
        for (RankEntity rankEntity : rankEntities) {
            for (NovelRankShowEntity novelRankShowEntity : novelRankShowEntities) {
                if (rankEntity.getBookUuid().equals(novelRankShowEntity.getNovelUuid())) {
                    novelRankShowEntity.setRank(rankEntity.getRank());
                    novelRankShowEntity.setScore(rankEntity.getScore());
                    result.add(novelRankShowEntity);
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 新增排行榜中数据
     *
     * @param key
     * @param value
     * @param score
     * @return 成功失败
     */
    @Override
    public Boolean addKVS(String key, String value, int score) {
        return redisComponent.add(key, value, score);
    }

    /**
     * 移除排行榜中数据
     *
     * @param key
     * @param value
     * @return 删除的条数
     */
    @Override
    public Long remove(String key, String value) {
        return redisComponent.remove(key, value);
    }

    /**
     * 给排行榜中数据增加score。减的话score为负数
     *
     * @param key
     * @param value
     * @param score
     * @return
     */
    @Override
    public Integer incrScore(String key, String value, int score) {
        return redisComponent.incrScore(key, value, score).intValue();
    }

    /**
     * get分数
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public Integer getScore(String key, String value) {
        return redisComponent.score(key, value).intValue();
    }

    @Override
    public Long combineWeekRecomTick() {
        Long result = 0L;
        List<String> list = DateUtil.getPastWeek();
        String[] dates = new String[list.size()];
        list.toArray(dates);
        String lastMonday = DateUtil.getLastWeekMonday();
        List<String> weekRankNames = new ArrayList<>();
        for (String category : categorys
        ) {
            String rankName1 = category + "_recom" + dates[0];
            String weekRankName = category + "_week_recom" + lastMonday;
            List<String> rankNames = new ArrayList<>();
            for (int i = 1; i < 7; i++) {
                rankNames.add(category + "_recom" + dates[i]);
            }
            System.out.println("rankName1=" + rankName1 + "targetrankName=" + weekRankName);
            result += redisComponent.unionAndStore(rankName1, rankNames, weekRankName);
            weekRankNames.add(weekRankName);
        }
        String weekRankName1 = weekRankNames.remove(0);
        String allrankName = "all_week_recom" + lastMonday;
        result += redisComponent.unionAndStore(weekRankName1, weekRankNames, allrankName);
        return result;
    }

    @Override
    public Long combineMonthRecomTick() {
        Long result = 0L;
        List<String> list = DateUtil.getLastMonthAllDate();
        String[] dates = new String[list.size()];
        list.toArray(dates);
        String lastMonth = DateUtil.getLastYearMonth();
        List<String> monthRankNames = new ArrayList<>();
        for (String category : categorys
        ) {
            String rankName1 = category + "_recom" + dates[0];
            String monthRankName = category + "_month_recom" + lastMonth;
            List<String> rankNames = new ArrayList<>();
            for (int i = 1; i < dates.length; i++) {
                rankNames.add(category + "_recom" + dates[i]);
            }
            System.out.println("rankName1=" + rankName1 + "targetrankName=" + monthRankName);
            result += redisComponent.unionAndStore(rankName1, rankNames, monthRankName);
            monthRankNames.add(monthRankName);
        }
        String monthRankName1 = monthRankNames.remove(0);
        String allrankName = "all_month_recom" + lastMonth;
        result += redisComponent.unionAndStore(monthRankName1, monthRankNames, allrankName);
        return result;
    }

    /**
     * 获取前n名的排行榜数据,score从大到小
     *
     * @param n
     * @return
     */
    @Override
    public List<RankEntity> getTopNRanks(String key, int n) {
        Set<ZSetOperations.TypedTuple<String>> result = redisComponent.revRangeWithScore(key, 0, n - 1);
        return buildRedisRankToRankEntity(result, 1);
    }

    @Override
    public List<RankEntity> getRanksByRank(String key, int front, int after) {
        Set<ZSetOperations.TypedTuple<String>> result = redisComponent.revRangeWithScore(key, front - 1, after - 1);
        return buildRedisRankToRankEntity(result, front);
    }

    @Override
    public Long combineLastMonthTicket() {
        Long result = 0L;
        String lastMonth = DateUtil.getLastYearMonth();
        List<String> rankNames = new ArrayList<>();
        for (String category : categorys
        ) {
            rankNames.add(category + "_monthticket" + lastMonth);
        }
        result += redisComponent.unionAndStore(rankNames.remove(0), rankNames, "all_monthticket" + lastMonth);
        return result;
    }

    @Override
    public Long combineUpdateRank() {
        Long result = 0L;
        List<String> list = DateUtil.getPastDate(3);
        String[] dates = new String[list.size()];
        list.toArray(dates);
        List<String> threeDayRankNames = new ArrayList<>();
        for (String category : categorys
        ) {
            String targetRankName = category + "_newest_update";
            List<String> rankNames = new ArrayList<>();
            for (int i = 0; i < dates.length; i++) {
                rankNames.add(category + "_update" + dates[i]);
            }
            result += redisComponent.unionAndStore(rankNames.remove(0), rankNames, targetRankName);
            threeDayRankNames.add(targetRankName);
        }
        String firstDayRankName = threeDayRankNames.remove(0);
        String allrankName = "all_newest_update";
        result += redisComponent.unionAndStore(firstDayRankName, threeDayRankNames, allrankName);
        return result;
    }

    @Override
    public List<NovelRankShowEntity> getRankShows(String key, int front, int after) {
        List<RankEntity> rankEntities = this.getRanksByRank(key, front, after);
        int size = rankEntities.size();
        String[] novelUuids = new String[size];
        int i = 0;
        for (RankEntity re : rankEntities
        ) {
            novelUuids[i] = re.getBookUuid();
            i++;
        }
        if (novelUuids.length == 0) {
            return null;
        }
        List<NovelRankShowEntity> novelRankShowEntities = novelDao.getRankShowsByUuids(novelUuids);
        return getNovelRankShowEntityByLists(novelRankShowEntities, rankEntities);
    }


}
