# GsonCompat
    Gson兼容PHP空对象引发的json语法错误：


### 兼容前
| Json | Response<Object> | Response<List> | Response<Map>
| - | :-: | :-: | :-: |
| {"code":0,"msg":"成功","data":""} | null / 异常 | null / 异常 | null / 异常 |
| {"code":0,"msg":"成功","data":{}} | √ / √ | null / 异常 | √ / √ |
| {"code":0,"msg":"成功","data":[]} | null / 异常 | √ / √ | null / 异常 |



### 兼容后
| Json | Response\<Object> | Response\<List> | Response\<Map> |
| - | :-: | :-: | :-: |
| {"code":0,"msg":"成功","data":""} | √ / null | √ / null | √ / null |
| {"code":0,"msg":"成功","data":{}} | √ / √ | √ / null | √ / √ |
| {"code":0,"msg":"成功","data":[]} | √ / null | √ / √ | √ / null |

