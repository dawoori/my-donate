package com.mydonate.websocket;

import lombok.Getter;

@Getter
public class Donation {
    private String content;

    public Donation() {
    }

    public Donation(String content) {
        this.content = content;
    }
}
