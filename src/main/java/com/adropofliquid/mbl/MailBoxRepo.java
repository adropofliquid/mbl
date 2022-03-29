package com.adropofliquid.mbl;

import org.springframework.data.repository.CrudRepository;

public interface MailBoxRepo extends CrudRepository<Inbox, Integer> {

    int countByIsReadIsFalse();

}