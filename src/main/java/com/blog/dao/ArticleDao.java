package com.blog.dao;

import com.blog.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleDao {
    /**
     * 删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);
    
    /**
     * 新建
     * @param record
     * @return
     */
    int insert(Article record);
    
    /**
     *
     * @param record
     * @return
     */
    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    Article selectLastArticle(Integer id);

    Article selectNextArticle(Integer id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);
    
    /**
     * 计算总数
     * @return
     */
    int countAllNum();


    List<Article> queryAll();
    
    /**
     * 根据关键词查询
     * @param word
     * @return
     */
    List<Article> selectByWord(String word);
}