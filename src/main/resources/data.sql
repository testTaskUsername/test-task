insert into features (id, type, company_id, name_ru, name_ua, name_en, is_online, is_visible) values (218, 'city', 31, 'Первое город', 'Перше міське', 'First municipal', true, true);
insert into features (id, type, company_id, name_ru, name_ua, name_en, is_online, is_visible) values (212, 'megapolice', 30, 'Друге город', 'Второе міське', 'Second municipal', false, false);
insert into features (id, type, company_id, name_ru, name_ua, name_en, is_online, is_visible) values (318, 'city', 31, 'Первое город', 'Перше міське', 'First municipal', true, true);

insert into services (id, name, value, feature_id) values (1, 'vip', false, 218);
insert into services (id, name, value, feature_id) values (2, 'all_hours', false, 218);
insert into services (id, name, value, feature_id) values (3, 'pi', true, 218);
insert into services (id, name, value, feature_id) values (4, 'entities', true, 218);
insert into services (id, name, value, feature_id) values (5, 'premium', false, 218);
insert into services (id, name, value, feature_id) values (6, 'english_speaking', false, 218);

insert into services (id, name, value, feature_id) values (7, 'vip', true, 212);
insert into services (id, name, value, feature_id) values (8, 'all_hours', true, 212);
insert into services (id, name, value, feature_id) values (9, 'pi', true, 212);
insert into services (id, name, value, feature_id) values (10, 'entities', true, 212);
insert into services (id, name, value, feature_id) values (11, 'premium', false, 212);
insert into services (id, name, value, feature_id) values (12, 'english_speaking', false, 212);

insert into services (id, name, value, feature_id) values (13, 'vip', false, 318);
insert into services (id, name, value, feature_id) values (14, 'all_hours', false, 318);
insert into services (id, name, value, feature_id) values (15, 'pi', true, 318);
insert into services (id, name, value, feature_id) values (16, 'entities', true, 318);
insert into services (id, name, value, feature_id) values (17, 'premium', false, 318);
insert into services (id, name, value, feature_id) values (18, 'english_speaking', false, 318);


insert into work_hours (id, hours, feature_id) values (1, '0040,0080', 218);
insert into work_hours (id, hours, feature_id) values (2, '0040,0080', 218);

insert into work_hours (id, hours, feature_id) values (3, '0040,0080', 212);
insert into work_hours (id, hours, feature_id) values (4, '0040,0080', 212);
insert into work_hours (id, hours, feature_id) values (5, '0040,0080', 212);

insert into work_hours (id, hours, feature_id) values (6, '1040,1080', 318);












