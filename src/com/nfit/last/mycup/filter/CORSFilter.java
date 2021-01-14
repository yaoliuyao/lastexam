package com.nfit.last.mycup.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class CORSFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletResponse;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        resp.setHeader("Access-Control-Allow-Origin", "*"); // 允许某个域名的网站跨域
        //resp.setHeader("Access-Control-Allow-Credentials", "true");             // 允许发送 cookie

        if (req.getMethod().equals("Options")) {
            resp.setHeader("Access-Control-Allow-Methods", "*");
            resp.setHeader("Access-Control-Allow-Headers", "*");
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
