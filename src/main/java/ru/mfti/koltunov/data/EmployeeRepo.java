package ru.mfti.koltunov.data;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepo extends CrudRepository<Employee, Long> {
    @Query("Select id, departmentId, name from employees where name = :name")
    Iterable<Employee> findByName(@Param("name") String name);

    @Query("Delete from employees where name = :name")
    void deleteByName(@Param("name") String name);
}
