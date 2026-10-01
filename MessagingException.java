public record MessageRequest(String channel, String recipient, String text) {
    public MessageRequest {
        if (channel == null || channel.isBlank()) throw new IllegalArgumentException("channel is required");
        if (recipient == null || recipient.isBlank()) throw new IllegalArgumentException("recipient is required");
        if (text == null || text.isBlank()) throw new IllegalArgumentException("text is required");
    }
}
