-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:8889
-- Généré le :  jeu. 13 fév. 2020 à 17:56
-- Version du serveur :  5.7.26
-- Version de PHP :  7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `GameDev`
--

-- --------------------------------------------------------

--
-- Structure de la table `Player`
--

CREATE TABLE `Player` (
  `Id` int(11) NOT NULL COMMENT 'Numero Player',
  `Name` varchar(100) NOT NULL,
  `SpeedRotation` int(11) DEFAULT NULL,
  `SpeedMove` int(11) NOT NULL,
  `Life` int(11) NOT NULL,
  `Power` int(11) NOT NULL,
  `Delay` int(11) NOT NULL,
  `SpeedSpecialAttack` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Caracteristique du joueur';

--
-- Déchargement des données de la table `Player`
--

INSERT INTO `Player` (`Id`, `Name`, `SpeedRotation`, `SpeedMove`, `Life`, `Power`, `Delay`, `SpeedSpecialAttack`) VALUES
(1, 'Luffy', 50, 50, 100, 20, 2, 4),
(2, 'Naruto', 50, 50, 100, 20, 2, 4);

-- --------------------------------------------------------

--
-- Structure de la table `Score`
--

CREATE TABLE `Score` (
  `Id` int(11) NOT NULL,
  `Pseudo` text NOT NULL,
  `Score` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `Score`
--

INSERT INTO `Score` (`Id`, `Pseudo`, `Score`) VALUES
(1, 'Luffy', 50),
(2, 'Naruto', 100),
(1, 'Luffy', 50),
(2, 'Naruto', 100);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `Player`
--
ALTER TABLE `Player`
  ADD PRIMARY KEY (`Id`);
