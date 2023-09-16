## Cервис управления колонией строгово режима (backend)
#### Назначение:
Cервис управления колонией, управление вертухаями и зк.
#### Подготовка для запуска:
Если порт 8080 на локальной машине занят тогда поменять в "docker run -d -p 8080:8080 -t topzona" изменить первый 8080 на свободный.

#### Сборка:
```
gradle clean build
```
#### Запуск:
```
gradle bootRun
```
#### Сборка в docker:
```
gradle clean build
docker build -t topzona .
docker run -d -p 8080:8080 -t topzona
```
#### Локальный порт для запуска:
8080 указываются в файле **application.yml**.
так же подключение к Базе Данных: DB_CONNECT, DB_NAME, DB_USER, DB_PASSWORD
#### Используемые технологии:
* Java 17
* Spring Boot
* Тип сервиса: REST
* PostgreSQL
* Flyway
#### Controllers в Rest контроллере http://localhost:8080/swagger-ui.html#/:
* zona-controller - управление реквезитами зоны.