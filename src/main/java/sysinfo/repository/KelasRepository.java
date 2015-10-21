package sysinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sysinfo.model.Kelas;

@RepositoryRestResource(collectionResourceRel = "kelas", path = "kelas")
public interface KelasRepository extends JpaRepository<Kelas, Integer> {
}
