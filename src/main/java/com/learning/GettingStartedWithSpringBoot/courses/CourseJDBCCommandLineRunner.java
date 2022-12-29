package com.learning.GettingStartedWithSpringBoot.courses;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * CommandLineRunner can be used to run some stuff the needs by the start-up of the application
 */
@Component
public class CourseJDBCCommandLineRunner implements CommandLineRunner {

    private final CourseJDBCRepository courseJDBCRepository;

    // Auto wiring through constructor injection
    public CourseJDBCCommandLineRunner(CourseJDBCRepository courseJDBCRepository) {
        this.courseJDBCRepository = courseJDBCRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        courseJDBCRepository.insert(
                Course.builder()
                        .id(2L)
                        .name("Everything")
                        .author("Bharath")
                        .build()
        );

        courseJDBCRepository.delete(1L);
    }
}
