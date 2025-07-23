package repository;

import entity.Board;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

//  MyBatis Framework(mybatis.org) API - 설정(xml->java)
/*
  1. Java코드<-----Mapping------>SQL(XML)
  2. Connection Pool(?)
 */
public class BoardDAOMyBatis {
    private static SqlSessionFactory sqlSessionFactory;
    // 초기화 블럭
    static {
        try{
            String resource = "mybatis-config/dbconfig.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    // 게시물 전체 가져오기 동작
    public List<Board> findAll(){
        SqlSession session=sqlSessionFactory.openSession();
        List<Board> bList=session.selectList("findAll");
        //String SQL="select * from board order by num desc";
        session.close();// 반납(*)
        return bList;
    }
    // 게시판 데이터를 저정하는 메서드
    public void save(Board board){
        SqlSession session=sqlSessionFactory.openSession();
        session.insert("save", board);
        session.commit(); //SQL->완료
        session.close();
    }
    // num을 받아서 삭제하는 메서드
    public void deleteById(int num){
        SqlSession session=sqlSessionFactory.openSession();
        session.delete("deleteById", num);
        session.commit(); //SQL->완료
        session.close();
    }
}









