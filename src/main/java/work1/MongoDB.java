package work1;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import helper.DateHelper;
import org.bson.Document;

import java.util.List;

/**
 * @Title MongoDB
 * @Author Administrator
 * @Description TODO
 * @Date 2024/9/11 15:31
 * @Version 1.0
 **/
public class MongoDB {
    public static void main(String[] args) {
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
        //listCollectionNames(database);
        //查询数据
        //find(collection);
        //新增数据
        //insertOne(collection);
        //更新数据
        //updateMany(collection);
        createAlpha();
        DateHelper.getNow();
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
    private static void insertMany(MongoCollection<Document> collection, List <Document> list){

        Document document = new Document("title", "002")
                .append("description", "database")
                .append("likes", 164)
                .append("url", "https://www.runoob.com/mongodb/mongodb")
                .append("by", "jiangshuai");

        // 将文档插入到集合中
        collection.insertMany(list);
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
        collection.deleteMany(Filters.eq("title", "MongoDB"));
        System.out.println("Document delete successfully...");
    }
}
