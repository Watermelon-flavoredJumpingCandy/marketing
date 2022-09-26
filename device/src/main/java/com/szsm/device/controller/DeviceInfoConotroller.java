package com.szsm.device.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.szsm.device.MD5Util;
import com.szsm.device.entity.DeviceInfo;
import com.szsm.device.service.IDeviceInfoService;
import com.szsm.device.service.impl.DeviceInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin.dom.core.Comment;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/deviceInfoController")
public class DeviceInfoConotroller {
    @Autowired
    private IDeviceInfoService deviceInfoServiceImpl;

    @RequestMapping("/test")
    public String test() {
        return "test!";
    }

    // 通过客户经理工号查询登录信息列表
    @RequestMapping("/queryDeviceByJobNo")
    public Page<DeviceInfo> queryDeviceByJobNo(@RequestBody DeviceInfo deviceInfo) {

        Page<DeviceInfo> page=new Page<DeviceInfo>();
        return deviceInfoServiceImpl.page(
                page,new QueryWrapper<DeviceInfo>().eq("job_no",deviceInfo.getJobNo()));

    }

    //保存登录信息
    @RequestMapping("/saveDeviceInfo")
    public boolean saveDeviceInfo(@RequestBody Map<String,String> map){
        System.out.println(map.get("seq"));
        DeviceInfo deviceInfo=new DeviceInfo();
        deviceInfo.setSeq(Integer.valueOf(map.get("seq")));
        deviceInfo.setJobNo(map.get("jobNo"));
        deviceInfo.setAuthType(map.get("authType"));
        deviceInfo.setPassword(MD5Util.md5(map.get("password")));
        deviceInfo.setDeviceNo(map.get("deviceNo"));
        deviceInfo.setCreateTime(
                toLocalDateTime(map.get("createTime"), "yyyy-MM-dd HH:mm:ss"));

        System.out.println("保存数据成功");
        return deviceInfoServiceImpl.save(deviceInfo);

    }

    //修改登录密码
    @RequestMapping("/updateDeviceInfo")
    public boolean UpdateDeviceInfo(@RequestBody DeviceInfo deviceInfo){

     deviceInfo.setPassword(MD5Util.md5(deviceInfo.getPassword()));

        return deviceInfoServiceImpl.update(
           deviceInfo,new UpdateWrapper<DeviceInfo>().
                        eq("job_no",deviceInfo.getJobNo()));
    }


    //根据工号删除登录信息
    @RequestMapping("/deleteDeviceInfoByJobNo")
    public boolean deleteDeviceInfoByJobNo(@RequestBody DeviceInfo deviceInfo){
        return deviceInfoServiceImpl.remove(
                new QueryWrapper<DeviceInfo>().eq("job_no",deviceInfo.getJobNo()));
    }

    //日期格式转换
    public static LocalDateTime toLocalDateTime(String dateTime, String format) {
        if (StringUtils.isEmpty(dateTime)) {
            return null;
        }
        if (StringUtils.isEmpty(format)) {
            format = "yyyy-MM-dd HH:mm:ss";
        }

        DateTimeFormatter df = DateTimeFormatter.ofPattern(format);
        LocalDateTime ldt = LocalDateTime.parse(dateTime,df);
        return ldt;
    }


}
