package ru.alexbykov.sailesstat.local;

import java.util.ArrayList;
import java.util.List;

import ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO;

/**
 * Created by Alexey on 22.07.2016.
 */
public class Cache {


    private static List<ManagerDTO> managerDTO = new ArrayList<>();


    private Cache() {
    }

    public static List<ManagerDTO> getManagers() {
        return managerDTO;
    }

    public static void setManagerDTO(List<ManagerDTO> managerDTO) {
        Cache.managerDTO = managerDTO;
    }
}
