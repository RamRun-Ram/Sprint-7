package enteties

import org.hibernate.SessionFactory

class StudentDAO(
    private val sessionFactory: SessionFactory
) {
    fun save(student: Student) {
        sessionFactory.openSession().use { session ->
            session.beginTransaction()
            session.save(student)
            session.transaction.commit()
        }
    }

    fun find(id: Long): Student? {
        val result: Student?
        sessionFactory.openSession().use { session ->
            session.beginTransaction()
            result = session.get(Student::class.java, id)
            session.transaction.commit()
        }
        return result
    }

    fun delete(id: Long) {
        sessionFactory.openSession().use { session ->
            session.beginTransaction()
            val std = find(id)
            session.remove(std)
            session.transaction.commit()
        }
    }

    fun findAll(): List<Student> {
        val result: List<Student>
        sessionFactory.openSession().use { session ->
            session.beginTransaction()
            result = session.createQuery("from Student").list() as List<Student>
            session.transaction.commit()
        }
        return result
    }
}