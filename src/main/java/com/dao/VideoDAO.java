package main.java.com.dao;

import java.util.List;
import main.java.com.model.Video;
/**
 * Defines DAO operations for the video upload model.
 *
 */
public interface VideoDAO {
	/*long save(Video video);
    Video get(long id);
    List<Video> list();
    void update(long id, Video video);
    void delete(long id);*/
    public List<Video> list();
    public void save (Video video);
    public void update (String video, int[] emotionList);
    public Video get(String videoLink);
    public void updateComments (String video, String comments);
}