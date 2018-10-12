package ivc.uty.model.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tbl5065")
@XmlRootElement
public class Tbl5065 {

    private int id;
    private Integer gruty;
    private Integer grutykr;
    private Integer grutypl;
    private Integer grutypv;
    private Integer grutycs;
    private Integer grutypr;
    private Integer grutydr;
    private Integer poruty;
    private Integer porutykr;
    private Integer porutypl;
    private Integer porutypv;
    private Integer porutycs;
    private Integer porutypr;
    private Integer porutydr;
    private Integer summuty;
    private Integer grchuj;
    private Integer grchujkr;
    private Integer grchujpl;
    private Integer grchujpv;
    private Integer grchujcs;
    private Integer grchujpr;
    private Integer grchujdr;
    private Integer porchuj;
    private Integer porchujkr;
    private Integer porchujpl;
    private Integer porchujpv;
    private Integer porchujcs;
    private Integer porchujpr;
    private Integer porchujdr;
    private Integer summchuj;
    private Timestamp upddate;

    private Stations station;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_st")
    public Stations getStation() {
        return station;
    }

    public void setStation(Stations station) {
        this.station = station;
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

    @Basic
    @Column(name = "gruty", nullable = true)
    @XmlElement
    public Integer getGruty() {
        return gruty;
    }

    public void setGruty(Integer gruty) {
        this.gruty = gruty;
    }

    @Basic
    @Column(name = "poruty", nullable = true)
    @XmlElement
    public Integer getPoruty() {
        return poruty;
    }

    public void setPoruty(Integer poruty) {
        this.poruty = poruty;
    }

    @Basic
    @Column(name = "summuty", nullable = true)
    @XmlElement
    public Integer getSummuty() {
        return summuty;
    }

    public void setSummuty(Integer summuty) {
        this.summuty = summuty;
    }

    @Basic
    @Column(name = "grchuj", nullable = true)
    @XmlElement
    public Integer getGrchuj() {
        return grchuj;
    }

    public void setGrchuj(Integer grchuj) {
        this.grchuj = grchuj;
    }

    @Basic
    @Column(name = "porchuj", nullable = true)
    @XmlElement
    public Integer getPorchuj() {
        return porchuj;
    }

    public void setPorchuj(Integer porchuj) {
        this.porchuj = porchuj;
    }

    @Basic
    @Column(name = "summchuj", nullable = true)
    @XmlElement
    public Integer getSummchuj() {
        return summchuj;
    }

    public void setSummchuj(Integer summchuj) {
        this.summchuj = summchuj;
    }

    //    @Temporal(value = TemporalType.TIMESTAMP)
    @Basic
    @Column(name = "upddate", nullable = true)
    @XmlElement
    public Timestamp getUpddate() {
        return upddate;
    }

    public void setUpddate(Timestamp upddate) {
        this.upddate = upddate;
    }

    @Basic
    @Column(name = "grutykr", nullable = true)
    @XmlElement
    public Integer getGrutykr() {
        return grutykr;
    }

    public void setGrutykr(Integer grutykr) {
        this.grutykr = grutykr;
    }

    @Basic
    @Column(name = "grutypl", nullable = true)
    @XmlElement
    public Integer getGrutypl() {
        return grutypl;
    }

    public void setGrutypl(Integer grutypl) {
        this.grutypl = grutypl;
    }

    @Basic
    @Column(name = "grutypv", nullable = true)
    @XmlElement
    public Integer getGrutypv() {
        return grutypv;
    }

    public void setGrutypv(Integer grutypv) {
        this.grutypv = grutypv;
    }

    @Basic
    @Column(name = "grutycs", nullable = true)
    @XmlElement
    public Integer getGrutycs() {
        return grutycs;
    }

    public void setGrutycs(Integer grutycs) {
        this.grutycs = grutycs;
    }

    @Basic
    @Column(name = "grutypr", nullable = true)
    @XmlElement
    public Integer getGrutypr() {
        return grutypr;
    }

    public void setGrutypr(Integer grutypr) {
        this.grutypr = grutypr;
    }

    @Basic
    @Column(name = "grutydr", nullable = true)
    @XmlElement
    public Integer getGrutydr() {
        return grutydr;
    }

    public void setGrutydr(Integer grutydr) {
        this.grutydr = grutydr;
    }

    @Basic
    @Column(name = "porutykr", nullable = true)
    @XmlElement
    public Integer getPorutykr() {
        return porutykr;
    }

    public void setPorutykr(Integer porutykr) {
        this.porutykr = porutykr;
    }

    @Basic
    @Column(name = "porutypl", nullable = true)
    @XmlElement
    public Integer getPorutypl() {
        return porutypl;
    }

    public void setPorutypl(Integer porutypl) {
        this.porutypl = porutypl;
    }

    @Basic
    @Column(name = "porutypv", nullable = true)
    @XmlElement
    public Integer getPorutypv() {
        return porutypv;
    }

    public void setPorutypv(Integer porutypv) {
        this.porutypv = porutypv;
    }

    @Basic
    @Column(name = "porutycs", nullable = true)
    @XmlElement
    public Integer getPorutycs() {
        return porutycs;
    }

    public void setPorutycs(Integer porutycs) {
        this.porutycs = porutycs;
    }

    @Basic
    @Column(name = "porutypr", nullable = true)
    @XmlElement
    public Integer getPorutypr() {
        return porutypr;
    }

    public void setPorutypr(Integer porutypr) {
        this.porutypr = porutypr;
    }

    @Basic
    @Column(name = "porutydr", nullable = true)
    @XmlElement
    public Integer getPorutydr() {
        return porutydr;
    }

    public void setPorutydr(Integer porutydr) {
        this.porutydr = porutydr;
    }

    @Basic
    @Column(name = "grchujkr", nullable = true)
    @XmlElement
    public Integer getGrchujkr() {
        return grchujkr;
    }

    public void setGrchujkr(Integer grchujkr) {
        this.grchujkr = grchujkr;
    }

    @Basic
    @Column(name = "grchujpl", nullable = true)
    @XmlElement
    public Integer getGrchujpl() {
        return grchujpl;
    }

    public void setGrchujpl(Integer grchujpl) {
        this.grchujpl = grchujpl;
    }

    @Basic
    @Column(name = "grchujpv", nullable = true)
    @XmlElement
    public Integer getGrchujpv() {
        return grchujpv;
    }

    public void setGrchujpv(Integer grchujpv) {
        this.grchujpv = grchujpv;
    }

    @Basic
    @Column(name = "grchujcs", nullable = true)
    @XmlElement
    public Integer getGrchujcs() {
        return grchujcs;
    }

    public void setGrchujcs(Integer grchujcs) {
        this.grchujcs = grchujcs;
    }

    @Basic
    @Column(name = "grchujpr", nullable = true)
    @XmlElement
    public Integer getGrchujpr() {
        return grchujpr;
    }

    public void setGrchujpr(Integer grchujpr) {
        this.grchujpr = grchujpr;
    }

    @Basic
    @Column(name = "grchujdr", nullable = true)
    @XmlElement
    public Integer getGrchujdr() {
        return grchujdr;
    }

    public void setGrchujdr(Integer grchujdr) {
        this.grchujdr = grchujdr;
    }

    @Basic
    @Column(name = "porchujkr", nullable = true)
    @XmlElement
    public Integer getPorchujkr() {
        return porchujkr;
    }

    public void setPorchujkr(Integer porchujkr) {
        this.porchujkr = porchujkr;
    }

    @Basic
    @Column(name = "porchujpl", nullable = true)
    @XmlElement
    public Integer getPorchujpl() {
        return porchujpl;
    }

    public void setPorchujpl(Integer porchujpl) {
        this.porchujpl = porchujpl;
    }

    @Basic
    @Column(name = "porchujpv", nullable = true)
    @XmlElement
    public Integer getPorchujpv() {
        return porchujpv;
    }

    public void setPorchujpv(Integer porchujpv) {
        this.porchujpv = porchujpv;
    }

    @Basic
    @Column(name = "porchujcs", nullable = true)
    @XmlElement
    public Integer getPorchujcs() {
        return porchujcs;
    }

    public void setPorchujcs(Integer porchujcs) {
        this.porchujcs = porchujcs;
    }

    @Basic
    @Column(name = "porchujpr", nullable = true)
    @XmlElement
    public Integer getPorchujpr() {
        return porchujpr;
    }

    public void setPorchujpr(Integer porchujpr) {
        this.porchujpr = porchujpr;
    }

    @Basic
    @Column(name = "porchujdr", nullable = true)
    @XmlElement
    public Integer getPorchujdr() {
        return porchujdr;
    }

    public void setPorchujdr(Integer porchujdr) {
        this.porchujdr = porchujdr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tbl5065 tbl5065 = (Tbl5065) o;
        return id == tbl5065.id &&
                Objects.equals(gruty, tbl5065.gruty) &&
                Objects.equals(grutykr, tbl5065.grutykr) &&
                Objects.equals(grutypl, tbl5065.grutypl) &&
                Objects.equals(grutypv, tbl5065.grutypv) &&
                Objects.equals(grutycs, tbl5065.grutycs) &&
                Objects.equals(grutypr, tbl5065.grutypr) &&
                Objects.equals(grutydr, tbl5065.grutydr) &&
                Objects.equals(poruty, tbl5065.poruty) &&
                Objects.equals(porutykr, tbl5065.porutykr) &&
                Objects.equals(porutypl, tbl5065.porutypl) &&
                Objects.equals(porutypv, tbl5065.porutypv) &&
                Objects.equals(porutycs, tbl5065.porutycs) &&
                Objects.equals(porutypr, tbl5065.porutypr) &&
                Objects.equals(porutydr, tbl5065.porutydr) &&
                Objects.equals(summuty, tbl5065.summuty) &&
                Objects.equals(grchuj, tbl5065.grchuj) &&
                Objects.equals(grchujkr, tbl5065.grchujkr) &&
                Objects.equals(grchujpl, tbl5065.grchujpl) &&
                Objects.equals(grchujpv, tbl5065.grchujpv) &&
                Objects.equals(grchujcs, tbl5065.grchujcs) &&
                Objects.equals(grchujpr, tbl5065.grchujpr) &&
                Objects.equals(grchujdr, tbl5065.grchujdr) &&
                Objects.equals(porchuj, tbl5065.porchuj) &&
                Objects.equals(porchujkr, tbl5065.porchujkr) &&
                Objects.equals(porchujpl, tbl5065.porchujpl) &&
                Objects.equals(porchujpv, tbl5065.porchujpv) &&
                Objects.equals(porchujcs, tbl5065.porchujcs) &&
                Objects.equals(porchujpr, tbl5065.porchujpr) &&
                Objects.equals(porchujdr, tbl5065.porchujdr) &&
                Objects.equals(summchuj, tbl5065.summchuj) &&
                Objects.equals(upddate, tbl5065.upddate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gruty, grutykr, grutypl, grutypv, grutycs, grutypr, grutydr, poruty, porutykr, porutypl, porutypv, porutycs, porutypr, porutydr, summuty, grchuj, grchujkr, grchujpl, grchujpv, grchujcs, grchujpr, grchujdr, porchuj, porchujkr, porchujpl, porchujpv, porchujcs, porchujpr, porchujdr, summchuj, upddate);
    }

    @Override
    public String toString() {
        return "Tbl5065{" +
                "id=" + id +
                ", gruty=" + gruty +
                ", grutykr=" + grutykr +
                ", grutypl=" + grutypl +
                ", grutypv=" + grutypv +
                ", grutycs=" + grutycs +
                ", grutypr=" + grutypr +
                ", grutydr=" + grutydr +
                ", poruty=" + poruty +
                ", porutykr=" + porutykr +
                ", porutypl=" + porutypl +
                ", porutypv=" + porutypv +
                ", porutycs=" + porutycs +
                ", porutypr=" + porutypr +
                ", porutydr=" + porutydr +
                ", summuty=" + summuty +
                ", grchuj=" + grchuj +
                ", grchujkr=" + grchujkr +
                ", grchujpl=" + grchujpl +
                ", grchujpv=" + grchujpv +
                ", grchujcs=" + grchujcs +
                ", grchujpr=" + grchujpr +
                ", grchujdr=" + grchujdr +
                ", porchuj=" + porchuj +
                ", porchujkr=" + porchujkr +
                ", porchujpl=" + porchujpl +
                ", porchujpv=" + porchujpv +
                ", porchujcs=" + porchujcs +
                ", porchujpr=" + porchujpr +
                ", porchujdr=" + porchujdr +
                ", summchuj=" + summchuj +
                ", upddate=" + upddate +
                '}';
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Tbl5065 tbl5065 = (Tbl5065) o;
//
//        if (id != tbl5065.id) return false;
//        if (gruty != null ? !gruty.equals(tbl5065.gruty) : tbl5065.gruty != null) return false;
//        if (poruty != null ? !poruty.equals(tbl5065.poruty) : tbl5065.poruty != null) return false;
//        if (summuty != null ? !summuty.equals(tbl5065.summuty) : tbl5065.summuty != null) return false;
//        if (grchuj != null ? !grchuj.equals(tbl5065.grchuj) : tbl5065.grchuj != null) return false;
//        if (porchuj != null ? !porchuj.equals(tbl5065.porchuj) : tbl5065.porchuj != null) return false;
//        if (summchuj != null ? !summchuj.equals(tbl5065.summchuj) : tbl5065.summchuj != null) return false;
//        if (upddate != null ? !upddate.equals(tbl5065.upddate) : tbl5065.upddate != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (gruty != null ? gruty.hashCode() : 0);
//        result = 31 * result + (poruty != null ? poruty.hashCode() : 0);
//        result = 31 * result + (summuty != null ? summuty.hashCode() : 0);
//        result = 31 * result + (grchuj != null ? grchuj.hashCode() : 0);
//        result = 31 * result + (porchuj != null ? porchuj.hashCode() : 0);
//        result = 31 * result + (summchuj != null ? summchuj.hashCode() : 0);
//        result = 31 * result + (upddate != null ? upddate.hashCode() : 0);
//        return result;
//    }


}