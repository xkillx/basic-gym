package sysinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sysinfo.model.Member;

import java.util.Date;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "member", path = "member")
public interface MemberRepository extends JpaRepository<Member, Integer> {
    @Query("select m from Member m " +
            "where m.tanggal_daftar between ?1 and ?2")
    List<Member> cariMemberdari(Date mulai, Date akhir);
}
