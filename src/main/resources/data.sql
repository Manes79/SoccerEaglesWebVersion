--event
insert into events (id, event_name, event_date, event_place, event_comments)
values (gen_random_uuid(), '', '', '', '');

--confirmedUsers
insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), '', '',
        (select id from events where event_name = ''));

insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), '', '',
        (select id from events where event_name = ''));

insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), '', '',
        (select id from events where event_name = ''));

--declinedUsers
insert into declinedusers(id, declined_user_name, presence_comments, event_id)
values (gen_random_uuid(), '', '',
        (select id from events where event_name = ''));

insert into declinedusers(id, declined_user_name, presence_comments, event_id)
values (gen_random_uuid(), '', '',
        (select id from events where event_name = ''));

--inactiveUsers
insert into inactiveusers(id, unknown_user_name, presence_comments, event_id)
values (gen_random_uuid(), '', '',
        (select id from events where event_name = ''));




insert into events (id, event_name, event_date, event_place, event_comments)
values (gen_random_uuid(), 'Rugby', '', '', '');

insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Chudy Bolo', '',
        (select id from events where event_name = 'Rugby'));

insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Cienki Lolo', '',
        (select id from events where event_name = 'Rugby'));

insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Gruby Jolo', '',
        (select id from events where event_name = 'Rugby'));

--declinedUsers
insert into declinedusers(id, declined_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Marian Koniuszko', '',
        (select id from events where event_name = 'Rugby'));

insert into declinedusers(id, declined_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Krzysztof Jarzyna', '',
        (select id from events where event_name = 'Rugby'));

--inactiveUsers
insert into inactiveusers(id, unknown_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Zbój Łamignat', '',
        (select id from events where event_name = 'Rugby'));


--event
insert into events (id, event_name, event_date, event_place, event_comments)
values (gen_random_uuid(), 'Siatkówka', '', '', '');

insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Jagoda', '',
        (select id from events where event_name = 'Siatkówka'));

insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Śliwka', '',
        (select id from events where event_name = 'Siatkówka'));

insert into confirmedusers (id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Gruszka', '',
        (select id from events where event_name = 'Siatkówka'));

--declinedUsers
insert into declinedusers(id, declined_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Ogórek', '',
        (select id from events where event_name = 'Siatkówka'));

insert into declinedusers(id, declined_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Ziemniak', '',
        (select id from events where event_name = 'Siatkówka'));

--inactiveUsers
insert into inactiveusers(id, unknown_user_name, presence_comments, event_id)
values (gen_random_uuid(), 'Orzech', '',
        (select id from events where event_name = 'Siatkówka'));


insert into eventsdecision(id, event_decision, presence_comments)
values (gen_random_uuid(), '', '');





