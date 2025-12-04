package com.basic_crud.dto;

public class MemberGetOneResponseDto {


    private final Long id;
    private final String name;


    public MemberGetOneResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
