package edu.njit.mynovelnet.book.controller;

import com.alibaba.fastjson.JSON;
import edu.njit.mynovelnet.book.entity.*;
import edu.njit.mynovelnet.book.service.NovelService;
import edu.njit.mynovelnet.myutil.DateUtil;
import edu.njit.mynovelnet.myutil.Message;
import edu.njit.mynovelnet.rank.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/book")
public class NovelController {

    @Autowired
    private NovelService novelService;

    @Autowired
    private RankService rankService;

    @RequestMapping("/test")
    @ResponseBody
    public String testFunctionA() {
        return novelService.getAll().toString();
    }

//    @RequestMapping("/info")
//    public String goToBookInfo(HttpServletResponse response, String novelUuid) {
//        Message message;
//        response.setContentType("text/html;charset=utf-8");
//        // 创建cookie并将成功登陆的用户保存在里面
//        Cookie cookie = new Cookie("novelUuid", novelUuid);
//        cookie.setMaxAge(60 * 60 * 24);
//        cookie.setPath("/");
//        // 服务器返回给浏览器cookie以便下次判断
//        response.addCookie(cookie);
//
//        return "bookinfo";
//    }

    @RequestMapping(value = "/getNovelInfoPageNovelData", produces = "application/json")
    @ResponseBody
    public NovelInfoPageEntity getNovelInfoPageNovelData(String novelUuid) {
        return novelService.getNovelInfoPageNovelData(novelUuid);
    }

    @RequestMapping(value = "/getNovelDetailIntro", produces = "application/json")
    @ResponseBody
    public String getNovelDetailInfo(String novelUuid) {
        return novelService.getNovelDetailIntro(novelUuid);
    }

    @RequestMapping(value = "/getNovelCatalogShow", produces = "application/json")
    @ResponseBody
    public Map<String, List<ChapterEntity>> getNovelCatalogShow(String novelUuid) {
        return novelService.getCatalogShowMap2(novelUuid);
    }

    @RequestMapping(value = "/getChapterSum", produces = "application/json")
    @ResponseBody
    public Integer getChapterSum(String novelUuid) {
        return novelService.getChapterSum(novelUuid);
    }

    @RequestMapping(value = "/getBookstoreList", produces = "application/json")
    @ResponseBody
    public List<String> getBookstoreList(String userUuid) {
        return novelService.getBookstoreList(userUuid);
    }

    @RequestMapping(value = "/addToBookstore", produces = "application/json")
    @ResponseBody
    public Integer addToBookstore(String userUuid, String novelUuid) {
        BookstoreEntity bookstoreEntity = new BookstoreEntity();
        bookstoreEntity.setUserUuid(userUuid);
        bookstoreEntity.setNovelUuid(novelUuid);
        bookstoreEntity.setTime(Calendar.getInstance().getTimeInMillis());
        return novelService.addToBookstore(bookstoreEntity);
    }

    @RequestMapping(value = "/getAllWorks", produces = "application/json")
    @ResponseBody
    public List<AllWorkShowEntity> getAllWorks() {
        return novelService.getAllWorks();
    }

    @RequestMapping(value = "/getAllWorksByFilter", produces = "application/json")
    @ResponseBody
    public List<AllWorkShowEntity> getAllWorksByFilter(String category, Integer state, Integer ifVip, Integer minWordCount, Integer maxWordCount) {
        SearchEntity searchEntity = new SearchEntity();

        if (!category.equals("0")) {
            searchEntity.setpCategoryId(Integer.parseInt(category));
        }
        if (state != 0) {
            searchEntity.setState(state);
        }
        if (ifVip != -1) {
            searchEntity.setIfVip(ifVip.toString());
        }
        if (minWordCount != 0) {
            searchEntity.setMinWordCount(minWordCount);
        }
        if (maxWordCount != 0) {
            searchEntity.setMaxWordCount(maxWordCount);
        }
        System.out.println(searchEntity);
        return novelService.getAllWorksByFilter(searchEntity);
    }

    @RequestMapping(value = "/getChapterContext", produces = "application/json")
    @ResponseBody
    public ChapterContextEntity getChapterContext(String chapterUuid) {
        return novelService.getChapterContext(chapterUuid);
    }

    @RequestMapping(value = "/getReadPageInfo", produces = "application/json")
    @ResponseBody
    public ReadShowEntity getReadPageInfo(String novelUuid, String chapterUuid, String userUuid) {
        return novelService.getReadShowInfo(novelUuid, chapterUuid, userUuid);
    }

