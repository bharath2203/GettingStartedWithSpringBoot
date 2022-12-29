package com.learning.GettingStartedWithSpringBoot.courses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Course {
    private Long id;
    private String name;
    private String author;
}
