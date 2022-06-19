create table candidatos
(
    id        serial,
    nome      varchar     not null,
    email     varchar     not null,
    cep       varchar     not null,
    estado    varchar     not null,
    pais      varchar     not null,
    descricao varchar     not null,
    cpf       varchar     not null
        constraint candidatos_pk
            primary key,
    formacao  varchar     not null,
    idade     varchar(2)  not null,
    senha     varchar(10) not null
);

alter table candidatos
    owner to postgres;

create table candidatos_competencias
(
    id          serial
        constraint candidatos_competencias_pk
            primary key,
    cpf         varchar not null
        constraint cpf_fk
            references candidatos,
    competencia varchar not null
        constraint competencia_fk
            references competencias (nome)
);

alter table candidatos_competencias
    owner to postgres;

create table competencias
(
    id   serial
        constraint competencias_pk
            primary key,
    nome varchar not null
);

alter table competencias
    owner to postgres;

create unique index competencias_nome_uindex
    on competencias (nome);

create table empresas
(
    id        serial,
    nome      varchar     not null,
    email     varchar     not null,
    cep       varchar     not null,
    estado    varchar     not null,
    pais      varchar     not null,
    descricao varchar     not null,
    cnpj      varchar     not null
        constraint empresas_pk
            primary key,
    senha     varchar(10) not null
);

alter table empresas
    owner to postgres;

create table vagas
(
    id        serial
        constraint vagas_pk
            primary key,
    nome      varchar not null,
    estado    varchar not null,
    empresa   varchar not null
        constraint vagas_empresas_cnpj_fk
            references empresas,
    descricao varchar not null
);

alter table vagas
    owner to postgres;

create table vagas_competencias
(
    id          serial
        constraint vagas_competencias_pk
            primary key,
    id_vaga     integer      not null,
    competencia varchar(255) not null
);

alter table vagas_competencias
    owner to postgres;


