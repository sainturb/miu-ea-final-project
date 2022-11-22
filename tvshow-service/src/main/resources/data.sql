-- #GENRE

INSERT INTO Genre(name, description) VALUES('Action', '');

INSERT INTO Genre(name, description) VALUES('Adventure', '');

INSERT INTO Genre(name, description) VALUES('Animation ', '');

INSERT INTO Genre(name, description) VALUES('Biography', '');

INSERT INTO Genre(name, description) VALUES('Comedy', '');

INSERT INTO Genre(name, description) VALUES('Crime', '');

INSERT INTO Genre(name, description) VALUES('Documentary', '');

INSERT INTO Genre(name, description) VALUES('Drama', '');

INSERT INTO Genre(name, description) VALUES('Family', '');

INSERT INTO Genre(name, description) VALUES('Fantasy', '');

INSERT INTO Genre(name, description) VALUES('History', '');

INSERT INTO Genre(name, description) VALUES('Horror', '');

INSERT INTO Genre(name, description) VALUES('Music', '');

INSERT INTO Genre(name, description) VALUES('Mystery', '');

INSERT INTO Genre(name, description) VALUES('Romance', '');

INSERT INTO Genre(name, description) VALUES('Sci-Fi', '');

INSERT INTO Genre(name, description) VALUES('Sport', '');

INSERT INTO Genre(name, description) VALUES('Superhero', '');

INSERT INTO Genre(name, description) VALUES('Thriller', '');

INSERT INTO Genre(name, description) VALUES('War', '');

INSERT INTO Genre(name, description) VALUES ('Western', '');

--

-- # DIRECTOR --

INSERT INTO
    director(
        id,
        first_name,
        last_name,
        dob,
        gender,
        biography
    )
VALUES (
        1,
        'Vince',
        'Gilligan',
        '1967/02/10',
        'MALE',
        'George Vincent Gilligan Jr. (born February 10, 1967) is an American writer, producer, and director'
    );

INSERT INTO
    director(
        id,
        first_name,
        last_name,
        dob,
        gender,
        biography
    )
VALUES (
        2,
        'David',
        'Benioff',
        '1970/09/25',
        'MALE',
        'He is a producer and writer, known for Game of Thrones (2011).'
    );

--

-- # MOVIES --

INSERT INTO
    motion_picture(
        type,
        duration,
        name,
        rating,
        released_year,
        director_id,
        number_of_comments,
        number_of_seasons
    )
VALUES (
        'tvshow',
        4214,
        'Game of Thrones',
        9.2,
        2011,
        2,
        0,
        8
    );

INSERT INTO
    motion_picture(
        type,
        duration,
        name,
        rating,
        released_year,
        director_id,
        number_of_comments,
        number_of_seasons
    )
VALUES (
        'tvshow',
        3600,
        'Breaking Bad',
        9.5,
        2008,
        1,
        0,
        5
    );

-- #GENRES

INSERT INTO
    motion_picture_genres(motion_pictures_id, genres_id)
VALUES (1, 1);

INSERT INTO
    motion_picture_genres(motion_pictures_id, genres_id)
VALUES (1, 2);

INSERT INTO
    motion_picture_genres(motion_pictures_id, genres_id)
VALUES (1, 8);

INSERT INTO
    motion_picture_genres(motion_pictures_id, genres_id)
VALUES (2, 6);

INSERT INTO
    motion_picture_genres(motion_pictures_id, genres_id)
VALUES (2, 8);

INSERT INTO
    motion_picture_genres(motion_pictures_id, genres_id)
VALUES (2, 19);

-- #ACTOR

INSERT INTO
    actor(
        id,
        first_name,
        last_name,
        dob,
        gender,
        biography
    )
VALUES (
        3,
        'Emilia',
        'Clarke',
        '1986/10/23',
        'FEMALE',
        'British actress Emilia Clarke was born in London and grew up in Oxfordshire, England.'
    );

INSERT INTO
    actor(
        id,
        first_name,
        last_name,
        dob,
        gender,
        biography
    )
VALUES (
        4,
        'Kit',
        'Harington',
        '1986/12/26',
        'MALE',
        'Kit Harington was born Christopher Catesby Harington in Acton, London.'
    );

INSERT INTO
    actor(
        id,
        first_name,
        last_name,
        dob,
        gender,
        biography
    )
VALUES (
        5,
        'Bryan',
        'Cranston',
        '1956/03/07',
        'MALE',
        'Bryan Lee Cranston was born on March 7, 1956 in Hollywood, California, to Audrey Peggy Sell, a radio actress.'
    );

INSERT INTO
    actor(
        id,
        first_name,
        last_name,
        dob,
        gender,
        biography
    )
VALUES (
        6,
        'Aaron',
        'Paul',
        '1979/08/27',
        'MALE',
        'Aaron Paul was born Aaron Paul Sturtevant in Emmett, Idaho.'
    );

-- #CHARACTERS

INSERT INTO
    character_of_motion_picture(
        additional_information,
        name,
        motion_picture_id,
        actor_id
    )
VALUES (
        'Character for GoT',
        'Daenerys Targaryen',
        1,
        3
    );

INSERT INTO
    character_of_motion_picture(
        additional_information,
        name,
        motion_picture_id,
        actor_id
    )
VALUES (
        'Character for GoT',
        'Jon Snow',
        1,
        4
    );

INSERT INTO
    character_of_motion_picture(
        additional_information,
        name,
        motion_picture_id,
        actor_id
    )
VALUES (
        'Character for Breaking bad',
        'Walter White',
        2,
        5
    );

INSERT INTO
    character_of_motion_picture(
        additional_information,
        name,
        motion_picture_id,
        actor_id
    )
VALUES (
        'Character for Breaking bad ',
        'Jesse Pinkman',
        2,
        6
    );