package com.basic_crud.dto;

import java.util.List;

public class MemberGetAllResponseDto {


    private final int count;
    private final List<MemberGetOneResponseDto> data;


    public int getCount() {
        return count;
    }

    public List<MemberGetOneResponseDto> getData() {
        return data;
    }

    public MemberGetAllResponseDto(int count, List<MemberGetOneResponseDto> data) {
        this.count = count;
        this.data = data;
    }
}
