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
        viewHolder.tvTitle.setText(story.getTitle());
        viewHolder.tvSummary.setText(story.getSummary());
        if(!story.getImageUrl().isEmpty()){
            imageLoader.DisplayImage(story.getImageUrl(), viewHolder.imgPreivew);
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imgPreivew;
        public TextView tvTitle;
        public TextView tvSummary;

        public ViewHolder(View itemView) {
            super(itemView);
            imgPreivew = (ImageView)itemView.findViewById(R.id.iv_previewImg);
            tvTitle = (TextView)itemView.findViewById(R.id.tv_title);
            tvSummary = (TextView)itemView.findViewById(R.id.tv_summary);
        }
    }
}


