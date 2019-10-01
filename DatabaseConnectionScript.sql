###########################################################
create database App_tarefa;

use App_tarefa;

create table Prioridade(
	Id int primary key auto_increment,
    Nivel_prioridade int not null,
    Descricao_Prioridade varchar(200)
);

create table Usuario (
	Id int primary key auto_increment,
    Nome varchar(50),
    Sobrenome varchar(50)
);

create table Tarefas(
	Id int primary key auto_increment,
    Nome_tarefa varchar(250) not null,
    FK_Prioridade int,
    FK_Responsavel int,
    constraint FK_Prioridade foreign key(FK_Prioridade) references Prioridade(Id),
    constraint FK_Responsavel foreign key(FK_Responsavel) references Usuario(Id)
);
insert into Prioridade (Nivel_prioridade, Descricao_Prioridade)values(1, 'Baixo');
insert into Prioridade (Nivel_prioridade, Descricao_Prioridade)values(2, 'Medio');
insert into Prioridade (Nivel_prioridade, Descricao_Prioridade)values(3, 'Alto');
insert into Prioridade (Nivel_prioridade, Descricao_Prioridade)values(4, 'Urgente');
alter table Tarefas add Tarefa_status bit;
