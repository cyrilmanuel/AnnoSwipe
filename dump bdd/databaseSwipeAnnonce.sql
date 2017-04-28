-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  localhost:3306
-- Généré le :  Ven 28 Avril 2017 à 11:42
-- Version du serveur :  5.6.33
-- Version de PHP :  7.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `SwipeAnnonce`
--

-- --------------------------------------------------------

--
-- Structure de la table `annonce`
--

CREATE TABLE `annonce` (
  `id` int(11) NOT NULL,
  `annonce_name` varchar(45) NOT NULL,
  `annonce_price` double NOT NULL,
  `annonce_description` longtext NOT NULL,
  `annonce_dateParution` datetime DEFAULT NULL,
  `annonce_user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `annonce`
--

INSERT INTO `annonce` (`id`, `annonce_name`, `annonce_price`, `annonce_description`, `annonce_dateParution`, `annonce_user_id`) VALUES
(36, 'kim <3', 10000000000000, 'parfaite\r\n', '2017-04-27 08:12:02', 28),
(37, 'dsfasdfsdf', 0, 'Sin autem ad adulescentiam perduxissent, dirimi tamen interdum contentione vel uxoriae condicionis vel commodi alicuius, quod idem adipisci uterque non posset. Quod si qui longius in amicitia provecti essent, tamen saepe labefactari, si in honoris contentionem incidissent; pestem enim nullam maiorem esse amicitiis quam in plerisque pecuniae cupiditatem, in optimis quibusque honoris certamen et gloriae; ex quo inimicitias maximas saepe inter amicissimos exstitisse.', '2017-04-27 10:58:38', 28),
(39, 'newann', 23, 'Sin autem ad adulescentiam perduxissent, dirimi tamen interdum contentione vel uxoriae condicionis vel commodi alicuius, quod idem adipisci uterque non posset. Quod si qui longius in amicitia provecti essent, tamen saepe labefactari, si in honoris contentionem incidissent; pestem enim nullam maiorem esse amicitiis quam in plerisque pecuniae cupiditatem, in optimis quibusque honoris certamen et gloriae; ex quo inimicitias maximas saepe inter amicissimos exstitisse.', '2017-04-27 13:42:01', 28),
(46, 'new annonce test', 25, 'annonce de test selenium', '2017-04-27 19:30:04', 2),
(47, 'new annonce test', 25, 'annonce de test selenium', '2017-04-27 19:30:45', 2),
(48, 'new annonce test', 25, 'annonce de test selenium', '2017-04-27 19:31:04', 2),
(49, 'new annonce test', 25, 'annonce de test selenium', '2017-04-27 19:31:35', 2),
(55, 'new annonce test 2', 2340, 'Sin autem ad adulescentiam perduxissent, dirimi tamen interdum contentione vel uxoriae condicionis vel commodi alicuius, quod idem adipisci uterque non posset. Quod si qui longius in amicitia provecti essent, tamen saepe labefactari, si in honoris contentionem incidissent; pestem enim nullam maiorem esse amicitiis quam in plerisque pecuniae cupiditatem, in optimis quibusque honoris certamen et gloriae; ex quo inimicitias maximas saepe inter amicissimos exstitisse.', '2017-04-27 20:55:13', 33),
(56, 'new annonce test 2', 2340, 'Sin autem ad adulescentiam perduxissent, dirimi tamen interdum contentione vel uxoriae condicionis vel commodi alicuius, quod idem adipisci uterque non posset. Quod si qui longius in amicitia provecti essent, tamen saepe labefactari, si in honoris contentionem incidissent; pestem enim nullam maiorem esse amicitiis quam in plerisque pecuniae cupiditatem, in optimis quibusque honoris certamen et gloriae; ex quo inimicitias maximas saepe inter amicissimos exstitisse.', '2017-04-27 20:56:07', 33),
(57, 'new annonce test 23', 2340, 'Sin autem ad adulescentiam perduxissent, dirimi tamen interdum contentione vel uxoriae condicionis vel commodi alicuius, quod idem adipisci uterque non posset. Quod si qui longius in amicitia provecti essent, tamen saepe labefactari, si in honoris contentionem incidissent; pestem enim nullam maiorem esse amicitiis quam in plerisque pecuniae cupiditatem, in optimis quibusque honoris certamen et gloriae; ex quo inimicitias maximas saepe inter amicissimos exstitisse.', '2017-04-27 20:56:42', 33),
(58, 'sdfa', 0, 'sdfasdf', '2017-04-27 20:57:27', 33),
(59, 'fsdaf', 0, 'sdfasdf', '2017-04-27 20:57:51', 30),
(60, 'sdfa', 0, 'sdfadf', '2017-04-27 20:58:45', 30),
(61, 'nouvelle annonce', 250, 'nouvelle selenium', '2017-04-27 21:05:50', 30),
(62, 'dfa', 0, 'description final', '2017-04-27 16:52:49', 30),
(63, 'nouvelle annonce', 250, 'nouvelle selenium', '2017-04-27 21:07:13', 30),
(64, 'dfa', 0, 'description final', '2017-04-27 16:52:49', 30);

-- --------------------------------------------------------

--
-- Structure de la table `groups`
--

CREATE TABLE `groups` (
  `id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Table of user groups';

--
-- Contenu de la table `groups`
--

INSERT INTO `groups` (`id`, `name`) VALUES
(2, 'admins'),
(1, 'users');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `login_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Table of users';

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`id`, `login_name`, `password`) VALUES
(1, 'user1', '5f4dcc3b5aa765d61d8327deb882cf99'),
(2, 'user2', '5f4dcc3b5aa765d61d8327deb882cf99'),
(3, 'user3', '5f4dcc3b5aa765d61d8327deb882cf99'),
(4, 'user4', '5f4dcc3b5aa765d61d8327deb882cf99'),
(28, 'cyrilmanuel', '7d340c3f867d8b7816b1cc1ed8f5d238'),
(30, 'karim2', '5f4dcc3b5aa765d61d8327deb882cf99'),
(31, 'newutilisateur', '5f4dcc3b5aa765d61d8327deb882cf99'),
(32, 'newutilisateur2', '5f4dcc3b5aa765d61d8327deb882cf99'),
(33, 'newutilisateur3', '5f4dcc3b5aa765d61d8327deb882cf99'),
(35, 'newutilisateur4', '5f4dcc3b5aa765d61d8327deb882cf99'),
(36, 'newutilisateur10', '5f4dcc3b5aa765d61d8327deb882cf99'),
(38, 'new2', '82f2ec5f5ed4dfed2b55c68496d7bac4'),
(40, 'test10', '5f4dcc3b5aa765d61d8327deb882cf99'),
(42, 'test11', 'bdc87b9c894da5168059e00ebffb9077');

-- --------------------------------------------------------

--
-- Structure de la table `users_groups`
--

CREATE TABLE `users_groups` (
  `login_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `group_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Table of groups to which the users belong';

--
-- Contenu de la table `users_groups`
--

INSERT INTO `users_groups` (`login_name`, `group_name`) VALUES
('user3', 'admins'),
('user4', 'admins'),
('cyrilmanuel', 'users'),
('karim2', 'users'),
('new2', 'users'),
('newutilisateur', 'users'),
('newutilisateur10', 'users'),
('newutilisateur2', 'users'),
('newutilisateur3', 'users'),
('newutilisateur4', 'users'),
('test10', 'users'),
('test11', 'users'),
('user2', 'users'),
('user4', 'users');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `annonce`
--
ALTER TABLE `annonce`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_user_annonce_idx` (`annonce_user_id`);

--
-- Index pour la table `groups`
--
ALTER TABLE `groups`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `groups_name_uk` (`name`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `users_login_name_uk` (`login_name`);

--
-- Index pour la table `users_groups`
--
ALTER TABLE `users_groups`
  ADD UNIQUE KEY `users_groups_uk` (`login_name`,`group_name`),
  ADD KEY `users_groups_group_name_fk` (`group_name`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `annonce`
--
ALTER TABLE `annonce`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;
--
-- AUTO_INCREMENT pour la table `groups`
--
ALTER TABLE `groups`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `annonce`
--
ALTER TABLE `annonce`
  ADD CONSTRAINT `fk_user_annonce` FOREIGN KEY (`annonce_user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `users_groups`
--
ALTER TABLE `users_groups`
  ADD CONSTRAINT `users_groups_group_name_fk` FOREIGN KEY (`group_name`) REFERENCES `groups` (`name`),
  ADD CONSTRAINT `users_groups_login_name_fk` FOREIGN KEY (`login_name`) REFERENCES `users` (`login_name`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
