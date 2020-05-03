package edu.njit.mynovelnet.index.dao;

import edu.njit.mynovelnet.index.entity.CoverRecomEntity;
import edu.njit.mynovelnet.index.entity.EditorRecomEntity;
import edu.njit.mynovelnet.index.entity.RecomEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("indexDao")
public interface IndexDao {

    List<RecomEntity> getStrongRecommondByDate(@Param("date") Long date);

    List<RecomEntity> getSanJiangByDate(@Param("date") Long date);

    Integer getCount();

    List<RecomEntity> getRecomByUuids(@Param("novelUuids") String[] novelUuids);

    List<EditorRecomEntity> getEditorRecom();

    List<CoverRecomEntity> getNewest5CoverRecom();
}
