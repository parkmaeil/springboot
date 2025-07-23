package frontcontroller;

import controller.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// FrontController
@WebServlet("*.do")  // /boardList.do
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
                               throws ServletException, IOException {
         // 1. 클라이언트의 요청을 확인하기
         // /boardList--->BoardListController
         // /boardDelete-->BoardDeleteController
         String reqURI=req.getRequestURI(); // /b01/boardList
         String ctx=req.getContextPath(); // /b01
         String command=reqURI.substring(ctx.length());
         System.out.println(command);
         // 2.컨트롤러 분기 작업(HandlerMapping)
         HandlerMapping mapping=new HandlerMapping();
         Controller controller=mapping.getController(command);
         String viewName=controller.requestHandler(req, resp);
        // 3.뷰 페이지 분기 작업(viewName)
        // forward("boardList")
        if(viewName!=null) {
            if(!viewName.contains(":/")) {
                RequestDispatcher rd = req.getRequestDispatcher(ViewResolver.makeView(viewName));
                rd.forward(req, resp);
            }else {
                // redirect("redirect:/boardList.do")
                resp.sendRedirect(viewName.split(":/")[1]);// boardList.do
            }
        }
    }
}
