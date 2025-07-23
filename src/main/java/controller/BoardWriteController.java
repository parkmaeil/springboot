package controller;

import entity.Board;
import repository.BoardDAOMyBatis;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/boardWrite")
public class BoardWriteController implements Controller {
                            // title=XXX, writer=XXX
    public String requestHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 클라이언트 폼에서 넘어온 파라메서를 받기
        req.setCharacterEncoding("utf-8");
        String title=req.getParameter("title");
        String writer=req.getParameter("writer");
        // 묶기(DTO : Board)
        Board board=new Board(); // 파라메서수집
        board.setTitle(title);
        board.setWriter(writer);
        // DAO
        BoardDAOMyBatis dao=new BoardDAOMyBatis();
        dao.save(board); // insert or update
        // 글쓰기 후에는 어디로 가야되나? -> 리스트보기(/boardList)
        // redirect 기술
        // resp.sendRedirect("/b01/boardList");
        return "redirect:/boardList.do";
    }
}
