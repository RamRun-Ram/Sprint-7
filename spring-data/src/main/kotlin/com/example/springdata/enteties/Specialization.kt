package com.example.springdata.enteties

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Specialization(
    @Id
    @GeneratedValue
    var id: Long = 0,

    var specialization: String
) {
    override fun toString(): String {
        return "Specialization(id= $id, specialization= '$specialization')"
    }
}
