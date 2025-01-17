package com.example.log.cep.Logging.Cep.Service.dataprovider;

import com.example.log.cep.Logging.Cep.Service.dataprovider.entity.CepEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlLoggingRepository extends JpaRepository<CepEntity, Long> {
}
