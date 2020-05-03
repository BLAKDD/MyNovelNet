package edu.njit.mynovelnet.index.service.serviceimpl;

import edu.njit.mynovelnet.index.dao.IndexDao;
import edu.njit.mynovelnet.index.entity.CoverRecomEntity;
import edu.njit.mynovelnet.index.entity.EditorRecomEntity;
import edu.njit.mynovelnet.index.entity.RecomEntity;
import edu.njit.mynovelnet.index.service.IndexService;
import edu.njit.mynovelnet.myutil.DateUtil;
import edu.njit.mynovelnet.rank.entity.RankEntity;
import edu.njit.mynovelnet.rank.entity.RankShowEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("indexService")
public class IndexServiceImpl implements IndexService {
    @Autowired
    private IndexDao indexDao;

    private List<RankShowEntity> getRankShowEntityByLists(List<RankEntity> rankEntities, List<RecomEntity> recomEntities) {
        List<RankShowEntity> rankShowEntities = new ArrayList<>();
        for (RankEntity rankEntity : rankEntities
        ) {
            for (RecomEntity recomEntity : recomEntities
            ) {
                if (rankEntity.getBookUuid().equals(recomEntity.getNovelUuid())) {
                    RankShowEntity rankShowEntity = new RankShowEntity(recomEntity, rankEntity.getScore().intValue());
                    rankShowEntities.add(rankShowEntity);
                    break;
                }
            }
        }
        return rankShowEntities;
    }

    @Override
    public List<RecomEntity> getNewestStrongRecommond() {
        Long date = DateUtil.getNowDateLong();
        System.out.println(date);
        return indexDao.getStrongRecommondByDate(date);
    }

    @Override
    public List<RecomEntity> getNewestSanJiang() {
        Long date = DateUtil.getNowDateLong();
        return indexDao.getSanJiangByDate(date);
    }

    @Override
    public Integer getCount() {
        return indexDao.getCount();
    }

    @Override
    public List<RankShowEntity> getRecomByRankList(List<RankEntity> ranklist) {
        int size = ranklist.size();
        String[] novelUuids = new String[size];
        int i = 0;
        for (RankEntity re : ranklist
        ) {
            novelUuids[i] = re.getBookUuid();
            i++;
        }
        if (novelUuids.length == 0) {
            return null;
        }
        List<RecomEntity> list = indexDao.getRecomByUuids(novelUuids);
        return this.getRankShowEntityByLists(ranklist, list);
    }

    @Override
    public List<EditorRecomEntity> getEditorRecom() {
        return indexDao.getEditorRecom();
    }

    @Override
    public List<CoverRecomEntity> getNewest5CoverRecom() {
        return indexDao.getNewest5CoverRecom();
    }
}
