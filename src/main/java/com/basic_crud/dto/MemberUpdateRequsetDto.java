package com.basic_crud.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MemberUpdateRequsetDto {
    private String name;

    @JsonCreator
    public MemberUpdateRequsetDto(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
