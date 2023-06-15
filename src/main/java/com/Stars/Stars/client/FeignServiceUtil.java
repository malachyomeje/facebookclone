package com.Stars.Stars.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Service
@FeignClient(value = "state",url = "https://restcountries.com")
public interface FeignServiceUtil {

    @GetMapping("/v3.1/all")
    List<Object>getState();


}
