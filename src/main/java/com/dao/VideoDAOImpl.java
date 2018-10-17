package main.java.com.dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.com.model.Video;


/**
 * An implementation of the VideoDAO interface.
 *
 */

@Repository("videoDao")
public class VideoDAOImpl implements VideoDAO{

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public long save(Video video) {
      sessionFactory.getCurrentSession().save(video);
      return video.getId();
   }

   @Override
   public Video get(long id) {
      return sessionFactory.getCurrentSession().get(Video.class, id);
   }

   @Override
   public List<Video> list() {
      Session session = sessionFactory.getCurrentSession();
      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaQuery<Video> cq = cb.createQuery(Video.class);
      Root<Video> root = cq.from(Video.class);
      cq.select(root);
      Query<Video> query = session.createQuery(cq);
      return query.getResultList();
   }

   @Override
   public void update(long id, Video video) {
      Session session = sessionFactory.getCurrentSession();
      Video video2 = session.byId(Video.class).load(id);
      video2.setTitle(video.getTitle());
      video2.setEmotionCount(video.getEmotionCount());
      session.flush();
   }

   @Override
   public void delete(long id) {
      Session session = sessionFactory.getCurrentSession();
      Video video = session.byId(Video.class).load(id);
      session.delete(video);
   }


}

