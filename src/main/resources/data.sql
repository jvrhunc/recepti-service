INSERT INTO recept (created, ime, opis, tip, uporabnik_id)
        VALUES ('2020-12-1', 'Palačinke', 'Palačinke za sladek dan', 'SLAD', 1);
INSERT INTO recept (created, ime, opis, tip, uporabnik_id)
        VALUES ('2020-12-2', 'Pire krompir', 'Slastna priloga glavni jedi', 'GLAV', 1);

INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2020-12-1', 'g', 'moke', 100, 1);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2020-12-1', 'žlica', 'sladkorja', 1, 1);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2020-12-1', 'ščepca', 'soli', 2, 1);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2020-12-1', '', 'jajci', 2, 1);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2020-12-1', 'ml', 'mleka', 300, 1);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2020-12-1', 'žlica', 'olja', 1, 1);

INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2020-12-2', 'g', 'krompirja', 1200, 2);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2020-12-2', 'l', 'mleka', 1, 2);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2020-12-2', 'žlici', 'kisle smetane', 2, 2);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2020-12-2', 'žlici', 'masla', 2, 2);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2020-12-2', 'žlički', 'soli', 2, 2);
