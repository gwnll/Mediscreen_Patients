INSERT INTO patients (id, lastname, firstname, gender, phone, address, birthdate) VALUES (nextval('patient_id_seq'), 'TestNone', 'Test', 'FEMALE', '100-222-3333', '1 Brookside St', '31-12-1966');
INSERT INTO patients (id, lastname, firstname, gender, phone, address, birthdate) VALUES (nextval('patient_id_seq'), 'TestBorderline', 'Test', 'MALE', '200-333-4444', '2 High St', '24-06-1945');
INSERT INTO patients (id, lastname, firstname, gender, phone, address, birthdate) VALUES (nextval('patient_id_seq'), 'TestInDanger', 'Test', 'MALE', '300-444-5555', '3 Club Road', '18-06-2004');
INSERT INTO patients (id, lastname, firstname, gender, phone, address, birthdate) VALUES (nextval('patient_id_seq'), 'TestEarlyOnset', 'Test', 'FEMALE', '400-555-6666', '4 Valley Dr', '28-06-2002');