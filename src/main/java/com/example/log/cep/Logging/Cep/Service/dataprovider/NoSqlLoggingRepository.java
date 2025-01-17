package com.example.log.cep.Logging.Cep.Service.dataprovider;

import com.example.log.cep.Logging.Cep.Service.dataprovider.entity.CepEntityOther;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface NoSqlLoggingRepository extends MongoRepository<CepEntityOther, Integer> {
}
