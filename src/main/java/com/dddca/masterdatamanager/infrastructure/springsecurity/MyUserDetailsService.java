package com.dddca.masterdatamanager.infrastructure.springsecurity;

import com.dddca.masterdatamanager.domain.model.MdmUser;
import com.dddca.masterdatamanager.domain.repository.MdmUserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final MdmUserRepository mdmUserRepository;

    public MyUserDetailsService(MdmUserRepository mdmUserRepository) {
        this.mdmUserRepository = mdmUserRepository;
    }

    /**
     * @param username ログインフォームで定義され、画面側のuserNumberの想定
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<MdmUser> mdmUserList = mdmUserRepository.findByUserNumber(username);
        if (mdmUserList.size() == 0 || mdmUserList.size() > 1) {
            throw new UsernameNotFoundException(username);
        }
        MdmUser targetUser = mdmUserList.get(0);
        String password = targetUser.getPassword();

        // TODO:ユーザーロール情報暫定、ロールテーブル実装まち
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new User(username, password, grantedAuthorities);
    }
}
