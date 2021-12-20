-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : lun. 13 déc. 2021 à 20:48
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gsbmat`
--

-- --------------------------------------------------------

--
-- Structure de la table `emprunt`
--

DROP TABLE IF EXISTS `emprunt`;
CREATE TABLE IF NOT EXISTS `emprunt` (
  `idEmprunt` int(5) NOT NULL,
  `duree` int(5) DEFAULT NULL,
  `dateheuredebut` datetime DEFAULT NULL,
  `dateheurefin` datetime DEFAULT NULL,
  `idVisiteur` int(5) DEFAULT NULL,
  `idObjet` int(5) DEFAULT NULL,
  PRIMARY KEY (`idEmprunt`),
  KEY `idVisiteur` (`idVisiteur`),
  KEY `idObjet` (`idObjet`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `empruntmat`
--

DROP TABLE IF EXISTS `empruntmat`;
CREATE TABLE IF NOT EXISTS `empruntmat` (
  `idMateriel` int(11) NOT NULL,
  `idVisiteur` int(11) NOT NULL,
  `dateDebut` varchar(50) NOT NULL,
  `dateFin` varchar(50) NOT NULL,
  `duree` float NOT NULL,
  PRIMARY KEY (`idMateriel`,`idVisiteur`),
  KEY `idVisiteur` (`idVisiteur`),
  KEY `idMateriel` (`idMateriel`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `empruntmat`
--

INSERT INTO `empruntmat` (`idMateriel`, `idVisiteur`, `dateDebut`, `dateFin`, `duree`) VALUES
(18, 54321, '2021-12-09', '2021-12-13', 1),
(56, 14789, '2021-12-10', '2021-12-12', 2);

--
-- Déclencheurs `empruntmat`
--
DROP TRIGGER IF EXISTS `verifDate`;
DELIMITER $$
CREATE TRIGGER `verifDate` BEFORE INSERT ON `empruntmat` FOR EACH ROW BEGIN
	declare count int;
	SELECT count(*) INTO count
    FROM empruntmat
	WHERE dateDebut <= NEW.dateFin 
    AND dateFin >= NEW.dateDebut
    AND idMateriel = NEW.idMateriel;
	IF count <> 0 THEN
     	SIGNAL SQLSTATE '26000' SET MESSAGE_TEXT = "Date déjà prise";
	END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `empruntveh`
--

DROP TABLE IF EXISTS `empruntveh`;
CREATE TABLE IF NOT EXISTS `empruntveh` (
  `idVehicule` int(11) NOT NULL,
  `idVisiteur` int(11) NOT NULL,
  `dateDebut` varchar(50) NOT NULL,
  `dateFin` varchar(50) NOT NULL,
  `duree` float NOT NULL,
  PRIMARY KEY (`idVehicule`,`idVisiteur`),
  KEY `idVisiteur` (`idVisiteur`),
  KEY `idVehicule` (`idVehicule`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `empruntveh`
--

INSERT INTO `empruntveh` (`idVehicule`, `idVisiteur`, `dateDebut`, `dateFin`, `duree`) VALUES
(1, 54321, '2021-12-12', '2021-12-12', 10);

-- --------------------------------------------------------

--
-- Structure de la table `materiel`
--

DROP TABLE IF EXISTS `materiel`;
CREATE TABLE IF NOT EXISTS `materiel` (
  `id` int(5) NOT NULL,
  `libelle` varchar(75) NOT NULL,
  `largeur` double DEFAULT NULL,
  `longueur` double DEFAULT NULL,
  `type` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `materiel`
--

INSERT INTO `materiel` (`id`, `libelle`, `largeur`, `longueur`, `type`) VALUES
(18, 'test', 19, 19, 'test'),
(56, 'aaa', 15, 15, 'aaa');

-- --------------------------------------------------------

--
-- Structure de la table `objet`
--

DROP TABLE IF EXISTS `objet`;
CREATE TABLE IF NOT EXISTS `objet` (
  `id` int(5) NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `typevehicule`
--

DROP TABLE IF EXISTS `typevehicule`;
CREATE TABLE IF NOT EXISTS `typevehicule` (
  `code` varchar(6) DEFAULT NULL,
  `libelle` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

DROP TABLE IF EXISTS `vehicule`;
CREATE TABLE IF NOT EXISTS `vehicule` (
  `id` int(5) NOT NULL,
  `immat` varchar(10) DEFAULT NULL,
  `modele` varchar(30) DEFAULT NULL,
  `marque` varchar(30) DEFAULT NULL,
  `nbPlaces` int(7) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `vehicule`
--

INSERT INTO `vehicule` (`id`, `immat`, `modele`, `marque`, `nbPlaces`) VALUES
(1, 'AA-000-AA', '208', 'Peugeot', 5),
(2, 'BB-111-BB', 'Capture', 'Renault', 5);

-- --------------------------------------------------------

--
-- Structure de la table `visiteur`
--

DROP TABLE IF EXISTS `visiteur`;
CREATE TABLE IF NOT EXISTS `visiteur` (
  `id` int(5) NOT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `prenom` varchar(30) DEFAULT NULL,
  `login` varchar(15) DEFAULT NULL,
  `mdp` varchar(150) DEFAULT NULL,
  `adresse` varchar(50) DEFAULT NULL,
  `cp` varchar(5) DEFAULT NULL,
  `ville` varchar(50) DEFAULT NULL,
  `dateEmbauche` date DEFAULT NULL,
  `typeUtilisateur` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `visiteur`
--

INSERT INTO `visiteur` (`id`, `nom`, `prenom`, `login`, `mdp`, `adresse`, `cp`, `ville`, `dateEmbauche`, `typeUtilisateur`) VALUES
(12345, 'oui', 'oui', 'oui', '5898fc860300e228dcd54c0b1045b5fa0dcda502', '42 Rue des 12 Arpents', '91540', 'Ormoy', '2021-11-15', 'S'),
(14789, 'ep', 'ep', 'ep', '881baaede9ab674cbb97cddae8bfda41d8ad51c3', 'ep', 'ep', 'ep', '2021-12-13', 'V'),
(54321, 'pe', 'pe', 'pe', '1db828bcd41de75377dce59825af73ae7fca5651', '40 Rue des 12 Arpents', '91540', 'Ormoy', '2021-11-15', 'V'),
(98765, 'non', 'non', 'non', '37031f99ac78580c9f82e04fa237d295ea10ca41', '41 Rue des 12 Arpents', '91540', 'Ormoy', '2021-11-15', 'D');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `emprunt`
--
ALTER TABLE `emprunt`
  ADD CONSTRAINT `Emprunt_ibfk_1` FOREIGN KEY (`idVisiteur`) REFERENCES `visiteur` (`id`),
  ADD CONSTRAINT `Emprunt_ibfk_2` FOREIGN KEY (`idObjet`) REFERENCES `objet` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
