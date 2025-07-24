package controller;

import entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @RequestMapping("/boardForm")
    public String boardForm(){
        return "boardForm";
    }
    @RequestMapping("/boardWrite")
    public String boardWrite(Board board){ // new Board()
        boardMapper.save(board);
          // 다시 리스트페이지
        return "redirect:/boardList";
    }
    @RequestMapping("/boardDelete")
    public String boardDelete(@RequestParam("num") int num){ // ?num=3
        boardMapper.deleteById(num);
        return "redirect:/boardList";
    }
    @RequestMapping("/boardDetail/{num}")
    public String boardDetail(@PathVariable int num, Model model){
        Board board=boardMapper.findById(num);
        // 객체바인딩
        model.addAttribute("board", board);
        return "boardDetail";  // ${board.num} ~~~~
    }
    @RequestMapping("/boardDelete/{num}")
    public String boardDeleteById(@PathVariable int num){
        boardMapper.deleteById(num);
        return "redirect:/boardList";
    }
    @RequestMapping("/boardUpdateForm/{num}")
    public String boardUpdateForm(@PathVariable int num, Model model){
        Board board=boardMapper.findById(num);
        model.addAttribute("board", board);
        return "boardUpdate"; // boardUpdate.jsp
    }
    @RequestMapping("/boardUpdate")
    public String boardUpdate(Board board){ //num, title, writer
        boardMapper.updateById(board);
        return "redirect:/boardList";
    }
}
