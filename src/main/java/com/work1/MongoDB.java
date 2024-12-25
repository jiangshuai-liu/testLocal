package com.work1;

import com.common.util.StringUtils;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @Title MongoDB
 * @Author Administrator
 * @Description
 * @Date 2024/9/11 15:31
 * @Version 1.0
 **/
public class MongoDB {
    private static int useMinNum=33;
    private static int maxNum=127;
    private static int minNum=33;
    public static void main(String[] args) throws InterruptedException {
        // 创建 MongoDB 连接
        MongoClient mongo = new MongoClient("localhost", 27017);
        // 连接到 MongoDB
        MongoCredential credential = MongoCredential.createCredential("jiangshuai", "mydb", "password".toCharArray());
        System.out.println("Credentials ::" + credential);

        // 访问数据库
        MongoDatabase database = mongo.getDatabase("mydb");
        System.out.println("Connect to database successfully!");
        System.out.println("MongoDatabase info is : " + database.getName());

        // 检索集合
        MongoCollection<Document> collection = database.getCollection("myInfo");
        System.out.println("chose collection : " + collection.getNamespace());

        //获得全部集合
       // listCollectionNames(database);
        //查询数据
        //find(collection);
        //新增数据
        //insertOne(collection);
        //新增多个数据
        //insertMany(collection,1);
        //更新数据
        //updateMany(collection);
        //随机查询
        //selectUseRandomCode(collection);
        //随机查询p
        //selectUseRandomCodePro(collection);
        //删除多个数据
        //deleteMany(collection);
        String sss="2023-09";
        System.out.println(sss.compareTo("2023-09"));

    }


    /**
     * 随机码查询
     * @param collection
     */
    private static void selectUseRandomCode (MongoCollection<Document> collection){
        int i=0;
        while (true){
            i++;
            String str =  Common.getRandomCode(3);
            Document document = new Document("description",str);
            boolean bool=find(collection,document);
            if(i%100000==0){
                System.out.println(i);
            }
            if(bool){
                break;
            }
        }
    }
    /**
     * 随机码查询
     * @param collection
     */
    private static void selectUseRandomCodePro (MongoCollection<Document> collection){
        String getStr="";
        while (true){
            String getChar=getStr(getStr);
            System.out.println(getChar);
            if(getStr.equals(getChar)){
                System.out.println("含有非法字符");
                break;
            }
            getChar=changeMean(getChar);
            Pattern phones =Pattern.compile("^"+getChar+".*$", Pattern.CASE_INSENSITIVE);
            Document document = new Document("description",phones);
            boolean bool=find(collection,document);
            if(bool){
                getStr=getChar;
                //重置最小值
                useMinNum=minNum;
                document = new Document("description",getStr);
                boolean lastCode=find(collection,document);
                if(lastCode){
                    System.out.println("最终随机码："+getStr);
                    break;
                }
            }
        }
    }
    /**
     * 创建集合
     * @param database 数据库链接
     * @param collectionName 创建集合名称
     */
    private static void createCollection (MongoDatabase database,String collectionName){
        // 创建集合
        database.createCollection(collectionName);
        System.out.println("create collection successfully!");
    }

    /**
     * 获得集合名称
     * @param database
     */
    private static void listCollectionNames(MongoDatabase database){
        System.out.println(database.getName()+"内含有集合名称：");
        System.out.println("||----------------------------------------------------------------||");
        for (String name : database.listCollectionNames()) {
            System.out.println("|| "+name);
        }
        System.out.println("||----------------------------------------------------------------||");
    }
    /**
     * 数据新增
     * @param collection
     */
    private static void insertOne(MongoCollection<Document> collection){
        Document document = new Document("title", "002")
                .append("description", "database")
                .append("likes", 164)
                .append("url", "https://www.runoob.com/mongodb/mongodb")
                .append("by", "jiangshuai");

        // 将文档插入到集合中
        collection.insertOne(document);
        System.out.println("Document insert successfully!");
    }
    /**
     * 数据新增(多个数据 insertMany)
     * @param collection
     */
    private static void insertMany(MongoCollection<Document> collection, int length){
        write(collection,length);
        System.out.println("Document insert successfully!");
    }

    /**
     * 查询数据
     * @param collection
     */
    private static void find(MongoCollection<Document> collection){
        // 获取 iterable 对象
        FindIterable<Document> iterDoc = collection.find();
        // 获取迭代器
        for (Document document : iterDoc) {
            System.out.println(document);
        }
    }
    /**
     * 查询数据
     * @param collection
     */
    private static Boolean find(MongoCollection<Document> collection,Document document){
        // 获取 iterable 对象
        FindIterable<Document> iterDoc = collection.find(document);
        // 获取迭代器
        for (Document getDocument : iterDoc) {
            System.out.println(getDocument);
            return true;
        }
        return false;
    }
    /**
     * 数据更新（多条更新 updateMany）
     * @param collection
     */
    private static void updateMany(MongoCollection<Document> collection){
        collection.updateMany(Filters.eq("title", "MongoDB"), Updates.set("likes", 150));
        System.out.println("Document update successfully...");
    }

    /**
     * 数据更新（更新单个 updateOne）
     * @param collection
     */
    private static void updateOne(MongoCollection<Document> collection){
        collection.updateOne(Filters.eq("title", "MongoDB"), Updates.set("likes", 150));
        System.out.println("Document update successfully...");
    }

    /**
     * 删除数据（删除单个 deleteOne）
     * @param collection
     */
    private static void deleteOne(MongoCollection<Document> collection){
        collection.deleteOne(Filters.eq("title", "MongoDB"));
        System.out.println("Document delete successfully...");
    }

    /**
     * 删除数据（删除多个 deleteMany）
     * @param collection
     */
    private static void deleteMany(MongoCollection<Document> collection){
        collection.deleteMany(Filters.eq("by", "jiangshuai"));
        System.out.println("Document delete successfully...");
    }

    public static void write(MongoCollection<Document> collection, int length) {
        ArrayList writes = new ArrayList();
        for(int num=0;num<length;num++) {
            Document document = new Document("title", num)
                    .append("description", Common.getRandomCode(3))
                    .append("likes", Common.getRandomCode(8))
                    .append("url", "https://www.runoob.com/mongodb/mongodb")
                    .append("by", "jiangshuai");
            writes.add(document);
        }
        collection.insertMany(writes);
    }

    public static Map<String, Object> objectToMap(Object obj) {
        HashMap map = new HashMap();
        try {
            Class<?> clazz = obj.getClass();
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(obj));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }


    /**
     * 获取字符
     * @param inStr
     * @return String
     */
    private static String getStr(String inStr){
        if(useMinNum<maxNum){
            useMinNum++;
            return inStr + (char) (useMinNum - 1);
        }else{
            return inStr;
        }
    }

    /**
     * 转义特殊符号
     * @param str
     * @return
     */
    public static String changeMean(String str) {
        if(StringUtils.isEmpty(str)){
            return "";
        }else{
            String[] fbsArr = { "\\", "$", "(", ")", "*", "+", ".", "[", "]", "?", "^", "{", "}", "|" };
            for (String key : fbsArr) {
                if (str.contains(key)) {
                    str = str.replace(key, "\\" + key);
                }
            }
            return str;
        }
    }

}
