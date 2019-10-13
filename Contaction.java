package TestMap;
import java.util.*;

/**
 * @ClassName Contaction
 * @Description TODO
 * @Auther danni
 * @Date 2019/10/8 19:31]
 * @Version 1.0
 **/

public class Contaction<K extends Comparable<K>,V> {
    public static class Infor<K,V> {
        K name;
        List<V> tele=new ArrayList<>();
        Infor left;
        Infor right;


        public Infor(K name, V tele){
            this.name=name;
            this.tele.add(tele);
        }
    }
    private static Infor contact=null;

    public List<V> search(K name){
        if(contact==null){
            return null;
        }
        Infor cur=contact;
        while(cur!=null){
            int r=name.compareTo((K)cur.name);
            if(r==0){
                return (List<V>)cur.tele;
            }else if(r<0){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
      return null;
    }
    public boolean update(K name,V telephnoe){
        if(contact==null){
            return false;
        }
        Infor cur=contact;
        while(cur!=null){
            int r=name.compareTo((K)cur.name);
            if(r==0){
                for(Object str:cur.tele){
                    if(str.equals(telephnoe)){
                        System.err.println("联系方式已存在");
                        return false;
                    }
                }
                cur.tele.add(telephnoe);
                return true;
            }else if(r<0){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
        return false;
    }
    public boolean put(K name,V telephone){
        List<V> list=this.search((name));
        if(list==null){
            Infor<String,String> cur=new Infor<>((String)name,(String)telephone);
            Insert(cur);
            return true;
        }else{
            for(Object str:list){
                if(str.equals(telephone)){
                System.err.println("该联系方式已存在");
                 return false;
                }
            }
            update(name,telephone);
        }
        return  true;
    }

    public boolean Insert(Infor<String,String> infor) {
        if(contact==null){
            contact=infor;
            return true;
        }
        Infor cur=contact;
        Infor parent=null;
        while(cur!=null){
            int r=infor.name.compareTo((String)cur.name);
            if(r<0){
                parent=cur;
                cur=cur.left;
            }else{
                parent=cur;
                cur=cur.right;
            }
        }
        int r=infor.name.compareTo((String)parent.name);
        if(r>0){
            parent.right=infor;
        }else {
            parent.left=infor;
        }
        return true;
    }

    public static void main(String[] args) {
        Contaction<String,String> contaction=new Contaction();
        contaction.put("aaa","1234");
        contaction.put("bbb","12345");
        contaction.put("aaa","5678");
        System.out.print(contaction.search("aaa"));
    }

}
