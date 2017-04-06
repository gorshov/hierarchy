import Connection.HibernateUtil;
import entity.Film;
import entity.Genre;
import entity.Review;
import entity.Star;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by user on 05.04.2017.
 */
public class TablePerClassHierarhyTest {
    public static Transaction transaction = null;
    private static Logger log = Logger.getLogger(TablePerClassHierarhyTest.class);

    public static Session getSession() {
        Session session = HibernateUtil.getHibernateUtil().getSession();
        return session;
    }

    @Test
    public void saveOrUpdateTest() {
        try {
            log.info("start save or update");
            Session session = TablePerClassHierarhyTest.getSession();
            transaction = session.beginTransaction();
            Film film = new Film("Title");
            session.saveOrUpdate(film);
            Review review = new Review("Title1", "my review", 10.0);
            session.saveOrUpdate(review);
            Star star = new Star("Title2", "Bredd", "Pitt");
            session.saveOrUpdate(star);

            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
        }
    }

    @Test
    public void getTest() {
        try {
            Session session = TablePerClassHierarhyTest.getSession();
            transaction = session.beginTransaction();
            Film f = (Film) session.get(Film.class, 1l);
            Review r = (Review) session.get(Review.class, 2l);
            Star s = (Star) session.get(Star.class, 3l);
            transaction.commit();
            Assert.assertEquals("Title", f.getTitle());
            Assert.assertEquals("my review", r.getText());
            Assert.assertEquals("Bredd", s.getFirstName());
        } catch (HibernateException e) {
            transaction.rollback();
        }
    }

    @Test
    public void deleteTest() {
        try {
            Session session = TablePerClassHierarhyTest.getSession();
            transaction = session.beginTransaction();
            Film f = (Film) session.get(Film.class, 1l);
            session.delete(f);
            Review r = (Review) session.get(Review.class, 2l);
            session.delete(r);
            Star s = (Star) session.get(Star.class, 3l);
            session.delete(s);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
        }

    }

}
