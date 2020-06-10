package com.qmui.quick.helper;

import com.qmui.quick.QuickApplication;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class QuickFileHelper {

    public static void write(Object obj, String fileName) {
        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            ObjectOutputStream oout = new ObjectOutputStream(bout);
            oout.writeObject(obj);
            oout.flush();
            oout.close();
            bout.close();
            byte[] b = bout.toByteArray();
            File file = new File(QuickApplication.getContext().getFilesDir(), fileName);
            FileOutputStream out = new FileOutputStream(file);
            out.write(b);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object read(String fileName) {
        // 拿出持久化数据
        Object obj = null;
        try {
            File file = new File(QuickApplication.getContext().getFilesDir(), fileName);
            if (file.exists()) {
                FileInputStream in = new FileInputStream(file);
                ObjectInputStream oin = new ObjectInputStream(in);
                obj = oin.readObject();
                in.close();
                oin.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
