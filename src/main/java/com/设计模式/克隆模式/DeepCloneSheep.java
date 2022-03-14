package com.设计模式.克隆模式;

import lombok.Data;

import java.io.*;

/**
 * @Author: xs
 * @describe: 深拷贝克隆羊
 * @date 2022/3/11 17:18
 */
@Data
public class DeepCloneSheep implements Cloneable, Serializable {
    String name;
    int age;
    DeepCloneSheep friend;

    public DeepCloneSheep(String name, int age) {
        this.name = name;
        this.age = age;
    }
    /**
     * @Author: xs
     * @Date: 2022/3/11 22:30
     * @describe: clone模式
     */
    @Override
    public DeepCloneSheep clone() throws CloneNotSupportedException {
        DeepCloneSheep clone = (DeepCloneSheep) super.clone();
        if (clone.getFriend() != null) {
            clone.setFriend(clone.getFriend().clone());
        }
        return clone;
    }
    /**
     * @Author: xs
     * @Date: 2022/3/11 22:30
     * @describe: 序列化方式
     */
    public DeepCloneSheep SerializableClone() {
        //字节输出流
        ByteArrayOutputStream bos = null;
        //对象输入流
        ObjectOutputStream oos = null;
        //对象输入流
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;    //对象输入流
        try {
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            DeepCloneSheep clone = (DeepCloneSheep) ois.readObject();
            return clone;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
