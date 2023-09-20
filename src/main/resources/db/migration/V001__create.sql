create table cells
(
    capacity integer      not null,
    id       serial       not null,
    type     varchar(255) not null check (type in ('REGULAR', 'SINGLETON', 'VIP', 'MEDICAL', 'SCHIZO', 'COCKEREL')),
    primary key (id)
);
create table events
(
    cell_id     integer,
    guard_id    uuid,
    id          uuid         not null,
    prisoner_id uuid,
    event_name  varchar(255) not null check (event_name in ('TRANSFER_TO_CELL', 'FORCE_COOPERATION',
                                                            'MANAGEMENT_INSPECTION_IS_EXPECTED')),
    result      varchar(255) not null check (result in
                                             ('PRISONER_TRANSFERRED', 'GUARDS_IS_SCARED', 'PRISONER_START_COOPERATION',
                                              'PRISONER_DO_NOT_START_COOPERATION')),
    primary key (id)
);
create table guards
(
    aggression integer      not null,
    id         uuid         not null,
    health     varchar(255) not null check (health in ('STRONG', 'GOOD', 'BAD', 'ILL', 'AIDS')),
    name       varchar(255) not null,
    primary key (id)
);
create table prisoners
(
    aggression     integer      not null,
    cell_id        integer unique,
    is_cooperation boolean      not null,
    id             uuid         not null,
    health         varchar(255) not null check (health in ('STRONG', 'GOOD', 'BAD', 'ILL', 'AIDS')),
    name           varchar(255) not null,
    nic_name       varchar(255),
    type           varchar(255) not null check (type in ('MAN', 'THIEVES', 'GOATS', 'CHICKEN')),
    primary key (id)
);
create table requisites
(
    id      uuid         not null,
    address varchar(255),
    city    varchar(255),
    name    varchar(255) not null,
    region  varchar(255),
    state   varchar(255),
    primary key (id)
);
alter table if exists prisoners add constraint FK6kkp9c0xn7q5jilkq96t5frtc foreign key (cell_id) references cells;