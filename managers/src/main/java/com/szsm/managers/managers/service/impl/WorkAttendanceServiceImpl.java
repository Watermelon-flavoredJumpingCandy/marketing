package com.szsm.managers.managers.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.szsm.managers.managers.entity.WorkAttendanceInfo;
import com.szsm.managers.managers.mapper.WorkAttendanceMapper;
import com.szsm.managers.managers.service.IWorkAttendanceService;
import org.springframework.stereotype.Service;

@Service
public class WorkAttendanceServiceImpl
        extends ServiceImpl<WorkAttendanceMapper, WorkAttendanceInfo>
        implements IWorkAttendanceService {
    private WorkAttendanceMapper workAttendanceMapper;
}
