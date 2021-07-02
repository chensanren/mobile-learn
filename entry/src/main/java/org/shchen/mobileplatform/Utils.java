package org.shchen.mobileplatform;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.ability.AbilitySlice;
import ohos.agp.components.Button;
import ohos.agp.components.Component;

public class Utils {

    public static void bundleButtonInAbilitySlice(AbilitySlice abilitySlice, int buttonId, Component.ClickedListener clickedListener) {
        Button button = (Button) abilitySlice.findComponentById(buttonId);
        button.setClickedListener(clickedListener);
    }
}
