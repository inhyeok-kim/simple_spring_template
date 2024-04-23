package com.seaweed.simple;

import com.seaweed.simple.modules.message.domain.MailMessage;
import com.seaweed.simple.modules.message.service.SimpleMailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest(properties = "spring.profiles.active:test")
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class SimpleMessageTests {

    @Autowired
    private SimpleMailService simpleMailService;

    @Test
    void test(){
        simpleMailService.sendMail(
            new MailMessage.Builder()
                .setHtml("hihihi")
                .setSenderName("테스터")
                .setSenderEmail("test@simple.com")
                .setReceiverEmails(new String[]{"test2@simple.com"})
            .build()
        );
    }
}
