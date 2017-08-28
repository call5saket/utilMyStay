package com.libmod_mystay.util_mystayapp_lib.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.SparseArray;
import android.view.View;

import java.io.ByteArrayOutputStream;

@SuppressWarnings({ "unchecked" })
public class ViewFindUtils
{
	/**
	 * ViewHolder Simple way to avoid the definition of ViewHolder in the adapter
	 * 
	 * <pre>
	 * if (convertView == null)
	 * {
	 * 	convertView = View.inflate(context, R.layout.ad_demo, null);
	 * }
	 * TextView tv_demo = ViewHolderUtils.get(convertView, R.id.tv_demo);
	 * ImageView iv_demo = ViewHolderUtils.get(convertView, R.id.iv_demo);
	 * </pre>
	 */
	public static <T extends View> T hold(View view, int id)
	{
		SparseArray<View> viewHolder = (SparseArray<View>) view.getTag();

		if (viewHolder == null)
		{
			viewHolder = new SparseArray<View>();
			view.setTag(viewHolder);
		}

		View childView = viewHolder.get(id);

		if (childView == null)
		{
			childView = view.findViewById(id);
			viewHolder.put(id, childView);
		}

		return (T) childView;
	}

	/**
	 * Replace the findviewById method
	 */
	public static <T extends View> T find(View view, int id)
	{
		return (T) view.findViewById(id);
	}

	public static byte[] convertDrawBitm(Context c, int rId){

		try {
			Bitmap bitmap = BitmapFactory.decodeResource(c.getResources(), rId);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
			byte[] b = baos.toByteArray();

			return b;
		}catch (Exception e){
			e.printStackTrace();
		}

 return null;
	}

	public static Bitmap getImageRounded(Bitmap bmp){
		Bitmap mbitmap = bmp;
		Bitmap imageRounded = Bitmap.createBitmap(mbitmap.getWidth(), mbitmap.getHeight(), mbitmap.getConfig());
		Canvas canvas = new Canvas(imageRounded);
		Paint mpaint = new Paint();
		mpaint.setAntiAlias(true);
		mpaint.setShader(new BitmapShader(mbitmap, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR));
		canvas.drawRoundRect((new RectF(10,10,mbitmap.getWidth(), mbitmap.getHeight())),30, 30, mpaint);// Round Image Corner 100 100 100 100

		return imageRounded;
	}
}
