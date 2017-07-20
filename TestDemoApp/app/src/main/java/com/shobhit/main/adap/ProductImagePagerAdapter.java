package com.shobhit.main.adap;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.shobhit.main.R;

/**
 * This is GetOrderActivity class
 * <p>
 *     This class is getting called from ItemDetailsActivity class.
 *     In this class we set paging for each image using PagerAdapter.
 * </p>
 * @author 3embed
 * @version 1.0
 * @since 18/5/16
 */
public class ProductImagePagerAdapter extends PagerAdapter
{
    private LayoutInflater layoutInflater;
    private int[] image_array;

    public ProductImagePagerAdapter(Activity context, int[] image_array) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.image_array = image_array;
        System.out.println("images url..."+image_array.length);
    }

    @Override
    public int getCount() {
        if(image_array != null){
            return image_array.length;
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        System.out.println("instantiate.."+container+" "+position);
        View itemView = layoutInflater.inflate(R.layout.product_image_viewpager_layout, container, false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.viewPagerItem_image1);
        imageView.setBackgroundResource(image_array[position]);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
