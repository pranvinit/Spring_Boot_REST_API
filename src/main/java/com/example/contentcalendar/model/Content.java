package com.example.contentcalendar.model;


import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public record Content(
        Integer id,
        @NotEmpty(message = "Please provide a valid title.")
        String title,
        @NotEmpty(message = "Please provide a valid description.")
        String desc,
        Status status,
        Type contentType,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String url
) {


}
