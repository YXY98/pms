INSERT INTO team_member
(user_name, team_name, team_role, team_privelige, join_time, join_by)
VALUES
('pig', '猪猪侠', '负责人', '0' , '03','pig'),
('sheep', '猪猪侠', '成员', '0' , '02','pig'),
('大灰狼', '猪猪侠', '成员', '0' , '01','pig'),
('pig', '钢铁侠', '成员', '0' , '01','iron');

INSERT INTO team_member
(user_name, team_name, team_role, team_privelige, join_time, join_by, del_time, del_flag)
VALUES
('被删除的成员', '猪猪侠', '成员', '0' , '01','pig','00',1);