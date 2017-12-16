package com.sagarandcompany.linkSharing.repository.userRepository;

import com.sagarandcompany.linkSharing.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository {
    public User save(User user);

}
