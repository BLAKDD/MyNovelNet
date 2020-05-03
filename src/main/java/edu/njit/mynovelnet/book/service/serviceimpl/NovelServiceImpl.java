package edu.njit.mynovelnet.book.service.serviceimpl;

import com.alibaba.fastjson.JSON;
import edu.njit.mynovelnet.book.dao.NovelDao;
import edu.njit.mynovelnet.book.entity.*;
import edu.njit.mynovelnet.book.service.NovelService;
import edu.njit.mynovelnet.myutil.DataUtil;
import edu.njit.mynovelnet.myutil.DateUtil;
import edu.njit.mynovelnet.user.dao.UserDao;
import edu.njit.mynovelnet.user.entity.ReaderEntity;
import edu.njit.mynovelnet.user.entity.ReaderOutcomeEntity;
import edu.njit.mynovelnet.user.entity.WriterIncomeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service("novelService")
public class NovelServiceImpl implements NovelService {

    @Autowired
    private NovelDao novelDao;

    @Autowired
    private UserDao userDao;

    @Override
    public List<NovelEntity> getAll() {
        return novelDao.getAll();
    }

    @Override
    public NovelInfoPageEntity getNovelInfoPageNovelData(String novelUuid) {
        return novelDao.getNovelInfoPageEntityByNovelUuid(novelUuid);
    }

    @Override
    public String getNovelDetailIntro(String novelUuid) {
        return novelDao.getNovelDetailByNovelUuid(novelUuid);
    }

    @Override
    public Map<VolumeEntity, List<ChapterEntity>> getCatalogShowMap(String novelUuid) {
        List<VolumeEntity> volumeEntities = novelDao.getVolumeListByNovelUuid(novelUuid);
        Map<VolumeEntity, List<ChapterEntity>> result = new LinkedHashMap<>();
        for (VolumeEntity volumeEntity : volumeEntities) {
            List<ChapterEntity> chapterEntities = novelDao.getChapterListByVolumeUuid(volumeEntity.getVolumeUuid());
            result.put(volumeEntity, chapterEntities);
        }
        return result;
    }

    @Override
    public Map<String, List<ChapterEntity>> getCatalogShowMap2(String novelUuid) {
        List<VolumeEntity> volumeEntities = novelDao.getVolumeListByNovelUuid(novelUuid);
        Map<String, List<ChapterEntity>> result = new LinkedHashMap<>();
        for (VolumeEntity volumeEntity : volumeEntities) {
            List<ChapterEntity> chapterEntities = novelDao.getChapterListByVolumeUuid(volumeEntity.getVolumeUuid());
            result.put(JSON.toJSONString(volumeEntity), chapterEntities);
        }
        return result;
    }

    @Override
    public Integer getChapterSum(String novelUuid) {
        System.out.println(novelUuid);
        return novelDao.getChapterSumByNovelUuid(novelUuid);
    }

    @Override
    public List<String> getBookstoreList(String userUuid) {
        return novelDao.getBookstoreList(userUuid);
    }

    @Override
    public Integer addToBookstore(BookstoreEntity bookstoreEntity) {
        Integer result = novelDao.updateBookshelf(bookstoreEntity);
        if (result == 0) {
            result = novelDao.addToBookstore(bookstoreEntity);
        }
        return result;
    }

    @Override
    public List<AllWorkShowEntity> getAllWorks() {
        return novelDao.getAllWorks();
    }

    @Override
    public List<AllWorkShowEntity> getAllWorksByFilter(SearchEntity searchEntity) {
        return novelDao.getAllWorksByFilter(searchEntity);
    }

    @Override
    public ChapterContextEntity getChapterContext(String chapterUuid) {
        return novelDao.getChapterContext(chapterUuid);
    }

    @Override
    public ReadShowEntity getReadShowInfo(String novelUuid, String chapterUuid, String userUuid) {
        ReadShowEntity readShowEntity = novelDao.getReadShowInfo(novelUuid, chapterUuid);
        if (readShowEntity == null) {
            return null;
        }
        if (readShowEntity.getIfVip() == 0) {
            readShowEntity.setCost(0);
        } else {
            if (userUuid != null) {
                readShowEntity.setIfBuy(novelDao.ifBuy(chapterUuid, userUuid));
            }
            double cost = readShowEntity.getChapterWordCount() * 0.005;
            readShowEntity.setCost((int) (cost + 1));
        }
        if (userUuid != null) {
            readShowEntity.setIfInbookstore(novelDao.ifInBookShelf(novelUuid, userUuid));
        }
        readShowEntity.setNovelUuid(novelUuid);
        readShowEntity.setChapterUuid(chapterUuid);
        return readShowEntity;
    }

