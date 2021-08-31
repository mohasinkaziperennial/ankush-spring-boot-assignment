package com.perennialsys.controller;

import com.perennialsys.entity.User;
import com.perennialsys.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * this end points related to third party api
 * it will consume third party api and display basic info
 *
 * @author ankush katkar
 */
@RestController
public class HomeController {
    private final ServiceLayer serviceLayer;

    @Autowired
    public HomeController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

    @GetMapping("/")
    public ResponseEntity<User[]> getData() {
        return new ResponseEntity<>(serviceLayer.consumeAPI(), HttpStatus.CREATED);
    }


}
