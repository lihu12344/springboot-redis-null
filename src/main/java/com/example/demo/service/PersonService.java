package com.example.demo.service;

import com.example.demo.pojo.Person;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lihu
 * @since 2019-11-23
 */
public interface PersonService extends IService<Person> {

    void add(Person person);

    Person getById(Integer id);

    void deleteById(Integer id);
}
