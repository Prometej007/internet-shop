package com.web.searchservice.repository;

import com.web.searchservice.model.TestModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestModelRepository extends ElasticsearchRepository<TestModel,Long> {
}
