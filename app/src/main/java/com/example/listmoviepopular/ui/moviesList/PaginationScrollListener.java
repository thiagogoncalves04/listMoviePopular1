package com.example.listmoviepopular.ui.moviesList;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class PaginationScrollListener extends RecyclerView.OnScrollListener {
    private int threshold = 2;

    RecyclerView.LayoutManager layoutManager;

    public PaginationScrollListener(RecyclerView.LayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        int visibleItemCount = layoutManager.getChildCount();
        int totalItemCount = layoutManager.getItemCount();
        int firstVisibleItemPosition = ((GridLayoutManager) layoutManager).findFirstVisibleItemPosition();

        if ((visibleItemCount + firstVisibleItemPosition + threshold) >=
                totalItemCount) {
            loadMoreItems();
        }
    }

    protected abstract void loadMoreItems();
}