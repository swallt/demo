package com.zhousx.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

class CardInfo {
    String prefix;
    String cardNum;
    String bankId;
    String bankName;
    String token;
    String cardType;

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
}

public class FastJsonTest {


 /*   public static List<String> jsonPattern2(String jsonStr, String key, String value, boolean type) {

        String[] pats = key.split(":");//得到key对应的数组
        // String[] keys = pats[0].split(",");
        int jsonObjectPos = 0;
        int jsonArrayPos = 0;
        JSONArray ja = new JSONArray();
        a:
        for (int z = 0; z < pats.length; z++)
        {
            Object j = null;
            try {
                j = new JSONTokener(JSONObject.parseObject(jsonStr).get(pats[z]).toString()).nextValue();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (j instanceof JSONArray)
            {
                ja = getJsonArray(jsonStr, pats[z]); //得到对应的jsonArray
                jsonObjectPos = z;
                jsonArrayPos++;
                break a;
            } else
            {
                jsonStr = j.toString();
            }
        }
        //得到jsonArray的大小，后面遍历使用
        int len = ja.size();
        // 返回list
        List<String> list = new ArrayList<>();
        //得到取哪些key值得value，最低一层
        String[] pat_detail = value.split(",");
        //取Jsonarray中对应的值
        if (type)
        {
            //对jsonArray遍历
            for (int i = 0; i < len; i++)
            {
                //拼接得到的值
                StringBuffer buffer = new StringBuffer();
                buffer.append("{");
                //对每个JsonArray中想取的值进行遍历取值
                for (int y = 0; y < pat_detail.length; y++)
                {
                    buffer.append("\"" + pat_detail[y] + "\":\"" +
                            (JSONObject.fromObject(ja.get(i)).getString(pat_detail[y]) + "\","));
                }
                String s = buffer.toString();
                StringBuffer re2 = new StringBuffer();
                s = s.substring(0, s.length() - 1);
                re2.append(s);
                re2.append("}");
                list.add(re2.toString());
            }
        }
        //取JsonObject中对应的值
        else {
            Object json = "";
            //遍历对应的JsonArray
            for (int i = 0; i < len; i++)
            {
                //判断 取到JsonArray后 key是否是最后一个，如果不是则继续取出最后一个key所对应的值
                if (jsonObjectPos != pats.length - 1)
                {
                    for (int yy = jsonArrayPos; yy <= pats.length - jsonArrayPos; yy++)
                    {
                        json = new JSONTokener(ja.getJSONObject(i).get(pats[yy]).toString()).nextValue();
                    }
                } else {
                    json = new JSONTokener(ja.getJSONObject(i).get(pats[jsonObjectPos]).toString()).nextValue();
                }
                //  Object json = new JSONTokener(ja.getJSONObject(i).get(pats[jsonObjectPos]).toString()).nextValue();
                //如果是jsonObject 则取出对应的参数
                if (json instanceof JSONObject)
                {
                    StringBuffer result = new StringBuffer();
                    result.append("{");
                    for (int y = 0; y < pat_detail.length; y++)
                    {
                        if (!(JSONObject.fromObject(json).get(pat_detail[y]) instanceof JSONObject))
                        {
                            result.append("\"" + pat_detail[y] + "\":\"" + ((JSONObject) json).get(pat_detail[y]) + "\",");
                        } else
                        {
                            json = JSONObject.fromObject(json).get(pat_detail[y]);
                        }
                    }
                    String s = result.toString();
                    StringBuffer re2 = new StringBuffer();
                    s = s.substring(0, s.length() - 1);
                    re2.append(s);
                    re2.append("}");
                    list.add(re2.toString());
                } else if (json instanceof JSONArray)
                {
                    //System.out.println("JSONArray");
                }
            }
        }
        return list;
    }*/

