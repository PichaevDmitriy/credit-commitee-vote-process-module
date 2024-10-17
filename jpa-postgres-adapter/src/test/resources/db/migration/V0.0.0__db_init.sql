create table black_list
(
    id            bigserial
        primary key,
    first_name         varchar(255),
    last_name         varchar(255),
    is_deleted    boolean not null,
    created_date  timestamp(6),
    updated_date  timestamp(6)
);

