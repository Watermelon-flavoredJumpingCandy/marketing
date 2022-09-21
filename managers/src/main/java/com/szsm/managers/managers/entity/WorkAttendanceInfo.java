package com.szsm.managers.managers.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@TableName("check_work_attendance")
@ApiModel(value = "WorkAttendanceInfo对象", description = "考勤信息表")
public class WorkAttendanceInfo implements Serializable {

    private static final long serialVersionUID = 9143132140209156954L;

    @ApiModelProperty("工号")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("客户经理工号")
    private String custManager;

    @ApiModelProperty("上班打卡时间")
    private String startTime;

    @ApiModelProperty("下班打卡时间")
    private String endTime;

    @ApiModelProperty("外出申请时间")
    private String outStartTime;

    @ApiModelProperty("外出回来时间")
    private String outEndTime;

    @ApiModelProperty("外出类型(公/私)")
    private String outType;

    @ApiModelProperty("考勤状态(正常，异常)")
    private String status;

    @ApiModelProperty("打卡地址详情")
    private String address;

    @ApiModelProperty("创建日期")
    private String createDate;

    @ApiModelProperty("图片保存")
    private String image;

    @ApiModelProperty("备注")
    private String remark;


}
