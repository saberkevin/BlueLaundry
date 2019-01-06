package binuslabproject.bluelaundry;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class VPCarouselAdapter extends PagerAdapter {

    private Context context;
    private int imageList[] = {};
    private LayoutInflater layoutInflater;

    public VPCarouselAdapter(Context context)
    {
        this.context = context;
    }

    @Override
    public int getCount() {
        return imageList.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View v = layoutInflater.inflate(R.layout.image_view_carousel, null);
        ImageView iv = v.findViewById(R.id.imageViewCarousel);
        iv.setImageResource(imageList[position]);
        ViewPager vp = (ViewPager) container;
        vp.addView(v);

        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View v = (View) object;
        ViewPager vp = (ViewPager) container;

        vp.removeView(v);
    }
}
