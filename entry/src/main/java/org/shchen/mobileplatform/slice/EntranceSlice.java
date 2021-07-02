package org.shchen.mobileplatform.slice;

import ohos.aafwk.ability.IAbilityConnection;
import ohos.aafwk.content.Operation;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.ListContainer;
import ohos.agp.window.dialog.ToastDialog;
import ohos.bundle.ElementName;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;
import ohos.rpc.IRemoteObject;
import org.shchen.mobileplatform.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import org.shchen.mobileplatform.Utils;

public class EntranceSlice extends AbilitySlice {

    private static final HiLogLabel label = new HiLogLabel(3, 0xD001100, "EntranceSlice");
    private static final int REQ_CODE_QUERY_WEATHER = 1;
    private final IAbilityConnection connection = new IAbilityConnection() {
        @Override
        public void onAbilityConnectDone(ElementName elementName, IRemoteObject iRemoteObject, int resultCode) {
        }

        @Override
        public void onAbilityDisconnectDone(ElementName elementName, int resultCode) {

        }
    };

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_entrance_slice);

        initButton();
    }

    @Override
    protected void onAbilityResult(int requestCode, int resultCode, Intent resultData) {
        switch (requestCode) {
            case REQ_CODE_QUERY_WEATHER:
                HiLog.info(label, "---------------------------------");
                return;
            default:
        }
    }

    private void initButton() {
//        Utils.bundleButtonInAbilitySlice(this, ResourceTable.Id_init_local_db, listener -> {
//            Intent dataIntent = new Intent();
//            Operation dataOperation = new Intent.OperationBuilder()
//                    .withDeviceId("")
//                    .withBundleName("org.shchen.mobileplatform")
//                    .withAbilityName("org.shchen.mobileplatform.DataAbility")
//                    .build();
//            dataIntent.setOperation(dataOperation);
//            startAbility(dataIntent);
//        });

        Utils.bundleButtonInAbilitySlice(this, ResourceTable.Id_start_service_ability, listener -> {
            Intent serviceIntent = new Intent();
            Operation serviceOperation = new Intent.OperationBuilder()
                    .withDeviceId("")
                    .withBundleName("org.shchen.mobileplatform")
                    .withAbilityName("org.shchen.mobileplatform.ServiceAbility")
                    .build();
            serviceIntent.setOperation(serviceOperation);
            connectAbility(serviceIntent, connection);
            startAbility(serviceIntent);
        });

        Utils.bundleButtonInAbilitySlice(this, ResourceTable.Id_switch_to_homepage_button, listener -> present(new HomeSlice(), new Intent()));

        Utils.bundleButtonInAbilitySlice(this, ResourceTable.Id_insert_local_db, listener -> {
            HiLog.info(label, "---------------------------------");

            Intent intent = new Intent();
            Operation dataOperation = new Intent.OperationBuilder()
                    .withDeviceId("")
                    .withBundleName("org.shchen.mobileplatform")
                    .withAbilityName("org.shchen.mobileplatform.DataAbility")
                    .build();
            intent.setOperation(dataOperation);
            startAbilityForResult(intent, REQ_CODE_QUERY_WEATHER);
        });

        Utils.bundleButtonInAbilitySlice(this, ResourceTable.Id_query_local_db, listener -> {


        });
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
