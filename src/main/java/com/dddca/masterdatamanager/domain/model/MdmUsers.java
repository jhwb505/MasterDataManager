package com.dddca.masterdatamanager.domain.model;


import com.dddca.masterdatamanager.domain.model.abstracts.AbstractVersion;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "mdm_users")
public class MdmUsers extends AbstractVersion {
}
