package sysinfo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "nama", nullable = false)
    private String nama;

    @Column(name = "alamat", nullable = false)
    private String alamat;

    @Temporal(TemporalType.DATE)
    @Column(name = "tanggal_lahir", nullable = false)
    private Date tanggal_lahir;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "telepon", nullable = false)
    private String telepon;

    @Column(name = "pekerjaan", nullable = false)
    private String pekerjaan;

    @Temporal(TemporalType.DATE)
    @Column(name = "tanggal_daftar", nullable = false)
    private Date tanggal_daftar;

    @Column(name = "kelas", nullable = false)
    private String kelas;

    @Column(name = "biaya_daftar", nullable = false)
    private Long biaya_daftar;

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

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Date getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(Date tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public Date getTanggal_daftar() {
        return tanggal_daftar;
    }

    public void setTanggal_daftar(Date tanggal_daftar) {
        this.tanggal_daftar = tanggal_daftar;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public Long getBiaya_daftar() {
        return biaya_daftar;
    }

    public void setBiaya_daftar(Long biaya_daftar) {
        this.biaya_daftar = biaya_daftar;
    }

    public Long getBiaya() {
        return biaya;
    }

    public void setBiaya(Long biaya) {
        this.biaya = biaya;
    }
}
