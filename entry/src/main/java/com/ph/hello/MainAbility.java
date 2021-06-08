package com.ph.hello;

import com.ph.hello.slice.MainAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;

public class MainAbility extends Ability {
    private Button startButton;
    private boolean isClicked;
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(MainAbilitySlice.class.getName());
        initComponent();
        initClickedListener();
    }
    //初始化组件
    private  void initComponent(){
        startButton= (Button) findComponentById(ResourceTable.Id_center_button);
    }
    private void initClickedListener(){
        startButton.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                if (isClicked){
                    startButton.setText("已经被点击啦");
                    isClicked=!isClicked;
                }else {
                    startButton.setText("我又恢复啦");
                    isClicked=!isClicked;
                }
            }
        });
    }
}
