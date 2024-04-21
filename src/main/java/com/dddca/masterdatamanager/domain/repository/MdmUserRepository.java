package com.dddca.masterdatamanager.domain.repository;

import com.dddca.masterdatamanager.domain.model.MdmUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MdmUserRepository extends JpaRepository<MdmUser, Long> {
    List<MdmUser> findByUserNumber(String userNumber);
}
