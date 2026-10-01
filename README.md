# Customer Messaging — Bridge + Adapter

## Run
```bash
mvn test
```

## Domain
A customer messaging service sends transactional and promotional messages through multiple channels: Email, SMS, and a legacy WhatsApp gateway.

## Bridge
- Abstraction: `CustomerMessage`
- Refined Abstractions: `TransactionalMessage`, `PromotionalMessage`
- Implementor: `MessageSender`
- Concrete Implementors: `EmailSender`, `SmsSender`, `WhatsAppAdapter`

## Adapter
`LegacyWhatsAppGateway` is intentionally incompatible. `WhatsAppAdapter` converts it to `MessageSender`.

## Complexity module
Dynamic implementor selection via `MessageSenderFactory`.
