package sysinfo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "perpanjang_member")
public class PerpanjangMember {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "nama", nullable = false)
    private String nama;

    @Temporal(TemporalType.DATE)
    @Column(name = "tanggal_perpanjang", nullable = false)
    private Date tanggal_perpanjang;

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
