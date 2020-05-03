package edu.njit.mynovelnet.index.service;

import edu.njit.mynovelnet.index.entity.CoverRecomEntity;
import edu.njit.mynovelnet.index.entity.EditorRecomEntity;
import edu.njit.mynovelnet.index.entity.RecomEntity;
import edu.njit.mynovelnet.rank.entity.RankEntity;
import edu.njit.mynovelnet.rank.entity.RankShowEntity;

import java.util.List;

public interface IndexService {
    List<RecomEntity> getNewestStrongRecommond();

    List<RecomEntity> getNewestSanJiang();

    Integer getCount();

    List<RankShowEntity> getRecomByRankList(List<RankEntity> ranklist);

    List<EditorRecomEntity> getEditorRecom();

    List<CoverRecomEntity> getNewest5CoverRecom();
}
