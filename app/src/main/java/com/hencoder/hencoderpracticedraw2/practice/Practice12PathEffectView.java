package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.SumPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice12PathEffectView extends View {

  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
  Path path = new Path();
  PathEffect mCornerPathEffect = new CornerPathEffect(20);
  PathEffect mDiscretePathEffect = new DiscretePathEffect(20, 5);
  PathEffect mDashPathEffect = new DashPathEffect(new float[] { 20, 10, 5, 10 }, 0);
  PathEffect mPathDashPathEffect;
  PathEffect mSumPathEffect = new SumPathEffect(mDashPathEffect, mDiscretePathEffect);
  PathEffect mComposePathEffect = new ComposePathEffect(mDashPathEffect, mDiscretePathEffect);

  public Practice12PathEffectView(Context context) {
    super(context);
  }

  public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  {
    paint.setStyle(Paint.Style.STROKE);

    path.moveTo(50, 100);
    path.rLineTo(50, 100);
    path.rLineTo(80, -150);
    path.rLineTo(100, 100);
    path.rLineTo(70, -120);
    path.rLineTo(150, 80);

    Path dashPath = new Path();
    dashPath.lineTo(20, -30);
    dashPath.lineTo(40, 0);
    dashPath.close();

    mPathDashPathEffect = new PathDashPathEffect(dashPath, 50, 0, PathDashPathEffect.Style.MORPH);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    // 使用 Paint.setPathEffect() 来设置不同的 PathEffect

    // 第一处：CornerPathEffect
    paint.setPathEffect(mCornerPathEffect);
    canvas.drawPath(path, paint);

    canvas.save();
    canvas.translate(500, 0);
    // 第二处：DiscretePathEffect
    paint.setPathEffect(mDiscretePathEffect);
    canvas.drawPath(path, paint);
    canvas.restore();

    canvas.save();
    canvas.translate(0, 200);
    // 第三处：DashPathEffect
    paint.setPathEffect(mDashPathEffect);
    canvas.drawPath(path, paint);
    canvas.restore();

    canvas.save();
    canvas.translate(500, 200);
    // 第四处：PathDashPathEffect
    paint.setPathEffect(mPathDashPathEffect);
    canvas.drawPath(path, paint);
    canvas.restore();

    canvas.save();
    canvas.translate(0, 400);
    // 第五处：SumPathEffect
    paint.setPathEffect(mSumPathEffect);
    canvas.drawPath(path, paint);
    canvas.restore();

    canvas.save();
    canvas.translate(500, 400);
    // 第六处：ComposePathEffect
    paint.setPathEffect(mComposePathEffect);
    canvas.drawPath(path, paint);
    canvas.restore();
  }
}
