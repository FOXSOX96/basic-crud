package com.basic_crud.dto;

public class ApiResponseGet {

    //속성
    private final String message;
    private final Integer status;
    private final MemberGetOneResponseDto data;

    //생성자
    public ApiResponseGet(String message, Integer status, MemberGetOneResponseDto data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    //기능
    public String getMessage() {
        return message;
    }

    public Integer getStatus() {
        return status;
    }

    public MemberGetOneResponseDto getData() {
        return data;
    }
}
