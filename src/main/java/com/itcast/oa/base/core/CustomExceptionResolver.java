package com.itcast.oa.base.core;

import com.itcast.oa.base.exception.BaseRuntimeException;
import com.itcast.oa.base.util.JacksonUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by GanSX on 2017/3/18.
 */
public class CustomExceptionResolver extends SimpleMappingExceptionResolver {
    private static final Logger logger = LoggerFactory
            .getLogger(CustomExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ex.printStackTrace();
        BaseRuntimeException customException = null;

        //如果抛出的是系统自定义的异常则直接转换
        if(ex instanceof BaseRuntimeException) {
            customException = (BaseRuntimeException) ex;
        } else {
            //如果抛出的不是系统自定义的异常则重新构造一个未知错误异常
            //这里我就也有CustomException省事了，实际中应该要再定义一个新的异常
            customException = new BaseRuntimeException() {
                @Override
                public void addErrorMessage(String... params) {
                    msg="系统未知错误";
                }
            };
        }

        if(isAjaxRequest(request,handler)){
            return doResolveAjaxException(response,customException);
        }

        /** 使用spring mvc自带的异常处理 */
        // 设置异常信息到Message对象中
        customException.toMessage();
        return super.doResolveException(request, response, handler, customException);
    }

    /**
     * 判断是否是ajax请求
     *
     * @param request
     * @param handler
     * @return
     */
    private boolean isAjaxRequest(HttpServletRequest request, Object handler) {
        if (request.getHeader("accept").indexOf("application/json") > -1) {
            return true;
        }
        if (request.getHeader("X-Requested-With") == null) {
            return false;
        }
        if (request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1) {
            return true;
        }
        return false;
    }

    /**
     * ajax时，写出异常信息到response中
     * @param response
     * @param ex
     * @return
     */
    private ModelAndView doResolveAjaxException(HttpServletResponse response,
                                                BaseRuntimeException ex) {
        setResponse(response);
        try {
            PrintWriter writer = response.getWriter();
            String jsonStr = JacksonUtils.toJsonString(ex, ex.packProperties());
            if (StringUtils.isNotBlank("jsonStr")) {
                writer.write(jsonStr);
            }
            writer.flush();
        } catch (IOException e) {
            logger.error("处理ajax请求 返回异常信息失败:" + e);
        }
        return new ModelAndView();
    }

    /**
     * 设置response 编码及头信息
     * @param response
     */
    private void setResponse(HttpServletResponse response) {
        //response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
    }

}
