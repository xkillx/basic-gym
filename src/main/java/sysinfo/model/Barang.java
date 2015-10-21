package sysinfo.model;

import javax.persistence.*;

@Entity
@Table(name = "barang")
public class Barang {

    @Id @GeneratedValue
    private Integer id_barang;

    @Column(name = "nama", nullable = false)
    private String nama;

    @Column(name = "harga", nullable = false)
    private Integer harga;

    @Column(name = "stok", nullable = false)
    private Integer stok;

    @Column(name = "deskripsi", nullable = true)
    private String deskripsi;

    public Integer getId_barang() {
        return id_barang;
    }

    public void setId_barang(Integer id_barang) {
        this.id_barang = id_barang;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
