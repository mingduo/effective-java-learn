package effectivejava;

import lombok.Data;

/**
 * 
 * @description:
 * @since 2019/7/30
 * @author : weizc 
 */
public class UseCloneDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Axe oriAxe =new UseCloneDemo().new Axe();
        oriAxe.setName("fw");

        Axe cloneAxe = (Axe) oriAxe.clone();
        System.out.println(cloneAxe);

        System.out.println("cloneAxe==oriAxe : "+(cloneAxe==oriAxe));

        System.out.println(cloneAxe.getName()==oriAxe.getName());



    }

    @Data
    class Axe extends Object implements Cloneable{
        //final Long id=1L;
        private String name;

        @Override
        public Object clone() throws CloneNotSupportedException {
            Axe clone = (Axe) super.clone();
            return clone;
        }
    }


}
