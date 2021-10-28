package com.example.demo.controller

import com.example.demo.persistance.Entity
import com.example.demo.persistance.EntityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {

    @GetMapping("hello")
    fun hello() = "Helloyyy"

}