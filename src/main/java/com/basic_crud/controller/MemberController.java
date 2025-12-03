package com.basic_crud.controller;

import com.basic_crud.dto.ApiResponse;
import com.basic_crud.dto.MemberCreateRequestDto;
import com.basic_crud.dto.MemberCreateResponseDto;
import com.basic_crud.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createMemberApi(@RequestBody MemberCreateRequestDto requestDto) {
        MemberCreateResponseDto memberCreateResponseDto = memberService.createMember(requestDto);
        //응답 형식 적용
        ApiResponse response = new ApiResponse("created", 201, memberCreateResponseDto);
        ResponseEntity<ApiResponse> response2 = new ResponseEntity<>(response, HttpStatus.CREATED);
        return response2;
    }

}
