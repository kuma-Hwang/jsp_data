package com.company.ex06;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("*.do") 	// 확장자만 일치하는 패턴
/*@WebServlet("/*")*/  // 모든 요청 url 패턴
public class TestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String context = request.getContextPath();
		String url = request.getRequestURL().toString(); 
		String mapping = request.getServletPath();
		String uri = request.getRequestURI(); //uri는 꼬랑지까지 다 가져오는것
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Test Servlet3</title>");
		out.println("</head>");
		out.println("<body bgcolor= 'tan'>");
		out.println("<b>TestServlet3입니다.</b><br>");
		out.println("<b>컨텍스트 이름 :"+ context +"</b><br>");
		out.println("<b>전체 경로:"+ url +"</b><br>");
		out.println("<b>매핑 이름:"+ mapping +"</b><br>");
		out.println("<b>URI :"+ uri +"</b>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
