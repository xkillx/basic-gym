package sysinfo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "penjualan")
public class Penjualan {

    @Id @GeneratedValue
    private Integer id_penjualan;

    @Temporal(TemporalType.DATE)
    @Column(name = "tanggal", nullable = false)
    private Date tanggal;

    @Column(name = "id_barang", nullable = false)
    private Integer id_barang;

    @Column(name = "nama_barang", nullable = false)
    private String nama_barang;

    @Column(name = "harga_barang", nullable = false)
    private Integer harga_barang;

    @Column(name = "jumlah", nullable = false)
    private Integer jumlah;

    @Column(name = "total", nullable = false)
    private Integer total;

    public Integer getId_penjualan() {
        return id_penjualan;
    }

    public void setId_penjualan(Integer id_penjualan) {
        this.id_penjualan = id_penjualan;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Integer getId_barang() {
        return id_barang;
    }

    public void setId_barang(Integer id_barang) {
        this.id_barang = id_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public Integer getHarga_barang() {
        return harga_barang;
    }

    public void setHarga_barang(Integer harga_barang) {
        this.harga_barang = harga_barang;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
