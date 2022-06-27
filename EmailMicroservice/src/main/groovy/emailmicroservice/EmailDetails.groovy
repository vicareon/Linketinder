package emailmicroservice

class EmailDetails {
    private String recipient;
    private String msgBody;
    private String subject;

    EmailDetails(String recipient, String msgBody, String subject) {
        this.recipient = recipient
        this.msgBody = msgBody
        this.subject = subject
    }

    EmailDetails() {
    }

    String getRecipient() {
        return recipient
    }

    void setRecipient(String recipient) {
        this.recipient = recipient
    }

    String getMsgBody() {
        return msgBody
    }

    void setMsgBody(String msgBody) {
        this.msgBody = msgBody
    }

    String getSubject() {
        return subject
    }

    void setSubject(String subject) {
        this.subject = subject
    }
}
