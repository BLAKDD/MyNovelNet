package edu.njit.mynovelnet.myutil;

public class Message {
    private Integer status;
    private String content;

    private Message() {
    }

    public static Message setMessage(Integer status, String msg) {
        Message r = new Message();
        r.setStatus(status);
        r.setContent(msg);
        return r;
    }

    public Integer getStatus() {
        return status;
    }

    private void setStatus(Integer status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    private void setContent(String content) {
        this.content = content;
    }
}
