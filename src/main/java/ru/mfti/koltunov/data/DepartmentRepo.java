package ru.mfti.koltunov.data;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DepartmentRepo extends CrudRepository<Department, Long> {
    @Query("Select id, departmentId, name from Departments where name = :name")
    Iterable<Department> findByName(@Param("name") String name);

    @Query("Delete from Employees where name = :name")
    void deleteByName(@Param("name") String name);
}
