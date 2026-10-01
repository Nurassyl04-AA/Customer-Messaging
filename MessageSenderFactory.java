public class LegacyWhatsAppGateway {
    public int dispatch(long customerId, String text, String templateCode) {
        if (customerId <= 0) return 401;
        if (text == null || text.isBlank()) return 422;
        if ("BLOCKED".equals(templateCode)) return 403;
        System.out.printf("[WHATSAPP-LEGACY] customerId=%d | template=%s | %s%n", customerId, templateCode, text);
        return 0;
    }
}
