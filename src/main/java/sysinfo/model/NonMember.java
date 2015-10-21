package sysinfo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "non_member")
public class NonMember {

    @Id @GeneratedValue
    private Integer id_nonmember;

    @Column(name = "nama", nullable = false)
    private String nama;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Temporal(TemporalType.DATE)
    @Column(name = "tanggal_datang", nullable = false)
    private Date tanggal_datang;

    @Column(name = "biaya", nullable = false)
    private Integer biaya;

    public Integer getId_nonmember() {
        return id_nonmember;
    }

    public void setId_nonmember(Integer id_nonmember) {
        this.id_nonmember = id_nonmember;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getTanggal_datang() {
        return tanggal_datang;
    }

    public void setTanggal_datang(Date tanggal_datang) {
        this.tanggal_datang = tanggal_datang;
    }

    public Integer getBiaya() {
        return biaya;
    }

    public void setBiaya(Integer biaya) {
        this.biaya = biaya;
    }
}
