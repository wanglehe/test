//package com.army.dataHub;
//
//import java.util.ArrayList;
//import java.util.List;
//public class DataHubUtil {
//    public static void main(String[] args) {
//        //LTAI5HN4tkVAibxC mBKJYWW722a37Jff6WuaF0iT2z19tk
//        Account account = new AliyunAccount("LTAI5HN4tkVAibxC", "mBKJYWW722a37Jff6WuaF0iT2z19tk");
//        DatahubConfiguration conf = new DatahubConfiguration(account, "http://dh-cn-hangzhou.aliyuncs.com");
//        //https://dh-cn-beijing.aliyuncs.com
//        DatahubClient client = new DatahubClient(conf);
//        // 可通过listShard接口获取shard列表，所有ACTIVE的shard均可使用，本利使用"0"
//        String shardId = "0";
//        // 构造需要上传的records
//        RecordSchema schema = client.getTopic("wx_jss", "location_simulator").getRecordSchema();
//        List<RecordEntry> recordEntries = new ArrayList<RecordEntry>();
//        RecordEntry entry = new RecordEntry(schema);
//        int i = 0;
//        int num1 = entry.getFieldCount();
//        while (i < num1) {
//            entry.setBigint(i,Long.valueOf(1));
//            entry.setString(i,"test");
//            i++;
//        }
//        entry.setShardId(shardId);
//        recordEntries.add(entry);
//        // 数据写入
//        for(int j=0;j<20;j++){
//        PutRecordsResult result = client.putRecords("collection", "collection", recordEntries);
//        if (result.getFailedRecordCount() != 0) {
//            List<ErrorEntry> errors = result.getFailedRecordError();
//            List<RecordEntry> records = result.getFailedRecords();
//            // 存在写入失败的记录，建议日志记录错误原因并重试写入
//        }
//        }
//    }
//}
