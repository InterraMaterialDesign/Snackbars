package snackbar.materialdesign.interra.com.snackbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.button.MaterialButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class FloatingActionButton extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.floating_action_button);

        final ArrayList<Country> cList = new ArrayList<>();
        Country countries = new Country("Afghanistan", "Kabul", "Afghanistan is bordered on the north by Turkmenistan, Uzbekistan, and Tajikistan, on the extreme northeast by China, on the east and south by Pakistan, and by Iran on the west");
        cList.add(countries);
        countries = new Country("Albania", "Tirana","Albania is situated on the eastern shore of the Adriatic Sea, with Montenegro and Serbia to the north, Macedonia to the east, and Greece to the south.");
        cList.add(countries);
        countries = new Country("Algeria", "Algiers","Nearly four times the size of Texas and the largest country on the continent, Algeria is bordered on the west by Morocco and Western Sahara and on the east by Tunisia and Libya. The Mediterranean Sea is to the north, and to the south are Mauritania, Mali, and Niger. The Saharan region, which is 85% of the country, is almost completely uninhabited.");
        cList.add(countries);
        countries = new Country("Andorra", "Andorra La Vella","Andorra is nestled high in the Pyrénées Mountains on the French-Spanish border.");
        cList.add(countries);
        countries = new Country("Angola", "Luanda","The Democratic Republic of the Congo and the Republic of Congo are to the north and east, Zambia is to the east, and Namibia is to the south.");
        cList.add(countries);
        countries = new Country("Argentina","Buenos Aires","Second in South America only to Brazil in size and population, Argentina is a plain, rising from the Atlantic to the Chilean border and the towering Andes peaks.");
        cList.add(countries);
        countries = new Country("Armenia", "Yerevan","It is bounded by Georgia on the north, Azerbaijan on the east, Iran on the south, and Turkey on the west.");
        cList.add(countries);
        countries = new Country("Australia", "Canberra","The continent of Australia, with the island state of Tasmania, is approximately equal in area to the United States.");
        cList.add(countries);
        countries = new Country("Austria", "Vienna","Austria includes much of the mountainous territory of the eastern Alps (about 75% of the area).");
        cList.add(countries);
        countries = new Country("Azerbaijan", "Baku","Azerbaijan is located on the western shore of the Caspian Sea at the southeast extremity of the Caucasus.");
        cList.add(countries);
        countries = new Country("Bahrain", "Manama","Bahrain, which means “two seas,” is an archipelago in the Persian Gulf off the coast of Saudi Arabia.");
        cList.add(countries);
        countries = new Country("Bangladesh", "Dhaka","The country is low-lying riverine land traversed by the many branches and tributaries of the Ganges and Brahmaputra rivers.");
        cList.add(countries);
        countries = new Country("Barbados", "Bridgetown","An island in the Atlantic about 300 mi (483 km) north of Venezuela, Barbados is only 21 mi long (34 km) and 14 mi across (23 km) at its widest point. ");
        cList.add(countries);
        countries = new Country("Belarus", "Minsk","Belarus is a hilly lowland with forests, swamps, and numerous rivers and lakes. There are wide rivers emptying into the Baltic and Black seas.");
        cList.add(countries);
        countries = new Country("Belgium", "Brussels","Located in western Europe, Belgium has about 40 mi of seacoast on the North Sea, at the Strait of Dover, and is approximately the size of Maryland.");
        cList.add(countries);
        countries = new Country("Bosnia and Herzegovina", "Sarajevo","The Bosnian region in the north is mountainous and covered with thick forests.");
        cList.add(countries);
        countries = new Country("Botswana", "Gaborone","Twice the size of Arizona, Botswana is in south-central Africa, bounded by Namibia, Zambia, Zimbabwe, and South Africa.");
        cList.add(countries);
        countries = new Country("Brazil", "Brasilia","Brazil covers nearly half of South America and is the continent's largest nation.");
        cList.add(countries);
        countries = new Country("Burkina Faso", "Ouagadougou","Slightly larger than Colorado, Burkina Faso, formerly known as Upper Volta, is a landlocked country in West Africa.");
        cList.add(countries);
        countries = new Country("Cambodia", "Phnom Penh","Situated on the Indochinese peninsula, Cambodia is bordered by Thailand and Laos on the north and Vietnam on the east and south");
        cList.add(countries);
        countries = new Country("Cameroon", "Yaounde","Cameroon is a Central African nation on the Gulf of Guinea, bordered by Nigeria, Chad, the Central African Republic, the Republic of Congo, Equatorial Guinea, and Gabon");
        cList.add(countries);
        countries = new Country("Canada", "Ottawa","Covering most of the northern part of the North American continent and with an area larger than that of the United States, Canada has an extremely varied topography. In the east, the mountainous maritime provinces have an irregular coastline on the Gulf of St. Lawrence and the Atlantic. The St. Lawrence plain, covering most of southern Quebec and Ontario, and the interior continental plain, covering southern Manitoba and Saskatchewan and most of Alberta, are the principal cultivable areas. They are separated by a forested plateau rising from Lakes Superior and Huron.");
        cList.add(countries);
        countries = new Country("Central African Republic", "Bangui","Situated about 500 mi (805 km) north of the equator, the Central African Republic is a landlocked nation bordered by Cameroon, Chad, the Sudan, the Democratic Republic of the Congo, and the Republic of Congo.");
        cList.add(countries);
        countries = new Country("Chile", "Santiago","Situated south of Peru and west of Bolivia and Argentina, Chile fills a narrow 2,880-mi (4,506 km) strip between the Andes and the Pacific. One-third of Chile is covered by the towering ranges of the Andes.");
        cList.add(countries);

        final View contextView = findViewById(R.id.coordinatorLayout);
        final View floatingActionButton = findViewById(R.id.floating);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        final CountryAdapter adapter = new CountryAdapter(this, cList);
        recyclerView.setAdapter(adapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        final ArrayList<Country> backUpList = new ArrayList<>();
        final ItemTouchHelper.Callback callback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                final int position = viewHolder.getAdapterPosition();
                    if (direction == ItemTouchHelper.LEFT) {
                        backUpList.add(0, cList.get(position));
                        cList.remove(position);
                        adapter.removeItem(position);
                        Snackbar snackbar = Snackbar.make(contextView, "Removed from list!", Snackbar.LENGTH_INDEFINITE);
                        snackbar.setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                cList.add(position, backUpList.get(0));
                                adapter.notifyItemInserted(position);
                                backUpList.remove(0);
                            }
                        });
                        snackbar.show();
                    }
                    else {
                        backUpList.add(cList.get(position));
                        cList.remove(position);
                        adapter.removeItem(position);
                        Snackbar snackbar = Snackbar.make(contextView, "Archived!", Snackbar.LENGTH_LONG);
                        snackbar.setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                cList.add(position, backUpList.get(0));
                                adapter.notifyItemInserted(position);
                                backUpList.remove(0);
                            }
                        });
                        snackbar.show();
                    }
            }

            @Override
            public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                Bitmap icon;
                if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
                    View view = viewHolder.itemView;
                    Paint paint = new Paint();
                    float height = view.getBottom() - view.getTop();
                    float width = height/3;

                    //left
                    if (dX < 0) {
                        paint.setColor(getResources().getColor(R.color.red));
                        RectF background = new RectF((float) view.getRight() + dX,  (float)view.getTop(), (float) view.getRight(), (float) view.getBottom());
                        c.drawRect(background, paint);
                        icon = BitmapFactory.decodeResource(getResources(), R.mipmap.delete_foreground);
                        RectF icon_dest = new RectF((float)view.getRight() - 2*width, (float) view.getTop() + width, (float)view.getRight() - width, (float) view.getBottom() - width);
                        c.drawBitmap(icon, null, icon_dest, paint);
                    }
                    //left
                    else {
                        paint.setColor(getResources().getColor(R.color.green));
                        RectF background = new RectF((float) view.getLeft(), (float)view.getTop(), dX, view.getBottom());
                        c.drawRect(background, paint);
                        icon = BitmapFactory.decodeResource(getResources(), R.mipmap.archive_foreground);
                        RectF icon_dest = new RectF((float) view.getLeft() + width, (float) view.getTop() + width, (float) view.getLeft() + 2*width, (float) view.getBottom() - width);
                        c.drawBitmap(icon, null, icon_dest, paint);
                    }

                    final float alpha = 1.0f - Math.abs(dX) / (float) viewHolder.itemView.getWidth();
                    viewHolder.itemView.setAlpha(alpha);
                    viewHolder.itemView.setTranslationX(dX);
                }
                else {
                    super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
                }
            }
        };


        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}
