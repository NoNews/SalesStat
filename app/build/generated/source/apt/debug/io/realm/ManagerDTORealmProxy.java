package io.realm;


import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmFieldType;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.ImplicitTransaction;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Table;
import io.realm.internal.TableOrView;
import io.realm.internal.android.JsonUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ManagerDTORealmProxy extends ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO
    implements RealmObjectProxy, ManagerDTORealmProxyInterface {

    static final class ManagerDTOColumnInfo extends ColumnInfo {

        public final long nameIndex;
        public final long planIndex;

        ManagerDTOColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(2);
            this.nameIndex = getValidColumnIndex(path, table, "ManagerDTO", "name");
            indicesMap.put("name", this.nameIndex);

            this.planIndex = getValidColumnIndex(path, table, "ManagerDTO", "plan");
            indicesMap.put("plan", this.planIndex);

            setIndicesMap(indicesMap);
        }
    }

    private final ManagerDTOColumnInfo columnInfo;
    private final ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("name");
        fieldNames.add("plan");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    ManagerDTORealmProxy(ColumnInfo columnInfo) {
        this.columnInfo = (ManagerDTOColumnInfo) columnInfo;
        this.proxyState = new ProxyState(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class, this);
    }

    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    public void realmSet$name(String value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$plan() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.planIndex);
    }

    public void realmSet$plan(int value) {
        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.planIndex, value);
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if (!transaction.hasTable("class_ManagerDTO")) {
            Table table = transaction.getTable("class_ManagerDTO");
            table.addColumn(RealmFieldType.STRING, "name", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "plan", Table.NOT_NULLABLE);
            table.addSearchIndex(table.getColumnIndex("name"));
            table.setPrimaryKey("name");
            return table;
        }
        return transaction.getTable("class_ManagerDTO");
    }

    public static ManagerDTOColumnInfo validateTable(ImplicitTransaction transaction) {
        if (transaction.hasTable("class_ManagerDTO")) {
            Table table = transaction.getTable("class_ManagerDTO");
            if (table.getColumnCount() != 2) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field count does not match - expected 2 but was " + table.getColumnCount());
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 2; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final ManagerDTOColumnInfo columnInfo = new ManagerDTOColumnInfo(transaction.getPath(), table);

            if (!columnTypes.containsKey("name")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("name") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'name' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.nameIndex)) {
                throw new RealmMigrationNeededException(transaction.getPath(),"@PrimaryKey field 'name' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("name")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Primary key not defined for field 'name' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("name"))) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Index not defined for field 'name' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("plan")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'plan' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("plan") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'int' for field 'plan' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.planIndex)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'plan' does support null values in the existing Realm file. Use corresponding boxed type for field 'plan' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(transaction.getPath(), "The ManagerDTO class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_ManagerDTO";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO obj = null;
        if (update) {
            Table table = realm.getTable(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("name")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("name"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                obj = new io.realm.ManagerDTORealmProxy(realm.schema.getColumnInfo(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class));
                ((RealmObjectProxy)obj).realmGet$proxyState().setRealm$realm(realm);
                ((RealmObjectProxy)obj).realmGet$proxyState().setRow$realm(table.getUncheckedRow(rowIndex));
            }
        }
        if (obj == null) {
            if (json.has("name")) {
                if (json.isNull("name")) {
                    obj = (io.realm.ManagerDTORealmProxy) realm.createObject(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class, null);
                } else {
                    obj = (io.realm.ManagerDTORealmProxy) realm.createObject(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class, json.getString("name"));
                }
            } else {
                obj = (io.realm.ManagerDTORealmProxy) realm.createObject(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class);
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((ManagerDTORealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((ManagerDTORealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("plan")) {
            if (json.isNull("plan")) {
                throw new IllegalArgumentException("Trying to set non-nullable field plan to null.");
            } else {
                ((ManagerDTORealmProxyInterface) obj).realmSet$plan((int) json.getInt("plan"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    public static ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO obj = realm.createObject(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ManagerDTORealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((ManagerDTORealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("plan")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field plan to null.");
                } else {
                    ((ManagerDTORealmProxyInterface) obj).realmSet$plan((int) reader.nextInt());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO copyOrUpdate(Realm realm, ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO) cachedRealmObject;
        } else {
            ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((ManagerDTORealmProxyInterface) object).realmGet$name();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    realmObject = new io.realm.ManagerDTORealmProxy(realm.schema.getColumnInfo(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class));
                    ((RealmObjectProxy)realmObject).realmGet$proxyState().setRealm$realm(realm);
                    ((RealmObjectProxy)realmObject).realmGet$proxyState().setRow$realm(table.getUncheckedRow(rowIndex));
                    cache.put(object, (RealmObjectProxy) realmObject);
                } else {
                    canUpdate = false;
                }
            }

            if (canUpdate) {
                return update(realm, realmObject, object, cache);
            } else {
                return copy(realm, object, update, cache);
            }
        }
    }

    public static ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO copy(Realm realm, ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO) cachedRealmObject;
        } else {
            ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO realmObject = realm.createObject(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class, ((ManagerDTORealmProxyInterface) newObject).realmGet$name());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((ManagerDTORealmProxyInterface) realmObject).realmSet$name(((ManagerDTORealmProxyInterface) newObject).realmGet$name());
            ((ManagerDTORealmProxyInterface) realmObject).realmSet$plan(((ManagerDTORealmProxyInterface) newObject).realmGet$plan());
            return realmObject;
        }
    }

    public static long insert(Realm realm, ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO object, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class);
        long tableNativePtr = table.getNativeTablePointer();
        ManagerDTOColumnInfo columnInfo = (ManagerDTOColumnInfo) realm.schema.getColumnInfo(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);
        String realmGet$name = ((ManagerDTORealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.planIndex, rowIndex, ((ManagerDTORealmProxyInterface)object).realmGet$plan());
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class);
        long tableNativePtr = table.getNativeTablePointer();
        ManagerDTOColumnInfo columnInfo = (ManagerDTOColumnInfo) realm.schema.getColumnInfo(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class);
        ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO object = null;
        while (objects.hasNext()) {
            object = (ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO) objects.next();
            if(!cache.containsKey(object)) {
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);
                String realmGet$name = ((ManagerDTORealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.planIndex, rowIndex, ((ManagerDTORealmProxyInterface)object).realmGet$plan());
            }
        }
    }

    public static long insertOrUpdate(Realm realm, ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO object, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class);
        long tableNativePtr = table.getNativeTablePointer();
        ManagerDTOColumnInfo columnInfo = (ManagerDTOColumnInfo) realm.schema.getColumnInfo(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((ManagerDTORealmProxyInterface) object).realmGet$name();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = table.findFirstNull(pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
            if (primaryKeyValue != null) {
                Table.nativeSetString(tableNativePtr, pkColumnIndex, rowIndex, (String)primaryKeyValue);
            }
        }
        cache.put(object, rowIndex);
        String realmGet$name = ((ManagerDTORealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.planIndex, rowIndex, ((ManagerDTORealmProxyInterface)object).realmGet$plan());
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class);
        long tableNativePtr = table.getNativeTablePointer();
        ManagerDTOColumnInfo columnInfo = (ManagerDTOColumnInfo) realm.schema.getColumnInfo(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO.class);
        long pkColumnIndex = table.getPrimaryKey();
        ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO object = null;
        while (objects.hasNext()) {
            object = (ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO) objects.next();
            if(!cache.containsKey(object)) {
                String primaryKeyValue = ((ManagerDTORealmProxyInterface) object).realmGet$name();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                    if (primaryKeyValue != null) {
                        Table.nativeSetString(tableNativePtr, pkColumnIndex, rowIndex, ((ManagerDTORealmProxyInterface) object).realmGet$name());
                    }
                }
                cache.put(object, rowIndex);
                String realmGet$name = ((ManagerDTORealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.planIndex, rowIndex, ((ManagerDTORealmProxyInterface)object).realmGet$plan());
            }
        }
    }

    public static ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO createDetachedCopy(ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO)cachedObject.object;
            } else {
                unmanagedObject = (ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((ManagerDTORealmProxyInterface) unmanagedObject).realmSet$name(((ManagerDTORealmProxyInterface) realmObject).realmGet$name());
        ((ManagerDTORealmProxyInterface) unmanagedObject).realmSet$plan(((ManagerDTORealmProxyInterface) realmObject).realmGet$plan());
        return unmanagedObject;
    }

    static ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO update(Realm realm, ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO realmObject, ru.alexbykov.sailesstat.remote.dto.models.ManagerDTO newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((ManagerDTORealmProxyInterface) realmObject).realmSet$plan(((ManagerDTORealmProxyInterface) newObject).realmGet$plan());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ManagerDTO = [");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{plan:");
        stringBuilder.append(realmGet$plan());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManagerDTORealmProxy aManagerDTO = (ManagerDTORealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aManagerDTO.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aManagerDTO.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aManagerDTO.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
