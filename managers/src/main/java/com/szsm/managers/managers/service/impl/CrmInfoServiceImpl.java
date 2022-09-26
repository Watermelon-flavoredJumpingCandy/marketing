package com.szsm.managers.managers.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.szsm.managers.managers.entity.CrmInfo;
import com.szsm.managers.managers.mapper.CrmInfoMapper;
import com.szsm.managers.managers.service.ICrmInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * <p>
 * 客户经理信息表 服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2022-09-26
 */
@Service
public class CrmInfoServiceImpl extends ServiceImpl<CrmInfoMapper, CrmInfo> implements ICrmInfoService {
    @Autowired
    private ShardedJedisPool pool;

    @Autowired
    private CrmInfoMapper crmInfoMapper;

    public String checkByCustNo(String custNo) {
        //Jedis jedis=new Jedis("10.9.39.13",6379);
        //从连接池获取资源操作redis集群
        ShardedJedis jedis=pool.getResource();
        try{
            CrmInfo existCustomer= crmInfoMapper.selectOne(new QueryWrapper<CrmInfo>().eq("job_no", custNo));
            System.out.println(existCustomer);
            if(existCustomer.getJobNo()==null){
                //登录校验失败
                return "0";
            }else{//登录成功
                //value数据 userJson的字符串
                String CustomerJson= JSON.toJSONString(existCustomer);
                //key
                String ticket="EM_TICKET"+
                        existCustomer.getJobNo();
                jedis.setex(ticket, 60*10, CustomerJson);
                //set ticket CustomerJson EX 600
                //成功后将ticket反悔
                return ticket;
            }
        }catch(Exception e){
            //出现任何异常,登录以失败处理
            return e.getMessage();
        }finally{
            //将jedis关闭
            pool.returnResource(jedis);
        }
    }


    public String updateByCustNo(String custNo) {
        //Jedis jedis=new Jedis("10.9.39.13",6379);
        //从连接池获取资源操作redis集群
        ShardedJedis jedis=pool.getResource();
        try{
            CrmInfo existCustomer= crmInfoMapper.selectOne(new QueryWrapper<CrmInfo>().eq("job_no", custNo));
            if(existCustomer==null){
                //登录校验失败
                return "";
            }else{//登录成功
                String CustomerJson= JSON.toJSONString(existCustomer);
                //key
                String ticket="EM_TICKET"+
                        existCustomer.getJobNo();
                jedis.setex(ticket, 60*10, CustomerJson);
                //set ticket CustomerJson EX 600
                //成功后将ticket反悔
                return ticket;
            }
        }catch(Exception e){
            //出现任何异常,登录以失败处理
            return "";
        }finally{
            //将jedis关闭
            pool.returnResource(jedis);
        }
    }

    public boolean delByCustNo(String custNo) {
        //Jedis jedis=new Jedis("10.9.39.13",6379);
        //从连接池获取资源操作redis集群
        ShardedJedis jedis=pool.getResource();
        try{
            CrmInfo existCustomer= crmInfoMapper.selectOne(new QueryWrapper<CrmInfo>().eq("job_no", custNo));
            if(existCustomer==null){
                //登录校验失败
                return false;
            }else{//登录成功
                //key
                String ticket="EM_TICKET"+
                        existCustomer.getJobNo();
                jedis.del(ticket);
                //set ticket userJson EX 180
                //成功后将ticket反悔
                return true;
            }
        }catch(Exception e){
            //出现任何异常,登录以失败处理
            return false;
        }finally{
            //将jedis关闭
            pool.returnResource(jedis);
        }
    }

    public String loginByCustNo(CrmInfo customer) {
//        //Jedis jedis=new Jedis("10.9.39.13",6379);
//        //从连接池获取资源操作redis集群
//        ShardedJedis jedis=pool.getResource();
//        try{
//            String passwordFromUser = customer.getPassword();
//            CrmInfo existCustomer= crmInfoMapper.selectOne(new QueryWrapper<CrmInfo>().eq("job_no", customer.getJobNo()));
////            System.out.println(existCustomer);
//            String passwordFromDB = existCustomer.getPassword();
//            if( (!StringUtils.isEmpty(passwordFromUser)) && passwordFromUser == passwordFromDB){
//                //登录校验失败
//                return "0";
//            }else{//登录成功
//                //value数据 userJson的字符串
//                String CustomerJson= JSON.toJSONString(existCustomer);
//                //key
//                String ticket="EM_TICKET"+
//                        existCustomer.getJobNo();
//                jedis.setex(ticket, 60*10, CustomerJson);
//                //set ticket CustomerJson EX 600
//                //成功后将ticket反悔
//                return ticket;
//            }
//        }catch(Exception e){
//            //出现任何异常,登录以失败处理
//            return e.getMessage();
//        }finally{
//            //将jedis关闭
//            pool.returnResource(jedis);
//        }
        return null;
    }
}
