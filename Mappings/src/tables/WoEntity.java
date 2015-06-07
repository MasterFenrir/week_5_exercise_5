package tables;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Sander on 6-6-2015.
 */
@Entity
@Table(name = "wo", schema = "", catalog = "funda_h")
public class WoEntity {
    private Integer woid;
    private Integer mkmdwid;
    private String address;
    private String pc;
    private String city;
    private Float vraagprijs;
    private Integer vraagprijssoort;
    private Integer soortObject;
    private Integer soortWoning;
    private Integer typeWoning;
    private Integer soortBouw;
    private String omschrijving;
    private Integer bouwJaar;
    private Byte tuinAanwezig;
    private Float tuinOppervlakte;
    private Integer status;
    private Float woonOppervlakte;
    private Float inhoud;
    private Integer aantalKamers;
    private Integer aantalBadkamers;
    private Integer aantalWoonlagen;
    private Float perceelOppervlakte;
    private Date plaatsingDatum;

    @Id
    @Column(name = "WOID", nullable = false, insertable = true, updatable = true)
    public Integer getWoid() {
        return woid;
    }

    public void setWoid(Integer woid) {
        this.woid = woid;
    }

    @Basic
    @Column(name = "MKMDWID", nullable = true, insertable = true, updatable = true)
    public Integer getMkmdwid() {
        return mkmdwid;
    }

    public void setMkmdwid(Integer mkmdwid) {
        this.mkmdwid = mkmdwid;
    }

