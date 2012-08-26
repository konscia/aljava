package aljava;

import java.io.File;
import java.util.HashMap;

public class SoundManager {
    
    public static HashMap<String, SoundEffect> mapaSons = new HashMap<String, SoundEffect>();

    public static boolean carrega(String key, String arquivoWAV){
      if(!mapaSons.containsKey(arquivoWAV)){
          File file = new File(arquivoWAV);
          if(!file.exists()){
            return false;
          }
          mapaSons.put(key, new SoundEffect(arquivoWAV));
      }
      return true;
    }

      public static boolean toca(String arquivoWAV){
          if(mapaSons.containsKey(arquivoWAV)){
              mapaSons.get(arquivoWAV).play();
              return true;
          } else {
              return false;
          }
      }

      public static boolean loop(String arquivoWAV){
          if(mapaSons.containsKey(arquivoWAV)){
              mapaSons.get(arquivoWAV).playLoop();
              return true;
          }else {
              return false;
          }
      }

      public static boolean para(String arquivoWAV){
          if(mapaSons.containsKey(arquivoWAV)){
              mapaSons.get(arquivoWAV).stop();
              return true;
          } else {
              return false;
          }
      }

}
