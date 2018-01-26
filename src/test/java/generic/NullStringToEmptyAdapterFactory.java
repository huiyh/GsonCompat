package generic;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

//
//作者：hloong
//        链接：http://www.jianshu.com/p/c6dd9a6b10ee
//        來源：简书
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
public class NullStringToEmptyAdapterFactory<T> implements TypeAdapterFactory {

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        Class<T> rawType = (Class<T>) type.getRawType();
        if (rawType != String.class) {
            return null;
        }
        return (TypeAdapter<T>) new StringNullAdapter();
    }
}