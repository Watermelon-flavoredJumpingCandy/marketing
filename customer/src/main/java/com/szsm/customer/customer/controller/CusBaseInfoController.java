package com.szsm.customer.customer.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.szsm.customer.customer.dto.QueryCusListByJobNoDto;
import com.szsm.customer.customer.dto.RemoveCusInfoDto;
import com.szsm.customer.customer.dto.SaveCusInfoDto;
import com.szsm.customer.customer.dto.UpdateCusInfoDto;
import com.szsm.customer.customer.entity.CusBaseInfo;
import com.szsm.customer.customer.service.ICusBaseInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
@Slf4j
@RestController
@RequestMapping("/cusBaseInfo")
public class CusBaseInfoController {
    @Autowired
    private ICusBaseInfoService cusBaseInfoServiceImpl;

    @RequestMapping("/test")
    public String test() {
        return "test!";
    }

    // 通过客户经理工号查询客户列表
    @RequestMapping("/queryCusListByJobNo")
    public Page<CusBaseInfo> queryCusListByJobNo(@RequestBody @Valid QueryCusListByJobNoDto queryCusListByJobNoDto) {
        log.info("--- CusBaseInfoController - saveCusInfo - cusBaseInfo : " + JSON.toJSONString(queryCusListByJobNoDto));
        Page<CusBaseInfo> page = new Page<CusBaseInfo>(queryCusListByJobNoDto.getCurrentPage(), queryCusListByJobNoDto.getSize());
        return cusBaseInfoServiceImpl.page(page, new QueryWrapper<CusBaseInfo>().eq("job_no", queryCusListByJobNoDto.getJobNo()));
    }

    // 新增客户信息
    @RequestMapping("/saveCusInfo")
    public boolean saveCusInfo(@RequestBody SaveCusInfoDto saveCusInfoDto) {
        log.info("--- CusBaseInfoController - saveCusInfo - cusBaseInfo : " + JSON.toJSONString(saveCusInfoDto));
        saveCusInfoDto.setCustCreatetime(new Date());
        CusBaseInfo cusBaseInfo = new CusBaseInfo();
        BeanUtils.copyProperties(saveCusInfoDto, cusBaseInfo);
        Integer cusNoSeq = cusBaseInfoServiceImpl.getCustNoSeq();
        cusBaseInfo.setCustNo(cusNoSeq.toString());
        return cusBaseInfoServiceImpl.save(cusBaseInfo);
    }

    // 更新客户信息
    @RequestMapping("/updateCusInfo")
    public boolean updateCusInfo(@RequestBody UpdateCusInfoDto updateCusInfoDto) {
        log.info("--- CusBaseInfoController - updateCusInfo - cusBaseInfo : " + JSON.toJSONString(updateCusInfoDto));
        updateCusInfoDto.setCustUpdatetime(new Date());
        List<CusBaseInfo> cusList = cusBaseInfoServiceImpl.list(new QueryWrapper<CusBaseInfo>().eq("cust_no", updateCusInfoDto.getCustNo()));
        if (cusList != null && cusList.size() > 0) {
            CusBaseInfo cusBaseInfo1 = cusList.get(0);
            if (cusBaseInfo1.getJobNo() != null && !cusBaseInfo1.getJobNo().equals(updateCusInfoDto.getJobNo())) {
                updateCusInfoDto.setCustTransfertime(new Date());
            }
        }
        CusBaseInfo cusBaseInfo = new CusBaseInfo();
        BeanUtils.copyProperties(updateCusInfoDto, cusBaseInfo);
        return cusBaseInfoServiceImpl.update(cusBaseInfo, new UpdateWrapper<CusBaseInfo>().eq("cust_no", updateCusInfoDto.getCustNo()));
    }

    // 删除客户信息
    @RequestMapping("/removeCusInfo")
    public boolean removeCusInfo(@RequestBody @Valid RemoveCusInfoDto removeCusInfoDto) {
        log.info("--- CusBaseInfoController - removeCusInfo - removeCusInfoDto : " + JSON.toJSONString(removeCusInfoDto));
        return cusBaseInfoServiceImpl.remove(new QueryWrapper<CusBaseInfo>().eq("cust_no", removeCusInfoDto.getCustNo()));
    }
}
