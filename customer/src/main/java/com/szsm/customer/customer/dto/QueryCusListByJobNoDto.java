package com.szsm.customer.customer.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Data
@Component
public class QueryCusListByJobNoDto {
    @NotNull(message = "客户经理工号不能为空")
    private String jobNo;
    @NotNull(message = "当前页数不能为空")
    private Integer currentPage;
    @NotNull(message = "页面大小不能为空")
    private Integer size;
}
