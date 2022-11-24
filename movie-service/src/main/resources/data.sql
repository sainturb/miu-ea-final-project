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
        'Ari',
        'Aster',
        '1986/07/15',
        'MALE',
        'Ari Aster is an American film director, screenwriter, and producer.'
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
        'Ryan',
        'Coogler',
        '1986/05/23',
        'MALE',
        'Ryan Kyle Coogler is an African-American filmmaker and producer.'
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
        number_of_comments
    )
VALUES (
        'movie',
        127,
        'Hereditary',
        7.0,
        2018,
        1,
        0
    );

INSERT INTO
    motion_picture(
        type,
        duration,
        name,
        rating,
        released_year,
        director_id,
        number_of_comments
    )
VALUES (
        'movie',
        161,
        'Black Panther: Wakanda Forever',
        7.3,
        2022,
        2,
        0
    );

-- #GENRES

INSERT INTO
    motion_picture_genres(motion_pictures_id, genres_id)
VALUES (1, 8);

INSERT INTO
    motion_picture_genres(motion_pictures_id, genres_id)
VALUES (1, 12);

INSERT INTO
    motion_picture_genres(motion_pictures_id, genres_id)
VALUES (1, 14);

INSERT INTO
    motion_picture_genres(motion_pictures_id, genres_id)
VALUES (2, 1);

INSERT INTO
    motion_picture_genres(motion_pictures_id, genres_id)
VALUES (2, 2);

INSERT INTO
    motion_picture_genres(motion_pictures_id, genres_id)
VALUES (2, 8);

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
        'Letitia',
        'Wright',
        '1993/10/31',
        'FEMALE',
        'Emmy - nominated Letitia Wright has cemented her position as one of the industry most captivating young actresses.'
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
        'Martin',
        'Freeman',
        '1971/09/08',
        'MALE',
        'Martin Freeman is an English actor,known for portraying Bilbo Baggins in Peter Jacksons The Hobbit film trilogy.'
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
        'Toni',
        'Collette',
        '1972/11/01',
        'FEMALE',
        'Toni Collette is an Academy Award-nominated Australian actress.'
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
        'Gabriel',
        'Byrne',
        '1950/05/12',
        'MALE',
        'Byrne was the first of six children, born in Dublin, Ireland.'
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
        'Character for Hereditary',
        'Annie',
        1,
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
        'Character for Hereditary',
        'Steve',
        1,
        6
    );

INSERT INTO
    character_of_motion_picture(
        additional_information,
        name,
        motion_picture_id,
        actor_id
    )
VALUES (
        'Character for Wakanda forever',
        'Shuri',
        2,
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
        'Character for Wakanda forever',
        'Everett Ross',
        2,
        4
    );