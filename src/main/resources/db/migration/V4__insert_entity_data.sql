INSERT INTO users (username, password, company_name ,street1, street2, city, country, zip, phone, email)
VALUES
    ('user1', crypt('password', gen_salt('bf')), 'TechBuilding', '17 Yala Close', null, 'Corson Mile', 'Greenland', 'CM653', '+1 (878) 9650318', 'techbuilding@gmail.com');

INSERT INTO buyers (user_id, company_name ,street1, street2, city, country, zip, phone, email)
VALUES
    (1, 'Apple', '12 Core Way', null, 'Silicon Valley', 'USA', 'SV3472', '+1 (541) 2348913', 'apple@apple.com'),
    (1, 'RedStripe', '214 Spanish Town Road', null, 'Kingston', 'Jamaica', 'KGN5', '+1 (541) 2348913', 'manager@heineken.com'),
    (1, 'Loren''s Garden', '45 Hagley Park Road', null, 'St. Andrew', 'Jamaica', 'KGN2', '(876) 7843921', 'lgardens@hotmail.com');

