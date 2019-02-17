package site.tsun.mybatisdemo.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import site.tsun.mybatisdemo.model.User
import site.tsun.mybatisdemo.service.impl.UserServiceImpl

@RestController
class UserController {

    @Autowired lateinit var userService: UserServiceImpl

    @GetMapping("/user/{id}")
    fun getUser(@PathVariable id: Int): User {
       return userService.findUser(id)
    }

    @PostMapping("/user", consumes = ["application/json"], produces = ["application/json"])
    fun saveUser(@RequestBody payload: String): String {
        return payload
    }


}