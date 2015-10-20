package sysinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sysinfo.model.NonMember;

@RepositoryRestResource(collectionResourceRel = "non_member", path = "non_member")
public interface NonMemberRepository extends JpaRepository<NonMember, String> {
}
