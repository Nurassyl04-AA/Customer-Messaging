import java.util.Map;
import java.util.function.Function;

public class MessageSenderFactory {
    private final Map<String, Function<MessageRequest, MessageSender>> creators;

    public MessageSenderFactory(Map<String, Function<MessageRequest, MessageSender>> creators) {
        this.creators = Map.copyOf(creators);
    }

    public MessageSender create(MessageRequest request) {
        var creator = creators.get(request.channel().toUpperCase());
        if (creator == null) throw new IllegalArgumentException("Unsupported channel: " + request.channel());
        return creator.apply(request);
    }
}
