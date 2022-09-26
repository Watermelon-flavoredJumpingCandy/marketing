package com.szsm.managers.managers.entity;

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
 * 客户经理信息表
 * </p>
 *
 * @author baomidou
 * @since 2022-09-26
 */
@Getter
@Setter
@TableName("crm_info")
@ApiModel(value = "CrmInfo对象", description = "客户经理信息表")
public class CrmInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("客户经理序号")
    @TableId(value = "crm_seq", type = IdType.AUTO)
    private Integer crmSeq;

    @ApiModelProperty("工号")
    private String jobNo;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("所属网点")
    private String deptNo;

    @ApiModelProperty("所属团队")
    private String teamNo;

    @ApiModelProperty("证件类型")
    private String idType;

    @ApiModelProperty("证件号")
    private String idNo;

    @ApiModelProperty("客户经理等级")
    private String level;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;


}
