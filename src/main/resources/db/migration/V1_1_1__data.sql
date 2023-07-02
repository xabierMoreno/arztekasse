INSERT INTO STORE (name, address) VALUES
  ('Store1', 'Street 71, Zurich'),
  ('Store2', 'Avenue 5, Zurich');

INSERT INTO BUSINESS_HOURS (day_of_week, start_time, end_time,store_id) VALUES
    (1, '15:00', '19:00',1),
    (1, '09:00', '13:00',1),
    (2, '09:00', '19:00',1),
    (3,  '09:00', '19:00',1),
    (4,  '09:00', '19:00',1),
    (5,  '09:00', '19:00',1),
    (6, 'CLOSED', 'CLOSED',1),
    (7, 'CLOSED', 'CLOSED',1),
    (1, 'CLOSED', 'CLOSED',2),
    (2,  'CLOSED', 'CLOSED',2),
    (3,   'CLOSED', 'CLOSED',2),
    (4,  '09:00', '19:00',2),
    (5,  '09:00', '23:00',2),
    (6, '09:00', '23:00',2),
    (7,  '09:00', '23:00',2);