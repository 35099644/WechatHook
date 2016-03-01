//package org.niray.wechatmoneyhook;
//
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import com.tencent.mm.A;
//import com.tencent.mm.plugin.luckymoney.c.ab;
//import com.tencent.mm.plugin.luckymoney.c.ae;
//import com.tencent.mm.plugin.luckymoney.c.i;
//import com.tencent.mm.plugin.luckymoney.c.n;
//import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
//import com.tencent.mm.sdk.platformtools.ay;
//import com.tencent.mm.sdk.platformtools.t;
//import com.tencent.mm.sdk.platformtools.y;
//import com.tencent.mm.ui.base.a;
//import com.tencent.mm.ui.base.g;
//import com.tencent.mm.ui.base.p;
//
//import java.io.IOException;
//
//@a(3)
//public class LuckyMoneyReceiveUI
//  extends LuckyMoneyBaseUI
//{
//  private p coc = null;
//  private TextView det;
//  private TextView eVH;
//  private Button eVK;
//  private ImageView eVL;
//  private View eVN;
//  private ImageView eVf;
//  private TextView eVh;
//  private String eVr;
//  private String eVt;
//  private View eYk;
//  private ImageView eYl;
//  private TextView eYm;
//  private String eYn;
//
//  public LuckyMoneyReceiveUI()
//  {
//    if (!BuildConfig.SKIP) {
//      A.a();
//    }
//  }
//
//  private int ahw()
//  {
//    if (com.tencent.mm.model.h.sc().equals(this.eYn)) {
//      return 1;
//    }
//    return 0;
//  }
//
//  private static int is(int paramInt)
//  {
//    if (paramInt == 1) {
//      return 1;
//    }
//    if (paramInt == 0) {
//      return 2;
//    }
//    return 0;
//  }
//
//  protected final void Gb()
//  {
//    this.eVN = findViewById(2131167684);
//    this.eVf = ((ImageView)findViewById(2131167687));
//    this.eVH = ((TextView)findViewById(2131167688));
//    this.det = ((TextView)findViewById(2131167689));
//    this.eVh = ((TextView)findViewById(2131167690));
//    this.eVK = ((Button)findViewById(2131167691));
//    this.eYm = ((TextView)findViewById(2131167694));
//    this.eYk = findViewById(2131167693);
//    this.eYl = ((ImageView)findViewById(2131167692));
//    this.eVL = ((ImageView)findViewById(2131167695));
//    this.eVL.setOnClickListener(new View.OnClickListener()
//    {
//      public final void onClick(View paramAnonymousView)
//      {
//        LuckyMoneyReceiveUI.this.finish();
//      }
//    });
//    this.koJ.cMt.setVisibility(8);
//    this.coc = g.a(this.koJ.kpc, getString(2131431101), true, new DialogInterface.OnCancelListener()
//    {
//      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
//      {
//        if ((LuckyMoneyReceiveUI.a(LuckyMoneyReceiveUI.this) != null) && (LuckyMoneyReceiveUI.a(LuckyMoneyReceiveUI.this).isShowing())) {
//          LuckyMoneyReceiveUI.a(LuckyMoneyReceiveUI.this).dismiss();
//        }
//        LuckyMoneyReceiveUI.this.eVc.agI();
//        if ((LuckyMoneyReceiveUI.b(LuckyMoneyReceiveUI.this).getVisibility() == 8) || (LuckyMoneyReceiveUI.c(LuckyMoneyReceiveUI.this).getVisibility() == 4))
//        {
//          com.tencent.mm.sdk.platformtools.u.i("!44@/B4Tb64lLpJU0DFL7wjx71n+iziipYdvDE8/jYxGd0A=", "user cancel & finish");
//          LuckyMoneyReceiveUI.this.finish();
//        }
//      }
//    });
//    if (this.eVK != null)
//    {
//      String str = t.d(y.getContext().getSharedPreferences(y.aUK(), 0));
//      if ((str == null) || (str.length() <= 0) || ((!str.equals("zh_CN")) && (!str.equals("zh_TW")) && (!str.equals("zh_HK")))) {}
//    }
//    else
//    {
//      return;
//    }
//    this.eVK.setBackgroundResource(2130969377);
//    this.eVK.setText(2131430721);
//  }
//
//  public final boolean e(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.r.j paramj)
//  {
//    if ((paramj instanceof ae))
//    {
//      if ((paramInt1 == 0) && (paramInt2 == 0))
//      {
//        paramString = (ae)paramj;
//        com.tencent.mm.plugin.report.service.h.fUJ.g(11701, new Object[] { Integer.valueOf(5), Integer.valueOf(is(paramString.eRO)), Integer.valueOf(ahw()), Integer.valueOf(0), Integer.valueOf(1) });
//        if (paramString.eSi == 2)
//        {
//          a(new com.tencent.mm.plugin.luckymoney.c.u(this.eVr, this.eVt, "v1.0"), false);
//          return true;
//        }
//        if ((this.coc != null) && (this.coc.isShowing())) {
//          this.coc.hide();
//        }
//        n.e(this.eVf, paramString.eRU);
//        n.a(this.koJ.kpc, this.eVH, paramString.eTA);
//        final boolean bool;
//        if ((paramString.eSi != 1) && (paramString.eRP != 4) && (paramString.eRP != 5) && (paramString.eRP != 1))
//        {
//          if (!ay.kz(paramString.eRQ))
//          {
//            this.det.setText(paramString.eRQ);
//            this.det.setVisibility(0);
//          }
//          if (!ay.kz(paramString.eRS))
//          {
//            n.a(this.koJ.kpc, this.eVh, paramString.eRS);
//            this.eVh.setVisibility(0);
//          }
//          this.eVK.setOnClickListener(new View.OnClickListener()
//          {
//            public final void onClick(View paramAnonymousView)
//            {
//              com.tencent.mm.plugin.report.service.h.fUJ.g(11701, new Object[] { Integer.valueOf(5), Integer.valueOf(LuckyMoneyReceiveUI.it(paramString.eRO)), Integer.valueOf(LuckyMoneyReceiveUI.d(LuckyMoneyReceiveUI.this)), Integer.valueOf(0), Integer.valueOf(2) });
//              paramAnonymousView = new ab(paramString.aFa, paramString.akC, paramString.eRV, paramString.bIx, n.agK(), com.tencent.mm.model.h.se(), LuckyMoneyReceiveUI.this.getIntent().getStringExtra("key_username"), "v1.0");
//              LuckyMoneyReceiveUI.this.a(paramAnonymousView, false);
//              n.b(LuckyMoneyReceiveUI.e(LuckyMoneyReceiveUI.this));
//            }
//          });
//          bool = false;
//          if ((!com.tencent.mm.model.h.sc().equals(this.eYn)) && ((paramString.eRO != 1) || (!bool))) {
//            break label514;
//          }
//          if (paramString.eRO == 1) {
//            this.eYm.setText(2131430657);
//          }
//          this.eYk.setVisibility(0);
//          this.eYk.setOnClickListener(new View.OnClickListener()
//          {
//            public final void onClick(View paramAnonymousView)
//            {
//              if (bool) {
//                com.tencent.mm.plugin.report.service.h.fUJ.g(11701, new Object[] { Integer.valueOf(6), Integer.valueOf(LuckyMoneyReceiveUI.it(paramString.eRO)), Integer.valueOf(LuckyMoneyReceiveUI.d(LuckyMoneyReceiveUI.this)), Integer.valueOf(0), Integer.valueOf(1) });
//              }
//              paramAnonymousView = new Intent();
//              paramAnonymousView.setClass(LuckyMoneyReceiveUI.this.koJ.kpc, LuckyMoneyDetailUI.class);
//              paramAnonymousView.putExtra("key_native_url", paramString.bIx);
//              paramAnonymousView.putExtra("key_sendid", paramString.eRV);
//              LuckyMoneyReceiveUI.this.startActivity(paramAnonymousView);
//              LuckyMoneyReceiveUI.this.finish();
//            }
//          });
//          this.eYl.setVisibility(8);
//        }
//        for (;;)
//        {
//          n.a(this.eVN, null);
//          this.koJ.cMt.setVisibility(0);
//          return true;
//          this.eVK.setBackgroundResource(2130969464);
//          this.eVK.setText(2131430654);
//          this.eVK.setOnClickListener(null);
//          this.eVK.setVisibility(8);
//          if (!ay.kz(paramString.eSs))
//          {
//            this.det.setText(paramString.eSs);
//            this.det.setVisibility(0);
//          }
//          for (;;)
//          {
//            this.eVh.setText(paramString.eRQ);
//            paramj = (RelativeLayout.LayoutParams)this.eYk.getLayoutParams();
//            paramj.bottomMargin = BackwardSupportUtil.b.a(this.koJ.kpc, 30.0F);
//            this.eYk.setLayoutParams(paramj);
//            bool = true;
//            break;
//            this.det.setVisibility(8);
//          }
//          label514:
//          this.eYk.setVisibility(8);
//          this.eYl.setVisibility(0);
//        }
//      }
//      if (paramInt2 == 416)
//      {
//        if ((this.coc != null) && (this.coc.isShowing())) {
//          this.coc.hide();
//        }
//        Bundle localBundle = new Bundle();
//        localBundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyReceiveUI");
//        localBundle.putString("realname_verify_process_jump_plugin", "luckymoney");
//        return n.a(this, paramInt2, paramString, paramj, localBundle);
//      }
//      if ((this.coc != null) && (this.coc.isShowing())) {
//        this.coc.hide();
//      }
//      return false;
//    }
//    if ((paramj instanceof ab))
//    {
//      n.c(this.eVK);
//      if ((paramInt1 == 0) && (paramInt2 == 0))
//      {
//        paramString = (ab)paramj;
//        paramj = paramString.eTf;
//        if (paramj.eSi == 2)
//        {
//          paramj = new Intent();
//          paramj.setClass(this.koJ.kpc, LuckyMoneyDetailUI.class);
//          try
//          {
//            paramj.putExtra("key_detail_info", paramString.eTf.toByteArray());
//            paramj.putExtra("key_jump_from", 2);
//            paramj.putExtra("key_native_url", paramString.bIx);
//            paramj.putExtra("key_sendid", paramString.eRV);
//            if (com.tencent.mm.g.h.pS().getInt("PlayCoinSound", 0) > 0) {
//              paramj.putExtra("play_sound", true);
//            }
//            startActivity(paramj);
//            finish();
//            return true;
//          }
//          catch (IOException localIOException)
//          {
//            for (;;)
//            {
//              com.tencent.mm.sdk.platformtools.u.w("!44@/B4Tb64lLpJU0DFL7wjx71n+iziipYdvDE8/jYxGd0A=", "luckyMoneyDetail.toByteArray() fail! " + localIOException.getLocalizedMessage());
//            }
//          }
//        }
//        this.eVK.setBackgroundResource(2130969464);
//        this.eVK.setText(2131430654);
//        this.eVK.setOnClickListener(null);
//        this.eVK.setVisibility(8);
//        if (!ay.kz(paramj.eSs))
//        {
//          this.det.setText(paramj.eSs);
//          this.det.setVisibility(0);
//        }
//        for (;;)
//        {
//          this.eVh.setText(paramj.eRQ);
//          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.eYk.getLayoutParams();
//          localLayoutParams.bottomMargin = BackwardSupportUtil.b.a(this.koJ.kpc, 30.0F);
//          this.eYk.setLayoutParams(localLayoutParams);
//          if ((!com.tencent.mm.model.h.sc().equals(this.eYn)) && (paramj.eRO != 1)) {
//            break;
//          }
//          this.eYk.setVisibility(0);
//          this.eYk.setOnClickListener(new View.OnClickListener()
//          {
//            public final void onClick(View paramAnonymousView)
//            {
//              paramAnonymousView = new Intent();
//              paramAnonymousView.setClass(LuckyMoneyReceiveUI.this.koJ.kpc, LuckyMoneyDetailUI.class);
//              paramAnonymousView.putExtra("key_native_url", paramString.bIx);
//              paramAnonymousView.putExtra("key_sendid", paramString.eRV);
//              LuckyMoneyReceiveUI.this.startActivity(paramAnonymousView);
//              LuckyMoneyReceiveUI.this.finish();
//            }
//          });
//          this.eYl.setVisibility(8);
//          return true;
//          this.det.setVisibility(8);
//        }
//        this.eYk.setVisibility(8);
//        this.eYl.setVisibility(0);
//        return true;
//      }
//    }
//    else if ((paramj instanceof com.tencent.mm.plugin.luckymoney.c.u))
//    {
//      if ((this.coc != null) && (this.coc.isShowing())) {
//        this.coc.hide();
//      }
//      if ((paramInt1 == 0) && (paramInt2 == 0))
//      {
//        paramj = (com.tencent.mm.plugin.luckymoney.c.u)paramj;
//        paramString = new Intent();
//        paramString.setClass(this.koJ.kpc, LuckyMoneyDetailUI.class);
//        try
//        {
//          paramString.putExtra("key_detail_info", paramj.eTf.toByteArray());
//          paramString.putExtra("key_jump_from", 2);
//          paramString.putExtra("key_native_url", this.eVt);
//          paramString.putExtra("key_sendid", this.eVr);
//          startActivity(paramString);
//          finish();
//          return true;
//        }
//        catch (IOException paramj)
//        {
//          for (;;)
//          {
//            com.tencent.mm.sdk.platformtools.u.w("!44@/B4Tb64lLpJU0DFL7wjx71n+iziipYdvDE8/jYxGd0A=", "luckyMoneyDetail.toByteArray() fail! " + paramj.getLocalizedMessage());
//          }
//        }
//      }
//      g.ba(this, paramString);
//      finish();
//      return true;
//    }
//    return false;
//  }
//
//  protected final int getLayoutId()
//  {
//    return 2131362612;
//  }
//
//  public void onCreate(Bundle paramBundle)
//  {
//    super.onCreate(paramBundle);
//    this.eVt = getIntent().getStringExtra("key_native_url");
//    com.tencent.mm.sdk.platformtools.u.i("!44@/B4Tb64lLpJU0DFL7wjx71n+iziipYdvDE8/jYxGd0A=", "nativeUrl= " + ay.ky(this.eVt));
//    Gb();
//    paramBundle = Uri.parse(ay.ky(this.eVt));
//    try
//    {
//      this.eVr = paramBundle.getQueryParameter("sendid");
//      if (!ay.kz(this.eVr))
//      {
//        int i = ay.getInt(paramBundle.getQueryParameter("channelid"), 1);
//        this.eYn = paramBundle.getQueryParameter("sendusername");
//        a(new ae(i, this.eVr, this.eVt, getIntent().getIntExtra("key_way", 0), "v1.0"), false);
//        if (this.coc != null) {
//          this.coc.show();
//        }
//        return;
//      }
//      finish();
//      com.tencent.mm.sdk.platformtools.u.w("!44@/B4Tb64lLpJU0DFL7wjx71n+iziipYdvDE8/jYxGd0A=", "sendid null & finish");
//      return;
//    }
//    catch (Exception localException)
//    {
//      for (;;) {}
//    }
//  }
//
//  protected void onDestroy()
//  {
//    super.onDestroy();
//    if ((this.coc != null) && (this.coc.isShowing())) {
//      this.coc.dismiss();
//    }
//  }
//}
//
//