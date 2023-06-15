package com.Stars.Stars.client;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feign")
@RequiredArgsConstructor
public class feignController {
private final FeignServiceUtil feignServiceUtil;

@GetMapping("/state")

List<Object>getState(){
    return feignServiceUtil.getState();
}

}

