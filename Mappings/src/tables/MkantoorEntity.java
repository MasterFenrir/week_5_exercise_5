package tables;

import javax.persistence.*;

/**
 * Created by Sander on 6-6-2015.
 */
@Entity
@Table(name = "mkantoor", schema = "", catalog = "funda_h")
public class MkantoorEntity {
    private Integer mkid;
    private String name;
    private String address;
    private String pc;
    private String city;
    private String phone;

    @Id
    @Column(name = "MKID", nullable = false, insertable = true, updatable = true)
    public Integer getMkid() {
        return mkid;
    }

    public void setMkid(Integer mkid) {
        this.mkid = mkid;
    }

    @Basic
    @Column(name = "Name", nullable = true, insertable = true, updatable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Address", nullable = true, insertable = true, updatable = true, length = 100)
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
    @Column(name = "Phone", nullable = true, insertable = true, updatable = true, length = 15)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MkantoorEntity that = (MkantoorEntity) o;

        if (mkid != null ? !mkid.equals(that.mkid) : that.mkid != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (pc != null ? !pc.equals(that.pc) : that.pc != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        return !(phone != null ? !phone.equals(that.phone) : that.phone != null);

    }

    @Override
    public int hashCode() {
        int result = mkid != null ? mkid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (pc != null ? pc.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
