package sysinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sysinfo.model.Pembelian;

@RepositoryRestResource(collectionResourceRel = "pembelian", path = "pembelian")
public interface PembelianRepository extends JpaRepository<Pembelian, String> {
}
