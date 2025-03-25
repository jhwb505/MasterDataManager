package com.dddca.masterdatamanager.domain.repository;

import com.dddca.masterdatamanager.domain.model.MdmUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MdmUserRepository extends JpaRepository<MdmUser, Long> {
    @Query("SELECT mdmuser FROM MdmUser mdmuser JOIN mdmuser.staticUserInfo staticinfo WHERE staticinfo.emailAddress = :emailAddress")
    Optional<MdmUser> findByEmailAddress(@Param("emailAddress") String emailAddress);
}
