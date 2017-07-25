package org.com.cay.repository;

import java.util.List;

import org.com.cay.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GirlRepository extends JpaRepository<Girl, Integer> {

	public List<Girl> findByAge(Integer age);
}
