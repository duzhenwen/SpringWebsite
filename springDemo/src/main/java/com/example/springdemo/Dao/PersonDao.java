package com.example.springdemo.Dao;



import com.example.springdemo.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDao extends JpaRepository<Person,Integer> {
  //  Person findOne(Integer id);
  //  Person findByName(String name);

   // static void save(Person person) {
    //}
}
