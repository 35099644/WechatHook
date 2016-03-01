//package org.niray.wechatmoneyhook;
//
//import android.content.DialogInterface;
//import android.content.DialogInterface.OnClickListener;
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.SpannableString;
//import android.text.method.LinkMovementMethod;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//import com.tencent.mm.A;
//import com.tencent.mm.BuildConfig;
//import com.tencent.mm.model.ah;
//import com.tencent.mm.plugin.order.c.a.a;
//import com.tencent.mm.plugin.order.model.i;
//import com.tencent.mm.plugin.remittance.b.b;
//import com.tencent.mm.pluginsdk.wallet.d;
//import com.tencent.mm.ui.MMActivity;
//import com.tencent.mm.ui.base.g;
//import com.tencent.mm.wallet_core.ui.WalletBaseUI;
//
//public class RemittanceDetailUI
//  extends WalletBaseUI
//{
//  public TextView eVJ = null;
//  public ImageView fSY = null;
//  public TextView fSZ = null;
//  public TextView fTa = null;
//  public Button fTb = null;
//  public TextView fTc = null;
//  public TextView fTd = null;
//  public int fTe;
//  public int fTf;
//  public String fTg = null;
//  public String fTh = null;
//  public String fTi = null;
//  protected String fTj = null;
//  public int fTk = 3;
//  protected boolean fTl = false;
//  protected int fTm;
//
//  public RemittanceDetailUI()
//  {
//    if (!BuildConfig.SKIP) {
//      A.a();
//    }
//  }
//
//  public static String M(String paramString, boolean paramBoolean)
//  {
//    String str = com.tencent.mm.wallet_core.ui.e.dY(paramString);
//    if (str == null) {
//      paramString = "";
//    }
//    do
//    {
//      do
//      {
//        return paramString;
//        paramString = str;
//      } while (str.length() <= 10);
//      paramString = str;
//    } while (!paramBoolean);
//    return str.substring(0, 8) + "...";
//  }
//
//  protected final void Gb()
//  {
//    qb(2131432357);
//    this.fSY = ((ImageView)findViewById(2131168093));
//    this.fSZ = ((TextView)findViewById(2131168094));
//    this.fTa = ((TextView)findViewById(2131168095));
//    this.fTb = ((Button)findViewById(2131168096));
//    this.eVJ = ((TextView)findViewById(2131168097));
//    this.fTc = ((TextView)findViewById(2131168098));
//    this.fTd = ((TextView)findViewById(2131168099));
//  }
//
//  public final void N(int paramInt, String paramString)
//  {
//    Intent localIntent = new Intent();
//    localIntent.putExtra("result_msg", paramString);
//    setResult(paramInt, localIntent);
//    finish();
//  }
//
//  public void aqh()
//  {
//    b localb = new b(this.fTg, this.fTi, this.fTm, "confirm", this.fTh, this.fTe);
//    localb.bwE = "RemittanceProcess";
//    j(localb);
//  }
//
//  public void aqi()
//  {
//    b localb = new b(this.fTg, this.fTi, this.fTm, "refuse", this.fTh, this.fTe);
//    localb.bwE = "RemittanceProcess";
//    j(localb);
//  }
//
//  public boolean e(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.r.j paramj)
//  {
//    label158:
//    Object localObject1;
//    if ((paramj instanceof com.tencent.mm.plugin.remittance.b.e))
//    {
//      paramString = (com.tencent.mm.plugin.remittance.b.e)paramj;
//      if ((paramInt1 == 0) && (paramInt2 == 0))
//      {
//        boolean bool;
//        if (paramString != null)
//        {
//          paramj = com.tencent.mm.model.h.sc();
//          bool = paramString.fSI.equals(paramj);
//          this.fTb.setVisibility(8);
//          this.fTa.setText(com.tencent.mm.wallet_core.ui.e.c(paramString.dec, paramString.foZ));
//          paramInt1 = paramString.status;
//        }
//        switch (paramInt1)
//        {
//        default:
//          finish();
//          if (paramString.fpH == 1)
//          {
//            if (!((String)ah.tD().rn().get(327729, "0")).equals("0")) {
//              break label1215;
//            }
//            paramString = this.koJ.kpc;
//            if (!com.tencent.mm.model.h.sp()) {
//              break label1208;
//            }
//            paramInt1 = 2131432361;
//            g.a(paramString, paramInt1, 2131432330, new DialogInterface.OnClickListener()
//            {
//              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
//              {
//                g.ba(RemittanceDetailUI.this.koJ.kpc, RemittanceDetailUI.this.getString(2131432351));
//              }
//            });
//            ah.tD().rn().set(327729, "1");
//          }
//          break;
//        }
//        for (;;)
//        {
//          return true;
//          Object localObject2;
//          com.tencent.mm.plugin.order.c.a locala;
//          if (!bool)
//          {
//            paramj = getString(2131432340, new Object[] { M(paramString.fSI, true) });
//            this.fSZ.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this, paramj, this.fSZ.getTextSize()));
//            paramj = getString(2131432345, new Object[] { Integer.valueOf(this.fTk) });
//            localObject1 = getString(2131432295);
//            localObject2 = new SpannableString(paramj + (String)localObject1);
//            locala = new com.tencent.mm.plugin.order.c.a(this);
//            locala.frP = new a.a()
//            {
//              public final void onClick(View paramAnonymousView)
//              {
//                g.a(RemittanceDetailUI.this, RemittanceDetailUI.this.getString(2131432289), RemittanceDetailUI.this.getString(2131431011), RemittanceDetailUI.this.getString(2131432287), RemittanceDetailUI.this.getString(2131430884), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
//                {
//                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
//                  {
//                    paramAnonymous2DialogInterface = new Intent();
//                    paramAnonymous2DialogInterface.putExtra("transaction_id", RemittanceDetailUI.this.fTg);
//                    paramAnonymous2DialogInterface.putExtra("receiver_name", RemittanceDetailUI.1.this.fTn.fSI);
//                    RemittanceDetailUI.this.z(paramAnonymous2DialogInterface);
//                  }
//                }, new DialogInterface.OnClickListener()
//                {
//                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
//                });
//              }
//            };
//            ((SpannableString)localObject2).setSpan(locala, paramj.length(), paramj.length() + ((String)localObject1).length(), 33);
//            this.eVJ.setMovementMethod(LinkMovementMethod.getInstance());
//            this.eVJ.setText((CharSequence)localObject2);
//          }
//          for (;;)
//          {
//            this.fSY.setImageResource(2130970177);
//            this.fTc.setText(getString(2131432348, new Object[] { com.tencent.mm.wallet_core.ui.e.si(paramString.fSH) }));
//            this.fTc.setVisibility(0);
//            this.fTd.setVisibility(8);
//            break;
//            this.fSY.setImageResource(2130970177);
//            this.fSZ.setText(2131432339);
//            this.fTb.setVisibility(0);
//            this.fTb.setOnClickListener(new View.OnClickListener()
//            {
//              public final void onClick(View paramAnonymousView)
//              {
//                RemittanceDetailUI.this.aqh();
//              }
//            });
//            paramj = getString(2131432344, new Object[] { Integer.valueOf(this.fTk) });
//            localObject1 = getString(2131432346);
//            localObject2 = new SpannableString(paramj + (String)localObject1);
//            locala = new com.tencent.mm.plugin.order.c.a(this);
//            locala.frP = new a.a()
//            {
//              public final void onClick(View paramAnonymousView)
//              {
//                g.a(RemittanceDetailUI.this, RemittanceDetailUI.this.getString(2131432356, new Object[] { RemittanceDetailUI.M(paramString.fSK, false) }), RemittanceDetailUI.this.getString(2131431011), RemittanceDetailUI.this.getString(2131432347), RemittanceDetailUI.this.getString(2131430884), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
//                {
//                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
//                  {
//                    RemittanceDetailUI.this.aqi();
//                  }
//                }, new DialogInterface.OnClickListener()
//                {
//                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
//                });
//              }
//            };
//            ((SpannableString)localObject2).setSpan(locala, paramj.length(), paramj.length() + ((String)localObject1).length(), 33);
//            this.eVJ.setMovementMethod(LinkMovementMethod.getInstance());
//            this.eVJ.setText((CharSequence)localObject2);
//          }
//          this.fSY.setImageResource(2130903238);
//          if (bool)
//          {
//            this.fSZ.setText(2131432341);
//            paramj = getString(2131432353);
//            localObject1 = new SpannableString(paramj);
//            localObject2 = new com.tencent.mm.plugin.order.c.a(this);
//            ((com.tencent.mm.plugin.order.c.a)localObject2).frP = new a.a()
//            {
//              public final void onClick(View paramAnonymousView)
//              {
//                d.v(RemittanceDetailUI.this, 0);
//              }
//            };
//            ((SpannableString)localObject1).setSpan(localObject2, 0, paramj.length(), 33);
//            this.eVJ.setMovementMethod(LinkMovementMethod.getInstance());
//            this.eVJ.setText((CharSequence)localObject1);
//            this.eVJ.setVisibility(0);
//          }
//          for (;;)
//          {
//            this.fTc.setText(getString(2131432348, new Object[] { com.tencent.mm.wallet_core.ui.e.si(paramString.fSH) }));
//            this.fTc.setVisibility(0);
//            this.fTd.setText(getString(2131432349, new Object[] { com.tencent.mm.wallet_core.ui.e.si(paramString.fSL) }));
//            this.fTd.setVisibility(0);
//            break;
//            paramj = M(paramString.fSI, true) + getString(2131432341);
//            this.fSZ.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this, paramj, this.fSZ.getTextSize()));
//            this.eVJ.setVisibility(8);
//          }
//          if ((paramInt1 == 2003) && (!bool))
//          {
//            this.fSY.setImageResource(2130903239);
//            this.fSZ.setText(2131432343);
//            label884:
//            if (bool) {
//              break label1196;
//            }
//            if (!"CFT".equals(paramString.fpx)) {
//              break label1183;
//            }
//            paramj = getString(2131432354);
//            localObject1 = getString(2131432353);
//            localObject2 = new SpannableString(paramj + (String)localObject1);
//            locala = new com.tencent.mm.plugin.order.c.a(this);
//            locala.frP = new a.a()
//            {
//              public final void onClick(View paramAnonymousView)
//              {
//                d.v(RemittanceDetailUI.this, 0);
//              }
//            };
//            ((SpannableString)localObject2).setSpan(locala, paramj.length(), paramj.length() + ((String)localObject1).length(), 33);
//            this.eVJ.setMovementMethod(LinkMovementMethod.getInstance());
//            this.eVJ.setText((CharSequence)localObject2);
//            label1016:
//            this.eVJ.setVisibility(0);
//          }
//          for (;;)
//          {
//            this.fTc.setText(getString(2131432348, new Object[] { com.tencent.mm.wallet_core.ui.e.si(paramString.fSH) }));
//            this.fTc.setVisibility(0);
//            this.fTd.setText(getString(2131432350, new Object[] { com.tencent.mm.wallet_core.ui.e.si(paramString.fSL) }));
//            this.fTd.setVisibility(0);
//            break;
//            this.fSY.setImageResource(2130903240);
//            if (bool)
//            {
//              this.fSZ.setText(2131432342);
//              break label884;
//            }
//            paramj = M(paramString.fSI, true) + getString(2131432342);
//            this.fSZ.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this, paramj, this.fSZ.getTextSize()));
//            break label884;
//            label1183:
//            this.eVJ.setText(2131432355);
//            break label1016;
//            label1196:
//            this.eVJ.setVisibility(8);
//          }
//          label1208:
//          paramInt1 = 2131432331;
//          break label158;
//          label1215:
//          g.ba(this.koJ.kpc, getString(2131432351));
//        }
//      }
//    }
//    else if ((paramj instanceof b))
//    {
//      localObject1 = (b)paramj;
//      if ((paramInt1 == 0) && (paramInt2 == 0))
//      {
//        if ("confirm".equals(((b)localObject1).fSs)) {
//          ka(1);
//        }
//        for (;;)
//        {
//          return true;
//          N(0, getString(2131432352));
//        }
//      }
//      if (paramInt2 == 416) {
//        return com.tencent.mm.plugin.wallet_core.id_verify.b.a.a(this, paramInt2, paramString, paramj, new Bundle());
//      }
//      N(paramInt2, paramString);
//      return true;
//    }
//    return false;
//  }
//
//  protected final int getLayoutId()
//  {
//    return 2131362709;
//  }
//
//  public void ka(int paramInt)
//  {
//    a(new com.tencent.mm.plugin.remittance.b.e(paramInt, this.fTg, this.fTi, this.fTe), true);
//  }
//
//  public void kb(int paramInt)
//  {
//    if (!getIntent().getBooleanExtra("is_sender", false)) {}
//    for (i locali = new i(this.fTi, this.fTj, paramInt);; locali = new i(this.fTg, this.fTj, paramInt))
//    {
//      locali.bwE = "RemittanceProcess";
//      j(locali);
//      return;
//    }
//  }
//
//  public void onCreate(Bundle paramBundle)
//  {
//    super.onCreate(paramBundle);
//    this.fTe = getIntent().getIntExtra("invalid_time", 0);
//    this.fTf = getIntent().getIntExtra("appmsg_type", 0);
//    this.fTg = getIntent().getStringExtra("transaction_id");
//    this.fTj = getIntent().getStringExtra("bill_id");
//    this.fTi = getIntent().getStringExtra("transfer_id");
//    this.fTh = getIntent().getStringExtra("sender_name");
//    this.fTk = getIntent().getIntExtra("effective_date", 3);
//    this.fTl = getIntent().getBooleanExtra("is_sender", false);
//    this.fTm = getIntent().getIntExtra("total_fee", 0);
//    Gb();
//    ka(0);
//  }
//
//  public void z(Intent paramIntent)
//  {
//    com.tencent.mm.ar.c.c(this, "remittance", ".ui.RemittanceResendMsgUI", paramIntent);
//  }
//}
//