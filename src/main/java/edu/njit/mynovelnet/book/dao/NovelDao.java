package edu.njit.mynovelnet.book.dao;

import edu.njit.mynovelnet.book.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("novelDao")
public interface NovelDao {
    List<NovelEntity> getAll();

    NovelInfoPageEntity getNovelInfoPageEntityByNovelUuid(@Param("novelUuid") String novelUuid);

    String getNovelDetailByNovelUuid(@Param("novelUuid") String novelUuid);

    List<VolumeEntity> getVolumeListByNovelUuid(@Param("novelUuid") String novelUuid);

    List<ChapterEntity> getChapterListByVolumeUuid(@Param("volumeUuid") String volumeUuid);

    Integer getChapterSumByNovelUuid(@Param("novelUuid") String novelUuid);

    List<NovelRankShowEntity> getRankShowsByUuids(@Param("novelUuids") String[] novelUuids);

    List<String> getBookstoreList(@Param("userUuid") String userUuid);

    Integer addToBookstore(BookstoreEntity bookstoreEntity);

    Integer updateBookshelf(BookstoreEntity bookstoreEntity);

    List<AllWorkShowEntity> getAllWorks();

    List<AllWorkShowEntity> getAllWorksByFilter(SearchEntity searchEntity);

    ChapterContextEntity getChapterContext(@Param("chapterUuid") String chapterUuid);

    ReadShowEntity getReadShowInfo(@Param("novelUuid") String novelUuid, @Param("chapterUuid") String chapterUuid);

    Integer ifInBookShelf(@Param("novelUuid") String novelUuid, @Param("userUuid") String userUuid);

    Integer ifBuy(@Param("chapterUuid") String chapterUuid, @Param("userUuid") String userUuid);

    String getChapterUuid(@Param("novelUuid") String novelUuid, @Param("chapterRank") Integer chapterRank);

    String getReadProgress(@Param("novelUuid") String novelUuid, @Param("userUuid") String userUuid);

    String getFirstChapterUuid(@Param("novelUuid") String novelUuid);

    List<ChapterEntity> getEasyCatalog(@Param("novelUuid") String novelUuid);

    Integer addReadProgress(ReadProgressEntity readProgressEntity);

    Integer updateReadProgress(ReadProgressEntity readProgressEntity);

    Integer addIfAutoSubscribe(BookstoreEntity bookstoreEntity);

    Integer updateIfAutoSubscribe(BookstoreEntity bookstoreEntity);

    Integer getPChapterIdByNovelUuid(@Param("novelUuid") String novelUuid);
}
