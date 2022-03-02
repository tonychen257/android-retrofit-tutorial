package edu.uci.swe264p.retrofit;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {
    private static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500";
    private Context context;
    private List<Movie> data;

    public MovieListAdapter(Context context, List<Movie> data) {
        this.context = context;
        this.data = data;
    }

    public void setData(List<Movie> data) {
        this.data = data;
        notifyDataSetChanged(); // with notify
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = data.get(position);

        holder.tvTitle.setText(movie.getTitle());
        holder.tvDate.setText(movie.getReleaseDate());
        holder.tvVote.setText(String.valueOf(movie.getVoteAverage()));
        holder.tvOverview.setText(movie.getOverview());
        Picasso.get()
                .load(IMAGE_BASE_URL+ movie.getPosterPath())
                .into(holder.ivMovie);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    // Declare a ViewHolder class that extends RecyclerView.ViewHolder, responsible for displaying single item with a view.
    public class ViewHolder extends RecyclerView.ViewHolder {
        // For each layout create a holder to it.
        ImageView ivMovie;
        TextView tvTitle;
        TextView tvDate;
        TextView tvVote;
        TextView tvOverview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivMovie = itemView.findViewById(R.id.ivMovie);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDate = itemView.findViewById(R.id.tvReleaseDate);
            tvVote = itemView.findViewById(R.id.tvVote);
            tvOverview = itemView.findViewById(R.id.tvOverview);
        }
    }
}
