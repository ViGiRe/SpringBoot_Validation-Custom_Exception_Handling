package com.app.Validation_Custom_Exception.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Validation_Custom_Exception.Entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserId(Long id);

}
