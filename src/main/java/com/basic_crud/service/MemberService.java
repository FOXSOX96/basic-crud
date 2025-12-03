package com.basic_crud.service;

import com.basic_crud.dto.MemberCreateRequestDto;
import com.basic_crud.dto.MemberCreateResponseDto;
import com.basic_crud.entity.Member;
import com.basic_crud.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public MemberCreateResponseDto createMember(MemberCreateRequestDto requestDto) {
        //데이터준비
        String name = requestDto.getName();
        //멤버생성
        Member newMember = new Member(name);
        //멤버저장
        Member savedMember = memberRepository.save(newMember);
        //반환데이터준비
        Long foundId = savedMember.getId();
        //반환Dto (도메인+기능+Dto)
        MemberCreateResponseDto responseDto = new MemberCreateResponseDto(foundId);
        return responseDto;
    }

}
