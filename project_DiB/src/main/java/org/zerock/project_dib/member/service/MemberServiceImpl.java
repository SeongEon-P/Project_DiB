package org.zerock.project_dib.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.zerock.project_dib.member.domain.Member;
import org.zerock.project_dib.member.domain.MemberRole;
import org.zerock.project_dib.member.dto.MemberDTO;
import org.zerock.project_dib.member.mapper.MemberMapper;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void join(MemberDTO memberDTO){
        log.info(modelMapper);
        Member member = modelMapper.map(memberDTO, Member.class);
        member.changePassword(passwordEncoder.encode(memberDTO.getMpw()));
//        member.addRole(MemberRole.USER);

        log.info("--------------------------------------");
        log.info(member);
//        log.info(member.getRoleSet());

        memberMapper.insert(member);
    }

    @Override
    public boolean confirmId(boolean exist) throws MidExistException {
        return exist;
    }


}
