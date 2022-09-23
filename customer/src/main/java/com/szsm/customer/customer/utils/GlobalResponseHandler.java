package com.szsm.customer.customer.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.szsm.common.entity.ResultData;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@Slf4j
@RestControllerAdvice("com.szsm.customer.customer.controller")
public class GlobalResponseHandler {
//public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Override
//    public boolean supports(MethodParameter methodParameter, Class aClass) { // 返回true执行beforeBodyWrite方法；返回false不执行
//        return true;
//    }
//
//    @SneakyThrows
//    @Override
//    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
//        final String returnTypeName = methodParameter.getParameterType().getName();
//        if (body instanceof String) {
//            return objectMapper.writeValueAsString(ResultData.success(body));
//        }
//        if ("void".equals(returnTypeName)) {
//            return ResultData.success(null); // 返回值为空
//        }
//        if (methodParameter.getParameterType().isInstance(ResultData.class)) { // 返回值类型符合规范
//            return body;
//        }
//        return ResultData.success(body);
//    }
}
