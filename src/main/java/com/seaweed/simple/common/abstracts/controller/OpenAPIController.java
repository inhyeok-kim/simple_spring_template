package com.seaweed.simple.common.abstracts.controller;

import com.seaweed.simple.common.response.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class OpenAPIController {

    @Autowired
    public ResponseBuilder responseBuilder;

}
