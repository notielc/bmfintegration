CREATE TABLE logs
(
id int NOT NULL,
operacao varchar(255) NOT NULL,
tipo varchar(255),
descricao varchar(255),
data varchar(255),
CONSTRAINT pk_log PRIMARY KEY (id)
)

CREATE TABLE error_message
(
id int NOT NULL,
operacao varchar(255),
nome_requisicao varchar(255),
error_id varchar(255),
data varchar(255),
CONSTRAINT pk_error PRIMARY KEY (id)
)

CREATE TABLE lote_transacao
(
id int NOT NULL,
lote_transacao varchar(255),
transacao varchar(255),
situacao varchar(255),
error_id varchar(255),
data varchar(255),
CONSTRAINT pk_lote_transacao PRIMARY KEY (id)
)

CREATE TABLE extrato
(
id int NOT NULL,
banco varchar(255),
agencia varchar(255),
conta varchar(255),
dt_saldo_ant varchar(255),
dt_saldo_atual varchar(255),
vlr_saldo varchar(255),
cod_ident varchar(255),
dt_lancamento varchar(255),
num_movto varchar(255),
num_docto varchar(255),
cod_hist varchar(255),
desc_hist varchar(255),
vlr_lanc varchar(255),
tp_deb_cred varchar(255),
bco_ctp varchar(255),
age_ctp varchar(255),
cta_ctp varchar(255),
tipo_cta_ctp varchar(255),
cnpj_cpf_ctp_titular1 varchar(255),
nome_ctp_titular1 varchar(255),
cnpj_cpf_ctp_titular2 varchar(255),
nome_ctp_titular2 varchar(255),
tp_pessoa_ctp varchar(255),
cod_cli varchar(255),
tp_pessoa_invest varchar(255),
cnpj_cpfinvest varchar(255),
nom_rzsocInvest varchar(255),
CONSTRAINT pk_extrato PRIMARY KEY (id)
)
