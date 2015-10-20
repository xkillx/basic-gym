package sysinfo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import sysinfo.model.Barang;
import sysinfo.model.Pembelian;

@RepositoryEventHandler(Pembelian.class)
public class PembelianEventHandler {

    @Autowired
    private BarangRepository br;

    @HandleBeforeCreate
    public void handlePembelianCreate(Pembelian pembelian) {
        Barang barang = br.findOne(pembelian.getId_barang());
        Long stok = barang.getStok();
        stok = stok + pembelian.getJumlah();
        barang.setStok(stok);
        br.save(barang);
    }

    @HandleBeforeDelete
    public void handlePembelianDelete(Pembelian pembelian) {
        Barang barang = br.findOne(pembelian.getId_barang());
        Long stok = barang.getStok();
        stok = stok - pembelian.getJumlah();
        barang.setStok(stok);
        br.save(barang);
    }
}
