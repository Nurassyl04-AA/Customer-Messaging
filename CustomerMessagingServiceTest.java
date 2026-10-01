import java.util.Map;

public class Main {
    public static void main(String[] args) {
        LegacyWhatsAppGateway legacyGateway = new LegacyWhatsAppGateway();

        MessageSenderFactory factory = new MessageSenderFactory(Map.of(
                "EMAIL", req -> new EmailSender(),
                "SMS", req -> new SmsSender(),
                "WHATSAPP", req -> new WhatsAppAdapter(legacyGateway, "CUSTOMER_TEMPLATE")
        ));

        CustomerMessagingService service = new CustomerMessagingService(factory);

        System.out.println("=== 1. Отправка Email (Transactional) ===");
        MessageRequest emailReq = new MessageRequest("EMAIL", "user@example.com", "Ваш заказ №1042 оформлен.");
        service.send(emailReq, "TRANSACTIONAL");

        System.out.println("\n=== 2. Отправка SMS (Promotional) ===");
        MessageRequest smsReq = new MessageRequest("SMS", "+77001234567", "Скидка 20% на все товары!");
        service.send(smsReq, "PROMOTIONAL");

        System.out.println("\n=== 3. Отправка через WhatsApp Adapter (Transactional) ===");
        MessageRequest waReq = new MessageRequest("WHATSAPP", "1001", "Код подтверждения: 4829");
        service.send(waReq, "TRANSACTIONAL");
    }
}
