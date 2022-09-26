package com.szsm.managers.managers.service;

import com.szsm.managers.managers.entity.CrmInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 客户经理信息表 服务类
 * </p>
 *
 * @author baomidou
 * @since 2022-09-26
 */
public interface ICrmInfoService extends IService<CrmInfo> {
    public String checkByCustNo(String custNo);

    public String updateByCustNo(String custNo);

    public boolean delByCustNo(String custNo);

    public String loginByCustNo(CrmInfo customer);
}
