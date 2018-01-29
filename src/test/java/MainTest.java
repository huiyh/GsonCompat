import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import generic.WordLoader;
import generic.entity.AObject;
import generic.entity.ApiResponse;

/**
 * Created by huiyh on 18-1-25.
 */

public class MainTest {

    @Test
    public void test1(){
        String inputWords = "{\"errorno\":1,\"errormsg\":\"\\u6210\\u529f\",\"data\":{\"no\":2}}";

        Type type = new TypeToken<ApiResponse<Object>>() {
        }.getType();

        Gson gson = new Gson(true);
        ApiResponse<Object> apiResponse = gson.fromJson(inputWords, type);
        System.out.println("parse result data is empty: " + (apiResponse.getData() == null));
    }

    @Test
    public void test2(){
        WordLoader loader = new WordLoader();
        loader.load("{\"errorno\":1,\"errormsg\":\"\\u6210\\u529f\",\"data\":[\"\",{}]}");
    }

    @Test
    public void test3(){
        AObject<String> aObject = new AObject<String>(){};
//        Type type = aObject.getClass().getGenericSuperclass();
        Type actualType = ((ParameterizedType) aObject.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        boolean equals = String.class.equals(actualType);
        System.out.println(actualType);
        System.out.println(equals);
    }
}
