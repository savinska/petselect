package com.softuni.petselect.model.dto.binding;


import jakarta.validation.constraints.NotBlank;

public class MessageBindingModel {
    @NotBlank
    private String textContent;


    public MessageBindingModel() {
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }
}
