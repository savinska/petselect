package com.softuni.petselect.service.impl;

import com.softuni.petselect.model.entity.BlockedIP;
import com.softuni.petselect.repository.BlackListRepository;
import com.softuni.petselect.service.BlackListService;
import org.springframework.stereotype.Service;

@Service
public class BlackListServiceImpl implements BlackListService {

    private final BlackListRepository blackListRepository;

    public BlackListServiceImpl(BlackListRepository blackListRepository) {
        this.blackListRepository = blackListRepository;
    }

    @Override
    public boolean isBlackListed(String ipAddress) {

        BlockedIP blockedIP = blackListRepository.findByIp(ipAddress).orElse(null);

        return blockedIP != null;
    }
}
