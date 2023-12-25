package com.example.mobile_pfe.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobile_pfe.R;
import com.example.mobile_pfe.model.MatchItem;

import java.util.List;

public class MatchListAdapter extends BaseAdapter {

    private Context context;
    private List<MatchItem> matchList;

    // Define an interface for the click listener
    public interface OnMoreButtonClickListener {
        void onMoreButtonClick(MatchItem matchItem);
    }

    private OnMoreButtonClickListener onMoreButtonClickListener;

    public MatchListAdapter(Context context, List<MatchItem> matchList) {
        this.context = context;
        this.matchList = matchList;
    }

    public void setOnMoreButtonClickListener(OnMoreButtonClickListener listener) {
        this.onMoreButtonClickListener = listener;
    }

    @Override
    public int getCount() {
        return matchList.size();
    }

    @Override
    public Object getItem(int position) {
        return matchList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_match, parent, false);
        }

        final MatchItem match = matchList.get(position);

        ImageView team1Logo = convertView.findViewById(R.id.team1Logo);
        TextView team1Name = convertView.findViewById(R.id.team1Name);
        ImageView team2Logo = convertView.findViewById(R.id.team2Logo);
        TextView team2Name = convertView.findViewById(R.id.team2Name);
        Button moreButton = convertView.findViewById(R.id.moreButton);

        team1Logo.setImageResource(match.getTeam1Logo());
        team1Name.setText(match.getTeam1Name());
        team2Logo.setImageResource(match.getTeam2Logo());
        team2Name.setText(match.getTeam2Name());

        // Set a click listener for the "More" button
        moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onMoreButtonClickListener != null) {
                    // Notify the listener when the "More" button is clicked
                    onMoreButtonClickListener.onMoreButtonClick(match);
                }
            }
        });

        return convertView;
    }
}