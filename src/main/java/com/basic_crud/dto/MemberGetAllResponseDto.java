package com.basic_crud.dto;

import java.util.List;

public class MemberGetAllResponseDto {


    private final int count;
    private final List<MemberDto> data;


    public int getCount() {
        return count;
    }

    public List<MemberDto> getData() {
        return data;
    }

    public MemberGetAllResponseDto(int count, List<MemberDto> data) {
        this.count = count;
        this.data = data;
    }

    //내부클래스, 중첩클래스
    public static class MemberDto {
        //속성
        private Long id;
        private String name;

        //생성자
        public MemberDto(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        //기능
        public String getName() {
            return name;
        }
        public Long getId() {
            return id;
        }
    }

}
