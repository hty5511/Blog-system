package com.blog.controller;

import com.blog.pojo.Admin;
import com.blog.pojo.AdminLoginLog;
import com.blog.service.AdminLoginLogService;
import com.blog.service.ArticleService;
import com.blog.service.CommentService;
import com.blog.service.impl.AdminLoginLogServiceImpl;
import com.blog.service.impl.ArticleServiceImpl;
import com.blog.service.impl.CommentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    
    private Logger loger = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    public AdminLoginLogService adminLoginLogService;
    @Autowired
    public ArticleService articleService;
    @Autowired
    public CommentService commentService;
    
    @RequestMapping("/main")
    public ModelAndView toMain(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("admin/main");
        String clientIp = request.getRemoteAddr();    //获取客户端IP，如：127.0.0.1
        String hostIp=request.getLocalAddr();
        int hostPort=request.getLocalPort();
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");//设置日期格式
        String dates = df.format(date);
        Admin admin=(Admin) request.getSession().getAttribute("admin");
        AdminLoginLog lastLoginLog=null;
        try {
            if (adminLoginLogService.selectRecent(admin.getId())!=null && adminLoginLogService.selectRecent(admin.getId()).size()==2){
                List<AdminLoginLog> adminLoginLogs=adminLoginLogService.selectRecent(admin.getId());
                lastLoginLog=adminLoginLogs.get(1);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            int articleCount=articleService.selectCount();
            int commentCount=commentService.countAllNum();
            int loginNum=adminLoginLogService.selectCountByAdminId(admin.getId());
            modelAndView.addObject("clientIp",clientIp);
            modelAndView.addObject("hostIp",hostIp);
            modelAndView.addObject("hostPort",hostPort);
            modelAndView.addObject("date",dates);
            if (lastLoginLog!=null){
                modelAndView.addObject("loginLog",lastLoginLog);
            }
            modelAndView.addObject("articleCount",articleCount);
            modelAndView.addObject("commentCount",commentCount);
            modelAndView.addObject("loginNum",loginNum);
            return modelAndView;
        }


    }

}
