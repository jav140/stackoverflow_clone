package com.example.stackoverflow_mono.controller;

import com.example.stackoverflow_mono.service.BaseService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class ApiController<S extends BaseService> {
    protected final S service;
    protected final String API = "/api";
    protected final String V1 = "/v1";
}
