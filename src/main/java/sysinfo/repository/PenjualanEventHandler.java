package sysinfo.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import sysinfo.model.Barang;
import sysinfo.model.Penjualan;

@RepositoryEventHandler(Penjualan.class)
public class PenjualanEventHandler {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BarangRepository br;

    @HandleBeforeCreate
    public void handlePenjualanCreate(Penjualan penjualan) {
        Barang barang = br.findOne(penjualan.getId_barang());
        Integer stok = barang.getStok();
        stok = stok - penjualan.getJumlah();
        barang.setStok(stok);
        br.save(barang);
    }

    @HandleBeforeDelete
    public void handlePenjualanDelete(Penjualan penjualan) {
        Barang barang = br.findOne(penjualan.getId_barang());
        Integer stok = barang.getStok();
        stok = stok + penjualan.getJumlah();
        barang.setStok(stok);
        br.save(barang);
    }
}