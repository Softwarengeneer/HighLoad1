package com.example.highload1.persistance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface User extends JpaRepository<User, UUID> {
    Optional<User> findByName(String username);
}
