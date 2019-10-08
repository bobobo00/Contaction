package TestK_V;

/**
 * @ClassName Contaction
 * @Description TODO
 * @Auther danni
 * @Date 2019/10/8 19:31]
 * @Version 1.0
 **/

public class Contaction {
    public static class information{
        String name;
        String telephone;
        information left;
        information right;

        public information(String name,String telephone){
            this.name=name;
            this.telephone=telephone;
        }
    }
    private static information contact=null;

    public String search(String name){
        if(contact==null){
            throw  new  RuntimeException("通讯录为空");
        }
        information cur=contact;
        while(cur!=null){
            int r=name.compareTo(cur.name);
            if(r==0){
                return cur.telephone;
            }else if(r<0){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
        throw  new  RuntimeException("不存在该联系人");
    }
    public boolean update(String name,String telephnoe){
        if(contact==null){
            throw  new  RuntimeException("通讯录为空");
        }
        information cur=contact;
        while(cur!=null){
            int r=name.compareTo(cur.name);
            if(r==0){
                cur.telephone=telephnoe;
                return true;
            }else if(r<0){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
        return false;
    }

}
