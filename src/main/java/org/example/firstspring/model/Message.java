package org.example.firstspring.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Message {
    private String name;
    private String message;
    private String id;
}
