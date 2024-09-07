# Spring-boot-PostgreSQL-Liquibase-Docker
#Wallet Service
#Описание

Приложение предоставляет REST API для управления кошельками. Вы можете выполнять операции пополнения и снятия средств, а также получать текущий баланс кошелька. Написаны миграции для базы данных с помощью liquibase. Предусмотрен формата ответа для заведомо неверных запросов, когда кошелька не существует, не валидный json, или недостаточно средств. Приложение запускается в докер контейнере, база данных тоже, вся система должна поднимается с помощью docker-compose.

#Технологический стек
Java 17
Spring Boot 3
Spring Data JPA
PostgreSQL
Liquibase
Docker
Docker Compose
JUnit 5
Maven
Swagger ui
#Эндпоинты

Документация, доступная по ссылке: http://localhost:8080/swagger-ui. А также есть OAS, доступный по адресу: http://localhost:8080/v3/api-docs.

GET /api/v1/wallets/{WALLET_ID}
Возвращает баланс указанного кошелька.

Response
{
"walletId": "UUID",
"balance": 1000
}

POST /api/v1/wallet
Выполняет операцию над кошельком.

Request
{
"walletId": "UUID",
"operationType": "DEPOSIT or WITHDRAW",
"amount": 1000
}
Response
{
"message": "Выполнение операции успешно завершено!"
}
#Как запустить проект
Предварительные требования
Перед тем как запустить проект, убедитесь, что у вас установлены следующие инструменты:

Docker: Для контейнеризации приложения и базы данных. Установите Docker с официального сайта docker.com.
Docker Compose: Для упрощения работы с несколькими контейнерами. Установите Docker Compose с официального сайта docs.docker.com/compose.
Запуск
Клонируйте репозиторий:

git clone (https://github.com/reshetnikovdimmi/Spring-boot-PostgreSQL-Liquibase-Docker.git)

Соберите и запустите контейнеры с помощью Docker Compose:

docker-compose up
Эта команда выполнит следующие действия:

Создаст и запустит контейнеры для приложения и базы данных.
Применит миграции базы данных через Liquibase.
Приложение будет доступно по адресу http://localhost:8080.
Конфигурация
Все конфигурационные параметры для приложения и базы данных находятся в файлах:

src/main/resources/application.properties - Конфигурация Spring Boot приложения.
docker-compose.yml - Конфигурация Docker Compose для настройки контейнеров.


#Миграции базы данных
Миграции базы данных выполняются автоматически при запуске приложения с помощью Liquibase. Скрипты миграций расположены в папке src/main/resources/db/changelog.

#Обработка ошибок
Ошибки возвращаются в формате XML и содержат следующие поля:

error_code - Код ошибки.
timestamp - Время возникновения ошибки.
description - Описание ошибки.
tip - Рекомендации по исправлению ошибки.
