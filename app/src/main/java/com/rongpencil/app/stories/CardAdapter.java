package com.rongpencil.app.stories;

    import android.support.v7.widget.RecyclerView;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.ImageView;
    import android.widget.TextView;

    import java.util.ArrayList;
    import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    List<StoryData> mItems;
    ImageLoader imageLoader;

    public CardAdapter(ArrayList<StoryData> data) {
        super();
        mItems = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view_card_item, viewGroup, false);

        imageLoader = new ImageLoader(v.getContext().getApplicationContext());

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        StoryData story = mItems.get(i);

        // Bind data to the view elements
        viewHolder.tvNature.setText(story.getTitle());
        viewHolder.tvDesNature.setText(story.getSummary());
        if(!story.getImageUrl().isEmpty()){
            imageLoader.DisplayImage(story.getImageUrl(), viewHolder.imgThumbnail);
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imgThumbnail;
        public TextView tvNature;
        public TextView tvDesNature;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView)itemView.findViewById(R.id.img_thumbnail);
            tvNature = (TextView)itemView.findViewById(R.id.tv_nature);
            tvDesNature = (TextView)itemView.findViewById(R.id.tv_des_nature);
        }
    }
}


