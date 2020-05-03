package edu.njit.mynovelnet.user.service.serviceimpl;

import edu.njit.mynovelnet.myutil.DateUtil;
import edu.njit.mynovelnet.user.dao.UserDao;
import edu.njit.mynovelnet.user.entity.*;
import edu.njit.mynovelnet.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User testFunction() {
        return userDao.testFunction();
    }

    @Override
    public User getUserInfoById(String userId) {
        return userDao.getUserInfoById(userId);
    }

    @Override
    public ReaderEntity getReaderInfoById(String userId) {
        return userDao.getReaderInfoById(userId);
    }

    @Override
    public Boolean ifExistAlreadyByUserId(String userId) {
        return userDao.getCountByUserId(userId) > 0;
    }

    @Override
    public Boolean ifExistAlreadyByUsername(String username) {
        return userDao.getCountByUsername(username) > 0;
    }

    @Override
    public void insertRegistesUser(User user) {
        userDao.insertRegistesUser(user);
    }

    @Override
    public void insertRegistreReader(ReaderEntity readerEntity) {
        userDao.insertRegistreReader(readerEntity);
    }

    @Override
    public WriterEntity getWriterInfoByUuid(String writerUuid) {
        return userDao.getWriterInfoByUuid(writerUuid);
    }

    @Override
    public Integer rechargeBookCoin(String userUuid, Integer bookCoin) {
        return userDao.rechargeBookCoin(userUuid, bookCoin);
    }

    @Override
    public ReadReaderEntity getReadReader(String userUuid, String novelUuid) {
        return userDao.getReadReader(userUuid, novelUuid);
    }

    @Override
    public Integer subscribeChapter(String userUuid, String novelUuid, String chapterUuid, Integer bookCoin) {
        int result = userDao.rechargeBookCoin(userUuid, -bookCoin);
        if (result == 1) {
            result = userDao.addToSubscribe(userUuid, chapterUuid);
        }
        String writerUuid = userDao.getWriterUuidByNovel(novelUuid);
        userDao.updateReaderXp(userUuid, bookCoin);
        userDao.updateWriterXp(writerUuid, bookCoin);
        String nowTime = DateUtil.getNowTime();
        ReaderOutcomeEntity readerOutcomeEntity =
                new ReaderOutcomeEntity(userUuid, novelUuid, chapterUuid, bookCoin, 0, nowTime);
        userDao.addReaderOutcome(readerOutcomeEntity);
        String thisMonth = DateUtil.getNowYearMonth();
        WriterIncomeEntity writerIncomeEntity =
                new WriterIncomeEntity(writerUuid, novelUuid, bookCoin, 0, thisMonth);
        Integer k = userDao.updateWriterSubscribeIncome(writerIncomeEntity);
        if (k == 0) {
            userDao.addWriterIncome(writerIncomeEntity);
        }
        return result;
    }

    @Override
    public ReaderEntity getReaderByUuid(String userUuid) {
        return userDao.getReaderByUuid(userUuid);
    }
}
