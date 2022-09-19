package com.szsm.customer.customer.dto;

import lombok.Data;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Data
public class RemoveCusInfoDto {
    @NotNull(message = "核心客户号不能为空")
    private String custNo;
}
