package java.com.设计模式.克隆模式;

import com.设计模式.克隆模式.DeepCloneSheep;
import com.设计模式.克隆模式.Sheep;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/11 16:11
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        //浅拷贝
        Sheep sheep = new Sheep("浅拷贝羊", 111);
        sheep.setFriend(new Sheep("浅拷贝羊朋友", 111));
        Sheep clone = sheep.clone();
        sheep.getFriend().setName("0");
        System.out.println(sheep.hashCode() + "==>" + sheep.getFriend().hashCode() + sheep.getFriend().toString());
        System.out.println(clone.hashCode() + "==>" + clone.getFriend().hashCode() + clone.getFriend().toString());
        /**
         * 引用被改变，说明只是拷贝的地址
         * -867064451=208254Sheep(name=0, age=0, friend=null)
         * -867064451=208254Sheep(name=0, age=0, friend=null)
         */
        //克隆模式1
        DeepCloneSheep deepCloneSheep = new DeepCloneSheep("深拷贝羊", 111);
        deepCloneSheep.setFriend(new DeepCloneSheep("深拷贝羊羊", 222));
        DeepCloneSheep clone1 = deepCloneSheep.clone();
        deepCloneSheep.getFriend().setAge(0);
        clone1.getFriend().setName("0");
        System.out.println(deepCloneSheep.getFriend().hashCode() + "==>" + deepCloneSheep.getFriend());
        System.out.println(clone1.getFriend().hashCode() + "==>" + clone1.getFriend());
        /**
         * -349906661=DeepCloneSheep(name=深拷贝羊羊, age=0, friend=null)
         * 981036=DeepCloneSheep(name=0, age=222, friend=null)
         */
        //克隆模式2
        DeepCloneSheep serializable = new DeepCloneSheep("深拷贝羊方式2", 111);
        serializable.setFriend(new DeepCloneSheep("深拷贝羊羊方式2", 222));
        DeepCloneSheep serializableClone = serializable.clone();
        serializable.getFriend().setAge(0);
        serializableClone.getFriend().setName("0");
        System.out.println(serializable.getFriend().hashCode() + "==>" + serializable.getFriend());
        System.out.println(serializableClone.getFriend().hashCode() + "==>" + serializableClone.getFriend());
        /**
         * -487254219==>DeepCloneSheep(name=深拷贝羊羊方式2, age=0, friend=null)
         * 981036==>DeepCloneSheep(name=0, age=222, friend=null)
         */
    }
}
