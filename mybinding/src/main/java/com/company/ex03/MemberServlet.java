package com.company.ex03;

import java.io.IOException; 
import java.io.PrintWriter; 
import java.util.List;

import jakarta.servlet.RequestDispatcher; 
import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * package com.company.ex03;
 * 
 * import java.io.IOException; 
 * import java.io.PrintWriter; import
 * java.util.List;
 * 
 * import jakarta.servlet.RequestDispatcher; import
 * jakarta.servlet.ServletException; import
 * jakarta.servlet.annotation.WebServlet; import
 * jakarta.servlet.http.HttpServlet; import
 * jakarta.servlet.http.HttpServletRequest; import
 * jakarta.servlet.http.HttpServletResponse;
 * 
 * 
 * @WebServlet ("/member3") public class MemberServlet extends HttpServlet {
 * private static final long serialVersionUID = 1L;
 * 
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { doHandle(request, response);
 * }
 * 
 * protected void doPost(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { doHandle(request, response);
 * }
 * 
 * 
 * 
 * protected void doHandle(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException {
 * request.setCharacterEncoding("utf-8");
 * response.setContentType("text/html;charset=utf-8"); PrintWriter out =
 * response.getWriter(); MemberDAO dao = new MemberDAO(); List membersList =
 * dao.listMembers(); request.setAttribute("membersList", membersList);
 * RequestDispatcher dispatch = request.getRequestDispatcher("viewMembers");
 * dispatch.forward(request, response);
 * 
 * 
 * }
 * 
 * }
 */



@WebServlet("/member3")
public class MemberServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String command = request.getParameter("command");

        // MemberDAO 객체 생성
        MemberDAO dao = new MemberDAO();

        // 'addMember' 커맨드 처리 (회원 추가)
        if (command != null && command.equals("addMember")) {
            // 폼에서 전달된 값 가져오기
            String _id = request.getParameter("id");
            String _pwd = request.getParameter("pwd");
            String _name = request.getParameter("name");
            String _email = request.getParameter("email");

            // MemberVO 객체 생성 및 값 세팅
            MemberVO vo = new MemberVO();
            vo.setId(_id);
            vo.setPwd(_pwd);
            vo.setName(_name);
            vo.setEmail(_email);

            // MemberDAO의 addMember 메서드 호출
            dao.addMember(vo);

            // 회원 추가 후 다시 목록을 보여주기
            List<MemberVO> membersList = dao.listMembers();
            request.setAttribute("membersList", membersList);
            RequestDispatcher dispatch = request.getRequestDispatcher("viewMembers");
            dispatch.forward(request, response);
        } 
        // 'delMember' 커맨드 처리 (회원 삭제)
        else if (command != null && command.equals("delMember")) {
            String id = request.getParameter("id");
            dao.delMember(id);

            // 삭제 후 다시 목록을 보여주기
            List<MemberVO> membersList = dao.listMembers();
            request.setAttribute("membersList", membersList);
            RequestDispatcher dispatch = request.getRequestDispatcher("viewMembers");
            dispatch.forward(request, response);
        }
        // 기타 경우: 기본적으로 회원 목록을 보여줌
        else {
            List<MemberVO> membersList = dao.listMembers();
            request.setAttribute("membersList", membersList);
            RequestDispatcher dispatch = request.getRequestDispatcher("viewMembers");
            dispatch.forward(request, response);
        }
    }
}

