public class CustomerMessagingService {
    private final MessageSenderFactory factory;

    public CustomerMessagingService(MessageSenderFactory factory) {
        this.factory = factory;
    }

    public void send(MessageRequest request, String messageType) {
        var sender = factory.create(request);
        CustomerMessage abstraction = switch (messageType.toUpperCase()) {
            case "TRANSACTIONAL" -> new TransactionalMessage(sender);
            case "PROMOTIONAL" -> new PromotionalMessage(sender);
            default -> throw new IllegalArgumentException("Unsupported message type: " + messageType);
        };
        abstraction.send(request.recipient(), request.text());
    }
}
