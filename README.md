# BookCrudJsfSoap
Crud JSF and SoapUI in: 'BookCrudJSFStevenFinal/StudentCrud_parent'

    Rest in: 'RestCrudBookStevenFinal/RestCrud_parent'
    
    Database in MariaDB:
    CREATE TABLE `book`.`book` (
          `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
          `name` VARCHAR(45) NULL,
          `writer` VARCHAR(45) NULL,
          `quantity` INT NULL);

        INSERT INTO book (name, writer, quantity) VALUES ('Hola','Daniel', 2);
