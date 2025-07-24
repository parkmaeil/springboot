package controller;

import entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import repository.BoardMapper;

import java.util.List;

// POJO(Controller)
@Controller
public class BoardController { // new BoardController()

    @Autowired // DI(의존성주입)
    private BoardMapper boardMapper;
    // 게시판 전체 리스트 가져오기(/boardList)
    @RequestMapping("/boardList")
    public String boardList(Model model){
        List<Board> bList=boardMapper.findAll();
        // 객체바인딩
        model.addAttribute("bList", bList);
        return "boardList"; // /WEB-INF/views/boardList.jsp
    }
}
