package com.shalyapin.library.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private Long id;
    private String title;
    private Long authorId;
    private String edition;
}
