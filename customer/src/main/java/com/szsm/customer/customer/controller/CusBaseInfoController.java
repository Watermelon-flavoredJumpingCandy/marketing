package com.szsm.customer.customer.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.szsm.customer.customer.entity.CusBaseInfo;
import com.szsm.customer.customer.service.ICusBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 客户基本信息表 前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2022-09-16
 */
@RestController
@RequestMapping("/cusBaseInfo")
public class CusBaseInfoController {
    @Autowired
    private ICusBaseInfoService cusBaseInfoServiceImpl;

    // 通过客户经理工号查询客户列表
    @RequestMapping("/queryCusListByJobNo")
    public Page<CusBaseInfo> queryCusListByJobNo(String jobNo) {
        Page<CusBaseInfo> page = new Page<CusBaseInfo>();
        return cusBaseInfoServiceImpl.page(page, new QueryWrapper<CusBaseInfo>().eq("jobNo", jobNo));
    }

    // 新增客户信息
    @RequestMapping("/saveCusInfo")
    public boolean saveCusInfo(CusBaseInfo cusBaseInfo) {
        cusBaseInfo.setCustCreatetime(new Date());
        return cusBaseInfoServiceImpl.save(cusBaseInfo);
    }

    // 更新客户信息
    @RequestMapping("/updateCusInfo")
    public boolean updateCusInfo(CusBaseInfo cusBaseInfo) {
        return cusBaseInfoServiceImpl.update(cusBaseInfo, new UpdateWrapper<CusBaseInfo>().eq("custNo", cusBaseInfo.getCustNo()));
    }

    // 删除客户信息
    @RequestMapping("/removeCusInfo")
    public boolean removeCusInfo(String custNo) {
        return cusBaseInfoServiceImpl.remove(new QueryWrapper<CusBaseInfo>().eq("custNo", custNo));
    }
}
