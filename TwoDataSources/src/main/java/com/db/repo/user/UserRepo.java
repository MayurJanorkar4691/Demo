package com.db.repo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
