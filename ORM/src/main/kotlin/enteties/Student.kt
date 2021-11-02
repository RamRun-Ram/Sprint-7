package enteties

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Student(
    @Id
    @GeneratedValue
    var id: Long = 0,

    var name: String,

    @OneToOne(cascade = [CascadeType.ALL])
    var homeAddress: HomeAddress,

    @ManyToOne(cascade = [CascadeType.ALL])
    var specialization: Specialization?,

    @CreationTimestamp
    var createdTime: LocalDateTime? = null,

    @UpdateTimestamp
    var updateTimestamp: LocalDateTime? = null
) {
    override fun toString(): String {
        return "Student(id=$id, name='$name', homeAddress=$homeAddress, specialization=$specialization)"
    }
}