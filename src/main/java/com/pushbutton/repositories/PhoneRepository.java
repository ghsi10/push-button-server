package com.pushbutton.repositories;

import com.pushbutton.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, String> {

//    @Transactional(readOnly = true)
//    @Query("select p.token from Phone p WHERE p.device = ?1")
//    Optional<String> findTokenByDevice(String device);
}
