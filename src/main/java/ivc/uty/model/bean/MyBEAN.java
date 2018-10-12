package ivc.uty.model.bean;

import ivc.uty.model.entities.SprUsers;
import ivc.uty.model.entities.Surfing;
import ivc.uty.model.entities.Stations;
import ivc.uty.model.entities.Tbl5065;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless(mappedName = "myBean", name = "myBean")
public class MyBEAN implements MyBeanInterface {
    @PersistenceContext(unitName = "myUnit")
    private EntityManager entityManager;

    public MyBEAN() {
    }

    public List<Tbl5065> findLast24HDatas(int idSt) {
        System.out.println("List<Tbl5065> findLast24HDatas IN");
        List<Tbl5065> list = new ArrayList<>();
        try {
            list = entityManager.createQuery("from Tbl5065 t where t.station.id = :idSt order by t.id desc", Tbl5065.class).setParameter("idSt", idSt)
                    .setFirstResult(0).setMaxResults(96).getResultList();
        } catch (Exception e) {
            Logger.getLogger(MyBEAN.class.getName()).log(Level.SEVERE, null, e);
        }
        System.out.println("List<Tbl5065> findLast24HDatas OUT");
        return list;
    }

    public void save(Tbl5065 tbl5065) {
        System.out.println("save(Tbl5065 tbl5065) IN");
        try {
            entityManager.persist(tbl5065);
        } catch (Exception e) {
            Logger.getLogger(MyBEAN.class.getName()).log(Level.SEVERE, null, e);
        }
        System.out.println("save(Tbl5065 tbl5065) OUT");
    }

    @Override
    public List<Stations> findAllStations() {
        System.out.println("List<Stations> findAllStations IN");
        List<Stations> list = new ArrayList<>();
        try {
            list = entityManager.createQuery("from Stations", Stations.class)
                    .setFirstResult(0).setMaxResults(96).getResultList();
        } catch (Exception e) {
            Logger.getLogger(MyBEAN.class.getName()).log(Level.SEVERE, null, e);
        }
        System.out.println("List<Stations> findAllStations OUT");
        return list;
    }

    @Override
    public Stations findStationById(int id) {
        System.out.println("Stations findStationById IN");
        Stations stations = null;
        try {
            stations = entityManager.find(Stations.class, id);
        } catch (Exception e) {
            Logger.getLogger(MyBEAN.class.getName()).log(Level.SEVERE, null, e);
        }
        System.out.println("Stations findStationById OUT");
        return stations;
    }

    @Override
    public SprUsers findUserByLoginPass(String login, String pass) {
        SprUsers user = null;
        try {
            user = entityManager.createQuery("from SprUsers s where s.login = :login and s.password = :pass", SprUsers.class)
                    .setParameter("login", login).setParameter("pass", pass).getSingleResult();
        } catch (Exception e) {
            Logger.getLogger(MyBEAN.class.getName()).log(Level.SEVERE, null, e);
        }
        return user;
    }

    @Override
    public SprUsers findUserByLogin(String login) {
        SprUsers user = null;
        try {
            user = entityManager.createQuery("from SprUsers s where s.login = :login", SprUsers.class)
                    .setParameter("login", login).getSingleResult();
        } catch (Exception e) {
            Logger.getLogger(MyBEAN.class.getName()).log(Level.SEVERE, null, e);
        }
        return user;
    }

    @Override
    public void save(Surfing surfing) {
        System.out.println("save(Surfing surfing) IN");
        try {
            entityManager.persist(surfing);
        } catch (Exception e) {
            Logger.getLogger(MyBEAN.class.getName()).log(Level.SEVERE, null, e);
        }
        System.out.println("save(Surfing surfing) OUT");
    }
}
