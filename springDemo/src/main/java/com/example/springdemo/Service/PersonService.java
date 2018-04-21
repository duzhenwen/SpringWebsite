package com.example.springdemo.Service;


import com.example.springdemo.Dao.PersonDao;
import com.example.springdemo.Entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service("names")
public class PersonService{
    @Autowired
    private PersonDao personDao;
   @Transactional
    public void add(String name,String telephone,String email){
        Person person=new Person();
        person.setName(name);
        person.setEmail(email);
        person.setTelephone(telephone);
        personDao.save(person);


    }

}



