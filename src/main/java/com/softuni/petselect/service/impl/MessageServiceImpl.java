package com.softuni.petselect.service.impl;

import com.softuni.petselect.model.dto.binding.MessageBindingModel;
import com.softuni.petselect.model.dto.service.MessageServiceModel;
import com.softuni.petselect.model.entity.MessageEntity;
import com.softuni.petselect.model.entity.UserEntity;
import com.softuni.petselect.repository.MessageRepository;
import com.softuni.petselect.service.MessageService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final ModelMapper modelMapper;

    public MessageServiceImpl(MessageRepository messageRepository, ModelMapper modelMapper) {
        this.messageRepository = messageRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<MessageServiceModel> getAllOutgoingMessages(Long idSender) {
        return messageRepository
                .findAllBySender_Id(idSender)
                .stream()
                .map(m -> modelMapper.map(m, MessageServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MessageServiceModel> getAllIncomingMessages(Long idRecipient) {
        return messageRepository
                .findAllByRecipient_Id(idRecipient)
                .stream()
                .map(m -> modelMapper.map(m, MessageServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public MessageEntity sendMessage(Long id, UserEntity sender, UserEntity recipient, String textContent) {
        MessageEntity message = new MessageEntity();
        message.setSender(sender);
        message.setRecipient(recipient);
        message.setTextContent(textContent);
        message.setSentOn(Instant.now());

        messageRepository.save(message);

        return message;
    }
}
