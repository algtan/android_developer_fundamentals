package io.github.algtan.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    // Create a private linked list of strings
    private final LinkedList<String> mWordList;
    // Create a member variable for the inflater
    private LayoutInflater mInfalter;

    // Add a new WordViewHolder inner class
    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // Add variables to the WordViewHolder innner class for the TextView and the adapter
        public final TextView wordItemView;
        final WordListAdapter mAdapter;

        // Add a constructor that initializes the ViewHolder TextView from the 'word' XML resource and sets its adapter
        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            this.mAdapter = adapter;

            // Connect the onClickListener with the View
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            // Get the position of the item that was clicked
            int mPosition = getLayoutPosition();
            // Use that to access the affected item in mWordList
            String element = mWordList.get(mPosition);
            // Change the word in the mWordList
            mWordList.set(mPosition, "Clicked! " + element);
            // Notify the adapter, that the data has changed so it can update the RecyclerView to display the data
            mAdapter.notifyDataSetChanged();
        }
    }

    // Constructor for WordListAdapter
    public WordListAdapter(Context context, LinkedList<String> wordList) {
        mInfalter = LayoutInflater.from(context);
        this.mWordList = wordList;
    }

    // When the ViewHolder is created, fills in it with initial data
    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInfalter.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    // onBindViewHolder places new items into the RecyclerView
    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }
}
