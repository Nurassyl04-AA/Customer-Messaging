public class WhatsAppAdapter implements MessageSender {
    private final LegacyWhatsAppGateway gateway;
    private final String templateCode;

    public WhatsAppAdapter(LegacyWhatsAppGateway gateway, String templateCode) {
        this.gateway = gateway;
        this.templateCode = templateCode;
    }

    @Override
    public void send(String recipient, String message) {
        long customerId;
        try {
            customerId = Long.parseLong(recipient);
        } catch (NumberFormatException e) {
            throw new MessagingException("WhatsApp adapter error: recipient must be numeric customerId, got: " + recipient, e);
        }

        int status = gateway.dispatch(customerId, message, templateCode);
        if (status != 0) {
            throw new MessagingException("WhatsApp delivery failed with status code " + status);
        }
    }
}
