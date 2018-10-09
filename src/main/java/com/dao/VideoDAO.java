package main.java.com.mykong.dao;

import java.util.List;
import main.java.com.mykong.model.Video;
/**
 * Defines DAO operations for the video upload model.
 *
 */
public interface VideoDAO {
	long save(Video video);
    Video get(long id);
    List<Video> list();
    void update(long id, Video video);
    void delete(long id);
}