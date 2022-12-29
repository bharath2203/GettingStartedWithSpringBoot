package com.learning.GettingStartedWithSpringBoot.courses;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJDBCRepository {

    private final JdbcTemplate springJdbcTemplate;

    private static final String RAW_INSERT_QUERY =
            """
                    INSERT INTO COURSE (id, name, author)
                    VALUES(1, 'Learn Spring', 'everyone');
                    """;

    private static final String PARAMETERISED_INSERT_QUERY =
            """
                    INSERT INTO COURSE (id, name, author)
                    VALUES(?,?,?);
                    """;

    private static final String PARAMETERISED_DELETE_QUERY =
            """
                    DELETE FROM COURSE WHERE id=?;
                    """;


    public CourseJDBCRepository(JdbcTemplate springJdbcTemplate) {
        this.springJdbcTemplate = springJdbcTemplate;
    }

    public void insert(Course course) {
        springJdbcTemplate.update(RAW_INSERT_QUERY);

        springJdbcTemplate.update(
                PARAMETERISED_INSERT_QUERY,
                course.getId(),
                course.getName(),
                course.getAuthor()
        );
    }

    public void delete(Long id) {
        springJdbcTemplate.update(PARAMETERISED_DELETE_QUERY, id);
    }
}
