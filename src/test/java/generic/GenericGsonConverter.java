package generic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.internal.ConstructorConstructor;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;


/**
 * 如果要得到String, 不建议使用该类
 * Created by huiyh on 2017/10/27.
 */

public class GenericGsonConverter<DATA> {

    protected static final Gson gson;

    static {
        ConstructorConstructor constructorConstructor = new ConstructorConstructor(Collections.emptyMap());
        LongSerializationPolicy longSerializationPolicy = LongSerializationPolicy.DEFAULT;

        GsonBuilder builder = new GsonBuilder();
        builder.setCompat(true);
//        // type adapters for basic platform types
//        builder.registerTypeAdapterFactory(TypeAdapters.STRING_FACTORY);
//        builder.registerTypeAdapterFactory(TypeAdapters.INTEGER_FACTORY);
//        builder.registerTypeAdapterFactory(TypeAdapters.BOOLEAN_FACTORY);
//        builder.registerTypeAdapterFactory(TypeAdapters.BYTE_FACTORY);
//        builder.registerTypeAdapterFactory(TypeAdapters.SHORT_FACTORY);
//        TypeAdapter<Number> longAdapter = longAdapter(longSerializationPolicy);
//        builder.registerTypeAdapterFactory(TypeAdapters.newFactory(long.class, Long.class, longAdapter));
//        builder.registerTypeAdapterFactory(TypeAdapters.newFactory(double.class, Double.class, doubleAdapter(serializeSpecialFloatingPointValues)));
//        builder.registerTypeAdapterFactory(TypeAdapters.newFactory(float.class, Float.class, floatAdapter(serializeSpecialFloatingPointValues)));
//        builder.registerTypeAdapterFactory(TypeAdapters.NUMBER_FACTORY);
//        builder.registerTypeAdapterFactory(TypeAdapters.ATOMIC_INTEGER_FACTORY);
//        builder.registerTypeAdapterFactory(TypeAdapters.ATOMIC_BOOLEAN_FACTORY);
//        builder.registerTypeAdapterFactory(TypeAdapters.newFactory(AtomicLong.class, atomicLongAdapter(longAdapter)));
//        builder.registerTypeAdapterFactory(TypeAdapters.newFactory(AtomicLongArray.class, atomicLongArrayAdapter(longAdapter)));
//        builder.registerTypeAdapterFactory(TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY);
//        builder.registerTypeAdapterFactory(TypeAdapters.CHARACTER_FACTORY);
//        builder.registerTypeAdapterFactory(TypeAdapters.STRING_BUILDER_FACTORY);
//        builder.registerTypeAdapterFactory(TypeAdapters.STRING_BUFFER_FACTORY);
//        builder.registerTypeAdapterFactory(TypeAdapters.newFactory(BigDecimal.class, TypeAdapters.BIG_DECIMAL));
//        builder.registerTypeAdapterFactory(TypeAdapters.newFactory(BigInteger.class, TypeAdapters.BIG_INTEGER));
//        builder.registerTypeAdapterFactory(TypeAdapters.URL_FACTORY);
//        builder.registerTypeAdapterFactory(TypeAdapters.URI_FACTORY);
//        builder.registerTypeAdapterFactory(TypeAdapters.UUID_FACTORY);
//        builder.registerTypeAdapterFactory(TypeAdapters.CURRENCY_FACTORY);
//        builder.registerTypeAdapterFactory(TypeAdapters.LOCALE_FACTORY);
//        builder.registerTypeAdapterFactory(TypeAdapters.INET_ADDRESS_FACTORY);
//        builder.registerTypeAdapterFactory(TypeAdapters.BIT_SET_FACTORY);
//        builder.registerTypeAdapterFactory(DateTypeAdapter.FACTORY);
//        builder.registerTypeAdapterFactory(TypeAdapters.CALENDAR_FACTORY);
//        builder.registerTypeAdapterFactory(TimeTypeAdapter.FACTORY);
//        builder.registerTypeAdapterFactory(SqlDateTypeAdapter.FACTORY);
//        builder.registerTypeAdapterFactory(TypeAdapters.TIMESTAMP_FACTORY);
//        builder.registerTypeAdapterFactory(ArrayTypeAdapter.FACTORY);
//        builder.registerTypeAdapterFactory(TypeAdapters.CLASS_FACTORY);
//
//        // type adapters for composite and user-defined types
//        builder.registerTypeAdapterFactory(new JsonArrayAdapterFactory(constructorConstructor));
////        builder.registerTypeAdapterFactory(new CollectionTypeAdapterFactory(constructorConstructor));
//        builder.registerTypeAdapterFactory(new MapTypeAdapterFactory(constructorConstructor, complexMapKeySerialization));
//        jsonAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(constructorConstructor);
//        builder.registerTypeAdapterFactory(jsonAdapterFactory);
//        builder.registerTypeAdapterFactory(TypeAdapters.ENUM_FACTORY);
//        builder.registerTypeAdapterFactory(new ObjectTypeAdapterFactory(constructorConstructor));
////        builder.registerTypeAdapterFactory(new ReflectiveTypeAdapterFactory());

        gson = builder.create();
    }

    /**
     * 自动读取泛型,使用Gson解析String
     *
     * @param string
     * @return
     */
    public final DATA convertAsGenericType(String string) {
        try {
            Type actualType = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            if (String.class.equals(actualType)){
                return (DATA) string;
            }
            DATA date = gson.fromJson(string, actualType);
            return date;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}