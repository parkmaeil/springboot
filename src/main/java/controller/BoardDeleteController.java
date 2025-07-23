package controller;

import repository.BoardDAOMyBatis;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/boardDelete")
public class BoardDeleteController implements Controller {

    public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
                                         throws ServletException, IOException {
        //?num=10
        int num = Integer.parseInt(req.getParameter("num")); // "10"->10
        BoardDAOMyBatis dao=new BoardDAOMyBatis();
        dao.deleteById(num);
        // 삭제후에는 리스트보기
        // redirect 기숳
        //resp.sendRedirect("/b01/boardList");
        return "redirect:/boardList.do";
    }
}
