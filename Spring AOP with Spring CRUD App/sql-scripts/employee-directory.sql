DROP TABLE aop_employee;

CREATE TABLE aop_employee (
  id NVARCHAR2 (255) NOT NULL PRIMARY KEY,
  first_name NVARCHAR2(45),
  last_name NVARCHAR2(45),
  email VARCHAR2(45)
);

-- Insert data into the table
INSERT INTO aop_employee (id, first_name, last_name, email) VALUES 
  ('F0C8CB35F1434C8BABE8E736E36A1A0E1', 'Leslie', 'Andrews', 'leslie@luv2code.com');
INSERT INTO aop_employee (id, first_name, last_name, email) VALUES 
  ('F0C8CB35F1434C8BABE8E736E36A1A0E2', 'Emma', 'Baumgarten', 'emma@luv2code.com');
INSERT INTO aop_employee (id, first_name, last_name, email) VALUES 
  ('F0C8CB35F1434C8BABE8E736E36A1A0E3', 'Avani', 'Gupta', 'avani@luv2code.com');
INSERT INTO aop_employee (id, first_name, last_name, email) VALUES 
  ('F0C8CB35F1434C8BABE8E736E36A1A0E4', 'Yuri', 'Petrov', 'yuri@luv2code.com');
INSERT INTO aop_employee (id, first_name, last_name, email) VALUES 
  ('F0C8CB35F1434C8BABE8E736E36A1A0E5', 'Juan', 'Vega', 'juan@luv2code.com');
  
COMMIT;