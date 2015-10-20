package sysinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sysinfo.model.Penjualan;

@RepositoryRestResource(collectionResourceRel = "penjualan", path = "penjualan")
public interface PenjualanRepository extends JpaRepository<Penjualan, String> {
}
