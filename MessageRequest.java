public class SmsSender implements MessageSender {
    @Override
    public void send(String recipient, String message) {
        System.out.printf("[SMS] To: %s | %s%n", recipient, message);
    }
}
