public class EmailSender implements MessageSender {
    @Override
    public void send(String recipient, String message) {
        System.out.printf("[EMAIL] To: %s | %s%n", recipient, message);
    }
}
