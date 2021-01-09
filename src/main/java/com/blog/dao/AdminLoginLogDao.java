package com.blog.dao;

import com.blog.pojo.AdminLoginLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminLoginLogDao {
    /**
     * 删除日志
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);
    
    /**
     * 新建日志
     *
     * @param record
     * @return
     */
    int insert(AdminLoginLog record);
    
    /**
     * 插入日志
     *
     * @param record
     * @return
     */
    int insertSelective(AdminLoginLog record);
    
    /**
     * 根据主键查找
     *
     * @param id
     * @return
     */
    AdminLoginLog selectByPrimaryKey(Long id);
    
    /**
     * 更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(AdminLoginLog record);
    
    /**
     * 更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(AdminLoginLog record);
    
    /**
     * 查询所有日志
     *
     * @return
     */
    List<AdminLoginLog> queryAll();
    
    /**
     * 查询最近日志
     *
     * @param adminId
     * @return
     */
    List<AdminLoginLog> selectRecent(Integer adminId);
    
    int selectCountByAdminId(Integer adminId);
}