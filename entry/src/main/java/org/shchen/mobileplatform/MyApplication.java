package org.shchen.mobileplatform;

import ohos.aafwk.ability.AbilityPackage;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

public class MyApplication extends AbilityPackage {

    private static final HiLogLabel label;

    static {
        int domain = 0x00201;
        String tag = "application_level";
        label = new HiLogLabel(HiLog.LOG_APP, domain, tag);
    }


    @Override
    public void onInitialize() {
        super.onInitialize();
    }
}
