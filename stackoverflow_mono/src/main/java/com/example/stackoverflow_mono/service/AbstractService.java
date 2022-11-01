package com.example.stackoverflow_mono.service;

import com.example.stackoverflow_mono.mapper.GenericMapper;
import com.example.stackoverflow_mono.repository.GenericRepository;
import com.example.stackoverflow_mono.utils.BaseUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractService<R extends GenericRepository, M extends GenericMapper> {
    protected final R repository;
    protected final M mapper;
    protected final BaseUtils utils;
}
