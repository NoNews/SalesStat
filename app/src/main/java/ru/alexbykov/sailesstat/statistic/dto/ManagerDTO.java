package ru.alexbykov.sailesstat.statistic.dto;

/**
 * Created by Alexey on 12.07.2016.
 */
public class ManagerDTO {

    String name;
    int plan;


    public ManagerDTO(String name, int plan) {
        this.name = name;
        this.plan = plan;
    }


    public String getName() {
        return name;
    }

    public int getPlan() {
        return plan;
    }
}
