package controller;

import entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import repository.BoardMapper;

import java.util.List;

@RestController // view페이지가 없고 JSON형식으로 응답하는 역할
public class BoardRestController {

    @Autowired
    private BoardMapper boardMapper;
    // JSON 응답(@ResponseBody)
    // http://localhost:8081/sb/android
    @RequestMapping("/android")
    //@ResponseBody // List<Board>-->[{    },{    },{    }]
    public List<Board> androidList(){
        List<Board> bList=boardMapper.findAll();
        return bList;
    }
}
