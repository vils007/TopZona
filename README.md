## Cервис управления колонией строгово режима (backend)
#### Назначение:
Cервис управления колонией, управление вертухаями и зк.
#### Подготовка для запуска:
Если порт 8080 на локальной машине занят тогда поменять в "docker run -d -p 8080:8080 -t topzona:0.0.1-SNAPSHOT" изменить первый 8080 на свободный.

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
docker build -t myorg/myapp
docker run -p 8080:8080 myorg/myapp 
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