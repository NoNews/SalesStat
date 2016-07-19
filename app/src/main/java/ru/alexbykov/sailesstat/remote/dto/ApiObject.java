package ru.alexbykov.sailesstat.remote.dto;



import java.util.List;

import retrofit2.http.GET;
import ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO;
import rx.Observable;





public interface ApiObject {

    @GET("11p73.json")
    Observable<List<ManagerDTO>> getManagers();

}
