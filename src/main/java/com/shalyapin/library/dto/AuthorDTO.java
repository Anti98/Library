package com.shalyapin.library.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {
        private Long id;
        private String name;
        private String surName;
        private String patronymic;
}
