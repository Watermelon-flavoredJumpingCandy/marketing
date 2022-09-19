package com.szsm.customer.customer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 客户基本信息表
 * </p>
 *
 * @author baomidou
 * @since 2022-09-19
 */
@Getter
@Setter
@TableName("cus_base_info")
@ApiModel(value = "CusBaseInfo对象", description = "客户基本信息表")
public class CusBaseInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("序号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("核心客户号")
    private String custNo;

    @ApiModelProperty("客户经理工号")
    private String jobNo;

    @ApiModelProperty("客户名称")
    private String custName;

    @ApiModelProperty("手机号")
    private String custPhonenumber;

    @ApiModelProperty("卡号")
    private String custCardno;

    @ApiModelProperty("身份证号码")
    private String custIdcardno;

    @ApiModelProperty("客户类型")
    private String custType;

    @ApiModelProperty("状态")
    private String custStatus;

    @ApiModelProperty("所属机构")
    private String custOrg;

    @ApiModelProperty("客户等级")
    private String custGrade;

    @ApiModelProperty("重要客户排名")
    private String custRanking;

    @ApiModelProperty("创建时间")
    private Date custCreatetime;

    @ApiModelProperty("更新时间")
    private Date custUpdatetime;

    @ApiModelProperty("客户经理转让时间")
    private Date custTransfertime;


}
