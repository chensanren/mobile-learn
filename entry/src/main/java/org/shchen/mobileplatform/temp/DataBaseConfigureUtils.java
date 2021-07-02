package org.shchen.mobileplatform.temp;

import ohos.app.Context;
import ohos.data.DatabaseHelper;
import ohos.data.rdb.RdbOpenCallback;
import ohos.data.rdb.RdbStore;
import ohos.data.rdb.StoreConfig;

public class DataBaseConfigureUtils {

    public static RdbStore createRDBStore(String localDBName, Context context,String initStatement) {
        StoreConfig config = StoreConfig.newDefaultConfig(localDBName);
        DatabaseHelper helper = new DatabaseHelper(context);

        return helper.getRdbStore(config, 1, new RdbOpenCallback() {
            @Override
            public void onCreate(RdbStore store) {
                store.executeSql(initStatement);
            }

            @Override
            public void onUpgrade(RdbStore store, int oldVersion, int newVersion) {
            }

        }, null);
    }
}
