CREATE SEQUENCE customer_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1000
CACHE 1;
ALTER TABLE customer_seq OWNER TO admin;
GRANT ALL ON TABLE customer_seq TO admin;
GRANT SELECT, UPDATE, INSERT, DELETE ON TABLE customer_seq TO app;
GRANT ALL ON TABLE customer_seq TO developer;



CREATE TABLE ref_userdemo
(
  userid bigint NOT NULL,
  version integer NOT NULL,
  username character varying(255) NOT NULL,
  password character varying(255) NOT NULL,
  active boolean NOT NULL DEFAULT true,
  deleted integer NOT NULL DEFAULT 0,
  CONSTRAINT ref_userdemo_pkey PRIMARY KEY (userid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ref_userdemo
  OWNER TO postgres;