package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice13ShadowLayerView extends View {

  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

  public Practice13ShadowLayerView(Context context) {
    this(context, null);
  }

  public Practice13ShadowLayerView(Context context, @Nullable AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public Practice13ShadowLayerView(Context context, @Nullable AttributeSet attrs,
      int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  static {
    // 使用 Paint.setShadowLayer() 设置阴影
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    paint.setTextSize(120);
    paint.setShadowLayer(10, 5, 5, Color.RED);
    canvas.drawText("Hello HenCoder", 50, 200, paint);
  }
}
