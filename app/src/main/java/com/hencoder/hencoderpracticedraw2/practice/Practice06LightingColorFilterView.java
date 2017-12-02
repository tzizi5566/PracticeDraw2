package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw2.R;

public class Practice06LightingColorFilterView extends View {

  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
  Bitmap bitmap;
  private ColorFilter mColorFilter1 = new LightingColorFilter(0x00ffff, 0x000000);
  private ColorFilter mColorFilter2 = new LightingColorFilter(0xffffff, 0x003000);

  public Practice06LightingColorFilterView(Context context) {
    this(context, null);
  }

  public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs,
      int defStyleAttr) {
    super(context, attrs, defStyleAttr);

  }

  {
    bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    // 使用 Paint.setColorFilter() 来设置 LightingColorFilter

    paint.setColorFilter(mColorFilter1);
    // 第一个 LightingColorFilter：去掉红色部分
    canvas.drawBitmap(bitmap, 0, 0, paint);

    paint.setColorFilter(mColorFilter2);
    // 第二个 LightingColorFilter：增强绿色部分
    canvas.drawBitmap(bitmap, bitmap.getWidth() + 100, 0, paint);
  }
}
