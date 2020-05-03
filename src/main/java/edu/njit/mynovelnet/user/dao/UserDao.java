package edu.njit.mynovelnet.user.dao;

import edu.njit.mynovelnet.user.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("userDao")
public interface UserDao {
    User testFunction();

    List<ReaderEntity> getAllReader();

    List<WriterEntity> getAllWriter();

    User getUserInfoById(@Param("userId") String userId);

    ReaderEntity getReaderInfoById(@Param("userId") String userId);

    Integer getCountByUserId(@Param("userId") String userId);

    Integer getCountByUsername(@Param("username") String username);

    void insertRegistesUser(User user);

    void insertRegistreReader(ReaderEntity readerEntity);

    WriterEntity getWriterInfoByUuid(@Param("writerUuid") String writerUuid);

    Integer rechargeBookCoin(@Param("userUuid") String userUuid, @Param("bookCoin") Integer bookCoin);

    ReadReaderEntity getReadReader(@Param("userUuid") String userUuid, @Param("novelUuid") String novelUuid);

    Integer addToSubscribe(@Param("userUuid") String userUuid, @Param("chapterUuid") String chapterUuid);

    ReaderEntity getReaderByUuid(@Param("userUuid") String userUuid);

    Integer voteRecTicket(@Param("userUuid") String userUuid, @Param("ticketNum") Integer ticketNum);

    Integer voteMonthTicket(@Param("userUuid") String userUuid, @Param("ticketNum") Integer ticketNum);

    Integer rewardNovel(@Param("userUuid") String userUuid, @Param("rewardNum") Integer rewardNum);

    Integer updateReaderXp(@Param("userUuid") String userUuid, @Param("xp") Integer xp);

    Integer updateWriterXp(@Param("userUuid") String userUuid, @Param("xp") Integer xp);

    Integer addWriterIncome(WriterIncomeEntity writerIncomeEntity);

    Integer addReaderOutcome(ReaderOutcomeEntity readerOutcomeEntity);

    Integer updateWriterSubscribeIncome(WriterIncomeEntity writerIncomeEntity);

    Integer updateWriterRewardIncome(WriterIncomeEntity writerIncomeEntity);

    String getWriterUuidByNovel(@Param("novelUuid") String novelUuid);
}
