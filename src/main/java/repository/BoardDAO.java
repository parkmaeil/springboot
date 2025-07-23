package repository;

import entity.Board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// JDBC Programming -> MyBatis Framework
/*
 1. 생산성이 떨어진다.(시간이 오래걸린다)
 2. 유지보수가 어렵다.(Java+SQL)
 */
public class BoardDAO {
    private Connection conn;
    //private Statement st; // ? , ? , ?
    private PreparedStatement ps;
    private ResultSet rs; // select SQL
    // 연결동작(접속URL, 아이디, 패스워드)
    public Connection getConnect(){
        String url="jdbc:mysql://localhost:3306/bootcamp";
        String username="root";
        String password="12345";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");// 동적드라이버로딩
            conn=DriverManager.getConnection(url, username, password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    // 게시물 전체 가져오기 동작
    public List<Board> findAll(){
        String SQL="select * from board order by num desc";
        conn=getConnect(); // 연결객체를 얻기
        List<Board> bList=new ArrayList<>();
        try{
           ps=conn.prepareStatement(SQL);
           rs=ps.executeQuery();
           while (rs.next()){
                 int num=rs.getInt("num");
                 String title=rs.getString("title");
                 String writer=rs.getString("writer");
                 Date date=rs.getDate("date");
                 int count=rs.getInt("count");
                 // 묶고(Board)->담고(List) -> 점심(오후)
                 Board board=new Board(num, title, writer, date, count);
                 bList.add(board);
           }
        }catch (Exception e){
            e.printStackTrace();
        }
        return bList;
    }
}
