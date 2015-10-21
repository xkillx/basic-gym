package sysinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sysinfo.model.PerpanjangMember;

@RepositoryRestResource(collectionResourceRel = "perpanjang_member", path = "perpanjang_member")
public interface PerpanjangMemberRepository extends JpaRepository<PerpanjangMember, Integer> {
}
