package com.example.demo.persistance

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.SpringBootTest

@DataJpaTest
class EntityRepositoryTest {
    @Autowired
    private lateinit var entityRepository: EntityRepository

    @Test
    fun `findById should find entity`() {
        val savedEntity = entityRepository.save(Entity(name = "Batman"))
        val foundEntity = entityRepository.findById(savedEntity.id!!)
        assertTrue { foundEntity.get() == savedEntity }
    }
}