package org.niray.wechatmoneyhook;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
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

public class Main implements IXposedHookLoadPackage {

    public static final String VERSION = "Android 6.3.18";

    /**
     * Assets jar
     * from 6.3.15 the money jar move to classes2.dex
     **/

    private final static String LuckyMoneyClassPath = "com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyReceiveUI";
    //public final boolean
    //int paramInt1, int paramInt2, String paramString, com.tencent.mm.s.j paramj)
    //if ((paramj instanceof ae))
    private final static String LuckyMoneyFunction = "d";
    //    private TextView faI;
//    private Button faL;
//    private ImageView faM;
    private final static String LuckyMoneyButtonName = "faL";// public Button

    private final static String RemittanceClassPath = "com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI";
    //(int paramInt1, int paramInt2, String paramString, com.tencent.mm.s.j paramj)
    // if ((paramj instanceof f))
    //public boolean
    private final static String RemittanceFunction = "d";
    //    public TextView fYW = null;
//    public Button fYX = null;
//    public TextView fYY = null;
    private final static String RemittanceButtonName = "fYX";// public Button

    //check $RemittanceClassPath or $RemittanceClassPath params
    private final static String MoneyParamClassPath = "com.tencent.mm.s.j";

    //详情页面包地址
    private final static String LuckyDetailClassPath = "com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI";
    //Context 包地址
    private final static String ContextClassPath = "com.tencent.mm.ui.MMFragmentActivity";


    //big jar class1.dex

    //base model start
    //1 com.tencent.mm.model.bc
    //onAccountPostReset   or  onSubCoreAccountPostReset post:
    private final static String HookBaseClassPath = "com.tencent.mm.model.bc";
    //在这里更改方法名字 public final void ak*(boolean paramBoolean)
    private final static String HookBaseFunction = "ak";
    //base model end


    //石头剪刀布 start
    //2 com.tencent.mm.sdk.platformtools.ba
    //id:%d num:%d/%d to
    private final static String GameClassPath = "com.tencent.mm.sdk.platformtools.bc";
    //new Random(S
    //  public static int qQ*(int paramInt)
    private final static String GameFunction = "qQ";
    //石头剪刀布 end

    //石头剪刀布 params
    private int diceCount = 0;
    private int morraNum = 0; // 0-剪刀 1-石头 2-布
    private Context mContext;

    @Override
    public void handleLoadPackage(final LoadPackageParam loadPackageParam) throws Throwable {
        if (!loadPackageParam.packageName.equals("com.tencent.mm")) return;

        Log.e("hook", "hookX Success In MM " + VERSION + loadPackageParam.packageName);
        hookAndGetContext(ContextClassPath, loadPackageParam, "onCreate");
        hookMoney(loadPackageParam);
        findAndHookMethodD(GameClassPath, loadPackageParam, GameFunction);
    }

    private void hookAndGetContext(String className, final LoadPackageParam lpparam, String methodName) {
        XposedHelpers.findAndHookMethod(className, lpparam.classLoader, methodName, Bundle.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                // Hook函数之前执行的代码
                if (mContext == null) {
                    mContext = (Context) param.thisObject;
                    XposedBridge.log("获取到了Context");
                }
            }

            @Override
            protected void afterHookedMethod(final MethodHookParam param) throws Throwable {
            }
        });
    }

    private void hookMoney(final LoadPackageParam loadPackageParam) {
        XposedHelpers.findAndHookMethod(HookBaseClassPath, loadPackageParam.classLoader, HookBaseFunction, boolean.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(final MethodHookParam param) throws Throwable {
                Log.e("hook", "afterHookedMethod In   " + VERSION + loadPackageParam.packageName);

                Class j = XposedHelpers.findClass(MoneyParamClassPath, loadPackageParam.classLoader);
                final Class uiClass = XposedHelpers.findClass(LuckyMoneyClassPath, loadPackageParam.classLoader);
//                final Class luckyDetailClass = XposedHelpers.findClass(LuckyDetailClassPath, loadPackageParam.classLoader);
                final Class remittanceClass = XposedHelpers.findClass(RemittanceClassPath, loadPackageParam.classLoader);

                XposedHelpers.findAndHookMethod(uiClass, "onCreate", Bundle.class, new XC_MethodReplacement() {
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

                XposedHelpers.findAndHookMethod(remittanceClass, RemittanceFunction, int.class, int.class, String.class, j, new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(final MethodHookParam param) throws Throwable {
                        Log.e("hook", "afterHookedMethod In remittanceClass e  " + VERSION);
                        Button button = (Button) XposedHelpers.getObjectField(param.thisObject, RemittanceButtonName);
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
                XposedHelpers.findAndHookMethod(uiClass, LuckyMoneyFunction, int.class, int.class, String.class, j, new XC_MethodHook() {
                            @Override
                            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                                Log.e("hook", "afterHookedMethod In uiClass  " + VERSION + LuckyMoneyFunction);
//                                Button button = (Button) XposedHelpers.callStaticMethod(uiClass, LuckyMoneyFunction, param.thisObject);
                                //from 6.3.18 use find button
                                Button button = (Button) XposedHelpers.getObjectField(param.thisObject, LuckyMoneyButtonName);
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


    /**
     * @param className  全路径类名：包名 + 类名
     * @param methodName 需要hook的方法名
     */
    private void findAndHookMethodD(String className, final LoadPackageParam lpparam, String methodName) {
        XposedHelpers.findAndHookMethod(className, lpparam.classLoader, methodName, int.class, new XC_MethodReplacement() {

            @Override
            protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                int gameType = (int) param.args[0];

                switch (gameType) {
                    case 5: // 摇骰子
                        Uri diceUri = Uri.parse("content://com.example.hookdemo.provider/wx_plugs_setting");
                        Cursor diceCursor = mContext.getContentResolver().query(diceUri, null, null, null, null);
                        if (diceCursor != null) {
                            while (diceCursor.moveToNext()) {
                                diceCount = diceCursor.getInt(diceCursor.getColumnIndex("dice_num"));
                                XposedBridge.log("查询获取骰子数为:" + diceCount);
                            }
                        }
                        break;

                    case 2: // 猜拳
                        Uri morraUri = Uri.parse("content://com.example.hookdemo.provider/wx_plugs_setting");
                        Cursor morraCursor = mContext.getContentResolver().query(morraUri, null, null, null, null);
                        if (morraCursor != null) {
                            while (morraCursor.moveToNext()) {
                                diceCount = morraCursor.getInt(morraCursor.getColumnIndex("morra_num"));
                                XposedBridge.log("查询猜拳数为:" + morraNum);
                            }
                        }
                        break;

                }
                XposedBridge.log("replaceHookedMethod--函数返回值:" + diceCount);
                return diceCount;
            }
        });
    }

}
