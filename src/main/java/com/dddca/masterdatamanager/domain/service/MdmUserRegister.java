package com.dddca.masterdatamanager.domain.service;

import com.dddca.masterdatamanager.domain.model.MdmUser;
import com.dddca.masterdatamanager.domain.model.MdmVersion;
import com.dddca.masterdatamanager.domain.repository.MdmUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class MdmUserRegister {

    private final MdmUserRepository mdmUserRepository;

    @Autowired
    public MdmUserRegister(MdmUserRepository mdmUserRepository) {
        this.mdmUserRepository = mdmUserRepository;
    }

    public void register(final String firstName, final String lastName, final String emailAddress, final String passWord ) {
        // TODO 将来的にversionRepositoryを作成して、現在有効なバージョンを自動で取得するようにする。
        final MdmVersion currentVersion = null;
        final String userNumber = null;
        MdmUser user = new MdmUser(firstName, lastName, emailAddress, userNumber, passWord, currentVersion);
        mdmUserRepository.save(user); // ← これでDBに1レコード追加
    }
}
