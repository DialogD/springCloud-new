package com.dialogd.api.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author: DJA
 * @Date: 2019/12/3
 */
@Component
@Slf4j
public class AuthFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        log.info("AuthFilter is running...");
        //1.获取请求上下文对象
        RequestContext requestContext = RequestContext.getCurrentContext();
        //2.根据上下文对象，获取响应对象
        HttpServletRequest request = requestContext.getRequest();
        //3.根据需求--必须包含认证信息token
        String token = request.getParameter("token");
        if (token == null || "".equals(token.trim())){
            //说明不存在令牌,不再往下调用
            requestContext.setSendZuulResponse(false);
            try {
                requestContext.getResponse().getWriter().write("validate request,token is null");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }
}
