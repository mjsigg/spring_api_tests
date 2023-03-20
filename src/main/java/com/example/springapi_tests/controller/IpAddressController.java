package com.example.springapi_tests.controller;

import com.example.springapi_tests.model.IpAPI;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// This should be probably end up being a service.  Treat it like a repository.

@Controller
public class IpAddressController {

//    @RequestMapping("/hello")
//    @ResponseBody
//    private IPAddress getIP() {
//        String uri = "http://ip-api.com/json/";
//        RestTemplate restTemplate = new RestTemplate();
//        IPAddress data = restTemplate.getForObject(uri,IPAddress.class);
//
//        Map<String,String> dataMap;
//
//        return data;
//    }

    @RequestMapping("/hello")
    @ResponseBody
    private Map<String, String> getIP() {
        String uri = "http://ip-api.com/json/";
        RestTemplate restTemplate = new RestTemplate();
        IpAPI data = restTemplate.getForObject(uri, IpAPI.class);

        Map<String, String> dataMap = new HashMap<>();
        Field[] fields = IpAPI.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(data);
                if (value != null) {
                    dataMap.put(field.getName(), value.toString());
                }
            } catch (IllegalAccessException e) {
                // handle exception
            }
        }
        System.out.println(dataMap);
        return dataMap;
    }









}