    @Basic
    @Column(name = "Address", nullable = true, insertable = true, updatable = true, length = 1000)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "PC", nullable = true, insertable = true, updatable = true, length = 7)
    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    @Basic
    @Column(name = "City", nullable = true, insertable = true, updatable = true, length = 50)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "Vraagprijs", nullable = true, insertable = true, updatable = true, precision = 0)
    public Float getVraagprijs() {
        return vraagprijs;
    }

    public void setVraagprijs(Float vraagprijs) {
        this.vraagprijs = vraagprijs;
    }

    @Basic
    @Column(name = "Vraagprijssoort", nullable = true, insertable = true, updatable = true)
    public Integer getVraagprijssoort() {
        return vraagprijssoort;
    }

    public void setVraagprijssoort(Integer vraagprijssoort) {
        this.vraagprijssoort = vraagprijssoort;
    }

    @Basic
    @Column(name = "SoortObject", nullable = true, insertable = true, updatable = true)
    public Integer getSoortObject() {
        return soortObject;
    }

    public void setSoortObject(Integer soortObject) {
        this.soortObject = soortObject;
    }

    @Basic
    @Column(name = "SoortWoning", nullable = true, insertable = true, updatable = true)
    public Integer getSoortWoning() {
        return soortWoning;
    }

    public void setSoortWoning(Integer soortWoning) {
        this.soortWoning = soortWoning;
    }

    @Basic
    @Column(name = "TypeWoning", nullable = true, insertable = true, updatable = true)
    public Integer getTypeWoning() {
        return typeWoning;
    }

    public void setTypeWoning(Integer typeWoning) {
        this.typeWoning = typeWoning;
    }

    @Basic
    @Column(name = "SoortBouw", nullable = true, insertable = true, updatable = true)
    public Integer getSoortBouw() {
        return soortBouw;
    }

    public void setSoortBouw(Integer soortBouw) {
        this.soortBouw = soortBouw;
    }

    @Basic
    @Column(name = "Omschrijving", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    @Basic
    @Column(name = "BouwJaar", nullable = true, insertable = true, updatable = true)
    public Integer getBouwJaar() {
        return bouwJaar;
    }

    public void setBouwJaar(Integer bouwJaar) {
        this.bouwJaar = bouwJaar;
    }

    @Basic
    @Column(name = "TuinAanwezig", nullable = true, insertable = true, updatable = true)
    public Byte getTuinAanwezig() {
        return tuinAanwezig;
    }

    public void setTuinAanwezig(Byte tuinAanwezig) {
        this.tuinAanwezig = tuinAanwezig;
    }

    @Basic
    @Column(name = "TuinOppervlakte", nullable = true, insertable = true, updatable = true, precision = 0)
    public Float getTuinOppervlakte() {
        return tuinOppervlakte;
    }

    public void setTuinOppervlakte(Float tuinOppervlakte) {
        this.tuinOppervlakte = tuinOppervlakte;
    }

    @Basic
    @Column(name = "Status", nullable = true, insertable = true, updatable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "WoonOppervlakte", nullable = true, insertable = true, updatable = true, precision = 0)
    public Float getWoonOppervlakte() {
        return woonOppervlakte;
    }

    public void setWoonOppervlakte(Float woonOppervlakte) {
        this.woonOppervlakte = woonOppervlakte;
    }

    @Basic
    @Column(name = "Inhoud", nullable = true, insertable = true, updatable = true, precision = 0)
    public Float getInhoud() {
        return inhoud;
    }

    public void setInhoud(Float inhoud) {
        this.inhoud = inhoud;
    }

    @Basic
    @Column(name = "AantalKamers", nullable = true, insertable = true, updatable = true)
    public Integer getAantalKamers() {
        return aantalKamers;
    }

    public void setAantalKamers(Integer aantalKamers) {
        this.aantalKamers = aantalKamers;
    }

    @Basic
    @Column(name = "AantalBadkamers", nullable = true, insertable = true, updatable = true)
    public Integer getAantalBadkamers() {
        return aantalBadkamers;
    }

    public void setAantalBadkamers(Integer aantalBadkamers) {
        this.aantalBadkamers = aantalBadkamers;
    }

    @Basic
    @Column(name = "AantalWoonlagen", nullable = true, insertable = true, updatable = true)
    public Integer getAantalWoonlagen() {
        return aantalWoonlagen;
    }

    public void setAantalWoonlagen(Integer aantalWoonlagen) {
        this.aantalWoonlagen = aantalWoonlagen;
    }

    @Basic
    @Column(name = "PerceelOppervlakte", nullable = true, insertable = true, updatable = true, precision = 0)
    public Float getPerceelOppervlakte() {
        return perceelOppervlakte;
    }

    public void setPerceelOppervlakte(Float perceelOppervlakte) {
        this.perceelOppervlakte = perceelOppervlakte;
    }

    @Basic
    @Column(name = "PlaatsingDatum", nullable = true, insertable = true, updatable = true)
    public Date getPlaatsingDatum() {
        return plaatsingDatum;
    }

    public void setPlaatsingDatum(Date plaatsingDatum) {
        this.plaatsingDatum = plaatsingDatum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WoEntity woEntity = (WoEntity) o;

        if (woid != null ? !woid.equals(woEntity.woid) : woEntity.woid != null) return false;
        if (mkmdwid != null ? !mkmdwid.equals(woEntity.mkmdwid) : woEntity.mkmdwid != null) return false;
        if (address != null ? !address.equals(woEntity.address) : woEntity.address != null) return false;
        if (pc != null ? !pc.equals(woEntity.pc) : woEntity.pc != null) return false;
        if (city != null ? !city.equals(woEntity.city) : woEntity.city != null) return false;
        if (vraagprijs != null ? !vraagprijs.equals(woEntity.vraagprijs) : woEntity.vraagprijs != null) return false;
        if (vraagprijssoort != null ? !vraagprijssoort.equals(woEntity.vraagprijssoort) : woEntity.vraagprijssoort != null)
            return false;
        if (soortObject != null ? !soortObject.equals(woEntity.soortObject) : woEntity.soortObject != null)
            return false;
        if (soortWoning != null ? !soortWoning.equals(woEntity.soortWoning) : woEntity.soortWoning != null)
            return false;
        if (typeWoning != null ? !typeWoning.equals(woEntity.typeWoning) : woEntity.typeWoning != null) return false;
        if (soortBouw != null ? !soortBouw.equals(woEntity.soortBouw) : woEntity.soortBouw != null) return false;
        if (omschrijving != null ? !omschrijving.equals(woEntity.omschrijving) : woEntity.omschrijving != null)
            return false;
        if (bouwJaar != null ? !bouwJaar.equals(woEntity.bouwJaar) : woEntity.bouwJaar != null) return false;
        if (tuinAanwezig != null ? !tuinAanwezig.equals(woEntity.tuinAanwezig) : woEntity.tuinAanwezig != null)
            return false;
        if (tuinOppervlakte != null ? !tuinOppervlakte.equals(woEntity.tuinOppervlakte) : woEntity.tuinOppervlakte != null)
            return false;
        if (status != null ? !status.equals(woEntity.status) : woEntity.status != null) return false;
        if (woonOppervlakte != null ? !woonOppervlakte.equals(woEntity.woonOppervlakte) : woEntity.woonOppervlakte != null)
            return false;
        if (inhoud != null ? !inhoud.equals(woEntity.inhoud) : woEntity.inhoud != null) return false;
        if (aantalKamers != null ? !aantalKamers.equals(woEntity.aantalKamers) : woEntity.aantalKamers != null)
            return false;
        if (aantalBadkamers != null ? !aantalBadkamers.equals(woEntity.aantalBadkamers) : woEntity.aantalBadkamers != null)
            return false;
        if (aantalWoonlagen != null ? !aantalWoonlagen.equals(woEntity.aantalWoonlagen) : woEntity.aantalWoonlagen != null)
            return false;
        if (perceelOppervlakte != null ? !perceelOppervlakte.equals(woEntity.perceelOppervlakte) : woEntity.perceelOppervlakte != null)
            return false;
        return !(plaatsingDatum != null ? !plaatsingDatum.equals(woEntity.plaatsingDatum) : woEntity.plaatsingDatum != null);

    }

    @Override
    public int hashCode() {
        int result = woid != null ? woid.hashCode() : 0;
        result = 31 * result + (mkmdwid != null ? mkmdwid.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (pc != null ? pc.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (vraagprijs != null ? vraagprijs.hashCode() : 0);
        result = 31 * result + (vraagprijssoort != null ? vraagprijssoort.hashCode() : 0);
        result = 31 * result + (soortObject != null ? soortObject.hashCode() : 0);
        result = 31 * result + (soortWoning != null ? soortWoning.hashCode() : 0);
        result = 31 * result + (typeWoning != null ? typeWoning.hashCode() : 0);
        result = 31 * result + (soortBouw != null ? soortBouw.hashCode() : 0);
        result = 31 * result + (omschrijving != null ? omschrijving.hashCode() : 0);
        result = 31 * result + (bouwJaar != null ? bouwJaar.hashCode() : 0);
        result = 31 * result + (tuinAanwezig != null ? tuinAanwezig.hashCode() : 0);
        result = 31 * result + (tuinOppervlakte != null ? tuinOppervlakte.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (woonOppervlakte != null ? woonOppervlakte.hashCode() : 0);
        result = 31 * result + (inhoud != null ? inhoud.hashCode() : 0);
        result = 31 * result + (aantalKamers != null ? aantalKamers.hashCode() : 0);
        result = 31 * result + (aantalBadkamers != null ? aantalBadkamers.hashCode() : 0);
        result = 31 * result + (aantalWoonlagen != null ? aantalWoonlagen.hashCode() : 0);
        result = 31 * result + (perceelOppervlakte != null ? perceelOppervlakte.hashCode() : 0);
        result = 31 * result + (plaatsingDatum != null ? plaatsingDatum.hashCode() : 0);
        return result;
    }
}
