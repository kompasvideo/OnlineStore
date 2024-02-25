package ru.andreybaryshnikov.notificationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MoneyKafka {
    private LocalDateTime dateTime;
    private String operation;
    private double count;
    private double total;
    private String xRequestId;
    private long userId;
}