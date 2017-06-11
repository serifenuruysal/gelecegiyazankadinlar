package serifenuruysal.com.mylistapp;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by serifenuruysal on 11/06/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    private List<Movie> movieList;
    private AdapterListener listener;
    private Context context;

    public MovieAdapter(List<Movie> movieList, AdapterListener listener,Context context) {
        this.movieList = movieList;
        this.listener = listener;
        this.context=context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, detail;
        public ImageView movieImage;
        public Button button;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.tvTitle);
            detail = (TextView) view.findViewById(R.id.tvDetail);
            movieImage = (ImageView) view.findViewById(R.id.ivMyImagee);
            button =(Button) view.findViewById(R.id.btnClickMe);
        }

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row, parent, false);
        return new MyViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
       final Movie movie = movieList.get(position);
        holder.title.setText(movie.getName());
        holder.detail.setText(movie.getDetail());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickImage(movie);
            }
        });

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickTitle(movie);
            }
        });

        holder.movieImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                builder.setMessage("Geleceği Kadınlar Yazar :)");
                builder.setCancelable(true);
                builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        holder.title.setText("TAMAMLANDI");
                    }
                });

                builder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        holder.title.setText("TAMAMLANAMADI");
                    }
                });
                AlertDialog alert=builder.create();
                alert.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public interface AdapterListener {
        public void onClickImage(Movie movie);

        public void onClickTitle(Movie movie);
    }
}

