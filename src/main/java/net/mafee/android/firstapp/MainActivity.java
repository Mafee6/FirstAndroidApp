package net.mafee.android.firstapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("First Android App!");
        ImageView infobtn = (ImageView) findViewById(R.id.info);
        infobtn.setOnClickListener((view) -> {
            Toast.makeText(getApplicationContext(), "Github", Toast.LENGTH_SHORT).show();
            Intent info = new Intent(Intent.ACTION_SEND);
            info.setType("text/plain");
            info.putExtra(Intent.EXTRA_TEXT, "https://github.com/mafee6/");
            startActivity(Intent.createChooser(info, null));
        });

        EditText name = (EditText) findViewById(R.id.name);
        TextView nametext = (TextView) findViewById(R.id.nametext);
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                nametext.setText(getString(R.string.hello).concat(" ").concat(charSequence.toString()));
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        RatingBar rating = (RatingBar) findViewById(R.id.rate);
        TextView rated = (TextView) findViewById(R.id.rated);
        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                rated.setText(String.valueOf(ratingBar.getRating()).concat(" :)"));
            }
        });


        Button twitter = (Button) findViewById(R.id.twitterbtn);
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twitterActivity();
            }
        });

    }

    public void twitterActivity () {
        Intent twit = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/mafee71"));
        startActivity(twit);
    }
}