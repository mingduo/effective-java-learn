package effectivejava;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 * 
 * @description:缓存的内存泄漏
 * @since 2019/7/29
 * @author : weizc 
 */

public class WeakHashMapDemo {


    public static void main(String[] args) {


        WeakHashMap<String, Object> cache = new WeakHashMap<>();
        cache.put("abc",new User("老王"));

        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<User> userReference = new WeakReference<>(new User("老王"),referenceQueue);

        for(int i=0;;i++){
            User value = userReference.get();
            if(value!=null){
                System.out.printf("对象还存活着  第%d循环 - %s \n",i, userReference);
            }else{
                System.out.println("对象 已经被回收了");
                break;
            }

        }



    }
    @AllArgsConstructor
    @Data
    private static class User {

        private String name;
    }
}
