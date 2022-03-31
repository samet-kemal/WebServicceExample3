package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.samet.webservicceexample3.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import Model.Information;

public class InformationAdapter extends BaseAdapter {

    List<Information> photoList;
    Context context;

    public InformationAdapter(List<Information> photoList, Context context) {
        this.photoList = photoList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return photoList.size();
    }

    @Override
    public Object getItem(int i) {
        return photoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(context).inflate(R.layout.layout,viewGroup,false);


        TextView albumid= (TextView) view.findViewById(R.id.albumIdTextView);
        TextView id= (TextView) view.findViewById(R.id.idTextView);
        TextView title= (TextView) view.findViewById(R.id.titleTextView);
        TextView url= (TextView) view.findViewById(R.id.urlTextView);

        ImageView informationImageVİew=(ImageView) view.findViewById(R.id.imageInformationImageView);

        Picasso.get().load(photoList.get(i).getThumbnailUrl()).into(informationImageVİew);
        albumid.setText((photoList.get(i).getAlbumId().toString()));
        id.setText((photoList.get(i).getId().toString()));
        title.setText((photoList.get(i).getTitle()));
        url.setText((photoList.get(i).getUrl()));

        return view;
    }
}
