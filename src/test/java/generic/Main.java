package generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import generic.entity.AObject;

public class Main {
    public static void main(String[] args) {
        WordLoader loader = new WordLoader();
        loader.load("{\"errorno\":1,\"errormsg\":\"\\u6210\\u529f\",\"data\":[\"\",{}]}");
//        loader.load("{\"errorno\":1,\"errormsg\":\"\\u6210\\u529f\",\"data\":\"\"}");
//        Gson gson = new Gson(true);
//        AssociateResponse associateResponse = gson.fromJson("{\"errorno\":1,\"errormsg\":\"\\u6210\\u529f\",\"data\":[\"\",{}]}", AssociateResponse.class);
//        System.out.println(associateResponse);
    }

    private static void test1() {
        AObject<String> aObject = new AObject<String>(){};
//        Type type = aObject.getClass().getGenericSuperclass();
        Type actualType = ((ParameterizedType) aObject.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        boolean equals = String.class.equals(actualType);
        System.out.println(actualType);
        System.out.println(equals);
    }
}
