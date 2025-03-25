package com.dddca.masterdatamanager.domain.model;

import com.dddca.masterdatamanager.domain.model.abstracts.AbstractVersion;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "mdm_user_roles")
public class MdmUserRole extends AbstractVersion {
    @Getter
    @Column(name = "code")
    private String code;

    @Getter
    @Column(name = "name")
    private String name;
}
