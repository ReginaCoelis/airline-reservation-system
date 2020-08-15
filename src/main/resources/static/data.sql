-- ROLES
INSERT INTO role_tbl(id,name) VALUES (1,"ROLE_ADMIN");
INSERT INTO role_tbl(id,name) VALUES (2,"ROLE_PASSENGER");


INSERT INTO passenger(id, name, email) VALUES (01,"elgordo", "elgordofifa@gmail.com");
INSERT INTO passenger(id, name, email) VALUES (02,"psgr2", "psgr2@test.com");
INSERT INTO passenger(id, name, email,password) VALUES (10,"rachel", "rachel@gmail.com","$2a$10$GD195vBOVTchZLnLQuDLRuYujnOvJdzxoXIIKrpVfVO3kGg.KhpH6");

INSERT INTO airport(id, city,state,street,zip,code,name) VALUES(002,"CedarRapids","Iowa","200N airportSt","123","456","Cedar Rapids airport");
INSERT INTO airport(id, city,state,street,zip,code,name) VALUES(001,"Des Moines","Iowa","1000S 4thSt","5674","987","Des Moines airport");

INSERT INTO airline(id, code,name) VALUES(50,"100","United Airline");
INSERT INTO airline(id, code,name) VALUES(51,"101","Virgin Airline");

INSERT INTO flight(id, arrival_date, arrival_time, capacity, departure_date, departure_time, flight_number, seats_available, airlineid, arrival_airport_id, departure_airport_id)VALUES(60,'2020-08-31','14:00:00',80,'2020-08-31', '9:00:00',200,80,50,002,001);
INSERT INTO flight(id,arrival_date, arrival_time, capacity,departure_date, departure_time,flight_number,seats_available,airlineid, arrival_airport_id, departure_airport_id) VALUES(61,'2020-08-20','21:00:00',100,'2020-08-20', '19:00:00',201,100,51,001,002);

INSERT INTO reservation(id,created_at,is_cancelled,is_confirmed,last_update_date,made_by_agent_id,made_by_user_id,passenger_id,reservation_code)VALUES(500, '2020-08-15', false, true, '2020-08-16',900,1000,01,2000);
INSERT INTO reservation(id,created_at,is_cancelled,is_confirmed,last_update_date,made_by_agent_id,made_by_user_id,passenger_id,reservation_code)VALUES(501, '2020-08-20', false, true, '2020-08-25',901,1001,02,2001);

INSERT INTO history(history, id) VALUES("Airline was started in 1980" ,300);
INSERT INTO history(history, id) VALUES("Our history goes back to 1890" ,301);

INSERT INTO reservation_flight_numbers(reservation_id, flight_number) VALUES(500, 61);
INSERT INTO reservation_flight_numbers(reservation_id, flight_number) VALUES(501, 60);

INSERT INTO passenger_roles(passenger_id, roles_id) VALUES (10,1);

-- INSERT INTO ticket(id,airline_name,arrival_airport, arrival_date, arrival_time,departure_date, departure_time,departure_airport,flight_number,issued_at,reservation_id)
--  VALUES(900,"United Airline","CedarRapids",'2020-08-31','14:00:00','2020-08-31','9:00:00',"Des Moines",50,'2020-08-25',500)
--
-- INSERT INTO ticket(id,airline_name,arrival_airport, arrival_date, arrival_time,departure_date, departure_time,departure_airport,flight_number,issued_at,reservation_id)
--  VALUES(901,"Virgin Airline","Des Moines",'2020-08-20','19:00:00','2020-08-20','21:00:00',"CedarRapids",51,'2020-08-16',501)
--
--



