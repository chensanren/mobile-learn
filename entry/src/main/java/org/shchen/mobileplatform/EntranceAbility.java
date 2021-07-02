package org.shchen.mobileplatform;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.ability.IAbilityConnection;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.bundle.ElementName;
import ohos.hiviewdfx.HiLogLabel;
import ohos.rpc.IRemoteObject;
import org.shchen.mobileplatform.slice.EntranceSlice;

public class EntranceAbility extends Ability {
    private static final HiLogLabel LABEL_LOG = new HiLogLabel(3, 0xD001100, "Demo");


    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(EntranceSlice.class.getName());
    }
}
