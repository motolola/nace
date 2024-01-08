package com.nace.excercise.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NaceDataDto {

    @NotNull(message = "Name is orderNumber")
    private Long orderNumber;
    @NotBlank(message = "Name is level")
    private String level;
    @NotBlank(message = "Name is code")
    private String code;
    @NotBlank(message = "Name is parent")
    private String parent;
    @NotBlank(message = "Name is description")
    private String description;
    @NotBlank(message = "Name is thisItemIncludes")
    private String thisItemIncludes;
    @NotBlank(message = "Name is thisItemAlsoIncludes")
    private String thisItemAlsoIncludes;
    private String rulings;
    @NotBlank(message = "Name is thisItemExcludes")
    private String thisItemExcludes;
    @NotBlank(message = "Name is referenceTpIsicRev4")
    private String referenceTpIsicRev4;
}

