package com.todo.dev.service;

import com.todo.dev.repository.FriendsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FriendsService {
    private final FriendsRepository friendsRepository;
    public Integer insertFriends(Integer myId , Integer targetId){
        return friendsRepository.insertFriend(myId, targetId);
    }
}
