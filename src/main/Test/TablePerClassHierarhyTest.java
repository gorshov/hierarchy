import Connection.HibernateUtil;
import entity.Film;
import entity.Genre;
import entity.Review;
import entity.Star;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.time.LocalDate;

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
    public void saveOrUpdate() {
        try {
            log.info("start save or update");
            Session session = TablePerClassHierarhyTest.getSession();
            transaction = session.beginTransaction();
            Film film = new Film("Fight Club", Genre.ACTION, LocalDate.of(2017, 10, 24), "USA");
            session.saveOrUpdate(film);
            Review review = new Review("Beest Review", 10.0);
            session.saveOrUpdate(review);
            Star star = new Star("Bred", "Pit");
            session.saveOrUpdate(star);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
        }
    }

}
