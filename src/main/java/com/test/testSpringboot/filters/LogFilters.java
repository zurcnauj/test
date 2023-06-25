package com.test.testSpringboot.filters;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
@Component
public class LogFilters implements Filter{


    @Override
    public void doFilter(
        ServletRequest servletRequest,
        ServletResponse servletResponse,
        FilterChain filterChain
    ) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        long timeInit = System.currentTimeMillis();
        this.getIdx(request,response);

        this.logRequest(request);
        filterChain.doFilter(request, response);
        this.logResponse(request, response, timeInit);
    }

    private void logRequest(HttpServletRequest request){
        log.info("Init [{} {}] ", request.getMethod(),request.getRequestURI());
        log.info("params:{}", request.getParameterMap());

    }

    private void logResponse(HttpServletRequest request, HttpServletResponse response, long timeInit){

        long totalTime = System.currentTimeMillis() - timeInit;
        log.info("finish  [{} {}] status:[{}] in {} ms",
            request.getMethod(),
            request.getRequestURI(),
            response.getStatus(),
            totalTime
        );
    }

    private void getIdx(HttpServletRequest request, HttpServletResponse response){
        String idTrx = request.getHeader("id_trx");
        if( idTrx == null) idTrx = Long.toString(System.nanoTime());
        MDC.put("id_trx", idTrx);
        response.setHeader("id_trx",idTrx);
    }
}
