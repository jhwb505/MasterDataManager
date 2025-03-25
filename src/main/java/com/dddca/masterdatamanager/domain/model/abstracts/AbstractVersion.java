package com.dddca.masterdatamanager.domain.model.abstracts;

import com.dddca.masterdatamanager.domain.model.MdmVersion;
import com.dddca.masterdatamanager.domain.model.interfaces.BasicEntityInterface;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
public abstract class AbstractVersion extends AbstractEntity implements BasicEntityInterface {
    // TODO vesionIdの位置をIDの後につけたい
    @Getter
    @Setter
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "version_id", referencedColumnName = "id")
    private MdmVersion version;
}
