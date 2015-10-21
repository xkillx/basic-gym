package sysinfo.model;

import javax.persistence.*;

@Entity
@Table(name = "kelas")
public class Kelas {

    @Id @GeneratedValue
    private Integer id_kelas;

    @Column(name = "nama", nullable = false)
    private String nama;

    @Column(name = "biaya", nullable = false)
    private Long biaya;

    @Column(name = "biaya_daftar", nullable = false)
    private Long biaya_daftar;

    public Integer getId_kelas() {
        return id_kelas;
    }

    public void setId_kelas(Integer id_kelas) {
        this.id_kelas = id_kelas;
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
