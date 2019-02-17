package site.tsun.mybatisdemo.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import site.tsun.mybatisdemo.mapper.UserMapper
import site.tsun.mybatisdemo.model.User
import site.tsun.mybatisdemo.service.UserService

@Service
class UserServiceImpl: UserService {

    @Autowired
    lateinit var userMapper: UserMapper

    override fun findUser(id: Int): User {
        return userMapper.findUser(id)
    }

    @Transactional(propagation= Propagation.REQUIRED)
    override fun save(record: User): Int {
        return userMapper.save(record)
    }

    @Transactional(propagation=Propagation.REQUIRED)
    override fun update(record: User): Int {
        return userMapper.update(record)
    }

    @Transactional(propagation=Propagation.REQUIRED)
    override fun delete(id: Int): Int {
        return userMapper.delete(id)
    }

}