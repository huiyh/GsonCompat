package generic;


import generic.entity.ApiResponse;


/**
 * Created by huiyh on 2017/10/26.
 */

public class AssociateWordLoader extends GenericGsonConverter<ApiResponse<Object>> {

    public static void main(String[] args) {
        AssociateWordLoader loader = new AssociateWordLoader();
        loader.load("{\"errorno\":1,\"errormsg\":\"\\u6210\\u529f\",\"data\":{\"no\":2}}");
//        loader.load("{\"errorno\":1,\"errormsg\":\"\\u6210\\u529f\",\"data\":\"\"}");
    }
    /**
     * 常用语
     *
     * @param inputWords
     */
    public void load(String inputWords ) {
        ApiResponse<Object> apiResponse = convertAsGenericType(inputWords);
        System.out.println("parse result data is empty: " + (apiResponse.getData() == null));
    }
}