package com.dddca.masterdatamanager.domain.model.abstracts;

import com.dddca.masterdatamanager.domain.model.interfaces.BasicEntityInterface;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractVersion extends AbstractEntity implements BasicEntityInterface {
    @Column(name = "version_id")
    public Long versionId;
}
