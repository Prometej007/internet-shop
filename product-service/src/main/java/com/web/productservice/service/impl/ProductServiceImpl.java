package com.web.productservice.service.impl;

import com.web.productservice.model.Product;
import com.web.productservice.model.utils.pattern.LastModification;
import com.web.productservice.repository.ProductRepository;
import com.web.productservice.service.DictionaryService;
import com.web.productservice.service.ImageService;
import com.web.productservice.service.MaterialsService;
import com.web.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

 @Autowired
 private ImageService imageService;
    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private MaterialsService materialsService;

    @Transactional(rollbackFor = NullPointerException.class)
    @Override
    public Product create(Product product) {
        return save(
                new Product()
                        .setImage(imageService.create(product.getImage()))

                        .setCategory(product.getCategory())

                        .setDateCreate(Timestamp.valueOf(LocalDateTime.now()))

                        .setWeight(product.getWeight())
                        .setLength(product.getLength())
                        .setHeight(product.getHeight())
                        .setName(dictionaryService.create(product.getName()))
                        .setDescription(dictionaryService.create(product.getDescription()))

                        .setCanBuy(ofNullable(product.getCanBuy()).orElse(false))
                        .setAvailable(ofNullable(product.getAvailable()).orElse(false))
                        .setNews(ofNullable(product.getNews()).orElse(false))

                        .setMaterials(product.getMaterials().stream().map(materials -> materialsService.findOne(materials)).collect(Collectors.toList()))
                        .setSoftness(product.getSoftness())
        );
    }

    @Transactional(rollbackFor = NullPointerException.class)
    @Override
    public Product save(Product product) {
        return productRepository.save(setLastModification(product));
    }

    @Override
    public Product findOne(Product product) {
        return findOne(product.getId());
    }

    @Override
    public Product findOne(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Transactional(rollbackFor = NullPointerException.class)
    @Override
    public Product update(Product product) {
        return save(setLastModification(product));
    }

    @Override
    public Product lastModification(LastModification<Product> lastModification) {
        return save(setLastModification(findOne(lastModification.getId())));
    }

    @Override
    public Product setLastModification(LastModification<Product> lastModification) {
        return lastModification.setLastModified(Timestamp.valueOf(LocalDateTime.now()));
    }

}
