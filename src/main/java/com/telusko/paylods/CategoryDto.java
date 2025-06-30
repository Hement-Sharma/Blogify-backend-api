package com.telusko.paylods;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto{
    private Integer categoryId;

    @NotBlank(message = "title cannot be blank")
    @Size(min = 4,message = "minimum length of title must be 4 char's ")
    private String categoryTitle;

    @NotBlank
    @Size(min = 5,message = "minimum length of description must be 5 char's ")
    private String categoryDescription;
}
