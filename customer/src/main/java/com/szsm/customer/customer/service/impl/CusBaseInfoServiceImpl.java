package com.szsm.customer.customer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.szsm.customer.customer.entity.CusBaseInfo;
import com.szsm.customer.customer.mapper.CusBaseInfoMapper;
import com.szsm.customer.customer.service.ICusBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 客户基本信息表 服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2022-09-19
 */
@Service
public class CusBaseInfoServiceImpl extends ServiceImpl<CusBaseInfoMapper, CusBaseInfo> implements ICusBaseInfoService {
    @Autowired
    private CusBaseInfoMapper cusBaseInfoMapper;
}
