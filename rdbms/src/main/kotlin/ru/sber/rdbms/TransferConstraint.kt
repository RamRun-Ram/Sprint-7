package ru.sber.rdbms

import java.sql.DriverManager
import java.sql.SQLException

class TransferConstraint {
    private val connection = DriverManager.getConnection(
        "jdbc:postgresql://localhost:5432/postgres",
        "postgres",
        "12345"
    )

    fun transfer(accountId1: Long, accountId2: Long, amount: Long) {
        connection.use{ conn-> try {
            val prepareStatementFirst =
                conn.prepareStatement("UPDATE account1 SET amount = amount - $amount WHERE id = $accountId1")
            prepareStatementFirst.use { statement ->
                statement.executeUpdate()
            }
            val prepareStatementSecond =
                conn.prepareStatement("UPDATE account1 SET amount = amount + $amount WHERE id = $accountId2")
            prepareStatementSecond.use { statement ->
                statement.executeUpdate()
            }
        }catch (exception: SQLException) {
            print("Ошибка операции")}
        }
    }
}
