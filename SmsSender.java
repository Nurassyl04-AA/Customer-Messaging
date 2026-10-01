public class TransactionalMessage extends CustomerMessage {
    public TransactionalMessage(MessageSender sender) {
        super(sender);
    }

    @Override
    public void send(String recipient, String text) {
        sender.send(recipient, "[TRANSACTIONAL] " + text);
    }
}
