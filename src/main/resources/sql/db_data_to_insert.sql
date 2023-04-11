--Table Cars
insert into cars (id,name, color, body, number_of_seats, transmission,engine_capacity,
power,price_per_day, registration_number)
VALUES (nextval('car_seq'), 'bmw', 'Синий', 'Седан', 5, 'Автоматическая', 3.2, 195, 4700, 'Б159ДС159');

insert into cars (id,name, color, body, number_of_seats, transmission,engine_capacity,
power,price_per_day, registration_number)
VALUES (nextval('car_seq'), 'audi', 'Белый', 'Седан', 5, 'Автоматическая', 2.4, 160, 4500, 'Е025ОМ159');

--Table Additional_characteristics_of_the_cars
insert into additional_characteristics(id, button, air_conditioner, climate_control, heated_front_seats, heated_steering_wheel, drive_wheels, audio_system,
navigation_system,cruise_control, airbag, parktronic)
values (nextval('additional_characteristics_seq'), 'Дополнительные характеристики', 'да',
'да','да' ,'да', 'Задние','да', 'да','да', 12, 'да');

insert into additional_characteristics(id, button, air_conditioner, climate_control, heated_front_seats, heated_steering_wheel, drive_wheels, audio_system,
navigation_system,cruise_control, airbag, parktronic)
values (nextval('additional_characteristics_seq'), 'Дополнительные характеристики', 'да',
'да','да' ,'да', 'Задние','да', 'да','да', 18, 'да');

insert into additional_characteristics(id, button, air_conditioner, climate_control, heated_front_seats, heated_steering_wheel, drive_wheels, audio_system,
navigation_system,cruise_control, airbag, parktronic)
values (nextval('additional_characteristics_seq'), 'Дополнительные характеристики', 'да',
'нет','да' ,'да', 'Передние','да', 'нет','нет', 10, 'нет');

--Table Roles
insert into roles
values (1, 'Роль пользователя', 'USER'),
        (2, 'Роль разработчика','ADMIN');

--Table Passport
insert into passports(id, series_passport, number_passport, date_is_issue, issued_by)
values (nextval('passport_seq'), 2688, 268814, '22.04.2014', 'ОУФМС России');

--Table Drivers_licenses
insert into drivers_licenses(id, category, license_issue_date, series_license, number_license)
values (nextval('drivers_license_seq'), 2, '14.03.2015', 5905, 868714);

--Table bank_cards
insert into bank_cards(id, number_card, ixpiration_date, code)
values (nextval('bank_cards'), '1234 1234 1234 1234', '09/29', 111);

--Car_AdditionalCharacteristics
insert into cars_additional_characteristics (car_id, additional_characteristics_id)
values (1,1);

insert into cars_additional_characteristics (car_id, additional_characteristics_id)
values (2,2);

insert into cars_additional_characteristics (car_id, additional_characteristics_id)
values (3,3);


