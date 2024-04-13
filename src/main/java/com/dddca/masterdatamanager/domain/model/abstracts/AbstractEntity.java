package com.dddca.masterdatamanager.domain.model.abstracts;

import com.dddca.masterdatamanager.domain.model.interfaces.BasicEntityInterface;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity implements BasicEntityInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public Long id;
}
