package ivc.uty.model.bean;

import ivc.uty.model.entities.SprUsers;
import ivc.uty.model.entities.Surfing;
import ivc.uty.model.entities.Stations;
import ivc.uty.model.entities.Tbl5065;

import javax.ejb.Local;
import java.util.List;

@Local
public interface MyBeanInterface {
    List<Tbl5065> findLast24HDatas(int idSt);

    void save(Tbl5065 tbl5065);

    List<Stations> findAllStations();

    Stations findStationById(int id);

    SprUsers findUserByLoginPass(String login, String pass);

    SprUsers findUserByLogin(String login);

    void save(Surfing surfing);

}
