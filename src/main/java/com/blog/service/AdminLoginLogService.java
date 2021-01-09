package com.blog.service;

import com.blog.pojo.AdminLoginLog;

import java.util.List;

/**
 * @author 55018
 */
public interface AdminLoginLogService {

    List<AdminLoginLog> selectRecent(Integer adminId);

    int insert(AdminLoginLog adminLoginLog);

    int selectCountByAdminId(int adminId);
}
