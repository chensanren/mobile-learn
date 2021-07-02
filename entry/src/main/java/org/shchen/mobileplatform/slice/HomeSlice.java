package org.shchen.mobileplatform.slice;

import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import org.shchen.mobileplatform.ResourceTable;

public class HomeSlice extends AbilitySlice {

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        this.setUIContent(ResourceTable.Layout_homepage_slice);
    }
}
