package sysinfo.model;

import javax.persistence.*;

@Entity
@Table(name = "kelas")
public class Kelas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "nama", nullable = false)
    private String nama;

    @Column(name = "biaya", nullable = false)
    private Long biaya;

    @Column(name = "biaya_daftar", nullable = false)
    private Long biaya_daftar;

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

    public Long getBiaya() {
        return biaya;
    }

    public void setBiaya(Long biaya) {
        this.biaya = biaya;
    }

    public Long getBiaya_daftar() {
        return biaya_daftar;
    }

    public void setBiaya_daftar(Long biaya_daftar) {
        this.biaya_daftar = biaya_daftar;
    }
}
