package com.example.demo.serviceImpl;

import com.example.demo.pojo.Person;
import com.example.demo.dao.PersonMapper;
import com.example.demo.service.PersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lihu
 * @since 2019-11-23
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {

    @Resource
    private PersonMapper personMapper;

    @Override
    @Cacheable(value = "custom",key="'person'+#id")
    public Person getById(Integer id) {
        System.out.println("查询id为："+id+"的person");
        return personMapper.selectById(id);
    }

    @Override
    @CachePut(value = "custom",key = "'person'+#person.id")
    public void add(Person person) {
        personMapper.insert(person);
    }

    @Override
    @CacheEvict(value = "custom",key = "'person'+#id")
    public void deleteById(Integer id) {
        personMapper.deleteById(id);
    }
}
