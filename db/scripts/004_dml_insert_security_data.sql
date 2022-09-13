insert into authorities (authority)
values ('ROLE_USER');
insert into authorities (authority)
values ('ROLE_ADMIN');

insert into users (username, enabled, password, authority_id)
values ('root', true, '$2a$10$7zAVgSzPgd.Rn79NfTrNpO6xe5ELWl6t9l6kyTf7jPwXEoqga8eZi',
        (select id from authorities where authority = 'ROLE_ADMIN'));