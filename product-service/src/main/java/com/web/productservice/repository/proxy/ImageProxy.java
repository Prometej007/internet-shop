package com.web.productservice.repository.proxy;

import com.web.productservice.dto.Image;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "resource-server")
public interface ImageProxy {

    @PostMapping("/resource-server/image/create")
    String create(@RequestBody Image image);

    @PostMapping("/resource-server/image/update")
    Image update(@RequestBody Image image);

    @PostMapping("/resource-server/image/params-create")
    Image update(@RequestParam String content,
                 @RequestParam String altRu, @RequestParam String altUa, @RequestParam String altEn,
                 @RequestParam String titleRu, @RequestParam String titleUa, @RequestParam String titleEn);

}


