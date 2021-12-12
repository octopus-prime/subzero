package com.example.subzero;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

public record Book(
        @Id
        @JsonIgnore
        UUID id,

        @NotEmpty(groups = Creating.class)
        String isbn,

        @NotEmpty(groups = Creating.class)
        String title,

        @NotEmpty(groups = Creating.class)
        String author,

        @NotNull(groups = Creating.class)
        LocalDate date
) {
    @Builder
    public Book {
    }
}
