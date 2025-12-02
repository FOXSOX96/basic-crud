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
    public MemberCreateResponseDto createMember(MemberCreateRequestDto requestDto){
        String name = requestDto.getName();
        Member newMember = new Member(name);
        Member savedMember = memberRepository.save(newMember);

        Long foundId = savedMember.getId();

    MemberCreateResponseDto responseDto =  new MemberCreateResponseDto(foundId);
    return responseDto;
    }

}
