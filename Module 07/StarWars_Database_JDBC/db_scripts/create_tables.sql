drop table IF EXISTS planet_residents;
drop table IF EXISTS person;
drop table IF EXISTS planet;

create table person
(
    url varchar(200) not null primary key,
    name varchar(100) not null,
    height varchar(100) not null,
    mass varchar(100) not null,
    hair_color varchar(100) not null,
    skin_color varchar(100) not null,
    eye_color varchar(100) not null,
    birth_year varchar(100) not null,
    gender varchar(100) not null,
    homeworld varchar(100) not null,
    created varchar(100) not null,
    edited varchar(100) not null
);

create table planet
(
    url varchar(200) not null primary key,
    name varchar(100) not null,
    rotation_period varchar(100) not null,
    orbital_period varchar(100) not null,
    diameter varchar(100) not null,
    climate varchar(100) not null,
    gravity varchar(100) not null,
    terrain varchar(100) not null,
    surface_water varchar(100) not null,
    population varchar(100) not null,
    created varchar(100) not null,
    edited varchar(100) not null
);

create table planet_residents
(
    person_url varchar(200),
    planet_url varchar(200),
    primary key
        (
            person_url,
            planet_url
        )
);