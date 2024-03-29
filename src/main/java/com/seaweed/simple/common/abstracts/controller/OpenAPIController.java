package com.seaweed.simple.common.abstracts.controller;

import com.seaweed.simple.common.component.http.response.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class OpenAPIController {

    @Autowired
    public ResponseBuilder responseBuilder;

}
