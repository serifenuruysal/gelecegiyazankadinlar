package serifenuruysal.com.mylistapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieAdapter.AdapterListener {
    List<Movie> movieList = new ArrayList<>();
    MovieAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rlvMyList);
        mAdapter = new MovieAdapter(movieList,this,this);
        recyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        fillMyMovieLisy();

    }

    private void fillMyMovieLisy() {
        movieList.add(new Movie("Game of Thrones", "blalslslsllsls ksksksksk"));
        movieList.add(new Movie("Game of Hebele", "djsheuu ksksksksk"));
        movieList.add(new Movie("HOppile of Thrones", "blalslslsllsls hsaha"));
        movieList.add(new Movie("Tabule of Thrones", "whuıeıuw ksksksksk"));
        movieList.add(new Movie("KAjjdj of Thrones", "blalslslsllsls ksksksksk"));
        movieList.add(new Movie("Bambam of Thrones", "bndgfjej ksksksksk"));
        movieList.add(new Movie("Hoppiti of Thrones", "djdjd ksksksksk"));
        movieList.add(new Movie("Dabadaa of Thrones", "blalslslsllsls ksksksksk"));
        movieList.add(new Movie("yabadaba of Thrones", "nxnjue ksksksksk"));
        movieList.add(new Movie("Da daa daa", "blalslslsllsls ksksksksk"));
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClickImage(Movie movie) {
        Intent newIntent=new Intent(MainActivity.this,WebViewActivity.class);
        startActivity(newIntent);

    }

    @Override
    public void onClickTitle(Movie movie) {
        Toast.makeText(this, movie.getName(),
                Toast.LENGTH_LONG).show();

    }
}
