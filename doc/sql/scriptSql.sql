-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 21 jan. 2019 à 10:47
-- Version du serveur :  8.0.13
-- Version de PHP :  7.2.10-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `diginamicproject`
--

-- --------------------------------------------------------

--
-- Structure de la table `absence`
--

CREATE TABLE `absence` (
  `id` int(11) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `reason` varchar(100) DEFAULT NULL,
  `idAbsenceType` int(11) NOT NULL,
  `idStatus` int(11) NOT NULL,
  `idUser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- --------------------------------------------------------

--
-- Structure de la table `absencetype`
--

CREATE TABLE `absencetype` (
  `id` int(11) NOT NULL,
  `name` varchar(105) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- --------------------------------------------------------

--
-- Structure de la table `dayoff`
--

CREATE TABLE `dayoff` (
  `id` int(11) NOT NULL,
  `date` date NOT NULL,
  `idTypeDayOff` int(11) NOT NULL,
  `idDepartement` int(11) NOT NULL,
  `comment` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Structure de la table `departement`
--

CREATE TABLE `departement` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Structure de la table `function`
--

CREATE TABLE `function` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Structure de la table `secretQuestion`
--

CREATE TABLE `secretQuestion` (
  `idsecretQuestion` int(11) NOT NULL,
  `question` varchar(80) DEFAULT NULL,
  `response` varchar(80) DEFAULT NULL,
  `idUser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


--
-- Structure de la table `status`
--

CREATE TABLE `status` (
  `id` int(11) NOT NULL,
  `name` varchar(105) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Structure de la table `typedayoff`
--

CREATE TABLE `typedayoff` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `firstname` varchar(100) NOT NULL,
  `email` varchar(150) NOT NULL,
  `password` varchar(150) NOT NULL,
  `nbrDaysOfLeave` int(11) DEFAULT NULL,
  `nbrRTT` int(11) DEFAULT NULL,
  `idDepartement` int(11) DEFAULT NULL,
  `idFunction` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Index pour la table `absence`
--
ALTER TABLE `absence`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idAbsenceType_idx` (`idAbsenceType`),
  ADD KEY `idStatus_idx` (`idStatus`),
  ADD KEY `idUser` (`idUser`);

--
-- Index pour la table `absencetype`
--
ALTER TABLE `absencetype`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name_UNIQUE` (`name`);

--
-- Index pour la table `dayoff`
--
ALTER TABLE `dayoff`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_dayoff_typedayoff1_idx` (`idTypeDayOff`),
  ADD KEY `fk_dayoff_departement1_idx` (`idDepartement`);

--
-- Index pour la table `departement`
--
ALTER TABLE `departement`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name_UNIQUE` (`name`);

--
-- Index pour la table `function`
--
ALTER TABLE `function`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name_UNIQUE` (`name`);

--
-- Index pour la table `secretQuestion`
--
ALTER TABLE `secretQuestion`
  ADD PRIMARY KEY (`idsecretQuestion`),
  ADD KEY `idUser_idx` (`idUser`);

--
-- Index pour la table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name_UNIQUE` (`name`);

--
-- Index pour la table `typedayoff`
--
ALTER TABLE `typedayoff`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email_UNIQUE` (`email`),
  ADD KEY `idDepartement_idx` (`idDepartement`),
  ADD KEY `idFunction_idx` (`idFunction`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `absence`
--
ALTER TABLE `absence`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT pour la table `absencetype`
--
ALTER TABLE `absencetype`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `dayoff`
--
ALTER TABLE `dayoff`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT pour la table `departement`
--
ALTER TABLE `departement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `function`
--
ALTER TABLE `function`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `secretQuestion`
--
ALTER TABLE `secretQuestion`
  MODIFY `idsecretQuestion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `status`
--
ALTER TABLE `status`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `typedayoff`
--
ALTER TABLE `typedayoff`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `absence`
--
ALTER TABLE `absence`
  ADD CONSTRAINT `idAbsenceType` FOREIGN KEY (`idAbsenceType`) REFERENCES `absencetype` (`id`),
  ADD CONSTRAINT `idStatus` FOREIGN KEY (`idStatus`) REFERENCES `status` (`id`),
  ADD CONSTRAINT `idUser` FOREIGN KEY (`idUser`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `dayoff`
--
ALTER TABLE `dayoff`
  ADD CONSTRAINT `fk_dayoff_departement1` FOREIGN KEY (`idDepartement`) REFERENCES `departement` (`id`),
  ADD CONSTRAINT `fk_dayoff_typedayoff1` FOREIGN KEY (`idTypeDayOff`) REFERENCES `typedayoff` (`id`);

--
-- Contraintes pour la table `secretQuestion`
--
ALTER TABLE `secretQuestion`
  ADD CONSTRAINT `idUserQuestion` FOREIGN KEY (`idUser`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `idDepartement` FOREIGN KEY (`idDepartement`) REFERENCES `departement` (`id`),
  ADD CONSTRAINT `idFunction` FOREIGN KEY (`idFunction`) REFERENCES `function` (`id`);

DELIMITER $$
--
-- Évènements
--
CREATE DEFINER=`rootlogin`@`%` EVENT `event1` ON SCHEDULE EVERY 1 DAY STARTS '2019-01-17 01:00:00' ON COMPLETION NOT PRESERVE ENABLE DO UPDATE `absence` SET `idStatus` = '2' WHERE `absence`.`idStatus` = 1$$

DELIMITER ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
