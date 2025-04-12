package com.dddca.masterdatamanager.domain.model;


import com.dddca.masterdatamanager.domain.model.abstracts.AbstractVersion;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;

@Entity
@Table(name = "mdm_users")
public class MdmUser extends AbstractVersion {

    @Getter
    @Column(name = "first_name")
    private String firstName;

    @Getter
    @Column(name = "last_name")
    private String lastName;

    @Getter
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "static_user_id", referencedColumnName = "id")
    private MdmUserStaticInfo staticUserInfo;

    public MdmUser() {
    }

    public MdmUser(String firstName, String lastName, String emailAddress, String userNumber, String password, MdmVersion currentVersion) {
        this.firstName = firstName;
        this.lastName = lastName;
        super.setVersion(currentVersion);

        MdmUserStaticInfo staticUserInfo = new MdmUserStaticInfo(emailAddress, userNumber, password);
        this.staticUserInfo = staticUserInfo;
    }

    @ManyToMany
    @JoinTable(
            name = "mdm_user_user_roles", // 中間テーブル
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private ArrayList<MdmUserRole> mdmUserRoles;
}
