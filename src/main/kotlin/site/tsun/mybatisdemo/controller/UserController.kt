package site.tsun.mybatisdemo.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import site.tsun.mybatisdemo.model.HttpResult
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
    // @RequestBody force request body to be json format
    fun saveUser(@RequestBody user: User): User {
        userService.save(user)
        return user
    }

    @PutMapping("/user", consumes = ["application/json"], produces = ["application/json"])
    fun updateUser(@RequestBody user: User): User {
        userService.update(user)
        return user
    }

    @DeleteMapping("/user/{id}")
    fun deleteUser(@PathVariable id: Int): HttpResult {
        val result = userService.delete(id)
        when (result) {
            true -> return HttpResult()
            false -> {
                val errors: ArrayList<String> = ArrayList()
                errors.add("Failed to delete the user")
                return  HttpResult(false, errors)
            }
        }
    }
}