package com.blog.dao;

import com.blog.pojo.Catalog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CatalogDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Catalog record);

    int insertSelective(Catalog record);

    Catalog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Catalog record);

    int updateByPrimaryKeyWithBLOBs(Catalog record);

    int updateByPrimaryKey(Catalog record);
}