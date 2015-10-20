package sysinfo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pembelian")
public class Pembelian {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private String id;

    @Temporal(TemporalType.DATE)
    @Column(name = "tanggal", nullable = false)
    private Date tanggal;

    @Column(name = "id_barang", nullable = false)
    private String id_barang;

    @Column(name = "nama_barang", nullable = false)
    private String nama_barang;

    @Column(name = "harga_barang", nullable = false)
    private Long harga_barang;

    @Column(name = "jumlah", nullable = false)
    private Long jumlah;

    @Column(name = "total", nullable = false)
    private Long total;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getId_barang() {
        return id_barang;
    }

    public void setId_barang(String id_barang) {
        this.id_barang = id_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public Long getHarga_barang() {
        return harga_barang;
    }

    public void setHarga_barang(Long harga_barang) {
        this.harga_barang = harga_barang;
    }

    public Long getJumlah() {
        return jumlah;
    }

    public void setJumlah(Long jumlah) {
        this.jumlah = jumlah;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
