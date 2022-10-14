insert into categories (id, category)
values  (gen_random_uuid(), 'Piłka nożna'),
        (gen_random_uuid(), 'Koszykówka'),
        (gen_random_uuid(), 'Siatkówka'),
        (gen_random_uuid(), 'Tenis'),
        (gen_random_uuid(), 'Hokej');
--
-- insert into events (id, event_name, event_date, event_place, event_comments)
-- values (gen_random_uuid(), '', '', '', '');
--
-- insert into confirmedusers (id, confirmed_user_name, presence_comments)
-- values (gen_random_uuid(), '', '');
--
-- insert into declinedusers (id, declined_user_name, presence_comments)
-- values (gen_random_uuid(), '', '');
--
-- insert into inactiveusers (id, unknown_user_name, presence_comments)
-- values (gen_random_uuid(), '', '');
--
-- insert into eventsdecision (id, event_decision, presence_comments)
-- values (gen_random_uuid(), '', '');

-- select * from events;
insert into events (id, event_name, event_date, event_place, event_comments, event_category_id)
values (gen_random_uuid(), 'Koszykówka', '', '', '',
        (select id from categories where category = 'Koszykówka'));
