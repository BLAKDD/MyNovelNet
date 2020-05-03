package edu.njit.mynovelnet.book.service;

import edu.njit.mynovelnet.book.entity.*;

import java.util.List;
import java.util.Map;

public interface NovelService {

    List<NovelEntity> getAll();

    NovelInfoPageEntity getNovelInfoPageNovelData(String novelUuid);

    String getNovelDetailIntro(String novelUuid);

    Map<VolumeEntity, List<ChapterEntity>> getCatalogShowMap(String novelUuid);

    Map<String, List<ChapterEntity>> getCatalogShowMap2(String novelUuid);

    Integer getChapterSum(String novelUuid);

    List<String> getBookstoreList(String userUuid);

    Integer addToBookstore(BookstoreEntity bookstoreEntity);

    List<AllWorkShowEntity> getAllWorks();

    List<AllWorkShowEntity> getAllWorksByFilter(SearchEntity searchEntity);

    ChapterContextEntity getChapterContext(String chapterUuid);

    ReadShowEntity getReadShowInfo(String novelUuid, String chapterUuid, String userUuid);

    String getNearChapterUuid(String novelUuid, Integer chapterRank);

    Integer ifInBookShelf(String userUuid, String novelUuid);

    String getReadProgress(String novelUuid, String userUuid);

    String getFirstChapterUuid(String novelUuid);

    List<ChapterEntity> getEasyCatalog(String novelUuid);

    Integer updateReadProgress(ReadProgressEntity readProgressEntity);

    Integer updateIfAutoSubscribe(BookstoreEntity bookstoreEntity);

    Integer voteRecTicket(String userUuid, String novelUuid, Integer ticketNum);

    String getNovelRankCategory(String novelUuid);

    Integer voteMonthTicket(String userUuid, String novelUuid, Integer ticketNum);

    Integer rewardNovel(String userUuid, String novelUuid, Integer rewardNum);
}
