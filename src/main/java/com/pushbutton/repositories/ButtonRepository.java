package com.pushbutton.repositories;

import com.pushbutton.models.Button;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ButtonRepository extends JpaRepository<Button, Long> {

}
