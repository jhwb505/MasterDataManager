package com.dddca.masterdatamanager.domain.service;

import com.dddca.masterdatamanager.domain.model.MdmUser;
import com.dddca.masterdatamanager.domain.model.MdmVersion;
import com.dddca.masterdatamanager.domain.model.request.UserRegisterRequest;
import com.dddca.masterdatamanager.domain.repository.MdmUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MdmUserRegister {

    private final MdmUserRepository mdmUserRepository;

    @Autowired
    public MdmUserRegister(MdmUserRepository mdmUserRepository) {
        this.mdmUserRepository = mdmUserRepository;
    }

    public void register(UserRegisterRequest req) {
        // TODO 将来的にversionRepositoryを作成して、現在有効なバージョンを自動で取得するようにする。
        final String name = "initial";
        final String info = "初版";
        final MdmVersion currentVersion = new MdmVersion(name, info);
        final String userNumber = UUID.randomUUID().toString();
        MdmUser user = new MdmUser(req.firstName(), req.lastName(), req.emailAddress(), userNumber, req.passWord(), currentVersion);
        mdmUserRepository.save(user);
    }
}
