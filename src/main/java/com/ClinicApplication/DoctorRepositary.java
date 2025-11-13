package com.ClinicApplication.Repositary;
import com.ClinicApplication.model.Doctor;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface DoctorRepositary extends JpaRepository<Doctor, Long> {
    Doctor findByNameContainingIgnoreCase(String name);

    Doctor findBySpecialization(String specialization);

    //List<Doctor> findByNameContainingIgnoreCase(String name);
    //List<Doctor> findBySpecialization(String specialization);
    //Page<Doctor> findAll(Pageable pageable);
}
