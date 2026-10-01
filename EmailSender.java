public class PromotionalMessage extends CustomerMessage {
    public PromotionalMessage(MessageSender sender) {
        super(sender);
    }

    @Override
    public void send(String recipient, String text) {
        sender.send(recipient, "[PROMO] " + text);
    }
}
