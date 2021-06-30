package org.shchen.mobileplatform.slice;

import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.colors.RgbColor;
import ohos.agp.components.DependentLayout;
import ohos.agp.components.Text;
import ohos.agp.components.element.ShapeElement;
import ohos.agp.utils.Color;

public class HomePageSlice extends AbilitySlice {

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);

        // 声明布局
        DependentLayout homepage = new DependentLayout(this);

        // 设置布局宽高
        homepage.setWidth(DependentLayout.LayoutConfig.MATCH_PARENT);
        homepage.setHeight(DependentLayout.LayoutConfig.MATCH_PARENT);

        // 设置布局背景为白色
        ShapeElement background = new ShapeElement();
        background.setRgbColor(new RgbColor(255, 255, 255));
        homepage.setBackground(background);

        // 创建一个文本
        Text text = new Text(this);
        text.setText("欢迎来到移动的世界");
        text.setWidth(DependentLayout.LayoutConfig.MATCH_PARENT);
        text.setTextSize(100);
        text.setTextColor(Color.BLACK);

        // 设置文本的布局
        DependentLayout.LayoutConfig textConfig = new DependentLayout.LayoutConfig(DependentLayout.LayoutConfig.MATCH_CONTENT, DependentLayout.LayoutConfig.MATCH_CONTENT);
        textConfig.addRule(DependentLayout.LayoutConfig.CENTER_IN_PARENT);
        text.setLayoutConfig(textConfig);
        homepage.addComponent(text);
        super.setUIContent(homepage);
    }
}
