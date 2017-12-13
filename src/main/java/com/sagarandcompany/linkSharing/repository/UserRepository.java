package com.sagarandcompany.linkSharing.repository;

import com.sagarandcompany.linkSharing.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
