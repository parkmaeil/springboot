package repository;

import entity.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    public List<Board> findAll();
    public void save(Board board);
    public void deleteById(int num);
}
