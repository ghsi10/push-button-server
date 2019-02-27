package com.pushbutton.repositories;

import com.pushbutton.models.SourceDevice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ButtonRepository extends JpaRepository<SourceDevice, Long> {

}
