package edu.njit.mynovelnet.rank.controller;

import edu.njit.mynovelnet.book.entity.NovelRankShowEntity;
import edu.njit.mynovelnet.myutil.DateUtil;
import edu.njit.mynovelnet.rank.entity.RankEntity;
import edu.njit.mynovelnet.rank.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/rank")
public class RankController {

    @Autowired
    private RankService rankService;

    @RequestMapping("/ranktest")
    public String goToRankTest() {
        return "ranktest";
    }

    /**
     * 改变排行榜中的值，返回当前小说再排行榜中的分数
     *
     * @param rankName
     * @param novelUuid
     * @param score
     * @return
     */
    @RequestMapping(value = "/addRankKVS", produces = "application/json")
    @ResponseBody
    public String addRankKVS(String rankName, String novelUuid, Integer score) {
        System.out.println("rankName=" + rankName + ",novelUuid" + novelUuid + ",score=" + score);
        return rankService.incrScore(rankName, novelUuid, score).toString();
    }

    /**
     * 日榜，每天都更新，用于合并成周榜，月榜。
     *
     * @param rankName
     * @param novelUuid
     * @param score
     * @return
     */
    @RequestMapping(value = "/addDailyRankByKVS", produces = "application/json")
    @ResponseBody
    public String addDailyRankByKVS(String rankName, String novelUuid, Integer score) {
        String realRankName = rankName + DateUtil.getNowDate();
        System.out.println("rankName=" + realRankName + ",novelUuid" + novelUuid + ",score=" + score);
        return rankService.incrScore(realRankName, novelUuid, score).toString();
    }

    /**
     * 月榜，每月一个key。
     *
     * @param rankName
     * @param novelUuid
     * @param score
     * @return
     */
    @RequestMapping(value = "/addMonthlyRankByKVS", produces = "application/json")
    @ResponseBody
    public String addMonthlyRankByKVS(String rankName, String novelUuid, Integer score) {
        String realRankName = rankName + DateUtil.getNowYearMonth();
        System.out.println("rankName=" + realRankName + ",novelUuid" + novelUuid + ",score=" + score);
        return rankService.incrScore(realRankName, novelUuid, score).toString();
    }

    /**
     * 返回排行榜中前n
     *
     * @param rankName
     * @param n
     * @return
     */
    @RequestMapping(value = "/getTopN", produces = "application/json")
    @ResponseBody
    public List<RankEntity> getTopN(String rankName, Integer n) {
        List<RankEntity> list = rankService.getTopNRanks(rankName, n);
        System.out.println(list.toString());
        return list;
    }

    /**
     * 生成上个星期的推荐票榜，14个分类榜，一个总榜
     *
     * @return
     */
    @RequestMapping(value = "/combineWeekRecomTick", produces = "application/json")
    @ResponseBody
    public String combineWeekRecomTick() {
        return rankService.combineWeekRecomTick().toString();
    }

    /**
     * 生成上个月的推荐票榜
     *
     * @return
     */
    @RequestMapping(value = "/combineMonthRecomTick", produces = "application/json")
    @ResponseBody
    public String combineMonthRecomTick() {
        return rankService.combineMonthRecomTick().toString();
    }

    /**
     * 合并生成上个月的月票总榜
     *
     * @return
     */
    @RequestMapping(value = "/combineLastMonthTicket", produces = "application/json")
    @ResponseBody
    public String combineLastMonthTicket() {
        return rankService.combineLastMonthTicket().toString();
    }

    /**
     * 合并近三天的更新榜
     *
     * @return
     */
    @RequestMapping(value = "/combineThreeDayUpdateTicket", produces = "application/json")
    @ResponseBody
    public String combineThreeDayUpdateTicket() {
        return rankService.combineUpdateRank().toString();
    }


    @RequestMapping(value = "/addtestrank", produces = "application/json")
    @ResponseBody
    public String addTestRank(String value, Integer score) {
        System.out.println("value=" + value + " score=" + score);
        return rankService.incrScore("testrank", value, score).toString();
    }

    @RequestMapping(value = "/gettopn", produces = "application/json")
    @ResponseBody
    public List<RankEntity> getTop2(Integer n) {
        List<RankEntity> list = rankService.getTopNRanks("testrank", n);
        System.out.println(list.toString());
        return list;
    }

    @RequestMapping(value = "/getWeekRecScoreByUuid", produces = "application/json")
    @ResponseBody
    public Integer getWeekRecScoreByUuid(String novelUuid) {
        String thisWeekMondy = DateUtil.getThisWeekMonday();
        String rankName = "all_week_recom" + thisWeekMondy;
        System.out.println(rankName);
        return rankService.getScore(rankName, novelUuid);
    }

    @RequestMapping(value = "/getWholeRecScoreByUuid", produces = "application/json")
    @ResponseBody
    public Integer getWholeRecScoreByUuid(String novelUuid) {
        return rankService.getScore("all_recom", novelUuid);
    }

    @RequestMapping(value = "/getMonthTicketRankDetail", produces = "application/json")
    @ResponseBody
    public List<NovelRankShowEntity> getMonthTicketRankDetail(String key, Integer front, Integer after) {
        return rankService.getRankShows(key, front, after);
    }

    @RequestMapping(value = "/getRecTicketRankDetail", produces = "application/json")
    @ResponseBody
    public List<NovelRankShowEntity> getRecTicketRankDetail(String key, Integer front, Integer after) {
        return rankService.getRankShows(key, front, after);
    }

    @RequestMapping(value = "/getRecTicketWeekRankDetail", produces = "application/json")
    @ResponseBody
    public List<NovelRankShowEntity> getRecTicketWeekRankDetail(String key, Integer front, Integer after) {
        String thisMonday = DateUtil.getThisWeekMonday();
        return rankService.getRankShows(key + thisMonday, front, after);
    }

}
