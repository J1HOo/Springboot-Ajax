package com.kh.AjaxProject.service;


import com.kh.AjaxProject.dto.Member;
import com.kh.AjaxProject.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberSerivceImpl implements MemberSerivce {

    //  필드 삽입은 권장되지 않습니다.
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public List<Member> getAllMembers() {
        return memberMapper.getAllMembers();
    }
}

