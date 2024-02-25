package ru.andreybaryshnikov.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Money {
    private LocalDateTime dateTime;
    private String operation;
    private double count;
    private double total;
}
