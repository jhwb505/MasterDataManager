-- Testdata

--insert into public.mdm_users(id,email_address,first_name,last_name,password,user_number,version_id) values
--    (1,'abc@mdm.dddca.com','taro','yuu','$2a$10$7ASmyNFRhoBVs/NbYcNFk.46Qvrc24iuRWRDK142gOBYXLNYix2QC','10001',999);--password:123456

--insert into public.versions(id,info,name) values
--    (999,'初期用','初期用');

INSERT
INTO public.mdm_user_roles(id, code, name, version_id)
VALUES (4, 'MDM_USER', 'ユーザ', 1);

--password 123456
INSERT
INTO public.mdm_user_static_info(id, email_address, password, user_number)
VALUES (3, 'abc@mdm.dddca.com', '$2a$10$TAwgUBIp1mQaxmSyuaqeBuHeU0OywqmhlJcU5lcIOhrnc5QkCadn2', '10001');

INSERT
INTO public.mdm_users( id
                     , first_name
                     , last_name
                     , version_id
                     , static_user_id)
VALUES (2, 'taro', 'taro', 1, 3);

INSERT
INTO public.versions(id, info, name)
VALUES (1, 'dev', 'firstversion');

