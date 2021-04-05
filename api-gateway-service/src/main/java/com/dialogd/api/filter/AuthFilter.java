package com.dialogd.api.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author: DJA
 * @Date: 2019/12/3
 */
@Component
public class AuthFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        //在这里写我们的具体处理逻辑--统一限流、鉴权

        //ServerWebExchange相当于当前请求和响应的上下文，通过它可以获取到request和response对象
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if (token == null || "".equals(token.trim())){
            //不通过
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            //不往下转发请求
            return exchange.getResponse().setComplete();
        }
        //如果合法，则转发请求
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        //指定优先级，值越小，优先级越高
        return 0;
    }
}
