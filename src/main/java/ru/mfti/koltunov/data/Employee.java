package ru.mfti.koltunov.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("EMPLOYEES")
public class Employee {
    @Id
    Long id;
    @Column("DEPARTMENTID")
    Long departmentId;
    String name;
}
