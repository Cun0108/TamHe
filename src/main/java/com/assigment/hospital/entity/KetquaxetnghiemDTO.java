package com.assigment.hospital.entity;

public class KetquaxetnghiemDTO {
    private long maxn;
    private String tenxn;
    private String donvi;
    private Integer ketqua;
    private String ghichu;

    public KetquaxetnghiemDTO() {
    }

    public KetquaxetnghiemDTO(long maxn, String tenxn, String donvi, Integer ketqua, String ghichu) {
        this.maxn = maxn;
        this.tenxn = tenxn;
        this.donvi = donvi;
        this.ketqua = ketqua;
        this.ghichu = ghichu;
    }

    public long getMaxn() {
        return maxn;
    }

    public void setMaxn(long maxn) {
        this.maxn = maxn;
    }

    public String getTenxn() {
        return tenxn;
    }

    public void setTenxn(String tenxn) {
        this.tenxn = tenxn;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public Integer getKetqua() {
        return ketqua;
    }

    public void setKetqua(Integer ketqua) {
        this.ketqua = ketqua;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((donvi == null) ? 0 : donvi.hashCode());
        result = prime * result + ((ghichu == null) ? 0 : ghichu.hashCode());
        result = prime * result + ((ketqua == null) ? 0 : ketqua.hashCode());
        result = prime * result + (int) (maxn ^ (maxn >>> 32));
        result = prime * result + ((tenxn == null) ? 0 : tenxn.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        KetquaxetnghiemDTO other = (KetquaxetnghiemDTO) obj;
        if (donvi == null) {
            if (other.donvi != null)
                return false;
        } else if (!donvi.equals(other.donvi))
            return false;
        if (ghichu == null) {
            if (other.ghichu != null)
                return false;
        } else if (!ghichu.equals(other.ghichu))
            return false;
        if (ketqua == null) {
            if (other.ketqua != null)
                return false;
        } else if (!ketqua.equals(other.ketqua))
            return false;
        if (maxn != other.maxn)
            return false;
        if (tenxn == null) {
            if (other.tenxn != null)
                return false;
        } else if (!tenxn.equals(other.tenxn))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "KetquaxetnghiemDTO [donvi=" + donvi + ", ghichu=" + ghichu + ", ketqua=" + ketqua + ", maxn=" + maxn
                + ", tenxn=" + tenxn + "]";
    }
    
}
