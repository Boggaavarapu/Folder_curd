package com.springapllication.Application1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springapllication.Application1.Model.Student;

public interface StudentRepository extends JpaRepository<Student ,Long> {
	
}
