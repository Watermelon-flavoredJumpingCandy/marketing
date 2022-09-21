package com.szsm.device.service.impl;

import com.szsm.device.entity.DeviceInfo;
import com.szsm.device.mapper.DeviceInfoMapper;
import com.szsm.device.service.IDeviceInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 设备信息表 服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2022-09-21
 */
@Service
public class DeviceInfoServiceImpl extends ServiceImpl<DeviceInfoMapper, DeviceInfo> implements IDeviceInfoService {

}
