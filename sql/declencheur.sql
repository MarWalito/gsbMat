DELIMITER |
CREATE TRIGGER `verifDate` 
BEFORE INSERT ON `empruntmat`
FOR EACH ROW
BEGIN
DECLARE cpt int;
	SELECT count(*) INTO cpt 
        FROM empruntMat
	WHERE dateDebut <= NEW.dateFin 
        AND dateFin >= NEW.dateDebut
        AND idMateriel = NEW.idMateriel;
	IF cpt <> 0 THEN
     	SIGNAL SQLSTATE '26000' SET MESSAGE_TEXT = "Date déjà prise";
	END IF;
END;
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER `verifDateVehicule` 
BEFORE INSERT ON `empruntveh`
FOR EACH ROW
BEGIN
DECLARE compteur int;
	SELECT count(*) INTO compteur 
        FROM empruntVeh
	WHERE dateDebut <= NEW.dateFin 
        AND dateFin >= NEW.dateDebut
        AND idVehicule = NEW.idVehicule;
	IF compteur <> 0 THEN
     	SIGNAL SQLSTATE '26000' SET MESSAGE_TEXT = "Date déjà prise";
	END IF;
END;
|
DELIMITER ;



