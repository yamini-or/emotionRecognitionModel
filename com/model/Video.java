package main.java.com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "EMT_Video")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String emotionCount;


    public Video() {

    }

    public Video(String title, String emotionCount) {
        this.title=title;
        this.emotionCount=emotionCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmotionCount() {
        return emotionCount;
    }

    public void setEmotionCount(String emotionCount) {
        this.emotionCount = emotionCount;
    }

}