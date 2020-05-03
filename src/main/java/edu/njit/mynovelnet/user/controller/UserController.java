package edu.njit.mynovelnet.user.controller;

import edu.njit.mynovelnet.myutil.DateUtil;
import edu.njit.mynovelnet.rank.service.RankService;
import edu.njit.mynovelnet.user.entity.ReadReaderEntity;
import edu.njit.mynovelnet.user.entity.ReaderEntity;
import edu.njit.mynovelnet.user.entity.WriterEntity;
import edu.njit.mynovelnet.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RankService rankService;

    @RequestMapping(value = "/getWriterInfo", produces = "application/json")
    @ResponseBody
    public WriterEntity getWriterInfo(String writerUuid) {
        return userService.getWriterInfoByUuid(writerUuid);
    }

    @RequestMapping(value = "/recharge", produces = "application/json")
    @ResponseBody
    public Integer rechargeBookCoin(String userUuid, Integer bookCoin) {
        return userService.rechargeBookCoin(userUuid, bookCoin);
    }

    @RequestMapping(value = "/getReadReader", produces = "application/json")
    @ResponseBody
    public ReadReaderEntity getReadReader(String userUuid, String novelUuid) {
        return userService.getReadReader(userUuid, novelUuid);
    }

    @RequestMapping(value = "/subscribeChapter", produces = "application/json")
    @ResponseBody
    public Integer subscribeChapter(String userUuid, String novelUuid, String chapterUuid, Integer bookCoin) {
        Integer result = userService.subscribeChapter(userUuid, novelUuid, chapterUuid, bookCoin);
        if (result == 1) {
            String today = DateUtil.getNowDate();
            String key = "all_sell" + today;
            rankService.incrScore(key, novelUuid, bookCoin);
        } else {
            return 0;
        }
        return result;
    }

    @RequestMapping(value = "/getReader", produces = "application/json")
    @ResponseBody
    public ReaderEntity getReaderByUuid(String userUuid) {
        return userService.getReaderByUuid(userUuid);
    }
}
