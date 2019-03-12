SET FOREIGN_KEY_CHECKS=0;
TRUNCATE TABLE absence;
TRUNCATE TABLE absencetype;
TRUNCATE TABLE _user;
TRUNCATE TABLE departement;
TRUNCATE TABLE function;
TRUNCATE TABLE status;
TRUNCATE TABLE dayoff;
TRUNCATE TABLE secretQuestion;
SET FOREIGN_KEY_CHECKS=1;

INSERT INTO _function (name) VALUES ('admin'), ('manager'), ('user');
INSERT INTO absence_type (name) VALUES ('conge'), ('RTT');
INSERT INTO absence_type (name) VALUES ('sSoldes'), ('mission');
INSERT INTO type_day_off (name) VALUES ('férié'), ('RTT employeur');
INSERT INTO status (name) VALUES ('initial'), ('attente');
INSERT INTO status (name) VALUES ('valide'), ('refuse');
INSERT INTO departement (name) VALUES ('informatique'), ('resource humaine');

INSERT INTO _user (name, firstname, email, password, nbrDaysOfLeave, nbrRTT, departement_id, function_id) 
VALUES ('mercadier', 'yoann', 'yo@plop.fr', '64a4e8faed1a1aa0bf8bf0fc84938d25', '30', '11', '1', '1'), 
('handura', 'youcef', 'youyou@plop.fr', '64a4e8faed1a1aa0bf8bf0fc84938d25', '35', '11', '1', '2');
INSERT INTO _user (name, firstname, email, password, nbrDaysOfLeave, nbrRTT, departement_id, function_id) 
VALUES ('pichery', 'melanie', 'pichery@plop.fr', '64a4e8faed1a1aa0bf8bf0fc84938d25', '45', '18', '1', '2'), 
('aallou', 'aniss', 'aallou@plop.fr', '64a4e8faed1a1aa0bf8bf0fc84938d25', '45', '11', '2', '3');
INSERT INTO _user (name, firstname, email, password, nbrDaysOfLeave, nbrRTT, departement_id, function_id) 
VALUES ('mercadier', 'yoann', 'yo@plop.fr', '64a4e8faed1a1aa0bf8bf0fc84938d25', '30', '11', '1', '1'), 
('handura', 'youcef', 'youyou@plop.fr', '64a4e8faed1a1aa0bf8bf0fc84938d25', '35', '11', '1', '2');
INSERT INTO _user (name, firstname, email, password, nbrDaysOfLeave, nbrRTT, departement_id, function_id) 
VALUES ('pichery', 'melanie', 'pichery@plop.fr', '64a4e8faed1a1aa0bf8bf0fc84938d25', '45', '18', '1', '2'), 
('aallou', 'aniss', 'aallou@plop.fr', '64a4e8faed1a1aa0bf8bf0fc84938d25', '45', '11', '2', '3');
INSERT INTO _user (name, firstname, email, password, nbrDaysOfLeave, nbrRTT, departement_id, function_id) 
VALUES ('pichery', 'melanie', 'pichery@plop.fr', '64a4e8faed1a1aa0bf8bf0fc84938d25', '45', '18', '1', '2'), 
('aallou', 'aniss', 'aallou@plop.fr', '64a4e8faed1a1aa0bf8bf0fc84938d25', '45', '11', '2', '3');


INSERT INTO absence (startDate, endDate, reason, absence_type_id, status_id, user_id) 
VALUES ('2019-01-08', '2019-01-16','sef', '3', '1', '1');
INSERT INTO absence (startDate, endDate, reason, absence_type_id, status_id, user_id) 
VALUES ('2019-01-23', '2019-01-24','esf', '1', '2', '4');

INSERT INTO dayoff (day_off, type_day_off_id, departement_id, comment) VALUES
('2019-01-23', 2, 1, 'yj'),
('2019-02-05', 2, 1, 'gyj'),
('2019-01-28', 2, 1, 'notre projet'),
('2019-01-31', 1, 1, 'parce que'),
('2019-06-21', 2, 1, 'music'),
('2019-12-25', 2, 1, 'NOEL');

INSERT INTO question_user (question, response, user_id) VALUES
('Quel est le nom de votre cheval ?', 'plop', 2),
('Quel est la couleur de votre 1er voiture?', 'verte', 8),
('Quel est le nom de votre chat?', 'Gluten', 9),
('Quel est la marque de votre nouvelle ordinateur?', 'DELL', 5),
('Quel est votre mot préféré?', 'plop', 1),
('Quelle est votre ville d origine?', 'nantes', 3),
('Quel est la couleur de votre premiere voiture?', 'verte', 6),
('Quel est la couleur de votre 1er voiture?', 'Verte', 7);