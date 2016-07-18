package ru.alexbykov.sailesstat.remote.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;


/**
 * Created by Alexey on 12.07.2016.
 */
public class ManagerDTO {


    @JsonSerialize
    private ArrayList<ManagerDTO> managerLists;

    String name;
    int plan;


    public ManagerDTO(String name, int plan) {
        this.name = name;
        this.plan = plan;
    }

    public void setManagerLists(ArrayList<ManagerDTO> managerLists) {
        this.managerLists = managerLists;
    }


    public ArrayList<ManagerDTO> getManagerLists() {

        return managerLists;
    }

    public String getName() {
        return name;
    }

    public int getPlan() {
        return plan;
    }


    public ManagerDTO(){

    }

}
