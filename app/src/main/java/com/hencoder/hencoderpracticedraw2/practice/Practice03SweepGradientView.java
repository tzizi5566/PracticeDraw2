package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice03SweepGradientView extends View {

  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
  private Shader mShader;

  public Practice03SweepGradientView(Context context) {
    this(context, null);
  }

  public Practice03SweepGradientView(Context context, @Nullable AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public Practice03SweepGradientView(Context context, @Nullable AttributeSet attrs,
      int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    mShader = new SweepGradient(
        300,
        300,
        Color.parseColor("#E91E63"),
        Color.parseColor("#2196F3"));
  }

  static {
    // 用 Paint.setShader(shader) 设置一个 SweepGradient
    // SweepGradient 的参数：圆心坐标：(300, 300)；颜色：#E91E63 到 #2196F3
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    paint.setShader(mShader);
    canvas.drawCircle(300, 300, 200, paint);
  }
}
