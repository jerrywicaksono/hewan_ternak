package com.cattle.livestocks.repository.generic;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T, P extends Serializable> extends JpaRepository<T, P>{
	
}