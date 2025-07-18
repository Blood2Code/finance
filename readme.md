# 💰 Finance REST API

## 📌 Описание
REST API для управления пользователями, их картами и транзакциями. Пользователи могут переводить средства со своей карты на карту другого пользователя. Каждая транзакция фиксируется и влияет на баланс обеих карт.

---

## 🚀 Технологии

- Java 17
- Spring Boot 3.4.7
- Spring Data JPA
- PostgreSQL 15
- MapStruct
- Lombok
- Docker & Docker Compose

---

## 📂 Структура проекта


- `Controller` — принимает и возвращает HTTP-запросы
- `Presenter` — формирует DTO-ответы для клиента
- `Service` — бизнес-логика, транзакции, валидация
- `Repository` — работа с базой данных
- `Entity` — модели: User, Card, Transaction
- `Auditable` — автоматические created/updated поля
- `ResponseDto<T>` — единый формат ответа API

---

## 📦 Запуск проекта (через Docker)

> Требования: установлен `docker`, `docker-compose`, `maven`

### 1. Сборка проекта:
```bash
./mvnw clean package -DskipTests

docker-compose up --build
```
3. API будет доступен по адресу: `http://localhost:8080/api`
