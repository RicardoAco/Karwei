package com.acosta.ricardo.logindemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerView_Config {

    private Context mContext;
    private KarweiAdapter mKarweiAdapter;

    public void setConfig(RecyclerView recyclerView, Context context,List<Karwei> karweis,List<String> keys){
        mContext = context;
        mKarweiAdapter = new KarweiAdapter(karweis, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mKarweiAdapter);
    }

    class KarweiItemView extends RecyclerView.ViewHolder{
        private TextView mTitle;
        private TextView mDescription;
        private TextView mContact;
        private TextView mWage;

        private Button mButton;

        private  String key;

        public KarweiItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.karwei_list_item, parent,false));

            mTitle = (TextView) itemView.findViewById(R.id.title_txtView);
            mDescription = (TextView) itemView.findViewById(R.id.description_txtView);
            mContact = (TextView) itemView.findViewById(R.id.contact_txtView);
            mWage = (TextView) itemView.findViewById(R.id.wage_txtView);

            //BUTTON MESSAGE
            mButton = (Button) itemView.findViewById(R.id.btnSendMessage);





        }

        public void bind(Karwei karwei,String key){
            mTitle.setText(karwei.getTitle());
            mDescription.setText(karwei.getDescription());
            mContact.setText(karwei.getContact());
            mWage.setText(karwei.getWage());
        }

    }
    class KarweiAdapter extends RecyclerView.Adapter<KarweiItemView>{
        private List<Karwei> mKarweiList;
        private List<String> mKeys;

        public KarweiAdapter(List<Karwei> mKarweiList, List<String> mKeys) {
            this.mKarweiList = mKarweiList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public KarweiItemView onCreateViewHolder(@NonNull ViewGroup parent, int i) {
            return new KarweiItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull KarweiItemView holder, int i) {
            holder.bind(mKarweiList.get(i), mKeys.get(i));
        }

        @Override
        public int getItemCount() {
            return mKarweiList.size();
        }
    }


}
