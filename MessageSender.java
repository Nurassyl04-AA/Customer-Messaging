public abstract class CustomerMessage {
    protected final MessageSender sender;

    protected CustomerMessage(MessageSender sender) {
        this.sender = sender;
    }

    public abstract void send(String recipient, String text);
}
