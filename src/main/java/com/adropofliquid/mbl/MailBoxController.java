package com.adropofliquid.mbl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MailBoxController {

    @Autowired
    MailBoxServices mailBoxServices;

    @CrossOrigin
    @GetMapping("/mail/{user}")
    public MessageCount infoPage(@PathVariable String user){
        if(user.equals("jim"))
            return mailBoxServices.getMessageCount();
        else
            return new MessageCount(0,0);
    }

    @CrossOrigin
    @GetMapping("/mail/{user}/inbox")
    public List<Inbox> inboxPage(@PathVariable String user){
        //maybe verify it;s jim first
        return mailBoxServices.getMinimalInbox();
    }

    @CrossOrigin
    @GetMapping("/mail/message/{id}")
    public Inbox messagePage(@PathVariable String id){

        mailBoxServices.setMailAsRead(id);
        return mailBoxServices.getInbox(id);
    }

}
