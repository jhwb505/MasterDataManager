package com.dddca.masterdatamanager.domain.model;

import com.dddca.masterdatamanager.domain.model.abstracts.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "mdm_user_static_info")
public class MdmUserStaticInfo extends AbstractEntity {

    @NaturalId
    @Getter
    @Column(name = "email_address", unique = true, nullable = false)
    private String emailAddress;

    @NaturalId
    @Getter
    @Column(name = "user_number", unique = true, nullable = false)
    private String userNumber;

    @Getter
    @Column(name = "password", nullable = false)
    private String password;

    public MdmUserStaticInfo() {
    }

    public MdmUserStaticInfo(final String emailAddress, final String userNumber, final String password) {
        this.emailAddress = emailAddress;
        this.userNumber = userNumber;
        this.password = password;
    }
}