    public static void main(String[] args) {
        String input = "{\"cardList\":[" +
            /*    "{\"prefix\":\"141000001\",\"cardNum\":\"622100123456789\"," +
                "\"bankId\":\"001\",\"bankName\":\"ICBC\",\"cardType\":\"011\",\"token\":\"\"}," +*/
                1 + "," +
                "{\"prefix\":\"141000002\",\"cardNum\":\"622100987654321\"," +
                "\"bankId\":\"002\",\"bankName\":\"CCB\",\"cardType\":\"001\",\"token\":\"\"}" +
                "]}";
        JSONObject jsonObject = JSON.parseObject(input);
        Object jsonArray = jsonObject.get("cardList");
        if (jsonArray instanceof JSONArray){
            for (int i = 0; i < ((JSONArray) jsonArray).size(); i++){
                try {
                    List<CardInfo> list = JSON.parseArray("["+((JSONArray) jsonArray).get(i) + "]", CardInfo.class);
                    for (CardInfo cardInfo : list) {
                        System.out.println(cardInfo.prefix);
                        System.out.println(cardInfo.cardNum);
                        //...
                    }
                } catch (Exception e){
                    continue;
                }
            }
        }


 /*       String jsonstr = "{" +
                "\"jsonrpc\": \"2.0\"," +
                "\"method\": \"call\"," +
                "\"params\": [0, \"vertify_transaction\", [{" +
                "\"ref_block_num\": 59543," +
                "\"ref_block_prefix\": 1864245504," +
                "\"expiration\": \"2018-11-06T03:07:10\"," +
                "\"operations\": [" +
                "[35, {" +
                "\"fee\": {" +
                "\"amount\": \"102402\"," +
                "\"asset_id\": \"1.3.0\"" +
                "}," +
                "\"payer\": \"1.2.31\"," +
                "\"required_auths\": []," +
                "\"id\": 9999," +
                "\"data\": \"7b226368616e6e656c54797065223a342c226163636f756e745f6e6f223a223078313233313233222c226163636f756e744e616d65223a22222c22616d6f756e74223a302e3030312c22636f696e5f74797065223a22425443222c22757365724964223a226e617468616e227d3\"" +
                "}]" +
                "]," +
                "\"extensions\": []," +
                "\"signatures\": [\"1f03d9ebefe9988aab1867e7931106c5f920768b16c8c7bac1b00a55ffd33dabfe08b82cbb19a252fded01ad009a50b8612b1e347af17b01eee190beaa5bf072aa\"]" +
                "}]]," +
                "\"id\": 1" +
                "}";
        try {
            Object j = new JSONTokener(JSONObject.parseObject(jsonstr).get("params").toString()).nextValue();
            if (j instanceof org.json.JSONArray){
                org.json.JSONArray ja = (org.json.JSONArray) j;
                for (int i =0; i < ja.length(); i++){
                    if (ja.get(i) instanceof org.json.JSONArray){
                        org.json.JSONArray ja1 = (org.json.JSONArray) ja.get(i);
                        for (int x =0; x < ja1.length(); x++){
                            if (ja1.get(x) instanceof org.json.JSONObject){
                                org.json.JSONObject jo = (org.json.JSONObject) ja1.get(x);
                                    if (jo.get("operations") instanceof org.json.JSONArray){
                                        org.json.JSONArray ja2 = (org.json.JSONArray) jo.get("operations");
                                        for (int y = 0; y < ja2.length(); y++){
                                            if (ja2.get(y) instanceof org.json.JSONArray){
                                                org.json.JSONArray ja3 = (org.json.JSONArray) ja2.get(y);
                                                for (int z = 0; z < ja3.length(); z++){
                                                    if (ja3.get(z) instanceof org.json.JSONObject){
                                                        String data = ((org.json.JSONObject) ja3.get(z)).get("data").toString();
                                                        System.out.println("data = " + data);
                                                    }
                                                }
                                            }
                                        }
                                    }
                            }
                        }
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }*/

    }
}
