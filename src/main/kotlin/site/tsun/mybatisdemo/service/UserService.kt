package site.tsun.mybatisdemo.service

import org.springframework.stereotype.Service
import site.tsun.mybatisdemo.model.User

@Service
interface UserService {
    fun findUser(id: Int): User
    fun save(record: User): Int
    fun update(record: User): Int
    fun delete(id: Int): Boolean
}