package com.szsm.managers.managers.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.szsm.managers.managers.entity.WorkAttendanceInfo;
import com.szsm.managers.managers.service.IWorkAttendanceService;
import com.szsm.managers.managers.service.impl.WorkAttendanceServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.parser.Entity;
import java.util.Date;

@RestController
@RequestMapping("/workAttendanceController")
public class WorkAttendanceController {
    @Autowired
    private IWorkAttendanceService workAttendanceServiceImpl;


    // 通过客户经理工号查询考勤信息表
    @RequestMapping("/queryWorkAttendanceListById")
    public Page<WorkAttendanceInfo> queryWorkAttendanceById(String id){

       Page<WorkAttendanceInfo> page =new Page<WorkAttendanceInfo>();

        return workAttendanceServiceImpl.page(page,
                new QueryWrapper<WorkAttendanceInfo>().eq("id",'1'));


    }

    // 保存客户考勤信息
    @RequestMapping("/saveWorkAttendanceInfo")
    public boolean saveWorkAttendanceInfo(WorkAttendanceInfo workAttendanceInfo){
//        workAttendanceInfo.setCreateDate(new Date());
        return workAttendanceServiceImpl.save(workAttendanceInfo);
    }

    // 更新客户考勤信息
    @RequestMapping("/updateWorkAttendanceInfo")
    public boolean updateWorkAttendanceInfo(WorkAttendanceInfo workAttendanceInfo){
        return workAttendanceServiceImpl.update(
                workAttendanceInfo,new UpdateWrapper<WorkAttendanceInfo>().eq("id",workAttendanceInfo.getId()));
    }

    //删除客户考勤信息
    @RequestMapping("/deleteWorkAttendanceInfo")
    public boolean deleteWorkAttendanceInfo(String id){
        return workAttendanceServiceImpl.remove(
                new QueryWrapper<WorkAttendanceInfo>().eq("id",id));
    }
}
