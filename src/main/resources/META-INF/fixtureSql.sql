SET FOREIGN_KEY_CHECKS=0;
TRUNCATE TABLE `absence`;
TRUNCATE TABLE `absencetype`;
TRUNCATE TABLE `user`;
TRUNCATE TABLE `departement`;
TRUNCATE TABLE `function`;
TRUNCATE TABLE `status`;
TRUNCATE TABLE `dayoff`;
TRUNCATE TABLE `secretQuestion`;
SET FOREIGN_KEY_CHECKS=1;

INSERT INTO `function` (`id`, `name`) VALUES (NULL, 'admin'), (NULL, 'manager'), (NULL, 'user');
INSERT INTO `absencetype` (`id`, `name`) VALUES (NULL, 'conge'), (NULL, 'RTT');
INSERT INTO `absencetype` (`id`, `name`) VALUES (NULL, 'sSoldes'), (NULL, 'mission');
INSERT INTO `status` (`id`, `name`) VALUES (NULL, 'initial'), (NULL, 'attente');
INSERT INTO `status` (`id`, `name`) VALUES (NULL, 'valide'), (NULL, 'refuse');
INSERT INTO `departement` (`id`, `name`) VALUES (NULL, 'informatique'), (NULL, 'resource humaine');

INSERT INTO `user` (`id`, `name`, `firstname`, `email`, `password`, `nbrDaysOfLeave`, `nbrRTT`, `idDepartement`, `idFunction`) 
VALUES (NULL, 'mercadier', 'yoann', 'yo@plop.fr', '64a4e8faed1a1aa0bf8bf0fc84938d25', '30', '11', '1', '1'), 
(NULL, 'handura', 'youcef', 'youyou@plop.fr', '64a4e8faed1a1aa0bf8bf0fc84938d25', '35', '11', '1', '2');
INSERT INTO `user` (`id`, `name`, `firstname`, `email`, `password`, `nbrDaysOfLeave`, `nbrRTT`, `idDepartement`, `idFunction`) 
VALUES (NULL, 'pichery', 'melanie', 'pichery@plop.fr', '64a4e8faed1a1aa0bf8bf0fc84938d25', '45', '18', '1', '2'), 
(NULL, 'aallou', 'aniss', 'aallou@plop.fr', '64a4e8faed1a1aa0bf8bf0fc84938d25', '45', '11', '2', '3');


INSERT INTO `absence` (`id`, `startDate`, `endDate`, `reason`, `idAbsenceType`, `idStatus`, `idUser`) 
VALUES (NULL, '2019-01-08', '2019-01-16', NULL, '3', '1', '1');
INSERT INTO `absence` (`id`, `startDate`, `endDate`, `reason`, `idAbsenceType`, `idStatus`, `idUser`) 
VALUES (NULL, '2019-01-23', '2019-01-24', NULL, '1', '2', '4');

INSERT INTO `dayoff` ( `date`, `idTypeDayOff`, `idDepartement`, `comment`) VALUES
('2019-01-23', 2, 1, ''),
('2019-02-05', 2, 1, ''),
('2019-01-28', 2, 1, 'notre projet'),
('2019-01-31', 1, 1, 'parce que'),
('2019-06-21', 2, 1, 'music'),
('2019-12-25', 2, 1, 'NOEL');

INSERT INTO `secretQuestion` (`question`, `response`, `idUser`) VALUES
('Quel est le nom de votre cheval ?', 'plop', 2),
('Quel est la couleur de votre 1er voiture?', 'verte', 8),
('Quel est le nom de votre chat?', 'Gluten', 9),
('Quel est la marque de votre nouvelle ordinateur?', 'DELL', 5),
('Quel est votre mot préféré?', 'plop', 1),
('Quelle est votre ville d origine?', 'nantes', 3),
('Quel est la couleur de votre premiere voiture?', 'verte', 6),
('Quel est la couleur de votre 1er voiture?', 'Verte', 7);