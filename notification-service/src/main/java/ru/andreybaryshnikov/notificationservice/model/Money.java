package ru.andreybaryshnikov.notificationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

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
