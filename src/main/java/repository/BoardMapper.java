package repository;

import entity.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper { // new BoardMapper()
    public List<Board> findAll();
    public void save(Board board);
    public void deleteById(int num);
    public Board findById(int num);
    public void updateById(Board board);
}
/*
   public class SqlSessionFactoryBean implements BoardMapper{
      public List<Board> findAll(){

      }
   }

 */