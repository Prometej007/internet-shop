package com.web.resourceserver.repository;

import com.web.resourceserver.dto.ImageDto;
import com.web.resourceserver.model.Dictionary;
import com.web.resourceserver.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DictionaryRepository extends JpaRepository<Dictionary,Long> {


}
