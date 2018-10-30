package com.web.resourceserver.repository;

import com.web.resourceserver.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {


    @Query("select i.lastModified from Image i where i.path=:path")
    Timestamp findDto(@Param("path") String path);

    Image findByPath(String path);

    Integer countByPath(String path);

}
