package edu.njit.mynovelnet.user.service;

import edu.njit.mynovelnet.user.entity.ReadReaderEntity;
import edu.njit.mynovelnet.user.entity.ReaderEntity;
import edu.njit.mynovelnet.user.entity.User;
import edu.njit.mynovelnet.user.entity.WriterEntity;

public interface UserService {
    User testFunction();

    User getUserInfoById(String userId);

    ReaderEntity getReaderInfoById(String userId);

    Boolean ifExistAlreadyByUserId(String userId);

    Boolean ifExistAlreadyByUsername(String username);

    void insertRegistesUser(User user);

    void insertRegistreReader(ReaderEntity readerEntity);

    WriterEntity getWriterInfoByUuid(String writerUuid);

    Integer rechargeBookCoin(String userUuid, Integer bookCoin);

    ReadReaderEntity getReadReader(String userUuid, String novelUuid);

    Integer subscribeChapter(String userUuid, String novelUuid, String chapterUuid, Integer bookCoin);

    ReaderEntity getReaderByUuid(String userUuid);
}
