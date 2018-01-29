# GsonCompat
    Gson兼容PHP空对象引发的json语法错误：


    | Name | Academy | score |
    | - | :-: | -: |
    | Harry Potter | Gryffindor| 90 |
    | Hermione Granger | Gryffindor | 100 |
    | Draco Malfoy | Slytherin | 90 |


## 兼容前

| Json | Response<Object> | Response<List> | Response<Map>

| {"errorno":0,"errormsg":"成功","data":""} | null / 异常 | null / 异常 | null / 异常

| {"errorno":0,"errormsg":"成功","data":{}} | √ / √ | null / 异常 | √ / √

| {"errorno":0,"errormsg":"成功","data":[]} | null / 异常 | √ / √ | null / 异常

## 兼容后

| Json | Response<Object> | Response<List> | Response<Map>

| {"errorno":0,"errormsg":"成功","data":""} | √ / null | √ / null | √ / null

| {"errorno":0,"errormsg":"成功","data":{}} | √ / √ | √ / null | √ / √

| {"errorno":0,"errormsg":"成功","data":[]} | √ / null | √ / √ | √ / null

