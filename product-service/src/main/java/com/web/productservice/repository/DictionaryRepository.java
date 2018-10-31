package com.web.productservice.repository;

import com.web.productservice.model.Dictionary;
import com.web.productservice.model.Materials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DictionaryRepository extends JpaRepository<Dictionary,Long> {
}
