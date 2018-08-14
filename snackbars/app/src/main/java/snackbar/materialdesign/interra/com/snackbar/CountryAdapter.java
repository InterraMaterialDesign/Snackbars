package snackbar.materialdesign.interra.com.snackbar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    private ArrayList<Country> countryList;
    private Context context;

    public CountryAdapter(Context context, ArrayList<Country> countryList) {
        this.context = context;
        this.countryList = countryList;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.country_list, viewGroup, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder countryViewHolder, int i) {
        Country countries = countryList.get(i);
        countryViewHolder.mCountry.setText(countries.getmCountry());
        countryViewHolder.mCapital.setText(countries.getmCapital());
        countryViewHolder.mDescription.setText(countries.getmDescription());
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public void removeItem (int position) {
        countryList.remove(position);
        notifyItemRemoved(position);
    }

    class CountryViewHolder extends RecyclerView.ViewHolder{
        TextView mCountry;
        TextView mCapital;
        TextView mDescription;

        CountryViewHolder(View itemView) {
            super(itemView);

            mCountry = itemView.findViewById(R.id.country);
            mCapital = itemView.findViewById(R.id.capital);
            mDescription = itemView.findViewById(R.id.description);
        }
    }
}
