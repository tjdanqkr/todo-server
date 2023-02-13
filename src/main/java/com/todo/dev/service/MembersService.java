package com.todo.dev.service;

import com.todo.dev.domain.entity.Members;
import com.todo.dev.domain.request.LoginRequest;
import com.todo.dev.domain.request.SignUpRequest;
import com.todo.dev.domain.response.MemberResponse;
import com.todo.dev.repository.MembersRepository;
import com.todo.dev.security.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MembersService {
    private final MembersRepository membersRepository;
    private final SecurityService securityService;

    public MemberResponse loginService(LoginRequest request){
        Members loginMember = membersRepository.findByIdAndPw(request);
        if(loginMember.getMemberId()!=null){
            String token = securityService.createToken(loginMember);
            return new MemberResponse(
                    loginMember.getId()
                    ,loginMember.getName()
                    ,loginMember.getPhoneNumber()
                    ,token
                    );
        }
        return null;
    }

    public MemberResponse signUpService(SignUpRequest request){
        Integer insertId = membersRepository.insertMembers(request);
        if(insertId!=null){
            LoginRequest loginRequest = new LoginRequest(request.getMemberId(), request.getMemberPw());
            return loginService(loginRequest);
        }
        return null;
    }
}
