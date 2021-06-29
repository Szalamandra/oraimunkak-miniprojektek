CREATE Database "diafilmek" character set utf8 collate utf8_hungarian_cli;

CREATE USER 'user'@'%' IDENTIFIED VIA mysql_native_password USING '***';GRANT USAGE ON *.* TO 'user'@'%' REQUIRE NONE WITH MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0;GRANT ALL PRIVILEGES ON `diafilmek`.* TO 'user'@'%';

INSERT INTO `kiado` (`id`, `nev`) VALUES
(1, 'Magyar Diafilmgyártó Vállalat'),
(2, 'Diafilmgyártó Kft'),
(3, 'Magyar Könyvkereskedelmi Vállalat'),
(4, 'Medicina Film'),
(5, 'Wspólna Sprawa Fotó és Diafilm Vállalat'),
(6, 'Medicina Könyvkiadó'),
(7, 'Magyar Fotó Dia-osztálya'),
(8, 'Állami Biztosító'),
(9, 'Egészségügyi Felvilágosító Központ'),
(10, 'Szövetkezetek Országos Szövetsége'),
(11, 'Filmtrade'),
(12, 'Magyar Szinkron és Videó Vállalat'),
(13, 'Horizont Könyv- Lap- és Zeneműterjesztő Vállalat'),
(14, 'Játéktervező Intézet'),
(15, 'Ecclesia Szövetkezet'),
(16, 'Népművelési Minisztérium'),
(17, 'Állami Könyvterjesztő Vállalat');
