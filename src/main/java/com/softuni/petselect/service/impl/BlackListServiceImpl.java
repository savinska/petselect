package com.softuni.petselect.service.impl;

import com.softuni.petselect.service.BlackListService;
import org.springframework.stereotype.Service;

@Service
public class BlackListServiceImpl implements BlackListService {
    @Override
    public boolean isBlackListed(String ipAddress) {
        //TODO
        return false;
    }
}
