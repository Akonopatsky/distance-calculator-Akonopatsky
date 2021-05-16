create table cities (
                        id bigint not null auto_increment,
                        latitude double precision not null,
                        longitude double precision not null,
                        name varchar(255) not null,
                        primary key (id)
) engine=InnoDB

GO


