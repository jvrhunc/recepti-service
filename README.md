# Recepti-service
 
 ### Lokalno testiranje
 
- Pognati je potrebno podatkovno bazo (SQL) na portu 3306:
``` docker run --name mysql-recepti -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=recepti_db -p 3306:3306 -d mysql:latest ```

- V application.properties je potrebno polje ```spring.datasource.urls``` spremeniti v: ```jdbc:mysql://localhost:3306/recepti_db?allowPublicKeyRetrieval=true&useSSL=false```

- Nato lahko aplikacijo zaženemo z zagonom Recepti Application ali z ukazom ```mvn clean package -DskipTests && java -jar target/recepti-service.jar ```

### Dockerfile in docker-compose.yml

- Dockerfile iz zbrane kode zgradi jar datoteko in jo shrani v ```target/recepti-service.jar```
    - zaženemo ga z ukazom ```docker build - -t <ime_slike>```
- docker-compose.yml vsebuje kodo za povezovanje docker slike aplikacije in docker slike podatkovne baze MySQL
    - zaženemo ga z ukazom ```docker-compose up```
    - ko je zagnan imamo na portu 8081 delujočo aplikacijo

### CI / CD

Status Travic CI-ja : [![Build Status](https://travis-ci.com/jvrhunc/recepti-service.svg)](https://travis-ci.com/jvrhunc/recepti-service)

- Za continous integration uporabljen Travis CI/CD

- Ko karkoli pushamo v repozitorij recepti-service se:
    - avtomatsko poženejo ukazi iz datoteke ```.travis.yml```
    - ukazi zgradijo projekt (```Dockerfile```) in naredijo novo sliko z unikatnim tag-om
    - sliko pushajo na Docker Hub
