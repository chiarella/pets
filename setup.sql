-- create the databases
CREATE DATABASE IF NOT EXISTS pets;

-- create the users for each database
CREATE USER 'chia'@'%' IDENTIFIED BY 'chia';
GRANT CREATE, ALTER, INDEX, LOCK TABLES, REFERENCES, UPDATE, DELETE, DROP, SELECT, INSERT ON `pets`.* TO 'chia'@'%';

FLUSH PRIVILEGES;