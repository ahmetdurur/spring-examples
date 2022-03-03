package com.haydikodlayalim.api;

import com.haydikodlayalim.service.MessageService;
import com.haydikodlayalim.service.SecondMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageApi {

    @Autowired
    private MessageService messageService;

    @Autowired
    private SecondMessageService secondMessageService;

    @PostMapping
    public ResponseEntity<String> ornekMethod(@RequestBody  String message) {
        secondMessageService.mesaj("bu mesaj second message");
        return ResponseEntity.ok(messageService.mesajVer(message));
    }
}
