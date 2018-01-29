# GsonCompat
Gson兼容PHP空对象引发的json语法错误：




兼容前

"Response Json"                             "Response<Object>"             Response<List>              Response<Map>

{"errorno":0,"errormsg":"成功","data":""}  null / 异常                  null / 异常                  null / 异常

{"errorno":0,"errormsg":"成功","data":{}}     √ / √                    null / 异常                     √ / √

{"errorno":0,"errormsg":"成功","data":[]}  null / 异常                  √ / √                       null / 异常

兼容后

Response Json                             Response<Object>            Response<List>             Response<Map>

{"errorno":0,"errormsg":"成功","data":""}  √ / null                    √ / null                   √ / null

{"errorno":0,"errormsg":"成功","data":{}}  √ / √                       √ / null                   √ / √

{"errorno":0,"errormsg":"成功","data":[]}  √ / null                    √ / √                      √ / null

