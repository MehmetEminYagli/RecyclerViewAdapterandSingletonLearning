package com.mehmet.countryinfo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mehmet.countryinfo.databinding.RecylerRowLearnBinding;

import java.util.ArrayList;

public class RecyclerViewAdapterLearn  extends RecyclerView.Adapter<RecyclerViewAdapterLearn.LandmarkHolder> {

    ArrayList<LandMark> landMarkArrayList;
//constructor ile dizide kaç tane elaman olduğunu alabiliriz
    //sonra bu constructor'ı main activity'ye bağlıyarak bilgileri çekebiliriz.
    public RecyclerViewAdapterLearn(ArrayList<LandMark> landMarkArrayList) {
        this.landMarkArrayList = landMarkArrayList;
    }

    @NonNull
    @Override
    public LandmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //LayoutInflater ==> sadece bir xml ile buradaki işlemleri birbirine bağladığımız bir yapı        (bizden bir context istiyor ama this yazmayız buraya yanlış yeri alır o yüzden bağlanıyacağı yeri söylebilmek için
        // parent.getcontext()   komutunu kullanıyoruz
        RecylerRowLearnBinding recylerRowLearnBinding = RecylerRowLearnBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new LandmarkHolder(recylerRowLearnBinding);
        //xml bağlantısını buradan yapıcaz
    }

    @Override
    public void onBindViewHolder(@NonNull LandmarkHolder holder, @SuppressLint("RecyclerView") int position) {
//burada değerleri vericez
        holder.binding.RecycylerTextView.setText(landMarkArrayList.get(position).name);
        //bunları gösterbilmek için MainActivity'ye adaptör ile bağlamamız lazım
        //bu komut ile her butona basıldığında ne olucağını söyleyebiliyoruz
        //her bir elemana tıklandığında ne olacağını bu şekilde yazabiliyoruz
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //                          burada this diyemiyoruz o yüzden bu komutu yazıyoruz
                //                          neden this diyemiyoruz çünkü aktivite içerisinde değiliz
                Intent intent = new Intent(holder.itemView.getContext(),DetailsActivity.class);
                //intent.putExtra("landmark", landMarkArrayList.get(position));

                //şu ana kadar veri aktarımlarını intent komutu ile yaptık bunun başka yollarıda vardır. Bunlardan biri SİNGLETON
                //Singelton kullanım örneği
                SingletonLearn singletonLearn = SingletonLearn.getInstance();
                singletonLearn.SetLandmark(landMarkArrayList.get(position));
                //sonra DetailsActivity'e gittik oradaya singelton komutu yazdık

                holder.itemView.getContext().startActivities(new Intent[]{intent});
            }


        });
    }

    @Override
    public int getItemCount() {
        return landMarkArrayList.size();
        //burada da kaç tane veri olduğunu söylücez
    }

    public  class  LandmarkHolder extends RecyclerView.ViewHolder {

        //yardımcı elemanı kullanabilmek için binding yazmamız gerekiyor

        private RecylerRowLearnBinding binding;


        public LandmarkHolder(RecylerRowLearnBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            //böylelikle LandmarkHolder her oluştuğunda benden bir binding isticek bende bu binding'i istenilen veri ile eşleştiricem
        }
    }


}
