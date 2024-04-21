-- Testdata

insert into public.mdm_users(id,email_address,first_name,last_name,password,user_number,version_id) values 
    (1,'abc@mdm.dddca.com','taro','yuu','$2a$10$7ASmyNFRhoBVs/NbYcNFk.46Qvrc24iuRWRDK142gOBYXLNYix2QC','10001',999);--password:123456
    
insert into public.versions(id,info,name) values 
    (999,'初期用','初期用');

