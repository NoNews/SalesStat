package ru.alexbykov.sailesstat.local;

import android.content.Context;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmModel;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO;


public class RealmHelper {

    Context context;
    Realm realm;


    public RealmHelper(Context context) {
        this.context = context;

        checkRealmConfiguration();


    }

    private void checkRealmConfiguration() {

        if (Realm.getDefaultInstance() == null) {
            RealmConfiguration rconf = new RealmConfiguration.Builder(context).build();
            Realm.setDefaultConfiguration(rconf);
        }
        realm = Realm.getDefaultInstance();
    }


    public void copyToRealmOrUpdate(List<ManagerDTO> managersFromJson) {

        realm.beginTransaction();

        List<ManagerDTO> managersFromRealm = getAllFromRealm(ManagerDTO.class);

        for (ManagerDTO managerFromRealm : managersFromRealm) {

            String managerFromRealmName = managerFromRealm.getName();
            if (!isFindInJSON(managersFromJson, managerFromRealmName))
                managerFromRealm.deleteFromRealm();
        }


        for (ManagerDTO manager : managersFromJson) {
            realm.copyToRealmOrUpdate(manager);
        }
        realm.commitTransaction();
    }


    public <S extends RealmModel> List getAllFromRealm(Class<S> clazz) {

        RealmQuery<S> query = realm.where(clazz);
        return query.findAll();
    }


    public void deleteFromRealm() {
        realm.beginTransaction();
        RealmResults<ManagerDTO> result = realm.where(ManagerDTO.class).findAll();
        result.deleteAllFromRealm();
        realm.commitTransaction();
    }


    private boolean isFindInJSON(List<ManagerDTO> managersFromJson, String managerFromDbName) {

        boolean isTheSame = false;
        for (ManagerDTO managerFromJson : managersFromJson) {

            String managerFromJsonName = managerFromJson.getName();
            if (managerFromDbName.equals(managerFromJsonName)) {
                isTheSame = true;
                break;
            }
        }
        return isTheSame;
    }


}
