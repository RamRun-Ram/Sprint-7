
import enteties.*
import org.hibernate.cfg.Configuration

fun main() {
    val sessionFactory = Configuration().configure()
        .addAnnotatedClass(Student::class.java)
        .addAnnotatedClass(HomeAddress::class.java)
        .addAnnotatedClass(Specialization::class.java)
        .buildSessionFactory()

    sessionFactory.use { sessionFactory ->
        val dao = StudentDAO(sessionFactory)

        val student1 = Student(
            name = "Сергей",
            specialization = Specialization(specialization =  "ИРЭТ"),
            homeAddress = HomeAddress(street = "Мамадышский тракт")
        )
        val student2 = Student(
            name = "Александр",
            specialization = Specialization(specialization = "экономический"),
            homeAddress = HomeAddress(street = "Гаврилова")
        )

        dao.save(student1)
        dao.save(student2)

        var find = dao.find(student1.id)
        println("Найден студент: $find \n")

        var allStudents = dao.findAll()
        println("Список всех студентов: $allStudents")

//        dao.delete(5L)
//        dao.delete(8L)
    }
}