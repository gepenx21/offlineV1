package com.shankara.djtiktoknew.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.shankara.djtiktoknew.Config;
import com.shankara.djtiktoknew.Model.Song;
import com.shankara.djtiktoknew.R;

import java.util.ArrayList;

import es.claucookie.miniequalizerlibrary.EqualizerView;


public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {

    private Context context;
    private ArrayList<Song> songList;
    private RecyclerItemClickListener listener;
    private int selectedPosition;

    public SongAdapter(Context context, ArrayList<Song> songList, RecyclerItemClickListener listener){
        this.context = context;
        this.songList = songList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_row, parent, false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        Song song = songList.get(position);
        if(song != null){
            if(selectedPosition == position){
                holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.background_selected_item));
                holder.iv_play_active.setVisibility(View.VISIBLE);
                if (Config.isPlaying) {
                    holder.eq_view.animateBars();
                    holder.rv_artwork.setVisibility(View.GONE);
                    holder.eq_view.setVisibility(View.VISIBLE);
                }
            }else{
                holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.card_color));
                holder.iv_play_active.setVisibility(View.INVISIBLE);
                holder.eq_view.stopBars();
                holder.rv_artwork.setVisibility(View.VISIBLE);
                holder.eq_view.setVisibility(View.GONE);

            }
            holder.tv_title.setText(song.getTitle());
            holder.tv_artist.setText(song.getArtist());
            holder.bind(song, listener);
        }
    }



    @Override
    public int getItemCount() {
        return songList.size();
    }

    static class SongViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_title, tv_artist;
        private ImageView  iv_play_active, rv_artwork;
        private EqualizerView eq_view;

        SongViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_artist = itemView.findViewById(R.id.tv_artist);
            iv_play_active = itemView.findViewById(R.id.iv_play_active);
            eq_view = itemView.findViewById(R.id.equalizer_view);
            rv_artwork = itemView.findViewById(R.id.rv_artwork);
        }

        void bind(final Song song, final RecyclerItemClickListener listener){
            itemView.setOnClickListener(v -> listener.onClickListener(song, getLayoutPosition()));
        }
    }

    public interface RecyclerItemClickListener{
        void onClickListener(Song song, int position);
    }

    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
    }

    public int getSelectedPosition() {
        return selectedPosition;
    }
}
