# Recepti-service
 
 ### Konfiguracija

 
 ### Lokalno testiranje
 
- Pognati je potrebno podatkovno bazo (Postgres SQL) na portu 5432:
``` docker run --name recepti-db --network rso-project -e POSTGRES_PASSWORD=root -e POSTGRES_DB=recepti-db -p 5432:5432 -d postgres ```

- Nato lahko aplikacijo zaženemo z zagonom Recepti Application ali z ukazom ```mvn clean package -DskipTests && java -jar target/recepti-service.jar ```

### Dockerfile

- Dockerfile iz zbrane kode zgradi jar datoteko in jo shrani v ```target/recepti-service.jar```, nato zgradi sliko kot docker image.
    - zaženemo ga z ukazom ```docker build - -t <ime_slike>```

### CI / CD

Status Travic CI-ja : [![Build Status](https://travis-ci.com/jvrhunc/recepti-service.svg)](https://travis-ci.com/jvrhunc/recepti-service)

- Za continous integration uporabljen Travis CI/CD

- Ko karkoli pushamo v repozitorij recepti-service se:
    - avtomatsko poženejo ukazi iz datoteke ```.travis.yml```
    - ukazi zgradijo projekt (```Dockerfile```) in naredijo novo sliko z unikatnim tag-om
    - sliko pushajo na Docker Hub (repozitorij: ```jvrhunc/recepti-service```)
    
Najnovejšo sliko pri sebi pridobimo z ukazom : ```docker pull jvrhunc/recepti-service:latest```

Za zagon aplikacije je potrebno imeti pognano podatkovno bazo ```recepti-db``` na ```5432``` v networku ```rso-project``` in pognati ukaz : ```docker run -p 8081:8081 --name recepti-service --net rso-project -d jvrhunc/recepti-service```

Aplikacija je nato dostopna na: ```localhost:8081```

### Health in Metrics

### Kubernetes
