-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: wildpath
-- ------------------------------------------------------
-- Server version	8.0.37

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (2,'2025-07-04 00:00:00.000000','2025-05-31',1,'CONFIRMED',1,1,26,NULL),(29,'2025-07-15 00:00:00.000000','2025-08-22',1,'CONFIRMED',8,4,26,NULL),(30,'2025-07-16 19:10:48.594325','2025-08-22',1,'CONFIRMED',8,4,26,NULL),(31,'2025-07-19 21:20:06.439607','2025-08-22',1,'CONFIRMED',8,4,27,NULL),(32,'2025-08-01 15:31:22.991832','2025-08-22',1,'PENDING',8,4,7,'cf538eb7-2ebd-4e10-a9c9-560df8c949e8');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Ciclismo / Mountain Bike','¿Buscas desafiar tus límites y conectar con la naturaleza a tu propio ritmo? Sumérgete en paisajes impresionantes, desde senderos sinuosos en frondosos bosques hasta desafiantes rutas de montaña con vistas panorámicas que te dejarán sin aliento. Explora caminos rurales llenos de encanto, conquista cumbres épicas en tu bicicleta de montaña o simplemente disfruta de un paseo relajado con amigos y familia.','/uploads/categories/6030ce5f-02f8-49cc-bf8d-ae8d67e7b5a3_mountain-bike.webp'),(2,'Parapente','Siente la libertad de surcar el cielo impulsado por el viento. Contempla paisajes espectaculares desde una perspectiva única y experimenta la serenidad de planear suavemente. El parapente te ofrece una sensación inigualable de libertad y la oportunidad de ver el mundo con ojos nuevos.','/uploads/categories/5bb76831-f76b-456a-95d5-31f0f0703a1e_parapente.webp'),(3,'Esquí','Vive la emoción de deslizarte por pistas nevadas, siente el aire fresco en tu rostro y maravíllate con la belleza del paisaje invernal. Ya seas principiante o experto, el esquí te brinda aventura, diversión y recuerdos inolvidables en un entorno mágico.','/uploads/categories/a37fd6dd-e557-445e-a618-b291796aa650_esqui.webp'),(4,'Senderismo / Trekking','Sumérgete en la belleza natural, descubre senderos ocultos y siente el ritmo de la tierra bajo tus pies. Desde paseos tranquilos hasta desafiantes travesías, el senderismo / trekking te invita a explorar paisajes asombrosos y a encontrar la paz en cada paso.','/uploads/categories/ec51749d-f6b3-4766-aa40-882a7403bbae_trekking.webp'),(5,'Campamento / Camping','Escapa de la rutina y sumérgete en la tranquilidad de la naturaleza. Duerme bajo un manto de estrellas, despierta con el canto de los pájaros y comparte momentos inolvidables alrededor de una fogata. El campamento / camping te ofrece la oportunidad de relajarte, reconectar con tus seres queridos y disfrutar de la simpleza de la vida al aire libre.','/uploads/categories/13ce1887-7160-4d16-a5c8-8dad3c3b6420_camping.webp'),(6,'Cabalgata','Experimenta la naturaleza desde una perspectiva diferente mientras te conectas con un noble compañero. Recorre senderos escénicos, siente el ritmo del galope y disfruta de una sensación única de libertad y aventura. La cabalgata riding te brinda una forma atemporal de explorar el entorno y crear recuerdos especiales.','/uploads/categories/208c0bb1-6c45-404c-b2be-4b6c99cfee69_cabalgata.webp'),(7,'Canotaje / Rafting','Siente la emoción de navegar por aguas turbulentas rodeado de paisajes impresionantes. El trabajo en equipo, la adrenalina y la fuerza del río se combinan para una experiencia inolvidable. El canotaje / rafting te llama a desafiar las corrientes y a vivir una aventura acuática emocionante.','/uploads/categories/15a7e66d-fbde-4ce6-a3b1-80cfabb78349_rafting.webp'),(8,'Escalada / Climbing','¿Te atrae la idea de superar obstáculos y alcanzar nuevas alturas, tanto físicas como personales? La escalada te reta a combinar fuerza, estrategia y concentración mientras te conectas con la roca y el entorno que te rodea. Desde imponentes paredes naturales hasta rutas deportivas en entornos controlados, cada ascenso es una experiencia única de superación y aventura. Siente la adrenalina al conquistar cada agarre, disfruta de vistas incomparables desde lo más alto y descubre lo que eres capaz de lograr con cada movimiento hacia la cima.','/uploads/categories/3409fd02-24f2-4734-b91e-2feb7c50f78c_climbing.webp');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `date_available`
--

