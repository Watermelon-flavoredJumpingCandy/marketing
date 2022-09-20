package com.szsm.customer.customer.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class UpdateCusInfoDto {
    @NotNull(message = "核心客户号不能为空")
    private String custNo;
    private String jobNo;
    private String custName;
    private String custPhonenumber;
    private String custCardno;
    private String custIdcardno;
    private String custType;
    private String custStatus;
    private String custOrg;
    private String custGrade;
    private String custRanking;
    private Date custCreatetime;
    private Date custUpdatetime;
    private Date custTransfertime;
}
