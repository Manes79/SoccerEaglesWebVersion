insert into events (id, event_name, event_date, event_place, event_comments)
values (gen_random_uuid(), '', '', '', '');

insert into confirmedusers(id, confirmed_user_name, presence_comments, event_id)
values (gen_random_uuid(), '', '', '');

insert into declinedusers(id, declined_user_name, presence_comments, event_id)
values (gen_random_uuid(), '', '', '');

insert into inactiveusers(id, unknown_user_name, presence_comments, event_id)
values (gen_random_uuid(), '', '', '');

insert into eventsdecision(id, event_decision, presence_comments)
values (gen_random_uuid(), '', '');