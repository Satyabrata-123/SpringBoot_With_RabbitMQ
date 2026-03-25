# RabbitMQ Spring Boot Application

A Spring Boot application demonstrating message queuing with RabbitMQ for order processing.

## 🚀 Quick Start

### 1. Prerequisites
- Java 17+
- Maven 3.6+
- Docker

### 2. Setup
```bash
# Start RabbitMQ
docker-compose up -d

# Configure application
cp src/main/resources/application.properties.sample src/main/resources/application.properties
# Edit application.properties with your settings

# Run application
mvn spring-boot:run
```

### 3. Access
- **Application**: http://localhost:8080
- **RabbitMQ UI**: http://localhost:15672 (admin/admin123)

## 📡 API Usage

### Send Order
```bash
POST http://localhost:8080/api/order
Content-Type: application/json

{
  "id": 101,
  "name": "Test Product",
  "price": 100.0,
  "qty": 2
}
```

## 🏗️ Architecture

```
REST API → RabbitMQ Exchange → Queue → Consumer
```

- **Producer**: `RMQProducer` (REST Controller)
- **Consumer**: `RabbitMQConsumer` (@RabbitListener)
- **Queue**: `rabbit_mq_queue`
- **Exchange**: `rabbit_mq_exchange`

## 🔧 Configuration

Key settings in `application.properties`:
- RabbitMQ connection details
- Queue/Exchange names
- DevTools settings

## 🐛 Troubleshooting

**Consumer not working?**
- Check `@EnableRabbit` in main class
- Verify `@RabbitListener` is uncommented

**Connection issues?**
- Ensure Docker container is running: `docker ps`
- Check RabbitMQ logs: `docker logs rabbitmq`

## 📝 Testing

1. **With Consumer**: Messages processed immediately
2. **Without Consumer**: Comment `@RabbitListener` to see messages in RabbitMQ UI

---
**Happy Messaging! 🐰**