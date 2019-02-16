package com.aaa.repository.redis;

import com.aaa.model.entity.Stuff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface StuffRepository extends CrudRepository<Stuff, String> {

    Optional<Stuff> findById(String id);

    List<Stuff> findByData(Long data);
}
