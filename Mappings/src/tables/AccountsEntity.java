package tables;

import javax.persistence.*;

/**
 * Created by Sander on 6-6-2015.
 */
@Entity
@Table(name = "accounts", schema = "", catalog = "funda_h")
public class AccountsEntity {
    private Integer accountNr;
    private String username;
    private String password;
    private Integer rights;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ACCOUNT_NR", nullable = false, insertable = true, updatable = true)
    public Integer getAccountNr() {
        return accountNr;
    }

    public void setAccountNr(Integer accountNr) {
        this.accountNr = accountNr;
    }

    @Basic
    @Column(name = "USERNAME", nullable = false, insertable = true, updatable = true, length = 100)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "PASSWORD", nullable = false, insertable = true, updatable = true, length = 100)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "RIGHTS", nullable = false, insertable = true, updatable = true)
    public Integer getRights() {
        return rights;
    }

    public void setRights(Integer rights) {
        this.rights = rights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountsEntity that = (AccountsEntity) o;

        if (accountNr != null ? !accountNr.equals(that.accountNr) : that.accountNr != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        return !(rights != null ? !rights.equals(that.rights) : that.rights != null);

    }

    @Override
    public int hashCode() {
        int result = accountNr != null ? accountNr.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (rights != null ? rights.hashCode() : 0);
        return result;
    }
}
