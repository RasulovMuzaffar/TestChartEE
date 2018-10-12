package ivc.uty.model.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "spr_users")
@XmlRootElement
public class SprUsers implements Serializable {
    private int id;
    private String login;
    private String password;

    private Set<Surfing> surfingSet = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public Set<Surfing> getSurfingSet() {
        return surfingSet;
    }

    public void setSurfingSet(Set<Surfing> surfingSet) {
        this.surfingSet = surfingSet;
    }

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

    @Column(name = "login")
    @XmlElement
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "password")
    @XmlElement
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SprUsers sprUsers = (SprUsers) o;
        return id == sprUsers.id &&
                Objects.equals(login, sprUsers.login) &&
                Objects.equals(password, sprUsers.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password);
    }
}
