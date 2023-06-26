# FakeStore

Spring Boot 3 Application - CRUD, API externa, Swagger, MariaDB - based on fakestoreapi

## Get All Products: /products/

```bash
curl -X 'GET' \
  'http://localhost:8080/products/' \
  -H 'accept: */*'
```

```json
[
  {
    "id": null,
    "entity_id": "02f254a0-7474-4373-aa66-19fecc84ac1e",
    "title": "Lock and Love Women's Removable Hooded Faux Leather Moto Biker Jacket",
    "price": 29.95,
    "category": "women's clothing",
    "description": "100% POLYURETHANE(shell) 100% POLYESTER(lining) 75% POLYESTER 25% COTTON (SWEATER), Faux leather material for style and comfort / 2 pockets of front, 2-For-One Hooded denim style faux leather jacket, Button detail on waist / Detail stitching at sides, HAND WASH ONLY / DO NOT BLEACH / LINE DRY / DO NOT IRON",
    "image": "https://fakestoreapi.com/img/81XH0e8fefL._AC_UY879_.jpg"
  },
  {
    "id": null,
    "entity_id": "08c59fce-7f50-455a-a7c7-9bb4adcb6ecf",
    "title": "Mens Cotton Jacket",
    "price": 55.99,
    "category": "men's clothing",
    "description": "great outerwear jackets for Spring/Autumn/Winter, suitable for many occasions, such as working, hiking, camping, mountain/rock climbing, cycling, traveling or other outdoors. Good gift choice for you or your family member. A warm hearted love to Father, husband or son in this thanksgiving or Christmas Day.",
    "image": "https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_.jpg"
  },
  {
    "id": null,
    "entity_id": "10eed4dc-bd53-4bab-8377-1916a252e703",
    "title": "Samsung 49-Inch CHG90 144Hz Curved Gaming Monitor (LC49HG90DMNXZA) – Super Ultrawide Screen QLED ",
    "price": 999.99,
    "category": "electronics",
    "description": "49 INCH SUPER ULTRAWIDE 32:9 CURVED GAMING MONITOR with dual 27 inch screen side by side QUANTUM DOT (QLED) TECHNOLOGY, HDR support and factory calibration provides stunningly realistic and accurate color and contrast 144HZ HIGH REFRESH RATE and 1ms ultra fast response time work to eliminate motion blur, ghosting, and reduce input lag",
    "image": "https://fakestoreapi.com/img/81Zt42ioCgL._AC_SX679_.jpg"
  }
]
```

## Update products: /products/

```bash
curl -X 'PUT' \
  'http://localhost:8080/products/?id=02f254a0-7474-4373-aa66-19fecc84ac1e' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "price": 108.3
}'
```

```json
{
  "id": null,
  "entity_id": "02f254a0-7474-4373-aa66-19fecc84ac1e",
  "title": "Lock and Love Women's Removable Hooded Faux Leather Moto Biker Jacket",
  "price": 108.3,
  "category": "women's clothing",
  "description": "women's clothing",
  "image": "https://fakestoreapi.com/img/81XH0e8fefL._AC_UY879_.jpg"
}
```

## Get product by title: /products/{title}

```bash
curl -X 'GET' \
  'http://localhost:8080/products/Lock%20and%20Love%20Women%27s%20Removable%20Hooded%20Faux%20Leather%20Moto%20Biker%20Jacket' \
  -H 'accept: */*'
```

```json
{
  "id": null,
  "entity_id": "02f254a0-7474-4373-aa66-19fecc84ac1e",
  "title": "Lock and Love Women's Removable Hooded Faux Leather Moto Biker Jacket",
  "price": 29.95,
  "category": "women's clothing",
  "description": "100% POLYURETHANE(shell) 100% POLYESTER(lining) 75% POLYESTER 25% COTTON (SWEATER), Faux leather material for style and comfort / 2 pockets of front, 2-For-One Hooded denim style faux leather jacket, Button detail on waist / Detail stitching at sides, HAND WASH ONLY / DO NOT BLEACH / LINE DRY / DO NOT IRON",
  "image": "https://fakestoreapi.com/img/81XH0e8fefL._AC_UY879_.jpg"
}
```


## Create a product: /products/

```bash
curl -X 'POST' \
  'http://localhost:8080/products/' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "title": "New Product",
  "price": 9.99,
  "category": "miscellaneous",
  "description": "This is a new product.",
  "image": "https://example.com/new-product.jpg"
}'
```

```json
{
  "id": "generated-id",
  "entity_id": null,
  "title": "New Product",
  "price": 9.99,
  "category": "miscellaneous",
  "description": "This is a new product.",
  "image": "https://example.com/new-product.jpg"
}
```

## Delete Product: /products/{id}

```bash
curl -X 'DELETE' \
  'http://localhost:8080/products/{id}' \
  -H 'accept: */*'
```

## Update product: /products/{id}

```bash
curl -X 'PUT' \
  'http://localhost:8080/products/{id}' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "title": "Updated Product",
  "price": 19.99,
  "category": "miscellaneous",
  "description": "This is an updated product.",
  "image": "https://example.com/updated-product.jpg"
}'
```
