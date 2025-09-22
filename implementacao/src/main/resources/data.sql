INSERT INTO CLIENTE (id, nome, cpf, rg, endereco, profissao) VALUES 
(1, 'Maria Souza', '12345678901', 'MG-12.345.678', 'Rua A, 100 - BH', 'Analista'),
(2, 'João Lima',  '98765432100', 'SP-98.765.432', 'Av. B, 200 - SP', 'Engenheiro');

INSERT INTO CLIENTE_EMPREGOS (cliente_id, entidade_empregadora, rendimento_mensal) VALUES
(1, 'Empresa X', 4500.00),
(1, 'Freelancer', 1200.00),
(2, 'Empresa Y', 7800.00);
