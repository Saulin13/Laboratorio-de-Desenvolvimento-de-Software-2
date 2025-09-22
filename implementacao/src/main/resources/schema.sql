CREATE TABLE IF NOT EXISTS CLIENTE (
  id        BIGINT PRIMARY KEY,
  nome      VARCHAR(255) NOT NULL,
  cpf       VARCHAR(14)  NOT NULL,
  rg        VARCHAR(20),
  endereco  VARCHAR(255),
  profissao VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS CLIENTE_EMPREGOs (
  id                   BIGINT AUTO_INCREMENT PRIMARY KEY,
  cliente_id           BIGINT NOT NULL,
  entidade_empregadora VARCHAR(255) NOT NULL,
  rendimento_mensal    DECIMAL(10,2) NOT NULL,
  CONSTRAINT fk_cliente_emp
    FOREIGN KEY (cliente_id) REFERENCES CLIENTE(id)
);
