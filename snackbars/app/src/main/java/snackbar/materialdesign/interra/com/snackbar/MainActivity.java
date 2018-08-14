package snackbar.materialdesign.interra.com.snackbar;

import android.content.Intent;
import android.support.design.button.MaterialButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View containerView = findViewById(R.id.coordinator);

        MaterialButton normal = findViewById(R.id.normal);
        MaterialButton withAction = findViewById(R.id.withAction);
        MaterialButton withSwipe = findViewById(R.id.withSwipe);
        MaterialButton customSnackbar = findViewById(R.id.customSnackbar);
        MaterialButton fab = findViewById(R.id.fab);
        MaterialButton multiLine = findViewById(R.id.multiLine);
        MaterialButton size = findViewById(R.id.size);
        MaterialButton fullWidth = findViewById(R.id.fullWidth);

        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(containerView, "Normal snackbar", Snackbar.LENGTH_LONG)
                        .show();
            }
        });

        withAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(containerView, "Snackbar with Action", Snackbar.LENGTH_LONG);
                snackbar.setAction("TOAST", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), "This is Toast!", Toast.LENGTH_SHORT).show();
                    }
                });
                snackbar.show();

            }
        });

        fullWidth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(containerView, "Snackbars can span the entire width of a UI", Snackbar.LENGTH_LONG);
                snackbar.setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
                Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();

                int width = containerView.getWidth();
                layout.setMinimumWidth(width);
                layout.setBackgroundResource(R.drawable.corner_radius);

                snackbar.show();
            }
        });

        withSwipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(containerView, "Snackbar with Swipe", Snackbar.LENGTH_INDEFINITE);
                snackbar.show();
            }
        });

        size.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(containerView, "Hugeeeee!", Snackbar.LENGTH_LONG);
                int snackbarTextId = android.support.design.R.id.snackbar_text;
                TextView textView = snackbar.getView().findViewById(snackbarTextId);
                textView.setTextSize(100);
                snackbar.show();
            }
        });

        customSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(containerView, R.string.custom_snackbar, Snackbar.LENGTH_LONG);
                snackbar.setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
                snackbar.setActionTextColor(getResources().getColor(R.color.black));

                int snackbarTextId = android.support.design.R.id.snackbar_text;
                TextView textView = snackbar.getView().findViewById(snackbarTextId);
                textView.setTextColor(getResources().getColor(R.color.green));

                snackbar.getView().setBackgroundColor(getResources().getColor(R.color.colorSecondary));

                snackbar.show();
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), FloatingActionButton.class);
                startActivity(intent);
            }
        });

        multiLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(containerView, "Two line message\nwith action\n", Snackbar.LENGTH_LONG).setAction("\n\nLONG ACTION", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
                View snackbarView = snackbar.getView();
                TextView textView = snackbarView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setMaxLines(3);
                snackbar.show();
            }
        });

    }
}
