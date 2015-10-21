package sysinfo.config;

import org.springframework.boot.autoconfigure.data.rest.SpringBootRepositoryRestMvcConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import sysinfo.model.*;

@Configuration
public class RepositoryConfig extends SpringBootRepositoryRestMvcConfiguration {
    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Member.class);
        config.exposeIdsFor(Barang.class);
        config.exposeIdsFor(NonMember.class);
        config.exposeIdsFor(Kelas.class);
        config.exposeIdsFor(PerpanjangMember.class);
        config.exposeIdsFor(Penjualan.class);
    }
}
