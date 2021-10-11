package com.dOne.MFaRe;

import com.dOne.MFaRe.Database.EntityForPersonTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class WelcomingSocket {

    @Autowired
    private JdbcTemplate jdbcTemplatee;

    @RequestMapping("/persondatabase")
    public List<EntityForPersonTable > welcome()
    {return jdbcTemplatee.query("SELECT id FROM PERSON", BeanPropertyRowMapper.newInstance(EntityForPersonTable.class));}

    @GetMapping("/persondatabase/id/{id}")
    public List<EntityForPersonTable > getUsersById(@PathVariable(value = "id") Long userId){
        return jdbcTemplatee.query("SELECT * FROM PERSON where id="+userId, BeanPropertyRowMapper.newInstance(EntityForPersonTable.class));
    }
    @GetMapping("/persondatabase/ad/{ad}")
    public List<EntityForPersonTable > getUsersByAd(@PathVariable(value = "ad") String userAd){
        return jdbcTemplatee.query("SELECT * FROM PERSON where ad=\""+userAd+"\"", BeanPropertyRowMapper.newInstance(EntityForPersonTable.class));
    }
    @GetMapping("/persondatabase/soyad/{soyad}")
    public List<EntityForPersonTable > getUsersBySoyad(@PathVariable(value = "soyad") String userSoyad){
        return jdbcTemplatee.query("SELECT * FROM PERSON where soyad="+userSoyad, BeanPropertyRowMapper.newInstance(EntityForPersonTable.class));
    }

    @Autowired
    private JdbcTemplate first;

    @RequestMapping("/persondatabase/first")
    public List<Map<String, Object>> database()
    {

        return first.queryForList("SELECT COUNT (ID) FROM PERSON", Collections.emptyMap());

    }


}
