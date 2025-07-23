package frontcontroller;

import controller.*;

import java.util.HashMap;

public class HandlerMapping {
    // Key(path)->Value(POJO)
    private HashMap<String, Controller> mappings;
    public HandlerMapping(){
        mappings=new HashMap<>();
        mappings.put("/boardList.do", new BoardListController());
        mappings.put("/boardForm.do", new BoardFormController());
        mappings.put("/boardWrite.do", new BoardWriteController());
        mappings.put("/boardDelete.do", new BoardDeleteController());
    }
    public Controller getController(String key){
        return mappings.get(key);
    }
}
