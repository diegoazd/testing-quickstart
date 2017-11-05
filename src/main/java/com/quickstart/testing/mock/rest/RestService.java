package com.quickstart.testing.mock.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;

@Service
public class RestService {

    @Autowired
    private Client client;

    public String getMessage() {
        return client.target("http://www.mocky.io/v2/59fe4f7c330000590b1349d9")
                .request().get(String.class);
    }
}
