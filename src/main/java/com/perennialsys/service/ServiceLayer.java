package com.perennialsys.service;

import com.perennialsys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceLayer {
    private final RestTemplate restTemplate;

    @Autowired
    public ServiceLayer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public User[] consumeAPI() {
        return restTemplate.getForObject("http://localhost:3000/users",
                User[].class);
    }
  /*  public User consumeApi1(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    }*/

}
