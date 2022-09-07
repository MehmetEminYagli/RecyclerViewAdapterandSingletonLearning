package com.mehmet.countryinfo;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.mehmet.countryinfo.databinding.ActivityMainBinding;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<LandMark> LandmarkArrayList;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //initialize yaptık
        LandmarkArrayList = new ArrayList<>();


        //datalar
        LandMark pisa = new LandMark("Pisa","Italy",R.drawable.pisa);
        LandMark eifel = new LandMark("eifel","France",R.drawable.eifel);
        LandMark collesium = new LandMark("collesium","France",R.drawable.eifel);

        //sonra dizi ile datalarımı tek tek yazdırabilirim

        LandmarkArrayList.add(pisa);
        LandmarkArrayList.add(eifel);
        LandmarkArrayList.add(collesium);


        //objerlerin nasıl görünceğinin komutunu yazmamız lazım ki objeler mal gibi durmasın
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapterLearn recyclerViewAdapterLearn = new RecyclerViewAdapterLearn(LandmarkArrayList);
        binding.recyclerView.setAdapter(recyclerViewAdapterLearn);



    }
}








/*
        //Adapter
        //burdaki veri kaynağımız ile  xml'i ve listView'i bağlayan yapıya Adapter diyoruz
        //adapteri listViewDe kullanmak daha basit olduğu için listView Daha basit oluyor

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                //MAPPİNG NEYİ NEYE ÇEVİRİYİM   sınıfın ismi -> değiştirilecek sınıf
                LandmarkArrayList.stream().map(landMark -> landMark.name).collect(Collectors.toList())
        );
        //setAdapter ile oluşturulan adaptörü istediğimiz obje ile bağlayabiliriz.
        binding.listView.setAdapter(arrayAdapter);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override                                                     //i ==> sırası 0 dan başlıyoruz hangi sayıya tıklanırsa ona olacakları yazıyoruz
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(MainActivity.this,LandmarkArrayList.get(i).name, Toast.LENGTH_SHORT).show();
                //AKTİVİTELER ARASI NASIL GEÇİŞ YAPARIZ İNTENT KOMUTU İLE
                                            //nereden nereye gidicez
                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);

                //hnagi objeye tıklandığını alıyım ki açılan yeni sayfada o objenin özelliklerini çağırabiliyim bunu nasıl yapıyorduk
                //intent.putExtra("anahtar kelime", neyi yollucaz)

                    intent.putExtra("landmark",LandmarkArrayList.get(i).name);
                startActivity(intent);
            }
        });
*/