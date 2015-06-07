package tables;

import javax.persistence.*;

/**
 * Created by Sander on 7-6-2015.
 */
@Entity
@Table(name = "woningligging", schema = "", catalog = "funda_h")
public class WoningliggingEntity {
    private Integer woWoid;
    private Integer liggingId;

    @Basic
    @Column(name = "wo_WOID", nullable = false, insertable = true, updatable = true)
    public Integer getWoWoid() {
        return woWoid;
    }

    public void setWoWoid(Integer woWoid) {
        this.woWoid = woWoid;
    }

    @Id
    @Column(name = "LIGGING_ID", nullable = false, insertable = true, updatable = true)
    public Integer getLiggingId() {
        return liggingId;
    }

    public void setLiggingId(Integer liggingId) {
        this.liggingId = liggingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WoningliggingEntity that = (WoningliggingEntity) o;

        if (woWoid != null ? !woWoid.equals(that.woWoid) : that.woWoid != null) return false;
        return !(liggingId != null ? !liggingId.equals(that.liggingId) : that.liggingId != null);

    }

    @Override
    public int hashCode() {
        int result = woWoid != null ? woWoid.hashCode() : 0;
        result = 31 * result + (liggingId != null ? liggingId.hashCode() : 0);
        return result;
    }
}
