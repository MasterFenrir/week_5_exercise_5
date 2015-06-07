package tables;

import javax.persistence.*;

/**
 * Created by Sander on 6-6-2015.
 */
@Entity
@Table(name = "mkantoormdw", schema = "", catalog = "funda_h")
public class MkantoormdwEntity {
    private Integer mkmdwid;
    private Integer mkid;
    private String name;
    private Integer accountNr;

    @Id
    @Column(name = "MKMDWID", nullable = false, insertable = true, updatable = true)
    public Integer getMkmdwid() {
        return mkmdwid;
    }

    public void setMkmdwid(Integer mkmdwid) {
        this.mkmdwid = mkmdwid;
    }

    @Basic
    @Column(name = "MKID", nullable = true, insertable = true, updatable = true)
    public Integer getMkid() {
        return mkid;
    }

    public void setMkid(Integer mkid) {
        this.mkid = mkid;
    }

    @Basic
    @Column(name = "Name", nullable = true, insertable = true, updatable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "ACCOUNT_NR", nullable = false, insertable = true, updatable = true)
    public Integer getAccountNr() {
        return accountNr;
    }

    public void setAccountNr(Integer accountNr) {
        this.accountNr = accountNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MkantoormdwEntity that = (MkantoormdwEntity) o;

        if (mkmdwid != null ? !mkmdwid.equals(that.mkmdwid) : that.mkmdwid != null) return false;
        if (mkid != null ? !mkid.equals(that.mkid) : that.mkid != null) return false;
        return !(name != null ? !name.equals(that.name) : that.name != null);

    }

    @Override
    public int hashCode() {
        int result = mkmdwid != null ? mkmdwid.hashCode() : 0;
        result = 31 * result + (mkid != null ? mkid.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
