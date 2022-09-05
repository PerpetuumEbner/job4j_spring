INSERT INTO rules (id, name)
VALUES (1, 'Статья 12.1');

INSERT INTO rules (id, name)
VALUES (2, 'Статья 12.5');

INSERT INTO rules (id, name)
VALUES (3, 'Статья 12.7');

INSERT INTO rules (id, name)
VALUES (4, 'Статья 12.8');

INSERT INTO rules (id, name)
VALUES (5, 'Статья 12.9');



INSERT INTO types (id, name)
VALUES (1, 'Легковой автомобиль');

INSERT INTO types (id, name)
VALUES (2, 'Грузовой автомобиль');

INSERT INTO types (id, name)
VALUES (3, 'Мотоцикл');

INSERT INTO types (id, name)
VALUES (4, 'Велосипед');


INSERT INTO accidents (id, name, text, address, type_id)
VALUES (2, 'Техническое состояние транспортного средства',
        'Управление транспортным средством с заведомо неисправными тормозной системой (за исключением стояночного тормоза), рулевым управлением или сцепным устройством (в составе поезда)',
        'Екатеринбург', 1);

INSERT INTO accidents (id, name, text, address, type_id)
VALUES (3, 'Состояние опьянения и отсутствие права управления',
        'Управление транспортным средством водителем, лишенным права управления транспортными средствами', 'Челябинск',
        1);

INSERT INTO accidents (id, name, text, address, type_id)
VALUES (4, 'Скоростной режим',
        'Превышение установленной скорости движения транспортного средства на величину более 20, но не более 40 километров в час',
        'Москва', 4);

INSERT INTO accidents (id, name, text, address, type_id)
VALUES (1, 'Отсутствие документов и регистрации автомобиля',
        'Управление транспортным средством, не зарегистрированным в установленном порядке', 'Санкт-Петербург', 1);



INSERT INTO accidents_rules (accident_id, rule_id)
VALUES (1, 1);

INSERT INTO accidents_rules (accident_id, rule_id)
VALUES (2, 2);

INSERT INTO accidents_rules (accident_id, rule_id)
VALUES (2, 3);

INSERT INTO accidents_rules (accident_id, rule_id)
VALUES (3, 1);

INSERT INTO accidents_rules (accident_id, rule_id)
VALUES (4, 1);

INSERT INTO accidents_rules (accident_id, rule_id)
VALUES (4, 2);

INSERT INTO accidents_rules (accident_id, rule_id)
VALUES (4, 3)