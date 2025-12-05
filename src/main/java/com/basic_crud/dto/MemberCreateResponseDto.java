package com.basic_crud.dto;

public class MemberCreateResponseDto {

    //속성
    private final Long id;

    //생성자
    public MemberCreateResponseDto(Long foundId) {
        this.id = foundId;
    }

    //기능
    public Long getId() {
        return id;
    }

}