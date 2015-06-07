package tables;

import javax.persistence.*;

/**
 * Created by Sander on 6-6-2015.
 */
@Entity
@Table(name = "administrators", schema = "", catalog = "funda_h")
public class AdministratorsEntity {
    private Integer adminNr;
    private String name;
    private Integer accountNr;

    @Id
    @Column(name = "ADMIN_NR", nullable = false, insertable = true, updatable = true)
    public Integer getAdminNr() {
        return adminNr;
    }

    public void setAdminNr(Integer adminNr) {
        this.adminNr = adminNr;
    }

    @Basic
    @Column(name = "NAME", nullable = false, insertable = true, updatable = true, length = 100)
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

        AdministratorsEntity that = (AdministratorsEntity) o;

        if (adminNr != null ? !adminNr.equals(that.adminNr) : that.adminNr != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return !(accountNr != null ? !accountNr.equals(that.accountNr) : that.accountNr != null);

    }

    @Override
    public int hashCode() {
        int result = adminNr != null ? adminNr.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (accountNr != null ? accountNr.hashCode() : 0);
        return result;
    }
}
