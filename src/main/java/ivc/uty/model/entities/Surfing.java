package ivc.uty.model.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "surfing")
@XmlRootElement
public class Surfing implements Serializable {
    private int id;
    private Timestamp startTime;
    private SprUsers user;
    private String ip;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "starttime")
    @XmlElement
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    public SprUsers getUser() {
        return user;
    }

    public void setUser(SprUsers user) {
        this.user = user;
    }

    @Column(name = "ip")
    @XmlElement
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
