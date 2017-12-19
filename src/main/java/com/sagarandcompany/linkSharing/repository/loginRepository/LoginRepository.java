package com.sagarandcompany.linkSharing.repository.loginRepository;

import com.sagarandcompany.linkSharing.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<User, Long> {
//    @Query(value = "select * from user where username=;usernmae ,password=:password", nativeQuery = true)
//    public User findByUsernameAndPassword(@Param("usernmae") String username, @Param("password") String password);

    public User findByUsernameAndPassword(String username, String password);
}
