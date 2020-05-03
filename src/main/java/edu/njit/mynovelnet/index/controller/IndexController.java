package edu.njit.mynovelnet.index.controller;

import edu.njit.mynovelnet.index.entity.CoverRecomEntity;
import edu.njit.mynovelnet.index.entity.EditorRecomEntity;
import edu.njit.mynovelnet.index.entity.RecomEntity;
import edu.njit.mynovelnet.index.service.IndexService;
import edu.njit.mynovelnet.myutil.DateUtil;
import edu.njit.mynovelnet.myutil.Message;
import edu.njit.mynovelnet.rank.entity.RankEntity;
import edu.njit.mynovelnet.rank.entity.RankShowEntity;
import edu.njit.mynovelnet.rank.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private IndexService indexService;

    @Autowired
    private RankService rankService;

    @RequestMapping("/index")
    public String goToIndex() {
        return "index";
    }

    @RequestMapping("/allWorks")
    public String goToAllWorks() {
        return "allworks";
    }

    @RequestMapping("/rankPage")
    public String goToRankPage() {
        return "rank";
    }

    @RequestMapping("/monthTicketRank")
    public String goTomonthTicketRank() {
        return "month_ticket_rank";
    }

    @RequestMapping("/recTicketRank")
    public String goTorecTicketRank() {
        return "rec_ticket_rank";
    }

    @RequestMapping("/register")
    public String goToregister() {
        return "register";
    }

    @RequestMapping("/bookInfo")
    public String goToBookInfo(HttpServletResponse response, String novelUuid) {
        Message message;
        response.setContentType("text/html;charset=utf-8");
        // 创建cookie并将成功登陆的用户保存在里面
        Cookie cookie = new Cookie("novelUuid", novelUuid);
        cookie.setMaxAge(60 * 60 * 24);
        cookie.setPath("/");
        // 服务器返回给浏览器cookie以便下次判断
        response.addCookie(cookie);

        return "bookinfo";
    }

    @RequestMapping("/read")
    public String goToReadPage(String novelUuid, String chapterUuid, Model model) {
        model.addAttribute("chapterUuid", chapterUuid);
        model.addAttribute("novelUuid", novelUuid);
        return "read";
    }

    @RequestMapping("/bookInfo2")
    public String goTobookInfo(String bookUuid) {

        return "bookinfo";
    }

    @RequestMapping(value = "/getNewestStrongRecom", produces = "application/json")
    @ResponseBody
    public List<RecomEntity> getNewestStrongRecom() {
        List<RecomEntity> list = indexService.getNewestStrongRecommond();
        System.out.println("getNewestStrongRecom:" + list);
        return list;
    }

    @RequestMapping(value = "/getNewestSanJiang", produces = "application/json")
    @ResponseBody
    public List<RecomEntity> getNewestSanJiang() {
        System.out.println("getNewestSanJiang");
        List<RecomEntity> list = indexService.getNewestSanJiang();
        System.out.println(list);
        return list;
    }

    @RequestMapping(value = "/getLastWeekRecomTop10", produces = "application/json")
    @ResponseBody
    public List<RankShowEntity> getAllLastWeekRecomTop10() {
        System.out.println("getAllLastWeekRecomTop10");
        String lastMonday = DateUtil.getLastWeekMonday();
        List<RankEntity> ranklist = rankService.getTopNRanks("all_week_recom" + lastMonday, 10);
        List<RankShowEntity> result = indexService.getRecomByRankList(ranklist);
        System.out.println(result);
        return result;
    }

    @RequestMapping(value = "/getLastMonthTicketTop10", produces = "application/json")
    @ResponseBody
    public List<RankShowEntity> getLastMonthTicketTop10() {
        System.out.println("getLastMonthTicketTop10");
        String lastMonth = DateUtil.getLastYearMonth();
        List<RankEntity> ranklist = rankService.getTopNRanks("all_monthticket" + lastMonth, 10);
        List<RankShowEntity> result = indexService.getRecomByRankList(ranklist);
        System.out.println(result);
        return result;
    }

    @RequestMapping(value = "/getCollectionTop10", produces = "application/json")
    @ResponseBody
    public List<RankShowEntity> getCollectionTop10() {
        System.out.println("getCollectionTop10");
        List<RankEntity> ranklist = rankService.getTopNRanks("all_collection", 10);
        List<RankShowEntity> result = indexService.getRecomByRankList(ranklist);
        System.out.println(result);
        return result;
    }

    @RequestMapping(value = "/getUpdateRankTop10", produces = "application/json")
    @ResponseBody
    public List<RankShowEntity> getUpdateRankTop10() {
        System.out.println("getUpdateRankTop10");
        List<RankEntity> ranklist = rankService.getTopNRanks("all_newest_update", 10);
        List<RankShowEntity> result = indexService.getRecomByRankList(ranklist);
        return result;
    }

    @RequestMapping(value = "/getAwardRankTop10", produces = "application/json")
    @ResponseBody
    public List<RankShowEntity> getAwardRankTop10() {
        System.out.println("getAwardRankTop10");
        String today = DateUtil.getNowDate();
        List<RankEntity> ranklist = rankService.getTopNRanks("all_award" + today, 10);
        List<RankShowEntity> result = indexService.getRecomByRankList(ranklist);
        return result;
    }

    @RequestMapping(value = "/getSellRankTop10", produces = "application/json")
    @ResponseBody
    public List<RankShowEntity> getSellRankTop10() {
        System.out.println("getSellRankTop10");
        String yesterday = DateUtil.getYesterday();
        List<RankEntity> ranklist = rankService.getTopNRanks("all_sell" + yesterday, 10);
        List<RankShowEntity> result = indexService.getRecomByRankList(ranklist);
        return result;
    }

    @RequestMapping(value = "/getRankTop10", produces = "application/json")
    @ResponseBody
    public List<RankShowEntity> getRankTop10(String rankName) {
        System.out.println("getTop10From:" + rankName);
        List<RankEntity> ranklist = rankService.getTopNRanks(rankName, 10);
        List<RankShowEntity> result = indexService.getRecomByRankList(ranklist);
        return result;
    }

    @RequestMapping(value = "/getCount", produces = "application/json")
    @ResponseBody
    public String getCount() {
        System.out.println("getCount:" + indexService.getCount());
        return indexService.getCount().toString();
    }

    @RequestMapping(value = "/getEditorRecom", produces = "application/json")
    @ResponseBody
    public List<EditorRecomEntity> getEditorRecom() {
        System.out.println("getEditorRecom:");
        return indexService.getEditorRecom();
    }

    @RequestMapping(value = "/getNewest5CoverRecom", produces = "application/json")
    @ResponseBody
    public List<CoverRecomEntity> getNewest5CoverRecom() {
        System.out.println("getNewest5CoverRecom:");
        return indexService.getNewest5CoverRecom();
    }

}
