insert into categories (id, category)
values  (gen_random_uuid(), 'Piłka nożna'),
        (gen_random_uuid(), 'Koszykówka'),
        (gen_random_uuid(), 'Siatkówka'),
        (gen_random_uuid(), 'Tenis'),
        (gen_random_uuid(), 'Rugby'),
        (gen_random_uuid(), 'Biegi'),
        (gen_random_uuid(), 'Hokej');



-- select * from events;
insert into events (id, event_name, event_date, event_place, event_comments, event_category_id)
values (gen_random_uuid(), 'Koszykówka', '20-10-2022', 'Lwowska 13, Lublin', '14:00',
        (select id from categories where category = 'Koszykówka'));
--
insert into events (id, event_name, event_date, event_place, event_comments, event_category_id)
values (gen_random_uuid(), 'Siatkówka', '27-10-2022', 'Berylowa 2, Lublin', '10:00',
        (select id from categories where category = 'Siatkówka'));

insert into events (id, event_name, event_date, event_place, event_comments, event_category_id)
values (gen_random_uuid(), 'Piłka nożna', '18-10-2022', 'Lwowska 13, Lublin', '19:00',
        (select id from categories where category = 'Piłka nożna'));

insert into events (id, event_name, event_date, event_place, event_comments, event_category_id)
values (gen_random_uuid(), 'Tenis', '19-10-2022', 'Lwowska 13, Lublin', '12:00',
        (select id from categories where category = 'Tenis'));

insert into events (id, event_name, event_date, event_place, event_comments, event_category_id)
values (gen_random_uuid(), 'Rugby', '23-10-2022', 'Struga 2, Lublin', '12:00',
        (select id from categories where category = 'Rugby'));

insert into events (id, event_name, event_date, event_place, event_comments, event_category_id)
values (gen_random_uuid(), 'Biegi', '25-10-2022', 'Wąwóz Czuby, Lublin', '09:00',
        (select id from categories where category = 'Biegi'));

insert into events (id, event_name, event_date, event_place, event_comments, event_category_id)
values (gen_random_uuid(), 'Hokej', '25-10-2022', 'Hala Globus, Zana 43, Lublin', '21:00',
        (select id from categories where category = 'Hokej'));



-- select * confirmedusers
insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Eddie Jones', '',
        (select id from events where event_name = 'Koszykówka'));

insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Michael Jordan', '',
        (select id from events where event_name = 'Koszykówka'));

insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Charles Barkley', '',
        (select id from events where event_name = 'Koszykówka'));

insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Patrick Ewing', '',
        (select id from events where event_name = 'Koszykówka'));

insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Denis Rodman', '',
        (select id from events where event_name = 'Koszykówka'));

insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Chris Bosh', '',
        (select id from events where event_name = 'Koszykówka'));

insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Dwayne Wade', '',
        (select id from events where event_name = 'Koszykówka'));

insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Larry Bird', '',
        (select id from events where event_name = 'Koszykówka'));

insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Larry Johnson', '',
        (select id from events where event_name = 'Koszykówka'));

insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Shaq ONeal', '',
        (select id from events where event_name = 'Koszykówka'));



-- select * declinedusers
insert into declinedusers (id, declined_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Hakeem Olajuwon', '',
        (select id from events where event_name = 'Koszykówka'));

insert into declinedusers (id, declined_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Toni Kukoc', '',
        (select id from events where event_name = 'Koszykówka'));



-- select * inactiveusers
insert into inactiveusers (id, unknown_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Lebron James', '',
        (select id from events where event_name = 'Koszykówka'));

insert into inactiveusers (id, unknown_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Derric Rose', '',
        (select id from events where event_name = 'Koszykówka'));

