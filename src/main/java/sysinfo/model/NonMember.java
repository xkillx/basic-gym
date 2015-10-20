package sysinfo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "non_member")
public class NonMember {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "nama", nullable = false)
    private String nama;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Temporal(TemporalType.DATE)
    @Column(name = "tanggal_datang", nullable = false)
    private Date tanggal_datang;

    @Column(name = "kelas", nullable = false)
    private String kelas;

    @Column(name = "biaya", nullable = false)
    private Long biaya;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public Long getBiaya() {
        return biaya;
    }

    public void setBiaya(Long biaya) {
        this.biaya = biaya;
    }
}
