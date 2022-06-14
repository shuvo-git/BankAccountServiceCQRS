package com.example.jpapractice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Entity
@Table(name = "events")
@Data
@NoArgsConstructor
public class Event {

    @Id
    @NotEmpty(message = "ID should not be Null or Blank")
    private String id;

    @Range(min = 1,max = 10,message = "Status should be in between 1 and 10")
    @NotNull(message = "Status should not be Null or Blank")
    private Integer status;
}
