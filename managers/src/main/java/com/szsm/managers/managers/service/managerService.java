package com.szsm.managers.managers.service;

import com.szsm.managers.managers.mapper.managerMapper;
import com.szsm.managers.managers.pojo.manager;
import com.szsm.managers.managers.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * @author xc
 * @ClassName customerService
 * @Description TODO
 * @date 2022/9/20 下午 2:53
 * @Version 1.0
 */
@Service
public class managerService {
    @Autowired
    private ShardedJedisPool pool;

    @Autowired
    private managerMapper managerMapper;

    public String checkByCustNo(String jobNo) {
        //Jedis jedis=new Jedis("10.9.39.13",6379);
        //从连接池获取资源操作redis集群
        ShardedJedis jedis=pool.getResource();
        try{
            manager existManager= managerMapper.queryByJobNo(jobNo);
            System.out.println(existManager);
            if(existManager.getJobNo()==null){
                //登录校验失败
                return "0";
            }else{//登录成功
                //value数据 userJson的字符串
                String ManagerJson=
                        MapperUtil.MP.writeValueAsString(existManager);
                //key
                String ticket="EM_TICKET"+
                        existManager.getJobNo() ;
                jedis.setex(ticket, 60*10, ManagerJson);
                //set ticket ManagerJson EX 600
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


    public String updateByCustNo(String jobNo) {
        //Jedis jedis=new Jedis("10.9.39.13",6379);
        //从连接池获取资源操作redis集群
        ShardedJedis jedis=pool.getResource();
        try{
            manager existManager= managerMapper.queryByJobNo(jobNo);//password userName
            if(existManager==null){
                //登录校验失败
                return "";
            }else{//登录成功
                //value数据 userJson的字符串
                String ManagerJson=
                        MapperUtil.MP.writeValueAsString(existManager);
                //key
                String ticket="EM_TICKET"+
                        existManager.getJobNo();
                jedis.setex(ticket, 60*10, ManagerJson);
                //set ticket ManagerJson EX 600
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

    public boolean delByCustNo(String jobNo) {
        //Jedis jedis=new Jedis("10.9.39.13",6379);
        //从连接池获取资源操作redis集群
        ShardedJedis jedis=pool.getResource();
        try{
            manager existManager= managerMapper.queryByJobNo(jobNo);//password userName
            if(existManager==null){
                //登录校验失败
                return false;
            }else{//登录成功
                //value数据 userJson的字符串
                String ManagerJson=
                        MapperUtil.MP.writeValueAsString(existManager);
                //key
                String ticket="EM_TICKET"+
                        existManager.getJobNo();
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

    public String loginByCustNo(manager manager) {
        //Jedis jedis=new Jedis("10.9.39.13",6379);
        //从连接池获取资源操作redis集群
        ShardedJedis jedis=pool.getResource();
        try{
            String passwordFromUser = manager.getPassword();
            manager existManager= managerMapper.queryByJobNo(manager.getJobNo());
//            System.out.println(existManager);
            String passwordFromDB = existManager.getPassword();
            if( (!StringUtils.isEmpty(passwordFromUser)) && passwordFromUser == passwordFromDB){
                //登录校验失败
                return "0";
            }else{//登录成功
                //value数据 userJson的字符串
                String ManagerJson=
                        MapperUtil.MP.writeValueAsString(existManager);
                //key
                String ticket="EM_TICKET"+
                        existManager.getJobNo();
                jedis.setex(ticket, 60*10, ManagerJson);
                //set ticket ManagerJson EX 600
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
}
