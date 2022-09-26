package com.szsm.managers.managers.controller;

import com.szsm.common.entity.ResultData;
import com.szsm.managers.managers.entity.CrmInfo;
import com.szsm.managers.managers.service.ICrmInfoService;
import com.szsm.managers.managers.service.impl.CrmInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 客户经理信息表 前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2022-09-26
 */
@RestController
@RequestMapping("/crm-info")
public class CrmInfoController {
    @Autowired
    private ICrmInfoService crmInfoServiceImpl;

    //校验客户登录
    @RequestMapping("Login/test")
    public ResultData checkCustNo(@RequestParam("custNo") String custNo) {
        //控制层判断反回数据
        String exist = crmInfoServiceImpl.checkByCustNo(custNo);
        System.out.println(exist);
        if ("0" == exist || exist == null) {//无该用户
            return ResultData.fail(201, "无" + custNo + "用户");
        } else {//有该用户
            return ResultData.success(exist);//status=200
        }
    }

    //	@RequestMapping(path = "Login/test", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @RequestMapping("Login")
    public ResultData loginByCustNo(@RequestBody CrmInfo customer) {
        //控制层判断反回数据
//		System.out.println(customer);
//		System.out.println(customer.getPassword());
        String exist = crmInfoServiceImpl.loginByCustNo(customer);
        System.out.println(exist);
        if ("0" == exist || exist == null) {//无该用户
            return ResultData.fail(201, "无" + customer.getJobNo() + "用户");
        } else {//有该用户
            return ResultData.success(exist);//status=200
        }
    }

    //更新redis的客户刷新时间
    @RequestMapping("updateLogin")
    public ResultData updateByCustNo(String custNo) {
        //判断成功失败结构
        try {
            String ticket = crmInfoServiceImpl.updateByCustNo(custNo);
            return ResultData.success(ticket);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultData.fail(201, "");
        }
    }

    //删除redis的客户登录信息
    @RequestMapping("delLogin")
    public ResultData delByCustNo(String custNo) {
        //判断成功失败结构
        try {
            boolean delFlag = crmInfoServiceImpl.delByCustNo(custNo);
            return ResultData.success(delFlag);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultData.fail(201, "");
        }
    }
}
