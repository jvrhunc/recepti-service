﻿# Recepti-service

Pognati je potrebno podatkovno bazo (SQL) na portu 3306:
``` docker run --name mysql-recepti -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=recepti_db -p 3306:3306 -d mysql:latest ```
