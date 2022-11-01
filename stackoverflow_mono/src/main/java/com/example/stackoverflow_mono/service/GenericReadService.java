package com.example.stackoverflow_mono.service;

import com.example.stackoverflow_mono.dto.GenericDto;
import lombok.NonNull;

import java.io.Serializable;
import java.util.List;

public interface GenericReadService <ID extends Serializable, D extends GenericDto> extends BaseService{
    List<D> getAll();

    D get(@NonNull ID id);
}
