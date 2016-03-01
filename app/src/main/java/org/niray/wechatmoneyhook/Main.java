package org.niray.wechatmoneyhook;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Button;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import static de.robv.android.xposed.XposedHelpers.findClass;

public class Main implements IXposedHookLoadPackage {


    @Override
    public void handleLoadPackage(final LoadPackageParam loadPackageParam) throws Throwable {
        if (loadPackageParam.packageName.equals("com.tencent.mm")) {
            Log.e("hook", "hookX Success In MM " + loadPackageParam.packageName);
            findAndHookMethod("com.tencent.mm.model.bc", loadPackageParam.classLoader, "ai", boolean.class, new XC_MethodHook() {

                @Override
                protected void afterHookedMethod(final MethodHookParam param) throws Throwable {
                    Log.e("hook", "afterHookedMethod In   " + loadPackageParam.packageName);

                    Class j = findClass("com.tencent.mm.r.j", loadPackageParam.classLoader);
                    final Class uiClass = findClass("com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyReceiveUI", loadPackageParam.classLoader);
                    final Class luckyDetailClass = findClass("com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI", loadPackageParam.classLoader);
                    final Class remittanceClass = findClass("com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI", loadPackageParam.classLoader);

                    findAndHookMethod(uiClass, "onCreate", Bundle.class, new XC_MethodReplacement() {
                        @Override
                        protected Object replaceHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                            Activity activity = (Activity) methodHookParam.thisObject;
                            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON | WindowManager.LayoutParams.FLAG_FULLSCREEN);
                            XposedBridge.invokeOriginalMethod(methodHookParam.method, methodHookParam.thisObject, methodHookParam.args);
                            return null;
                        }
                    });

//                    findAndHookMethod(luckyDetailClass, "onCreate", Bundle.class, new XC_MethodHook() {
//                        @Override
//                        protected void afterHookedMethod(final MethodHookParam param) throws Throwable {
//                            new android.os.Handler().postDelayed(new Runnable() {
//                                @Override
//                                public void run() {
//                                    XposedHelpers.callMethod(param.thisObject, "finish");
//                                }
//                            }, 1500);
//                        }
//                    });

                    findAndHookMethod(remittanceClass, "e", int.class, int.class, String.class, j, new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(final MethodHookParam param) throws Throwable {
                            Log.e("hook", "afterHookedMethod In remittanceClass e  ");
                            Button button = (Button) XposedHelpers.getObjectField(param.thisObject, "fTb");
//                            XposedHelpers.callMethod(param.thisObject, "e", param.args);
//                            Button button = (Button) XposedHelpers.callMethod(param.thisObject, "e", param.args);
                            if (button.isShown() && button.isClickable()) {
                                button.performClick();
                                button.setClickable(false);
                                XposedHelpers.callMethod(param.thisObject, "finish");
                            }
                        }
                    });

                    //button is ready for click here
                    findAndHookMethod(uiClass, "e", int.class, int.class, String.class, j, new XC_MethodHook() {
                                @Override
                                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                                    Log.e("hook", "afterHookedMethod In uiClass e  ");
                                    Button button = (Button) XposedHelpers.callStaticMethod(uiClass, "e", param.thisObject);
                                    if (button.isShown() && button.isClickable()) {
                                        button.performClick();
                                        button.setClickable(false);
                                    }
                                }
                            }
                    );
                }
            });
        }
    }

}
