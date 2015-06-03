package connector;

import javax.persistence.Id;

/**
 * Created by Sander on 2-6-2015.
 */
public class Broker {

    @Id
    private Integer id;
    private Integer office;
    private String name;
    private String user;
    private String pwd;

    public Broker(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOffice() {
        return office;
    }

    public void setOffice(Integer office) {
        this.office = office;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
