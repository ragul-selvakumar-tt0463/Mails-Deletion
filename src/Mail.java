// Mail.java

/**
 * Represents an email message.
 */
public class Mail {
    private String subject;
    private String body;
    private String createdTime;

    /**
     * Gets the subject of the email.
     * @return subject of the email.
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Gets the body of the email.
     * @return body of the email.
     */
    public String getBody() {
        return body;
    }

    /**
     * Gets the creation time of the email.
     * @return creation time of the email.
     */
    public String getCreatedTime() {
        return createdTime;
    }
}