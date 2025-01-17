/*GRANT CREATE ON SCHEMA public TO PUBLIC;

CREATE TABLE AUDIT_LOG IF NOT EXISTS (
                           id SERIAL PRIMARY KEY,
                           create_date TIMESTAMP NOT NULL,
                           cep JSONB NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS audit_log_seq
*/