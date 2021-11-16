package com.example.springdata.repository

import com.example.springdata.enteties.Student
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : CrudRepository<Student, Long> {
    fun findAllByName(name: String): List<Student>
}