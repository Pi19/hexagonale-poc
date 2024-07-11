package com.archi.hexagonale.other.configuration;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class FilterConfig implements Filter {

    private final String REQUEST_ID = "x-request-id";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        MDC.put(REQUEST_ID, httpRequest.getHeader(REQUEST_ID));
        chain.doFilter(request, response);
    }
}
