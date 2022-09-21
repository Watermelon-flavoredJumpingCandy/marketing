package com.szsm.device.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 设备信息表
 * </p>
 *
 * @author baomidou
 * @since 2022-09-21
 */
@Getter
@Setter
@TableName("device_info")
@ApiModel(value = "DeviceInfo对象", description = "设备信息表")
public class DeviceInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("序号")
    @TableId(value = "seq", type = IdType.AUTO)
    private Integer seq;

    @ApiModelProperty("工号")
    private String jobNo;

    @ApiModelProperty("认证方式")
    private String authType;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("设备信息")
    private String deviceNo;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;


}
