package io.realm;


import android.util.JsonReader;
import io.realm.internal.ColumnInfo;
import io.realm.internal.ImplicitTransaction;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Table;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>();
        modelClasses.add(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Table createTable(Class<? extends RealmModel> clazz, ImplicitTransaction transaction) {
        checkClass(clazz);

        if (clazz.equals(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class)) {
            return io.realm.ManagerDTORealmProxy.initTable(transaction);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public ColumnInfo validateTable(Class<? extends RealmModel> clazz, ImplicitTransaction transaction) {
        checkClass(clazz);

        if (clazz.equals(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class)) {
            return io.realm.ManagerDTORealmProxy.validateTable(transaction);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class)) {
            return io.realm.ManagerDTORealmProxy.getFieldNames();
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public String getTableName(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class)) {
            return io.realm.ManagerDTORealmProxy.getTableName();
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, ColumnInfo columnInfo) {
        checkClass(clazz);

        if (clazz.equals(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class)) {
            return clazz.cast(new io.realm.ManagerDTORealmProxy(columnInfo));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class)) {
            return clazz.cast(io.realm.ManagerDTORealmProxy.copyOrUpdate(realm, (ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO) obj, update, cache));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class)) {
            io.realm.ManagerDTORealmProxy.insert(realm, (ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new IdentityHashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class)) {
                io.realm.ManagerDTORealmProxy.insert(realm, (ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class)) {
                    io.realm.ManagerDTORealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class)) {
            io.realm.ManagerDTORealmProxy.insertOrUpdate(realm, (ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new IdentityHashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class)) {
                io.realm.ManagerDTORealmProxy.insertOrUpdate(realm, (ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class)) {
                    io.realm.ManagerDTORealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class)) {
            return clazz.cast(io.realm.ManagerDTORealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class)) {
            return clazz.cast(io.realm.ManagerDTORealmProxy.createUsingJsonStream(realm, reader));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class)) {
            return clazz.cast(io.realm.ManagerDTORealmProxy.createDetachedCopy((ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO) realmObject, 0, maxDepth, cache));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

}
