DROP TABLE IF EXISTS appointment_procedure;
DROP TABLE IF EXISTS appointment;
DROP TABLE IF EXISTS patient;
DROP TABLE IF EXISTS provider;
DROP TABLE IF EXISTS procedure;



--create all tables

CREATE TABLE procedure
(
    procedure_id SERIAL       NOT NULL PRIMARY KEY,
    code         VARCHAR(10)  NOT NULL UNIQUE,
    description  VARCHAR(255) NOT NULL,
    cost         MONEY        NOT NULL
);

CREATE TABLE provider
(
    provider_id   SERIAL       NOT NULL PRIMARY KEY,
    last_name     VARCHAR(20)  NOT NULL,
    first_name    VARCHAR(10)  NOT NULL,
    title         VARCHAR(30)  NULL,
    birth_date    DATE         NULL,
    email         VARCHAR(100) NULL,
    phone         VARCHAR(20)  NULL,
    provider_type VARCHAR(15)  NULL
);

CREATE TABLE patient
(
    patient_id  SERIAL NOT NULL PRIMARY KEY,
    provider_id INT    NOT NULL REFERENCES provider (provider_id)
);


CREATE TABLE appointment
(
    appointment_id SERIAL NOT NULL PRIMARY KEY,
    patient_id     INT    NOT NULL REFERENCES patient (patient_id),
    provider_id    INT    NOT NULL REFERENCES provider (provider_id)
    -- additional columns requried
);

CREATE TABLE appointment_procedure
(
    appointment_id INT   NOT NULL REFERENCES appointment (appointment_id),
    procedure_id   INT   NOT NULL REFERENCES procedure (procedure_id),
    cost           MONEY NOT NULL,
    PRIMARY KEY(
        appointment_id,
        procedure_id
    )
);


-- insert records

-- insert procedures
INSERT INTO procedure(procedure_id, code, description, cost) VALUES (1, '00730', 'Anesthesia for Procedures on the Upper Abdomen', 200.00);



-- insert providers



-- insert patients



-- insert appointments



-- insert appointment_procedures
