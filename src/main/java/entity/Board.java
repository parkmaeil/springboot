package entity;

import java.util.Date;

public class Board {
    private int num;
    private String title;
    private String writer;
    private Date date;
    private int count;
    public Board() {   }

    public Board(int num, String title, String writer, Date date, int count) {
        this.num = num;
        this.title = title;
        this.writer = writer;
        this.date = date;
        this.count = count;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Board{" +
                "num=" + num +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", date=" + date +
                ", count=" + count +
                '}';
    }
}
