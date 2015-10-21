package sysinfo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "member")
public class Member {

    @Id @GeneratedValue
    private Integer id_member;

    @Column(name = "nama", nullable = false)
    private String nama;

    @Column(name = "jalan", nullable = false)
    private String jalan;

    @Column(name = "kelurahan", nullable = false)
    private String kelurahan;

    @Column(name = "kecamatan", nullable = false)
    private String kecamatan;

    @Column(name = "kota", nullable = false)
    private String kota;

    @Temporal(TemporalType.DATE)
    @Column(name = "tanggal_lahir", nullable = true)
    private Date tanggal_lahir;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "telepon", nullable = false)
    private String telepon;

    @Column(name = "pekerjaan", nullable = true)
    private String pekerjaan;

    @Temporal(TemporalType.DATE)
    @Column(name = "tanggal_daftar", nullable = false)
    private Date tanggal_daftar;

    @Column(name = "biaya_daftar", nullable = false, length = 7)
    private Integer biaya_daftar;

    public Integer getId_member() {
        return id_member;
    }

    public void setId_member(Integer id_member) {
        this.id_member = id_member;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJalan() {
        return jalan;
    }

    public void setJalan(String jalan) {
        this.jalan = jalan;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
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

    public Integer getBiaya_daftar() {
        return biaya_daftar;
    }

    public void setBiaya_daftar(Integer biaya_daftar) {
        this.biaya_daftar = biaya_daftar;
    }
}
