# Recepti-service
 
 ### Konfiguracija
 
 Konfiguracija projekta se nahaja v https://github.com/jvrhunc/config-repo in sicer:
 - ```recepti-service-local``` (konfiguracija za lokalno okolje)
 - ```recepti-service-dev``` (konfiguracija za razvojno okolje)
 - ```recepti-service-prod``` (konfiguracija za produkcijsko okolje)
 
 ### Lokalno testiranje
 
- Pognati je potrebno podatkovno bazo (SQL) na portu 3306:
``` docker run --name mysql-recepti -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=recepti_db -p 3306:3306 -d mysql:latest ```

- Nato lahko aplikacijo zaženemo z zagonom Recepti Application ali z ukazom ```mvn clean package -DskipTests && java -jar target/recepti-service.jar ```

### Dockerfile

- Dockerfile iz zbrane kode zgradi jar datoteko in jo shrani v ```target/recepti-service.jar```
    - zaženemo ga z ukazom ```docker build - -t <ime_slike>```

### CI / CD

Status Travic CI-ja : [![Build Status](https://travis-ci.com/jvrhunc/recepti-service.svg)](https://travis-ci.com/jvrhunc/recepti-service)

- Za continous integration uporabljen Travis CI/CD

- Ko karkoli pushamo v repozitorij recepti-service se:
    - avtomatsko poženejo ukazi iz datoteke ```.travis.yml```
    - ukazi zgradijo projekt (```Dockerfile```) in naredijo novo sliko z unikatnim tag-om
    - sliko pushajo na Docker Hub
    
Najnovejšo sliko pri sebi pridobimo z ukazom : ```docker pull jvrhunc/recepti-service:latest```

Za zagon aplikacije je potrebno imeti pognano podatkovno bazo ```mysql-recepti``` na 3306 in pognati ukaz : ```docker run -p 8081:8081 --name recepti-service --link mysql-recepti -d jvrhunc/recepti-service```

Aplikacija je nato dostopna na: ```localhost:8081```
