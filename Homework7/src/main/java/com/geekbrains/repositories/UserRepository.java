package com.geekbrains.repositories;
import com.geekbrains.entities.User;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
