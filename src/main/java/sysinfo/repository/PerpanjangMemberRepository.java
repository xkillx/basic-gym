package sysinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sysinfo.model.PerpanjangMember;

import java.util.Date;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "perpanjang_member", path = "perpanjang_member")
public interface PerpanjangMemberRepository extends JpaRepository<PerpanjangMember, Integer> {
    @Query("select p from PerpanjangMember p " +
            "where p.tanggal_perpanjang between ?1 and ?2")
    List<PerpanjangMember> cariPerpanjangDari(Date mulai, Date akhir);
}
