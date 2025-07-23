package controller;
import entity.Board;
import repository.BoardDAOMyBatis;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
// Servlet -> POJO(순수 자바 객체)
//@WebServlet("/boardList") // web.xml(servlet-mapping)
public class BoardListController implements Controller{

    public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

       // BoardDAO dao=new BoardDAO(); //JDBC
        BoardDAOMyBatis dao=new BoardDAOMyBatis(); //MyBatis
        List<Board> bList=dao.findAll();
        // 객체바인딩
        req.setAttribute("bList", bList); // ${bList}

        return "boardList";
    }
}
