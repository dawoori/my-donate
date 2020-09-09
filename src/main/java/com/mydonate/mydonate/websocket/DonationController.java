package com.mydonate.mydonate.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class DonationController {

    @MessageMapping("/donation")
    @SendTo("/topic/greetings")
    public Donation greeting(HelloMessage message) throws InterruptedException {
        Thread.sleep(1000);
        return new Donation(HtmlUtils.htmlEscape(message.getName()));
    }
}
