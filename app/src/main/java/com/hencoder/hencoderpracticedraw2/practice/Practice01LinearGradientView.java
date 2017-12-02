package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice01LinearGradientView extends View {

  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
  private Shader mShader;

  public Practice01LinearGradientView(Context context) {
    this(context, null);
  }

  public Practice01LinearGradientView(Context context, @Nullable AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public Practice01LinearGradientView(Context context, @Nullable AttributeSet attrs,
      int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    mShader = new LinearGradient(
        100,
        100,
        500,
        500,
        Color.parseColor("#E91E63"),
        Color.parseColor("#2196F3"),
        Shader.TileMode.CLAMP);
  }

  static {
    // 用 Paint.setShader(shader) 设置一个 LinearGradient
    // LinearGradient 的参数：坐标：(100, 100) 到 (500, 500) ；颜色：#E91E63 到 #2196F3
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    paint.setShader(mShader);
    canvas.drawCircle(300, 300, 200, paint);
  }
}
