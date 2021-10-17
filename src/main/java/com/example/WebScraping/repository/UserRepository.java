package com.example.WebScraping.repository;

import com.example.WebScraping.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {



    public default void dataParsing(String yearFrom, String yearTo)  {
        //body olub olmayacagini bilmirem
    }
}
