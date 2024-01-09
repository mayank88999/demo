package com.example.demo.Repo;

import com.example.demo.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task,Long> {
}
