package org.shchen.mobileplatform.slice;

import ohos.agp.components.Button;
import org.shchen.mobileplatform.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;

public class MainAbilitySlice extends AbilitySlice {

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        Button button = (Button) findComponentById(ResourceTable.Id_homepage_button);

        // 点击按钮跳转至第二个页面
        button.setClickedListener(listener -> present(new HomePageSlice(), new Intent()));
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
