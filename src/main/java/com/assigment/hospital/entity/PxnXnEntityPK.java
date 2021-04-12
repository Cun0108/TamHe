package com.assigment.hospital.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PxnXnEntityPK implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 7755341774750898580L;
    
    private long mapxn;
    private long maxn;

    @Column(name = "mapxn", nullable = false)
    @Id
    public long getMapxn() {
        return mapxn;
    }

    public void setMapxn(long mapxn) {
        this.mapxn = mapxn;
    }

    @Column(name = "maxn", nullable = false)
    @Id
    public long getMaxn() {
        return maxn;
    }

    public void setMaxn(long maxn) {
        this.maxn = maxn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PxnXnEntityPK that = (PxnXnEntityPK) o;
        return mapxn == that.mapxn && maxn == that.maxn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mapxn, maxn);
    }
}