    @RequestMapping(value = "/getNearChapterUuid", produces = "application/json")
    @ResponseBody
    public String getNearChapterUuid(String novelUuid, Integer chapterRank) {
        return novelService.getNearChapterUuid(novelUuid, chapterRank);
    }

    @RequestMapping(value = "/ifInBookShelf", produces = "application/json")
    @ResponseBody
    public Integer ifInBookShelf(String userUuid, String novelUuid) {
        return novelService.ifInBookShelf(userUuid, novelUuid);
    }

    @RequestMapping(value = "/getReadProgress", produces = "application/json")
    @ResponseBody
    public String getReadProgress(String novelUuid, String userUuid) {
        return novelService.getReadProgress(novelUuid, userUuid);
    }

    @RequestMapping(value = "/getFirstChapterUuid", produces = "application/json")
    @ResponseBody
    public String getFirstChapterUuid(String novelUuid) {
        return novelService.getFirstChapterUuid(novelUuid);
    }

    @RequestMapping(value = "/getEasyCatalog", produces = "application/json")
    @ResponseBody
    public List<ChapterEntity> getEasyCatalog(String novelUuid) {
        return novelService.getEasyCatalog(novelUuid);
    }

    @RequestMapping(value = "/updateReadProgress", produces = "application/json")
    @ResponseBody
    public Integer updateReadProgress(ReadProgressEntity readProgressEntity) {
        return novelService.updateReadProgress(readProgressEntity);
    }

    @RequestMapping(value = "/updateIfAutoSubscribe", produces = "application/json")
    @ResponseBody
    public Integer updateIfAutoSubscribe(BookstoreEntity bookstoreEntity) {
        return novelService.updateIfAutoSubscribe(bookstoreEntity);
    }

    @RequestMapping(value = "/voteRecTicket", produces = "application/json")
    @ResponseBody
    public String voteRecTicket(String userUuid, String novelUuid, Integer ticketNum) {
        Message message;
        Integer status = novelService.voteRecTicket(userUuid, novelUuid, ticketNum);
        if (status == 0) {
            message = Message.setMessage(status, "推荐票不足");
        } else {
            String category = novelService.getNovelRankCategory(novelUuid);
            String thisMonday = DateUtil.getThisWeekMonday();
            String thisMonth = DateUtil.getNowYearMonth();
            String key = category + "_week_recom" + thisMonday;
            System.out.println("key:" + key);
            rankService.incrScore(key, novelUuid, ticketNum);
            key = "all_week_recom" + thisMonday;
            rankService.incrScore(key, novelUuid, ticketNum);
            key = category + "_month_recom" + thisMonth;
            rankService.incrScore(key, novelUuid, ticketNum);
            key = "all_month_recom" + thisMonth;
            rankService.incrScore(key, novelUuid, ticketNum);
            key = category + "_recom" + thisMonth;
            rankService.incrScore(key, novelUuid, ticketNum);
            key = "all_recom" + thisMonth;
            rankService.incrScore(key, novelUuid, ticketNum);
            message = Message.setMessage(status, "成功投出" + ticketNum + "张推荐票");
        }
        return JSON.toJSONString(message);
    }

    @RequestMapping(value = "/voteMonthTicket", produces = "application/json")
    @ResponseBody
    public String voteMonthTicket(String userUuid, String novelUuid, Integer ticketNum) {
        Message message;
        Integer status = novelService.voteMonthTicket(userUuid, novelUuid, ticketNum);
        if (status == 0) {
            message = Message.setMessage(status, "月票不足");
        } else {
            String category = novelService.getNovelRankCategory(novelUuid);
            String thisMonth = DateUtil.getNowYearMonth();
            String key = category + "_monthticket" + thisMonth;
            rankService.incrScore(key, novelUuid, ticketNum);
            key = "all_monthticket" + thisMonth;
            rankService.incrScore(key, novelUuid, ticketNum);
            message = Message.setMessage(status, "成功投出" + ticketNum + "张月票");
        }
        return JSON.toJSONString(message);
    }

    @RequestMapping(value = "/rewardNovel", produces = "application/json")
    @ResponseBody
    public String rewardNovel(String userUuid, String novelUuid, Integer rewardNum) {
        Message message;
        Integer status = novelService.rewardNovel(userUuid, novelUuid, rewardNum);
        if (status == 0) {
            message = Message.setMessage(status, "余额不足");
        } else {
            String today = DateUtil.getNowDate();
            String key = "all_award" + today;
            rankService.incrScore(key, novelUuid, rewardNum / 100);
            message = Message.setMessage(status, "成功打赏了" + rewardNum + "书币");
        }
        return JSON.toJSONString(message);
    }
}