    @Override
    public String getNearChapterUuid(String novelUuid, Integer chapterRank) {
        String lastChapterUuid = novelDao.getChapterUuid(novelUuid, chapterRank - 1);
        String nextChapterUuid = novelDao.getChapterUuid(novelUuid, chapterRank + 1);
        String result = "{\"lastChapterUuid\":";
        if (lastChapterUuid != null) {
            result += "\"" + lastChapterUuid + "\"";
        } else {
            result += "null";
        }
        result += ",\"nextChapterUuid\":";
        if (nextChapterUuid != null) {
            result += "\"" + nextChapterUuid + "\"";
        } else {
            result += "null";
        }
        result += "}";
        return result;
    }

    @Override
    public Integer ifInBookShelf(String userUuid, String novelUuid) {
        return novelDao.ifInBookShelf(novelUuid, userUuid);
    }

    @Override
    public String getReadProgress(String novelUuid, String userUuid) {
        return novelDao.getReadProgress(novelUuid, userUuid);
    }

    @Override
    public String getFirstChapterUuid(String novelUuid) {
        return novelDao.getFirstChapterUuid(novelUuid);
    }

    @Override
    public List<ChapterEntity> getEasyCatalog(String novelUuid) {
        return novelDao.getEasyCatalog(novelUuid);
    }

    @Override
    public Integer updateReadProgress(ReadProgressEntity readProgressEntity) {
        int result = novelDao.updateReadProgress(readProgressEntity);
        if (result == 0) {
            result = novelDao.addReadProgress(readProgressEntity);
        }
        return result;
    }

    @Override
    public Integer updateIfAutoSubscribe(BookstoreEntity bookstoreEntity) {
        int result = novelDao.updateIfAutoSubscribe(bookstoreEntity);
        if (result == 0) {
            result = novelDao.addIfAutoSubscribe(bookstoreEntity);
        }
        return result;
    }

    @Override
    public Integer voteRecTicket(String userUuid, String novelUuid, Integer ticketNum) {
        ReaderEntity reader = userDao.getReaderByUuid(userUuid);
        if (reader.getUserRecomTicket() < ticketNum) {
            return 0;
        } else if (userDao.voteRecTicket(userUuid, ticketNum) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String getNovelRankCategory(String novelUuid) {
        Integer chapter = novelDao.getPChapterIdByNovelUuid(novelUuid);
        return DataUtil.getCategoryPYById(chapter);
    }

    @Override
    public Integer voteMonthTicket(String userUuid, String novelUuid, Integer ticketNum) {
        ReaderEntity reader = userDao.getReaderByUuid(userUuid);
        if (reader.getUserMonthTicket() < ticketNum) {
            return 0;
        } else if (userDao.voteMonthTicket(userUuid, ticketNum) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public Integer rewardNovel(String userUuid, String novelUuid, Integer rewardNum) {
        ReaderEntity reader = userDao.getReaderByUuid(userUuid);
        if (reader.getBookCoin() < rewardNum) {
            return 0;
        } else if (userDao.rewardNovel(userUuid, rewardNum) == 0) {
            return 0;
        } else {
            String writerUuid = userDao.getWriterUuidByNovel(novelUuid);
            userDao.updateReaderXp(userUuid, rewardNum);
            userDao.updateWriterXp(writerUuid, rewardNum);
            String nowTime = DateUtil.getNowTime();
            ReaderOutcomeEntity readerOutcomeEntity =
                    new ReaderOutcomeEntity(userUuid, novelUuid, null, 0, rewardNum, nowTime);
            userDao.addReaderOutcome(readerOutcomeEntity);
            String thisMonth = DateUtil.getNowYearMonth();
            WriterIncomeEntity writerIncomeEntity =
                    new WriterIncomeEntity(writerUuid, novelUuid, 0, rewardNum, thisMonth);
            Integer k = userDao.updateWriterRewardIncome(writerIncomeEntity);
            if (k == 0) {
                userDao.addWriterIncome(writerIncomeEntity);
            }
            return 1;
        }
    }


}
