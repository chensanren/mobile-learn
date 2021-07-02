package org.shchen.mobileplatform;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.data.DatabaseHelper;
import ohos.data.rdb.*;
import ohos.data.resultset.ResultSet;
import ohos.data.dataability.DataAbilityPredicates;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;
import ohos.utils.net.Uri;
import ohos.utils.PacMap;
import org.shchen.mobileplatform.temp.DataBaseConfigureUtils;

import java.io.FileDescriptor;

public class DataAbility extends Ability {

    private static final HiLogLabel LABEL_LOG = new HiLogLabel(3, 0xD001100, "Demo");
    private RdbStore rdbStore;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        HiLog.info(LABEL_LOG, "DataAbility onStart");
        String initStatement = "CREATE TABLE IF NOT EXISTS USER (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR NOT NULL, password VARCHAR NOT NULL, gender VARCHAR NOT NULL )";
        rdbStore = DataBaseConfigureUtils.createRDBStore("MobilePlatform.db", this, initStatement);
    }

    @Override
    public ResultSet query(Uri uri, String[] columns, DataAbilityPredicates predicates) {
        columns = new String[] {"id", "name", "age", "salary"};
        RdbPredicates rdbPredicates = new RdbPredicates("test").equalTo("age", 25).orderByAsc("salary");
        ResultSet resultSet = rdbStore.query(rdbPredicates, columns);
        resultSet.goToNextRow();
        return null;
    }

    @Override
    public int insert(Uri uri, ValuesBucket value) {
        HiLog.info(LABEL_LOG, "DataAbility insert");
        ValuesBucket valuesBucket = new ValuesBucket();
        valuesBucket.putString("name", "");
        valuesBucket.putString("password", "");
        valuesBucket.putString("gender", "");
        rdbStore.insert("USER", valuesBucket);
        return 999;
    }

    @Override
    public int delete(Uri uri, DataAbilityPredicates predicates) {
        return 0;
    }

    @Override
    public int update(Uri uri, ValuesBucket value, DataAbilityPredicates predicates) {
        return 0;
    }

    @Override
    public FileDescriptor openFile(Uri uri, String mode) {
        return null;
    }

    @Override
    public String[] getFileTypes(Uri uri, String mimeTypeFilter) {
        return new String[0];
    }

    @Override
    public PacMap call(String method, String arg, PacMap extras) {
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }
}