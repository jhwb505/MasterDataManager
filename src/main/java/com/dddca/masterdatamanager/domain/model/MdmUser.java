package com.dddca.masterdatamanager.domain.model;


import com.dddca.masterdatamanager.domain.model.abstracts.AbstractVersion;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

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
    @Column(name = "email_address", nullable = false)
    private String emailAddress;

    @Getter
    @Column(name = "user_number", nullable = false)
    private String userNumber;

    @Getter
    @Column(name = "password", nullable = false)
    private String password;

    public MdmUser() {
    }

    public MdmUser(String firstName, String lastName, String emailAddress, String userNumber, String password, Version currentVersion) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userNumber = userNumber;
        this.password = password;
        this.versionId = currentVersion.getId();
    }
}
