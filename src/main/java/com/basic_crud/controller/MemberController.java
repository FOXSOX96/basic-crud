package com.basic_crud.controller;

import com.basic_crud.dto.*;
import com.basic_crud.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/members")
public class MemberController {

    private static final Logger log = LoggerFactory.getLogger(MemberController.class);
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * 멤버 생성
     *
     * @param requestDto
     * @return
     */

    @PostMapping
    public ResponseEntity<ApiResponse> createMemberApi(@RequestBody MemberCreateRequestDto requestDto) {
        MemberCreateResponseDto memberCreateResponseDto = memberService.createMember(requestDto);
        //응답 형식 적용
        ApiResponse response = new ApiResponse("created", 201, memberCreateResponseDto);
        ResponseEntity<ApiResponse> response2 = new ResponseEntity<>(response, HttpStatus.CREATED);
        return response2;
    }

    /**
     * 멤버 조회
     *
     * @param memberId
     */
    @GetMapping("/{memberId}")
    public ApiResponseGet getMemberDetailApi(@PathVariable("memberId") Long memberId) {
        log.info("memberId: {}", memberId);
        MemberGetOneResponseDto responseDto = memberService.getMemberDetail(memberId);
        ApiResponseGet responseGet = new ApiResponseGet("success",200,responseDto);
        return responseGet;
    }


}
