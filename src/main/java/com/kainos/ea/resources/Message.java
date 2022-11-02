package com.kainos.ea.resources;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
    private String text;

    public String getText() {
        return text;
    }
    @JsonCreator
    public void setText(@JsonProperty("text") String text) {
        this.text = text;
    }

    @JsonCreator
    public Message(@JsonProperty("text") String text) {
        this.setText(text);
    }
}