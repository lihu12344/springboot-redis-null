package com.example.demo.controller;


import com.example.demo.pojo.Person;
import com.example.demo.service.PersonService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lihu
 * @since 2019-11-23
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Resource
    private PersonService personService;

    @RequestMapping("/add")
    public String add(){
        for (int i=0;i<100;i++){
            Person person=new Person();
            person.setName("瓜田李下"+i);
            person.setAge(10+i%10);

            personService.add(person);
        }

        return "success";
    }

    @RequestMapping("/get")
    public String get(@RequestParam("id") Integer id){
        Person person= personService.getById(id);

        if (person!=null){
            System.out.println(person);
            return person.toString();
        }else {
            System.out.println("查找的id为："+id+" 的person不存在");
            return "查找的id为："+id+" 的person不存在";
        }
    }

    @RequestMapping("/delete")
    public String delete(Integer id){
        personService.deleteById(id);

        return "success";
    }
}

