package ru.alexbykov.sailesstat.remote.dto;



import java.util.List;

import retrofit2.http.GET;
import ru.alexbykov.sailesstat.Const;
import ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO;
import rx.Observable;





public interface ApiObject {

    @GET(Const.URL.JsonManagers)
    Observable<List<ManagerDTO>> getManagers();

}
