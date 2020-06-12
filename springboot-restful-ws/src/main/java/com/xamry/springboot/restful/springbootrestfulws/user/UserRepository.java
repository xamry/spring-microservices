package com.xamry.springboot.restful.springbootrestfulws.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Spring data repository, is an interface. 
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
