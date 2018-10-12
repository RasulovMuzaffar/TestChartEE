package ivc.uty.model.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.*;

@Entity
@Table(name = "stations")
@XmlRootElement
public class Stations {

    private Integer id;
    private String name;
    private String sprname;

    private Set<Tbl5065> tbl5065Set = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "station")
    public Set<Tbl5065> getTbl5065Set() {
        return tbl5065Set;
    }

    public void setTbl5065Set(Set<Tbl5065> tbl5065Set) {
        this.tbl5065Set = tbl5065Set;
    }

    @Id
    @Column(name = "id", nullable = false)
    @XmlElement
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Column(name = "sprname")
    @XmlElement
    public String getSprname() {
        return sprname;
    }

    public void setSprname(String sprname) {
        this.sprname = sprname;
    }


//    public List<Tbl5065> getTbl5065List() {
//        return tbl5065List;
//    }
//
//    public void setTbl5065List(List<Tbl5065> tbl5065List) {
//        this.tbl5065List = tbl5065List;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stations stations = (Stations) o;
        return Objects.equals(id, stations.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
