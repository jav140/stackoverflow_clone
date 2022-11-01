package com.example.stackoverflow_mono.service;

import com.example.stackoverflow_mono.dto.Dto;
import com.example.stackoverflow_mono.dto.GenericDto;

import java.io.Serializable;

public interface GenericCrudService <ID extends Serializable,
        D extends GenericDto,
        CD extends Dto,
        UD extends GenericDto> extends GenericModifyService<ID, CD, UD>, GenericReadService<ID, D> {

}
