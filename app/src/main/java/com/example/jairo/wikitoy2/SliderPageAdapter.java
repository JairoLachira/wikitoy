package com.example.jairo.wikitoy2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SliderPageAdapter extends PagerAdapter
{
    private Context mcontext;
    private List<slider> mList;

    public SliderPageAdapter(Context mcontext, List<slider> mList) {
        this.mcontext = mcontext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater=(LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View sliderLayout=inflater.inflate(R.layout.slider,null);

        ImageView sliderImg=sliderLayout.findViewById(R.id.slider1);
        TextView sliderText=sliderLayout.findViewById(R.id.tvslider);

        sliderImg.setImageResource(mList.get(position).getImage());
        sliderText.setText(mList.get(position).getTitle());
        container.addView(sliderLayout);
        return sliderLayout;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
