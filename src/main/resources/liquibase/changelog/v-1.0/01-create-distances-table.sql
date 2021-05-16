create table distances
(
    id           bigint           not null auto_increment,
    distance     double precision not null,
    from_city_id bigint,
    to_city_id   bigint,
    primary key (id)
) engine=InnoDB

GO

alter table distances
    add constraint FKr3hsoy2oppbynx6tpdhdsgqy4
        foreign key (from_city_id)
            references cities (id)

GO

alter table distances
    add constraint FK1cxwem0aecrho2q0kfd2kr4bb
        foreign key (to_city_id)
            references cities (id)

GO
