package com.mehmet.countryinfo;

public class SingletonLearn {
    //burada private yapmak önemli singleton'ın çalışma mantığı böyle başlıyor
    private LandMark secilenbutton;
    //ikinciside bir static bir singleton objesi oluşturmak
    private static SingletonLearn singletonLearn;

    private  SingletonLearn() {

    }

    //bundan sonra getter ve setterlarımı oluşturabiliriz


    public LandMark getLandMark(){
        return secilenbutton;
    }

    public void SetLandmark (LandMark secilenbutton){
        this.secilenbutton = secilenbutton;
    }

    /* private static SingletonLearn singletonLearn; bu obje oluşturulmadıysa eğer bunun oluşturulmasını sağlamam lazım ve daha öncede oluşturulduysa onun kullanılmasını olanak tanımam */

    public  static  SingletonLearn getInstance() {
        if (singletonLearn == null){
            singletonLearn = new SingletonLearn();
        }
       return  singletonLearn;
    }


}
