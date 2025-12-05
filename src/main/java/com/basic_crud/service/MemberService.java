package com.basic_crud.service;

import com.basic_crud.dto.MemberCreateRequestDto;
import com.basic_crud.dto.T;
import com.basic_crud.dto.MemberGetOneResponseDto;
import com.basic_crud.entity.Member;
import com.basic_crud.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private static final Logger log = LoggerFactory.getLogger(MemberService.class);

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 멤버 생성
     *
     * @param requestDto
     * @return
     */
    @Transactional
    public T createMember(MemberCreateRequestDto requestDto) {
        //데이터준비
        String name = requestDto.getName();
        //멤버생성
        Member newMember = new Member(name);
        //멤버저장
        Member savedMember = memberRepository.save(newMember);
        //반환데이터준비
        Long foundId = savedMember.getId();
        //반환Dto (도메인+기능+Dto)
        T responseDto = new T(foundId);
        return responseDto;
    }

    /**
     * 멤버 조회
     *
     * @param memberId
     * @return
     */
    @Transactional
    public MemberGetOneResponseDto getMemberDetail(Long memberId) {
        //데이터준비
        log.info("memberId: {}", memberId);
        //멤버생성
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("없는 멤버입니다.")
                );
        //반환데이터준비
        Long foundMemberId = member.getId();
        String foundMemberName = member.getName();
        //반환Dto
        MemberGetOneResponseDto responseDto = new MemberGetOneResponseDto(
                foundMemberId,
                foundMemberName
        );

        return responseDto;
    }

}
