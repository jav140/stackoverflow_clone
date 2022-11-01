package com.example.stackoverflow_mono.service;

import com.example.stackoverflow_mono.dto.Dto;
import com.example.stackoverflow_mono.dto.GenericDto;
import lombok.NonNull;

import java.io.Serializable;

public interface GenericModifyService<ID extends Serializable,
        CD extends Dto,
        UD extends GenericDto> extends BaseService {
    ID create(@NonNull CD dto);

    void delete(@NonNull ID id);

    void update(@NonNull UD dto);
}
