package com.basic_crud.service;

import com.basic_crud.dto.*;
import com.basic_crud.entity.Member;
import com.basic_crud.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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

    /**
     * 회원 목록 조회
     *
     * @return
     */
    @Transactional
    public MemberGetAllResponseDto getMembers() {
        log.info("연결완료");
        //데이터 준비
        List<Member> members = memberRepository.findAllByIsDeletedFalse();
        int count = members.size();

        //내부 dto 만들기
        List<MemberGetAllResponseDto.MemberDto> dtos = new ArrayList<>();
        for (Member member : members) {
            log.info("memberId: {}", member.getId());

            MemberGetAllResponseDto.MemberDto dto = new MemberGetAllResponseDto.MemberDto(
                    member.getId(),
                    member.getName()
            );
            dtos.add(dto);
        }

        //외부 dto 만들기
        MemberGetAllResponseDto memberGetAllResponseDto = new MemberGetAllResponseDto(count, dtos);
        return memberGetAllResponseDto;
    }

    /**
     * 회원 수정
     * @param memberId
     * @param requsetDto
     */
    @Transactional
    public MemberUpdateResponseDto updateMember(Long memberId, MemberUpdateRequsetDto requsetDto) {
        Member foundMember = memberRepository.findByIdAndIsDeletedFalse(memberId)
                .orElseThrow(() -> new IllegalArgumentException("없는 멤버입니다.")
                );
        log.info("서비스 -memberId: {}, 수정 전 name: {}", foundMember.getId(), foundMember.getName());

        Member updateMember = foundMember.updateMember(requsetDto.getName());

        log.info("서비스 -memberId: {}, 수정 후 name: {}", updateMember.getId(), updateMember.getName());

        return new MemberUpdateResponseDto(updateMember.getId());
    }
}






