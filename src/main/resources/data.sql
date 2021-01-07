INSERT INTO recept (created, ime, opis, tip, uporabnik_id)
        VALUES ('2020-12-1', 'Tiramisu', 'Najbolje je, če tiramisu pripravimo en dan vnaprej in ga do uporabe hranimo v hladilniku...', 'SLAD', 1);
INSERT INTO recept (created, ime, opis, tip, uporabnik_id)
        VALUES ('2021-4-1', 'Wellington Pečenka a la Gordon Ramsay', 'Goveja pečenka Wellington velja za eno najboljših prazničnih jedi...', 'GLAV', 2);
INSERT INTO recept (created, ime, opis, tip, uporabnik_id)
        VALUES ('2020-1-30', 'Jota', 'Ime jota izhaja iz galske besede za juho...', 'PRED', 3);

INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2020-12-1', 'g', 'piškotov', 400, 1);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2020-12-1', 'žlice', 'kave', 3, 1);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2020-12-1', '', 'jajca', 3, 1);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2020-12-1', 'g', 'sladkorja v prahu', 100, 1);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2020-12-1', 'g', 'sira mascarpone', 500, 1);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2020-12-1', 'žlici', 'konjaka', 2, 1);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2020-12-1', 'žlica', 'naribane pomarančne lupinice', 1, 1);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2020-12-1', 'žlici', 'kakava v prahu', 2, 1);

INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2021-1-4', 'g', 'goveje pljučne pečenke', 900, 2);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2021-1-4', 'žlici', 'olivnega olja', 2, 2);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2021-1-4', 'žlica', 'gorčice', 1, 2);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2021-1-4', 'g', 'šampinjonov brez betov', 700, 2);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2021-1-4', 'strok', 'česna', 1, 2);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2021-1-4', 'pest', 'kuhanega kostanja', 1, 2);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2021-1-4', 'vejici', 'svežega timijana', 2, 2);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2021-1-4', 'rezin', 'pršuta', 8, 2);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2021-1-4', 'g', 'odmrznjenega listnatega testa', 500, 2);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2021-1-4', '', 'rumenjaka', 2, 2);

INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2020-1-30', 'g', 'zelja', 500, 3);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2020-1-30', 'g', 'krompirja', 200, 3);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2020-1-30', 'g', 'rjavega fižola', 300, 3);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2020-1-30', 'žlička', 'soli', 1, 3);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2020-1-30', '', 'lovorjeva lista', 2, 3);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2020-1-30', 'zrn', 'črnega popra', 5, 3);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2020-1-30', 'g', 'moke', 20, 3);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2020-1-30', '', 'čebula', 1, 3);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2020-1-30', 'stroki', 'česna', 3, 3);
INSERT INTO sestavina (created, enota_kolicine, ime, kolicina, recept_fk)
        VALUES ('2020-1-30', '', 'klobasi', 2, 3);
