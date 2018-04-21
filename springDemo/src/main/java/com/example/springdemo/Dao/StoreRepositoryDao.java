package com.example.springdemo.Dao;

import com.example.springdemo.Entity.StoreRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepositoryDao extends JpaRepository<StoreRepository,Integer> {


}
