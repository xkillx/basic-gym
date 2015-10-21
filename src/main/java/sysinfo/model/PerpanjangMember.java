package sysinfo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "perpanjang_member")
public class PerpanjangMember {

    @Id @GeneratedValue
    private Integer id_perpanjang;

    @Column(name = "id_member", nullable = false)
    private Integer id_member;

    @Column(name = "nama", nullable = false)
    private String nama;

    @Temporal(TemporalType.DATE)
    @Column(name = "tanggal_perpanjang", nullable = false)
    private Date tanggal_perpanjang;

    @Column(name = "biaya", nullable = false)
    private Long biaya;

    public Integer getId_perpanjang() {
        return id_perpanjang;
    }

    public void setId_perpanjang(Integer id_perpanjang) {
        this.id_perpanjang = id_perpanjang;
    }

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

    public Date getTanggal_perpanjang() {
        return tanggal_perpanjang;
    }

    public void setTanggal_perpanjang(Date tanggal_perpanjang) {
        this.tanggal_perpanjang = tanggal_perpanjang;
    }

    public Long getBiaya() {
        return biaya;
    }

    public void setBiaya(Long biaya) {
        this.biaya = biaya;
    }
}