LOCK TABLES `date_available` WRITE;
/*!40000 ALTER TABLE `date_available` DISABLE KEYS */;
INSERT INTO `date_available` VALUES (1,1,'2025-08-16',21),(2,1,'2025-08-15',29),(3,1,'2025-05-31',20),(4,1,'2025-06-01',14),(5,2,'2025-08-16',11),(6,2,'2025-08-15',22),(7,2,'2025-06-01',16),(8,4,'2025-08-22',4),(9,4,'2025-06-01',10),(10,4,'2025-06-14',7),(11,4,'2025-06-22',5),(20,16,'2025-06-20',26),(21,16,'2025-08-22',31),(22,16,'2025-07-04',18),(24,35,'2025-07-04',8),(25,35,'2025-07-05',8),(26,35,'2025-07-11',8),(27,35,'2025-07-12',8),(28,35,'2025-07-18',8),(29,35,'2025-07-19',7),(30,35,'2025-07-25',7),(31,35,'2025-07-26',7),(32,35,'2025-08-01',8),(33,35,'2025-08-02',8),(34,35,'2025-08-08',8),(35,35,'2025-08-09',7),(36,35,'2025-08-15',8),(37,35,'2025-08-16',7),(38,35,'2025-08-22',8),(39,35,'2025-08-23',8),(40,35,'2025-08-29',8),(41,35,'2025-08-30',8);
/*!40000 ALTER TABLE `date_available` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `enterprises`
--

LOCK TABLES `enterprises` WRITE;
/*!40000 ALTER TABLE `enterprises` DISABLE KEYS */;
INSERT INTO `enterprises` VALUES (1,'Aventura Andina Extrema S.R.L.','30-77788899-1','info@aventuraandinaextrema.com','+54 261 4332211','Ruta Provincial 82 km 25, Luján de Cuyo, Mendoza',NULL,'Especialistas en experiencias de montaña en la Cordillera de los Andes. Ofrecemos trekking de diferentes niveles, cabalgatas escénicas y ascensos a cumbres emblemáticas en la región de Mendoza.'),(2,'Patagonia Rafting & Expediciones E.V.T.','30-99900011-2','reservas@patagoniarafting.com','+54 294 4523456','Av. Costanera s/n, San Martín de los Andes, Neuquén',NULL,'Empresa líder en rafting y expediciones fluviales en la Patagonia Norte. Disfruta de emocionantes descensos por ríos de aguas cristalinas y campamentos a orillas de paisajes inolvidables.'),(3,'Cielo Azul Parapente S.A.','30-11122233-3','vuelos@cieloazulparapente.com.ar','+54 223 4778899','Av. Félix U. Camet 1500, Mar del Plata, Buenos Aires',NULL,'Vive la adrenalina de volar en parapente biplaza sobre las playas de Mar del Plata. También ofrecemos emocionantes circuitos de mountain bike por los alrededores de la ciudad.'),(8,'Aventura Andina','30-12345678-9','contacto@aventuraandina.com','+54 9 261 555 1234','Av. de los Cóndores 1200, Mendoza, Argentina','@aventura.andina','Empresa dedicada a experiencias de turismo aventura en la región andina, con más de 10 años de trayectoria.');
/*!40000 ALTER TABLE `enterprises` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `favorites`
--

LOCK TABLES `favorites` WRITE;
/*!40000 ALTER TABLE `favorites` DISABLE KEYS */;
INSERT INTO `favorites` VALUES (28,4,26),(29,2,26),(35,1,26),(37,1,27),(40,1,7);
/*!40000 ALTER TABLE `favorites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `images`
--

LOCK TABLES `images` WRITE;
/*!40000 ALTER TABLE `images` DISABLE KEYS */;
INSERT INTO `images` VALUES (1,'/uploads/packages/2839260b-aa3b-4a31-b16a-d6609bd357ba_trekking-aconcagua.webp',1,'trekking-aconcagua.webp'),(2,'/uploads/packages/4369ba49-cfe4-4272-8b77-c15fbd678e98_trekking-aconcagua2.webp',1,'trekking-aconcagua2.webp'),(3,'/uploads/packages/ffbac10c-10a0-4655-8a06-5214f1c04dad_trekking-aconcagua3.webp',1,'trekking-aconcagua3.webp'),(4,'/uploads/packages/f8d26fc4-56ab-447a-8853-b0f849c859a2_trekking-aconcagua4.webp',1,'trekking-aconcagua4.webp'),(5,'/uploads/packages/0d33da5a-316b-4be0-beeb-2838f194178d_trekking-aconcagua5.webp',1,'trekking-aconcagua5.webp'),(6,'/uploads/packages/1f6c3317-7d3f-43a7-83d6-2a4f318a5b43_trekking-aconcagua6.webp',1,'trekking-aconcagua6.webp'),(7,'/uploads/packages/7a65e98c-cc08-4022-b009-0bf7c1b3f56d_rafting-riomanso.webp',2,'rafting-riomanso.webp'),(8,'/uploads/packages/2867dd9c-876f-4af2-917b-c7cbcb654c57_rafting-riomanso2.webp',2,'rafting-riomanso2.webp'),(9,'/uploads/packages/4bc8247c-adcb-44d0-88d1-fd740e225591_rafting-riomanso3.webp',2,'rafting-riomanso3.webp'),(10,'/uploads/packages/1b55ea77-ee70-492c-817a-93e3b51eecec_rafting-riomanso4.webp',2,'rafting-riomanso4.webp'),(11,'/uploads/packages/17efaf95-3f76-43a6-96a1-45dc4c2159c4_rafting-riomanso5.webp',2,'rafting-riomanso5.webp'),(12,'/uploads/packages/de02edde-c24f-470a-b87e-9a25b1861e34_rafting-riomanso6.webp',2,'rafting-riomanso6.webp'),(13,'/uploads/packages/119145e7-1660-49ae-9ca1-7f31587bcbd1_parapente-mar-del-plata.webp',4,'parapente-mar-del-plata.webp'),(14,'/uploads/packages/881bdb61-3f57-4657-8d35-0da471fb0154_parapente-mar-del-plata2.webp',4,'parapente-mar-del-plata2.webp'),(15,'/uploads/packages/dc402611-0068-46e2-8ce0-37fb9fd549e4_parapente-mar-del-plata3.webp',4,'parapente-mar-del-plata3.webp'),(16,'/uploads/packages/78725714-6807-4f35-b093-cf9ee16ba3ca_parapente-mar-del-plata4.webp',4,'parapente-mar-del-plata4.webp'),(17,'/uploads/packages/ed380496-02f1-468c-8bcc-cc3c6686a975_parapente-mar-del-plata5.webp',4,'parapente-mar-del-plata5.webp'),(18,'/uploads/packages/38f6e4a0-52b6-40dd-bf87-d03c236d35a2_parapente-mar-del-plata6.webp',4,'parapente-mar-del-plata6.webp'),(34,'/uploads/packages/2b27464d-000d-48d0-9ebd-8db02d41425c_campamento-perito-moreno1.webp',16,'campamento-perito-moreno1.webp'),(35,'/uploads/packages/f20ff834-17a8-41a8-8da1-de2e9ba0d3ed_campamento-perito-moreno3.webp',16,'campamento-perito-moreno3.webp'),(36,'/uploads/packages/07380e64-f30e-4070-90ba-88ce0fcbec5b_campamento-perito-moreno4.webp',16,'campamento-perito-moreno4.webp'),(37,'/uploads/packages/c5c0ca37-0373-4a92-9563-97abe6881a0a_campamento-perito-moreno5.webp',16,'campamento-perito-moreno5.webp'),(38,'/uploads/packages/d5dd5403-e1e3-4c2d-bbfb-1008787196be_campamento-perito-moreno.webp',16,'campamento-perito-moreno.webp'),(39,'/uploads/packages/5c0ec2bb-b744-4c8d-9bdb-f861d9dbdf50_campamento-perito-moreno2.webp',16,'campamento-perito-moreno2.webp'),(98,'/uploads/packages/b0600d2f-f12c-4383-b67e-5b37c5bba55f_CabalgataViñedo1.webp',35,'CabalgataViñedo1.webp'),(99,'/uploads/packages/ab60f47c-fb2f-4a95-bb04-a39ff847eb39_CabalgataViñedo2.webp',35,'CabalgataViñedo2.webp'),(100,'/uploads/packages/be2024f2-600d-4517-86bc-b7a8749e1ee3_CabalgataViñedo3.webp',35,'CabalgataViñedo3.webp'),(101,'/uploads/packages/8e2d9d17-1055-4601-9a5a-a0dd3759e5ce_CabalgataViñedo4.webp',35,'CabalgataViñedo4.webp'),(102,'/uploads/packages/1deb50f1-6b84-46e8-b557-83a0b81f51b4_CabalgataViñedo5.webp',35,'CabalgataViñedo5.webp');
/*!40000 ALTER TABLE `images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `package_includes`
--

LOCK TABLES `package_includes` WRITE;
/*!40000 ALTER TABLE `package_includes` DISABLE KEYS */;
INSERT INTO `package_includes` VALUES (1,1,'Guía de montaña bilingüe','/uploads/icons/19cf88de-037c-437b-99a3-9a2b1c21fd99_idioma.webp'),(2,1,'Equipo básico de trekking (bastones)','/uploads/icons/c70ec0c5-b36b-4ce6-9faf-93c839f37902_trekking-stiks.webp'),(3,1,'Alojamiento en refugio de montaña (2 noches)','/uploads/icons/a2820143-444c-48c7-9966-ece9e33d2fe5_alojamiento.webp'),(4,1,'Comidas mencionadas en el itinerario (2 desayunos, 2 cenas)','/uploads/icons/57ac8b8e-901c-4f4c-8d5c-eb40343f1977_food.webp'),(5,2,'Equipamiento completo de rafting (casco, chaleco salvavidas, remo)','/uploads/icons/a24da698-e390-400b-a750-44aca79994bf_remos.webp'),(6,2,'Guías de rafting profesionales','/uploads/icons/448cb459-a130-415a-9556-2e1d0d475f87_instructor.webp'),(7,2,'Almuerzo tipo picnic a orillas del río','/uploads/icons/32255740-ed64-4cef-aa51-f981401441e4_food.webp'),(8,2,'Seguro de actividad','/uploads/icons/4862935a-45ff-4d11-974f-9f25f3d6626d_secure.webp'),(9,4,'Vuelo en parapente biplaza con instructor certificado','/uploads/icons/7b019cdf-bfd4-4b71-b7bd-1910f4e80997_instructor.webp'),(10,4,'Equipo de vuelo completo (casco, arnés)','/uploads/icons/83b4aca6-9641-4718-b67f-f0666d5687e4_vuelo-parapente.webp'),(11,4,'Seguro de responsabilidad civil','/uploads/icons/5bc3a0b3-04d4-4785-937e-1edb0ba7f8a9_secure.webp'),(24,16,'Guía de montaña certificado','/uploads/icons/19e686f6-0881-4b88-acc9-6b648932d425_instructor.webp'),(25,16,'Traslados desde El Calafate al Glaciar','/uploads/icons/1d488d63-70f1-4150-8a5a-ec7cc4971ef4_bus.webp'),(26,16,'Equipo de seguridad para trekking en hielo (grampones)','/uploads/icons/926de5bb-de09-4b27-a392-1210f647657b_crampones.webp'),(27,16,'Alojamiento en domo geodésico equipado (1 noche)','/uploads/icons/18861d51-a17f-4d2c-89f5-1516470c412e_alojamiento.webp'),(28,16,'Cena y desayuno en el campamento de domos','/uploads/icons/6982b141-651c-41e2-8458-a5c9bd55d4d5_food.webp'),(42,20,'Equipo completo de esquí (botas, esquíes y bastones)','/uploads/icons/b43d85d6-32d8-42bd-976b-be7915a6ea7c_ski-kit.webp'),(43,20,'Pase diario a las pistas de Penitentes','/uploads/icons/9766f8c6-3655-416b-a957-8212bee89cf6_ticket.webp'),(44,20,'Clase grupal con instructor certificado','/uploads/icons/62aaa64a-4ef1-4071-9089-bb6ec31b916f_trainer.webp'),(45,20,'Almuerzo en parador de montaña','/uploads/icons/f644d179-5476-4e8e-9923-e6a93af96b71_food.webp'),(46,20,'Seguro de accidentes para actividades invernales','/uploads/icons/ea218ee5-b099-4590-8ccb-61ccb4de25d6_secure.webp'),(47,20,'Traslado ida y vuelta desde Luján de Cuyo','/uploads/icons/246729c1-6da1-438e-89af-e2d142316b4d_bus.webp'),(87,35,'Caballo y montura adecuados al nivel del jinete','/uploads/icons/bcdb1790-42ab-430a-b760-0d3a0bc57ea0_horse.webp'),(88,35,'Guía baqueano local\"','/uploads/icons/f6a18201-7c0f-40f7-b8e8-09f0b663fcbb_trainer.webp'),(89,35,'Degustación de vinos y productos regionales','/uploads/icons/e94be45d-0023-429d-adb3-8ed0d69d9d97_wine-cup.webp'),(90,35,'Casco protector (opcional)','/uploads/icons/35bcb3f7-d47a-48cb-86fd-9cd16d4e3fe9_helmet-cab.webp'),(91,35,'Seguro de responsabilidad civil','/uploads/icons/6f7ad4f1-3f71-4e1a-8cb5-ead63a458e97_secure.webp');
/*!40000 ALTER TABLE `package_includes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `package_itineraries`
--

LOCK TABLES `package_itineraries` WRITE;
/*!40000 ALTER TABLE `package_itineraries` DISABLE KEYS */;
/*!40000 ALTER TABLE `package_itineraries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `package_no_includes`
--

LOCK TABLES `package_no_includes` WRITE;
/*!40000 ALTER TABLE `package_no_includes` DISABLE KEYS */;
/*!40000 ALTER TABLE `package_no_includes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `packages`
--

LOCK TABLES `packages` WRITE;
/*!40000 ALTER TABLE `packages` DISABLE KEYS */;
INSERT INTO `packages` VALUES (1,'Trekking Aconcagua Básico',4,2,'PT72H','Una introducción al trekking de montaña en los senderos cercanos al majestuoso Cerro Aconcagua. Disfruta de paisajes imponentes y la flora y fauna local.',0.00,0.00,'Parque Provincial Aconcagua, Mendoza',150.00,'principiante','10% para grupos de 4 o más','Reembolso del 80% cancelando hasta 7 días antes del inicio.',1,1,NULL,NULL,NULL,2),(2,'Rafting Río Manso Inferior',7,4,'PT24H','¡Prepárense para una jornada llena de emoción y paisajes increíbles en el corazón de la Patagonia! Este paquete de rafting en el Río Manso Inferior está pensado para amantes de la aventura, grupos de amigos y familias que buscan una experiencia de pura adrenalina en contacto con la naturaleza. Navegarán por rápidos emocionantes y disfrutarán de la belleza del entorno, con bosques frondosos y aguas cristalinas. Nuestros guías expertos garantizarán una experiencia segura y divertida. Se incluye un delicioso almuerzo tipo picnic a orillas del río para recargar energías. ¡Una aventura inolvidable en uno de los ríos más hermosos de la Patagonia!',0.00,0.00,'Río Manso Inferior, cerca de Bariloche, Río Negro',119.00,'intermedio','5% para reservas anticipadas (30 días)','Reembolso del 70% cancelando hasta 5 días antes del inicio.',2,1,NULL,NULL,NULL,NULL),(4,'Parapente en Mar del Plata',2,1,'PT20M','¿Sueñas con volar como un pájaro y contemplar la costa desde una perspectiva única? Este paquete de parapente biplaza es la oportunidad perfecta para experimentar la increíble sensación de libertad y disfrutar de vistas panorámicas inigualables de las playas de Mar del Plata. Ideal para viajeros solitarios, parejas y amigos que buscan una dosis de adrenalina y belleza escénica. Junto a un instructor certificado, despegarás suavemente y planearás sobre el mar, disfrutando de la brisa y el paisaje costero. ¡Una experiencia emocionante y segura que te dejará recuerdos imborrables de la \"Feliz\"!',0.00,0.00,'Playa Waikiki, Mar del Plata, Buenos Aires',90.00,'principiante','15% para residentes locales (presentando DNI)','Re-programación sin costo con aviso de 24 horas. No se realizan reembolsos por no presentación.',3,1,NULL,NULL,NULL,NULL),(16,'Campamento Domos Glaciar Perito Moreno',5,3,'PT48H','Experimenta la majestuosidad del Glaciar Perito Moreno con el confort de un campamento en domos geodésicos. Este paquete está pensado para amantes de la naturaleza que buscan una conexión profunda con el entorno glacial sin sacrificar la comodidad, ideal para parejas, familias o grupos de amigos. Disfruta de una caminata guiada sobre el hielo (minitrekking) y una noche única en un domo cálido y acogedor, con vistas privilegiadas al glaciar y la posibilidad de observar el increíble cielo patagónico. Una aventura inolvidable que combina la grandiosidad natural con el confort de un alojamiento exclusivo.',0.00,0.00,'Parque Nacional Los Glaciares, El Calafate, Santa Cruz',450.00,'intermedio','5% si reservas con 60 días de anticipación','Reembolso del 75% cancelando hasta 15 días antes. No hay reembolso con menos de 7 días de anticipación.',1,1,NULL,NULL,NULL,NULL),(20,'Día de Esquí en Penitentes',3,3,'PT24H','¡Disfrutá de la nieve como nunca antes! Este paquete de esquí está diseñado para quienes quieren pasar un día completo en la nieve, ya sea aprendiendo desde cero o perfeccionando su técnica. Nos trasladamos desde Luján de Cuyo al centro de esquí Penitentes, ubicado en plena Cordillera de los Andes. Incluye pase diario a pistas, alquiler de equipo completo y una clase grupal con instructores certificados. A mitad del día, hacemos una pausa para almorzar con una vista increíble de la montaña. Ideal para familias, parejas o grupos de amigos que buscan aventura y diversión en la nieve.',0.00,0.00,'Centro de Esquí Penitentes, Mendoza',145.00,'principiante','10% para reservas anticipadas (20 días)','Reembolso del 80% cancelando hasta 7 días antes del inicio.',8,1,NULL,NULL,NULL,1),(35,'Cabalgata entre Viñedos y Montañas',6,5,'PT4H','Viví una experiencia auténtica recorriendo los paisajes del Valle de Uco a caballo. Esta cabalgata guiada es ideal para quienes buscan un paseo tranquilo entre viñedos, arroyos y montañas, con paradas para tomar fotografías y disfrutar del aire puro de la cordillera. A mitad del recorrido, se ofrece una degustación de vinos y productos regionales en una bodega local. Nuestros guías baqueanos te acompañarán durante toda la actividad garantizando seguridad y conexión con la naturaleza.',0.00,0.00,'Valle de Uco, Mendoza',75.00,'principiante','15% para grupos de 4 o más personas','Reembolso del 100% cancelando hasta 3 días antes del inicio.',8,1,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `packages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `places`
--

LOCK TABLES `places` WRITE;
/*!40000 ALTER TABLE `places` DISABLE KEYS */;
INSERT INTO `places` VALUES (1,'Playa','Siente la caricia cálida del sol en tu piel y la suave caricia de la arena bajo tus pies. Escucha el eterno vaivén de las olas, un sonido que aquieta la mente y relaja el alma. Sumérgete en aguas refrescantes y contempla atardeceres que pintan el horizonte de colores inolvidables. ¡La playa es tu refugio de serenidad y alegría!','/uploads/places/161baff1-f65d-46da-80ea-296cf1963cd0_playa.webp'),(2,'Montaña','Eleva tu espíritu hacia cumbres imponentes y admira la grandiosidad de paisajes que te dejarán sin aliento. Respira el aire puro de la altura, siente la emoción de la aventura en cada sendero y descubre la fuerza que reside en ti. ¡La montaña te invita a superar tus límites y alcanzar nuevas perspectivas!','/uploads/places/3ae240ec-a399-4623-9300-b2094a2acda6_montaña.webp'),(3,'Nieve','Deslízate sobre mantos inmaculados, siente la adrenalina de los deportes invernales y maravíllate con la belleza cristalina de un paisaje nevado. Construye recuerdos inolvidables en un entorno mágico donde la diversión y la tranquilidad se entrelazan. ¡La nieve te espera para vivir experiencias únicas y emocionantes!','/uploads/places/05d2f37f-8bf4-4f29-b19f-23cc145f5194_nieve.webp'),(4,'Río','Déjate llevar por la corriente suave o aventúrate en sus rápidos emocionantes. Explora paisajes ribereños llenos de vida, escucha el murmullo constante del agua y conéctate con la fuerza vital que fluye a través de la tierra. ¡El río te invita a descubrir su belleza dinámica y a vivir momentos de paz y aventura!','/uploads/places/0a3d1593-f656-4654-9bc6-bbe056d131b8_rio.webp'),(5,'Viñedo','Sumergite en un paisaje donde el tiempo parece detenerse. Caminá entre hileras de vides que dan vida a sabores únicos, respirá el aire perfumado de la tierra fértil y dejate envolver por el silencio sereno del entorno. Degustá la esencia del terruño en cada copa y conectate con la armonía de la naturaleza, la tradición y el arte del vino. ¡Los viñedos te invitan a una experiencia sensorial inolvidable!','/uploads/places/5e48d3f7-7ea0-44d8-8ae1-0af589cdc1f5_viñedo_1.webp');
/*!40000 ALTER TABLE `places` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `requirements`
--

LOCK TABLES `requirements` WRITE;
/*!40000 ALTER TABLE `requirements` DISABLE KEYS */;
INSERT INTO `requirements` VALUES (2,1,'Estado Físico','Bueno en general'),(3,1,'Seguro de viaje y médico','Recomendado'),(4,2,'Saber nadar','Recomendable'),(5,2,'Edad minima recomendable','10 años'),(6,2,'Vestuario','Llevar ropa y calzado adecuados para mojar (traje de baño, sandalias ajustables o zapatillas viejas).'),(7,2,'Restricción','Personas bajo la influencia de alcohol o drogas no podrán participar.'),(8,2,'Obligatorio','Uso del equipo de seguridad provisto (casco, chaleco salvavidas).'),(9,2,'No apto para','Personas embarazadas, con problemas de espalda severos, lesiones recientes o cirugías.'),(10,4,'Peso mínimo','40 kg'),(11,4,'Peso máximo','90-100 kg (puede variar según el centro de vuelo)'),(12,4,'Edad mínima recomendada','16 años (con autorización de los padres o tutores legales si es menor de edad).'),(13,4,'Vestimenta','Usar calzado cerrado y cómodo.'),(14,4,'No apto para','Personas con vértigo severo, epilepsia o problemas cardíacos no controlados, personas embarazadas.'),(15,4,'Restricción','Personas bajo la influencia de alcohol o drogas no podrán volar.'),(16,4,'Importante','El vuelo está sujeto a condiciones climáticas favorables y puede ser cancelado por razones de seguridad.'),(21,1,'Edad mínima','12 años'),(27,16,'Buen estado físico general','Aunque la caminata sobre el hielo es un \"minitrekking\", implica cierta actividad física en un terreno irregular y frío.'),(28,16,'Edad mínima y máxima','10 años (acompañado por un adulto responsable). La edad máxima recomendada es de 65 años debido a la naturaleza de la actividad en el glaciar.'),(29,16,'Indumentaria adecuada para nieve y frío','Esencial llevar ropa térmica, campera y pantalón impermeables, guantes, gorro y calzado de trekking impermeable y de caña alta (se pueden alquilar en El Calafate si no se posee).'),(30,16,'Seguro','Se recomienda contar con seguro de viaje y/o médico con cobertura para actividades de aventura.'),(31,16,'No apto para','Personas con problemas cardíacos preexistentes, enfermedades respiratorias graves (asma severa no controlada), problemas de columna, rodilla o cadera que impidan una caminata estable. Mujeres embarazadas. Personas con sobrepeso significativo (puede haber restricciones de peso para el traslado o el equipo). Personas bajo la influencia de alcohol o drogas. Individuos con movilidad reducida severa o que requieran asistencia constante.'),(32,16,'Uso obligatorio de grampones','Durante la caminata sobre el glaciar, es estrictamente obligatorio el uso de los grampones provistos por la empresa.'),(33,16,'No se permite fumar','dentro de los domos ni en las cercanías de la zona de campamento para prevenir incendios y por respeto al medio ambiente.'),(35,35,'Edad mínima recomendada','10 años'),(36,35,'Estado Físico','Capacidad para montar durante varias horas'),(37,35,'Vestimenta adecuada','Pantalón largo, calzado cerrado y sombrero'),(38,35,'Experiencia previa','No es necesaria');
/*!40000 ALTER TABLE `requirements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `reservations`
--

LOCK TABLES `reservations` WRITE;
/*!40000 ALTER TABLE `reservations` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
INSERT INTO `reviews` VALUES (1,'Una experiencia inolvidable. El guía fue súper amable y los paisajes, increíbles.','2025-06-22 14:45:00.000000',5,1,8),(2,'Buen viaje en general, aunque el transporte podría haber sido más cómodo.','2025-07-01 09:30:00.000000',4,2,1),(3,'Me encantó todo. Volvería a hacer este tour sin dudarlo.','2025-06-15 11:12:00.000000',5,4,9),(4,'El clima no ayudó mucho, pero el equipo organizador fue excelente.','2025-06-28 17:05:00.000000',3,16,26),(5,'Demasiado turístico para mi gusto, esperaba algo más auténtico.','2025-07-03 10:00:00.000000',2,20,12),(6,'Todo muy bien organizado, desde la reserva hasta la llegada.','2025-07-04 18:20:00.000000',4,1,25),(7,'Increíble atención y muy buena comida local. Súper recomendado.','2025-06-20 13:00:00.000000',5,2,26),(8,'Estuvo bien, aunque hubo algunos retrasos en el itinerario.','2025-06-25 15:45:00.000000',3,16,8),(9,'El guía era muy divertido y conocía mucho sobre el lugar.','2025-07-01 16:30:00.000000',4,4,12),(10,'Muy recomendable para ir con amigos. Lo pasamos genial.','2025-06-30 12:10:00.000000',5,20,1),(24,'Buenisimo!! Me encanto!!','2025-07-06 23:03:08.284558',5,1,26);
/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Pablo','Pecas','pablopecas@gmail.com','$2a$10$rNTeoxJcKEZvde7E9cRWD.wi0jgRL6OJD0SHnMxLC41LYc3LGMM32','USER',_binary '',NULL,NULL,NULL,NULL,NULL),(7,'Admin','Root','admin@wildpath.com','$2a$10$q3y6iavR80oOi7hulcWLaOdHDZ0gWrH9jNNLJH0w13cc/d7IAWzSK','ADMIN',_binary '',NULL,NULL,NULL,NULL,NULL),(8,'Pedro','Pedrin','pedropedrin@mail.com','$2a$10$GpcgEv3tzIeY7GoMhULN0uYh5zGTdhnUGlccUcxdB.TynIyZHiw5G','USER',_binary '',NULL,NULL,NULL,NULL,NULL),(9,'German','Leiva','germi@mail.com','$2a$10$lD.NIqHhAkSHGtWyxIC2NOH55bhPIO5TQ/wAECCsndqr0/7XqJWnO','USER',_binary '',NULL,NULL,NULL,NULL,NULL),(12,'Marco','Mateasovich','marco.mateasovich@gmail.com','$2a$10$c3kWDW4XCuYkPEIbbBFANeg6658uiK9jhvWZODZWskpfhja5d.1jq','USER',_binary '',NULL,NULL,NULL,NULL,NULL),(26,'Ana','Mateasovich','anaa2198@gmail.com','$2a$10$Gwl8.o7OU2ppweC7GWC.yefLzYHIiTBu0zbZqWsBuXH0buRpa175a','USER',_binary '',NULL,NULL,NULL,NULL,NULL),(27,'Ana','Mateasovich','anamateasovich98@gmail.com','$2a$10$QbtaXu.fWbc5iKkyxiqsn.G/IfhVTzQsTDACqm65YbHjbi6qlI1t6','USER',_binary '',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `verification_token`
--

LOCK TABLES `verification_token` WRITE;
/*!40000 ALTER TABLE `verification_token` DISABLE KEYS */;
INSERT INTO `verification_token` VALUES (3,'e44334b9-a2ba-4337-b9af-1dd53adb9158',12,'2025-06-22 20:48:42'),(17,'b7c6da22-10d7-41a2-8e2c-ce1bd2ae7f97',26,'2025-07-01 10:00:54'),(18,'c82f008e-8703-4009-9d66-9b81bee0357a',27,'2025-07-20 19:02:59');
/*!40000 ALTER TABLE `verification_token` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-10-31 23:02:15
