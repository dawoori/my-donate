package com.mydonate.websocket;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloMessage {
    private String donationText;
    private String name;

    public HelloMessage() {
    }

    public HelloMessage(String donationText) {
        this.donationText = donationText;
    }
}
