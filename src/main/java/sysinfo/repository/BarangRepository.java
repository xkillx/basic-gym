package sysinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sysinfo.model.Barang;

@RepositoryRestResource(collectionResourceRel = "barang", path = "barang")
public interface BarangRepository extends JpaRepository<Barang, Integer> {

}
