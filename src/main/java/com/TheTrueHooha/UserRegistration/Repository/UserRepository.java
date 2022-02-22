package com.TheTrueHooha.UserRegistration.Repository;

import com.TheTrueHooha.UserRegistration.User.UserParameters;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <UserParameters, Long> {
}
