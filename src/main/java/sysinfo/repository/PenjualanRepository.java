package sysinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sysinfo.model.Member;
import sysinfo.model.Penjualan;

import java.util.Date;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "penjualan", path = "penjualan")
public interface PenjualanRepository extends JpaRepository<Penjualan, Integer> {
    @Query("select p from Penjualan p " +
            "where p.tanggal between ?1 and ?2")
    List<Member> cariPenjualanDari(Date mulai, Date akhir);
}
