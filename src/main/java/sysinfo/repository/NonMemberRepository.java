package sysinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sysinfo.model.NonMember;

import java.util.Date;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "non_member", path = "non_member")
public interface NonMemberRepository extends JpaRepository<NonMember, Integer> {
    @Query("select n from NonMember n " +
            "where n.tanggal_datang between ?1 and ?2")
    List<NonMember> cariNonMemberdari(Date mulai, Date akhir);
}
