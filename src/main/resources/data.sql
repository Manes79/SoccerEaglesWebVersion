insert into events (id, event_name, event_date, event_place, event_comments)
values (gen_random_uuid(), 'Koszykówka', '', '', '');

insert into events (id, event_name, event_date, event_place, event_comments)
values (gen_random_uuid(), 'Trening piłki nożnej', '', '', '');

insert into events (id, event_name, event_date, event_place, event_comments)
values (gen_random_uuid(), 'Rugby', '', '', '');

insert into events (id, event_name, event_date, event_place, event_comments)
values (gen_random_uuid(), 'Siatkówka', '', '', '');



insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Alutka', '',
        (select id from events where event_name = 'Koszykówka'));

insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Majurka', '',
        (select id from events where event_name = 'Koszykówka'));

insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Dudiczek', '',
        (select id from events where event_name = 'Koszykówka'));

insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Kazik', '',
        (select id from events where event_name = 'Trening piłki nożnej'));

insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Konusik', '',
        (select id from events where event_name = 'Trening piłki nożnej'));

insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Robercik', '',
        (select id from events where event_name = 'Trening piłki nożnej'));

insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Dodo', '',
        (select id from events where event_name = 'Rugby'));

insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Bobo', '',
        (select id from events where event_name = 'Rugby'));

insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Dudu', '',
        (select id from events where event_name = 'Rugby'));

insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Zagumna', '',
        (select id from events where event_name = 'Siatkówka'));

insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Korek', '',
        (select id from events where event_name = 'Siatkówka'));

insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Skorek', '',
        (select id from events where event_name = 'Siatkówka'));



insert into declinedusers(id, declined_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Mazgaj', '',
        (select id from events where event_name = 'Siatkówka'));

insert into declinedusers(id, declined_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Oferma', '',
        (select id from events where event_name = 'Siatkówka'));

insert into declinedusers(id, declined_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Gruby Bolo', '',
        (select id from events where event_name = 'Rugby'));

insert into declinedusers(id, declined_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Chudy Lolo', '',
        (select id from events where event_name = 'Rugby'));

insert into declinedusers(id, declined_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Jacek Bambuła', '',
        (select id from events where event_name = 'Trening piłki nożnej'));

insert into declinedusers(id, declined_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Marek', '',
        (select id from events where event_name = 'Trening piłki nożnej'));

insert into declinedusers(id, declined_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Eddie Jones', '',
        (select id from events where event_name = 'Koszykówka'));

insert into declinedusers(id, declined_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Michael Jordan', '',
        (select id from events where event_name = 'Koszykówka'));



--
-- insert into inactiveusers(id, unknown_user_name, presence_comments)
-- values (gen_random_uuid(), '', '');
--
-- insert into eventsdecision(id, event_decision, presence_comments)
-- values (gen_random_uuid(), '', '');





