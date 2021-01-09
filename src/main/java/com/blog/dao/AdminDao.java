package com.blog.dao;

import com.blog.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminDao {
    /**
     * 根据主键删除id
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);
    
    /**
     * 插入数据
     * @param record
     * @return
     */
    int insert(Admin record);
    
    /**
     * 新建用户
     * @param record
     * @return
     */
    int insertSelective(Admin record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */
    Admin selectByPrimaryKey(Integer id);
    
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Admin record);
    
    /**
     * 根据主键更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Admin record);
}