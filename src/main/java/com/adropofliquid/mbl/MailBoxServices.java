package com.adropofliquid.mbl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailBoxServices {

    @Autowired
    MailBoxRepo mailBoxRepo;

    public MessageCount getMessageCount() {
        int total = (int) mailBoxRepo.count();
        int unread = mailBoxRepo.countByIsReadIsFalse();

        return new MessageCount(unread, total);
    }

    public List<Inbox> getMinimalInbox() {

        List<Inbox> inboxes = new ArrayList<>();

        mailBoxRepo.findAll().forEach(inbox -> {
            inbox.setContent(minimizeContent(inbox.getContent()));
            inboxes.add(inbox);
        });

        return inboxes;
    }

    private String minimizeContent(String content) {
        if(content.length() > 12)
            content = content.substring(0, 12);
        return content;
    }


    public Inbox getInbox(String id) {
        return mailBoxRepo.findById(Integer.valueOf(id)).get();
    }

    public void setMailAsRead(String id) {
        Inbox inbox = getInbox(id);
        inbox.setRead(true);
        mailBoxRepo.save(inbox);
    }
}
