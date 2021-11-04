package com.example.springdata

import com.example.springdata.enteties.HomeAddress
import com.example.springdata.enteties.Specialization
import com.example.springdata.enteties.Student
import com.example.springdata.repository.StudentRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringData(private val studentRepository: StudentRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
        val student1 = Student(
            name = "Сергей",
            specialization = Specialization(specialization = "инженерия"),
            homeAddress = HomeAddress(street = "Мамадышский тракт")
        )
        val student2 = Student(
            name = "Александр",
            specialization = Specialization(specialization = "бухгалтерия"),
            homeAddress = HomeAddress(street = "Гаврилова")
        )
        studentRepository.saveAll(listOf(student1, student2))
        val findName = studentRepository.findAllByName("Александр")
        print(findName)
    }
}

fun main(args: Array<String>) {
    runApplication<SpringData>(*args)
}
