package com.init.repository.redis;

import com.init.model.entity.Stuff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StuffRepository extends CrudRepository<Stuff, String> {

    Optional<Stuff> findById(String id);

    List<Stuff> findByData(Long data);
}
