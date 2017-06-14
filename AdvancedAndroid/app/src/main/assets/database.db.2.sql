CREATE TABLE temp AS SELECT col1_name,col2_name FROM table_name;
DROP TABLE table_name;
ALTER TABLE temp RENAME table_name;