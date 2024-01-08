package com.nace.excercise.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "NACE_DATA")
@Data
public class NaceData {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long Id;

    @Column(name = "ORDER_NUMBER")
    private Long orderNumber;

    @Column(name = "LEVEL")
    private String level;

    @Column(name = "CODE")
    private String code;

    @Column(name = "PARENT")
    private String parent;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "THIS_ITEM_INCLUDES")
    private String thisItemIncludes;

    @Column(name = "THIS_ITEM_ALSO_INCLUDE")
    private String thisItemAlsoIncludes;

    @Column(name = "RULINGS")
    private String rulings;

    @Column(name = "THIS_ITEM_EXCLUDES")
    private String thisItemExcludes;

    @Column(name = "REFERENCE_TO_ISIC_REV_4")
    private String referenceTpIsicRev4;


}

