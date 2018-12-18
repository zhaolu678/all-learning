


GET 方式请求 /api/goods/ 返回商品列表       http://localhost:8080/api/goods
GET 方式请求 /api/goods/1返回id为1的商品    http://localhost:8080/api/goods/1
POST 方式请求 /api/goods/ 通过Goods对象的JSON 参数创建新的Goods对象   http://localhost:8080/api/goods
                    请求：
                        {
                       	"name":"山苹果111",
                       	"price":"323.2",
                       	"picture":"sdf.jpg"
                       }
PUT 方式请求 /api/goods/3 更新id为3的发送json格式的Goods对象    http://localhost:8080/api/goods/1
                    请求：
                        {
                        "id","222",
                        "name":"山苹果111",
                        "price":"323.2",
                        "picture":"sdf.jpg"
                       }
DELETE 方式请求/api/goods/4删除 ID为 4的Goods对象  http://localhost:8080/api/goods/12
DELETE 方式请求/api/goods/删除所有Goods  http://localhost:8080/api/goods/



