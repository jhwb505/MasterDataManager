package com.dddca.masterdatamanager.infrastructure.springsecurity;

import com.dddca.masterdatamanager.domain.model.MdmUser;
import com.dddca.masterdatamanager.domain.repository.MdmUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final MdmUserRepository mdmUserRepository;

    @Autowired
    public MyUserDetailsService(MdmUserRepository mdmUserRepository) {
        this.mdmUserRepository = mdmUserRepository;
    }

    /**
     * @param username ログインフォームで定義され、画面側のuserNumberの想定
     * @return UserDetails
     * @throws UsernameNotFoundException ユーザ見つからない例外
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MdmUser> mdmUserOpt = mdmUserRepository.findByEmailAddress(username);
        // TODO versionの考慮未実装、結果 > 1可能性があり
        if (mdmUserOpt.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        MdmUser targetUser = mdmUserOpt.get();
        final String currentPassword = targetUser.getStaticUserInfo().getPassword();

        // TODO:ユーザーロール情報暫定、ロールテーブル実装まち
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_MDM_USER"));

        return new User(username, currentPassword, grantedAuthorities);
    }
}
