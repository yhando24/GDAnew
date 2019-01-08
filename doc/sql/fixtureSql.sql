SET FOREIGN_KEY_CHECKS=0;
TRUNCATE TABLE `absence`;
TRUNCATE TABLE `absencetype`;
TRUNCATE TABLE `user`;
TRUNCATE TABLE `departement`;
TRUNCATE TABLE `function`;
TRUNCATE TABLE `status`;
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