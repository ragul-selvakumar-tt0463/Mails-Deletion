// RetentionManager.java

/**
 * Manages the retention policies for emails.
 */
public class RetentionManager {
    /**
     * Tests and deletes emails based on retention criteria.
     */
    public void testAndDelete(Mail mail) {
        if (mail == null) {
            throw new IllegalArgumentException("Mail cannot be null");
        }
        // Validation and deletion logic here
        // If valid and meets criteria, delete the mail
    }
}