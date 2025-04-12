package com.dddca.masterdatamanager.domain.model;

import com.dddca.masterdatamanager.domain.model.abstracts.AbstractVersion;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;

@Entity
@Table(name = "mdm_org_units")
public class MdmOrgUnit extends AbstractVersion {
    @Getter
    @Column(name = "code")
    private String code;

    @Getter
    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "mdm_org_unit_users", // 中間テーブル
            joinColumns = @JoinColumn(name = "org_unit_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
    )
    private ArrayList<MdmUser> mdmUsers;

}
