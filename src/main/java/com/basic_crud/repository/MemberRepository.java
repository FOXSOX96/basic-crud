package com.basic_crud.repository;

import com.basic_crud.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findAllByIsDeletedFalse();

    Optional<Member> findByIdAndIsDeletedFalse(Long id);
}

