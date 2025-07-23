package controller;

import entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import repository.BoardMapper;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private BoardMapper boardMapper;

    @GetMapping("/boardList")
    public String index(Model model){
        List<Board> bList=boardMapper.findAll();
        model.addAttribute("bList", bList);
        return "boardList";
    }
}
