
 package com.company.ex01;
  
  import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
  
  @WebFilter("/*") public class EncoderFilter extends HttpFilter implements
  Filter {
  
  
  public void destroy() {
  
  }
  
  
  public void doFilter(ServletRequest request, ServletResponse response,
  FilterChain chain) throws IOException, ServletException {
  
  chain.doFilter(request, response); }
  
  
  public void init(FilterConfig fConfig) throws ServletException {
  
  }
  
 }
 