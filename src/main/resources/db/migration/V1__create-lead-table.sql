CREATE TABLE IF NOT EXISTS lead_consumer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    email VARCHAR(255) NOT NULL,
    telefone VARCHAR(20),
    valor_financiamento FLOAT,
    prazo INT,
    renda_mensal FLOAT,
    patrimonio FLOAT
);
