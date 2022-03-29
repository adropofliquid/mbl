package com.adropofliquid.mbl;


public class MessageCount {
    private int unread;
    private int total;

    public MessageCount(int unread, int total){
        this.unread = unread;
        this.total = total;
    }

    public int getUnread() {
        return unread;
    }

    public int getTotal() {
        return total;
    }
}
