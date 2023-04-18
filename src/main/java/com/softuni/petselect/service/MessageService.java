package com.softuni.petselect.service;

import com.softuni.petselect.model.dto.service.MessageServiceModel;
import com.softuni.petselect.model.entity.MessageEntity;
import com.softuni.petselect.model.entity.UserEntity;

import java.util.List;

public interface MessageService {

    List<MessageServiceModel> getAllOutgoingMessages(Long idSender);

    List<MessageServiceModel> getAllIncomingMessages(Long idRecipient);

    MessageEntity sendMessage(Long id, UserEntity sender, UserEntity recipient, String textContent);
}
