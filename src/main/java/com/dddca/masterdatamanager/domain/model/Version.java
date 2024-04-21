package com.dddca.masterdatamanager.domain.model;

import com.dddca.masterdatamanager.domain.model.abstracts.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "versions")
public class Version extends AbstractEntity {

    @Column(name = "name")
    @Getter
    private String name;

    @Column(name = "info", columnDefinition = "TEXT")
    @Getter
    private String info;

    public Version() {
    }

    public Version(String name, String info) {
        this.name = name;
        this.info = info;
    }

}
