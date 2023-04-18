package com.softuni.petselect.web;

import com.softuni.petselect.model.dto.binding.MessageBindingModel;
import com.softuni.petselect.model.dto.view.MessageViewModel;
import com.softuni.petselect.model.entity.UserEntity;
import com.softuni.petselect.service.MessageService;
import com.softuni.petselect.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/messages")
@Controller
public class MessageController {

    private final MessageService messageService;
    private final ModelMapper modelMapper;
    private final UserService userService;

    public MessageController(MessageService messageService, ModelMapper modelMapper, UserService userService) {
        this.messageService = messageService;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/inbox")
    public String myInbox(Principal principal, Model model) {

        Long id = userService.findUserByEmail(principal.getName()).getId();
        List<MessageViewModel> allIncomingMessages = messageService.getAllIncomingMessages(id)
                .stream()
                .map(messageServiceModel -> modelMapper.map(messageServiceModel, MessageViewModel.class))
                .collect(Collectors.toList());

        List<MessageViewModel> allOutgoingMessages = messageService.getAllOutgoingMessages(id)
                .stream()
                .map(messageServiceModel -> modelMapper.map(messageServiceModel, MessageViewModel.class))
                .collect(Collectors.toList());


        model.addAttribute("allIncoming", allIncomingMessages);
        model.addAttribute("allOutgoing", allOutgoingMessages);

        return "inbox";
    }

    @GetMapping("/send/{id}")
    public String sendMessage(@PathVariable Long id, Model model){
        var recipient = userService.findById(id);
        var nameRecipient = recipient.getFirstName() + " " + recipient.getLastName();

        model.addAttribute("idRecipient", userService.findById(id).getId());
        model.addAttribute("nameRecipient", nameRecipient);

        return "message-send";
    }


    @PostMapping("/send/{id}")
    public String sendMessage(@PathVariable Long id, MessageBindingModel messageBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes, Principal principal) {

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("messageBindingModel", messageBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.messageBindingModel", bindingResult);

             return "redirect:message-send";
        }
        UserEntity sender = userService.findUserByEmail(principal.getName());
        UserEntity recipient = userService.findById(id);
        String textContent = messageBindingModel.getTextContent();

        messageService.sendMessage(id, sender, recipient, textContent);

        return "redirect:/inbox";
    }

    @ModelAttribute
    public MessageBindingModel messageBindingModel() {
        return new MessageBindingModel();
    }
}
