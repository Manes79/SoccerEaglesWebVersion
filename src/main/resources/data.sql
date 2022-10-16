insert into categories (id, category)
values  (gen_random_uuid(), 'Piłka nożna'),
        (gen_random_uuid(), 'Koszykówka'),
        (gen_random_uuid(), 'Siatkówka'),
        (gen_random_uuid(), 'Tenis'),
        (gen_random_uuid(), 'Rugby'),
        (gen_random_uuid(), 'Tenis'),
        (gen_random_uuid(), 'Hokej');

-- select * from events;
insert into events (id, event_name, event_date, event_place, event_comments, event_category_id)
values (gen_random_uuid(), 'Koszykówka', '20-10-2022', 'Lwowska 13, Lublin', '14:00',
        (select id from categories where category = 'Koszykówka'));
--
-- insert into events (id, event_name, event_date, event_place, event_comments, event_category_id)
-- values (gen_random_uuid(), 'Koszykówka', '27-10-2022', 'Berylowa 2, Lublin', '10:00',
--         (select id from categories where category = 'Koszykówka'));
--
-- insert into events (id, event_name, event_date, event_place, event_comments, event_category_id)
-- values (gen_random_uuid(), 'Piłka nożna', '18-10-2022', 'Lwowska 13, Lublin', '19:00',
--         (select id from categories where category = 'Piłka nożna'));

-- select * confirmedusers
insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Eddie Jones', '',
        (select id from events where event_name = 'Koszykówka'));

insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Michael Jordan', '',
        (select id from events where event_name = 'Koszykówka'));

--
-- insert into declinedusers (id, declined_user_name, presence_comments)
-- values (gen_random_uuid(), '', '');
--
-- insert into inactiveusers (id, unknown_user_name, presence_comments)
-- values (gen_random_uuid(), '', '');
--
-- insert into eventsdecision (id, event_decision, presence_comments)
-- values (gen_random_uuid(), '', '');
