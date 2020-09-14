# This is a Voter backend!


There are 2 users: Admin and User. Both passwords are "password".

Admin has full access.
  
User has an access only for GET commands for Meal, Restaurant, Menu and Dish and can cast his vote via /rest/castvote/menu/{menuId} command. If User changes his mind before 11:00 AM, he will be able to cast a new vote. It overwrites the old one. User can vote only for today`s menus.   

## REST

###Login

POST /rest/auth/token

Data Params:

{   
    "name":[String],
    "password:[String] //5..100 symbols
}
    
Success Response:
Code: 200 
Content:

{
    "token": [String],
    "created": [DateTime],
    "expires": [DateTime],
    "type": [String]
}   
    
### Meal

####Create meal

POST /rest/meal
Data Params:
 
{   
     "name":[String]
}
     
Success Response:
Code: 200 
Content:
 
{
     "id": [long],
     "name":[String]
}

#### Get meal by id

GET /rest/meal/{id}
    
Success Response:
Code: 200 
Content:
 
{
     "id": [long],
     "name":[String]
}

#### Update meal by id
  
PUT /rest/meal/{id}
      
Data Params:
 
{   
     "name":[String]
}
     
Success Response:
Code: 200 
Content:
 
{
     "id": [long],
     "name":[String]
}

#### Delete meal by id

DELETE /rest/meal/{id}
    
Code: 200 
 
#### Get all meals
 
GET /rest/meals
    
Success Response:
Code: 200 
Content:
[ 
    {
     "id": [long],
     "name":[String]
    },
    ...
]

### Restaurant

####Create restaurant

POST /rest/restaurant
Data Params:
 
{   
     "name":[String]
}
     
Success Response:
Code: 200 
Content:
 
{
     "id": [long],
     "name":[String]
}

#### Get restaurant by id

GET /rest/restaurant/{id}
    
Success Response:
Code: 200 
Content:
 
{
     "id": [long],
     "name":[String]
}

#### Update restaurant by id
  
PUT /rest/restaurant/{id}
      
Data Params:
 
{   
     "name":[String]
}
     
Success Response:
Code: 200 
Content:
 
{
     "id": [long],
     "name":[String]
}

#### Delete restaurant by id

DELETE /rest/restaurant/{id}
    
Code: 200 
 
#### Get all restaurants
 
GET /rest/restaurants
    
Success Response:
Code: 200 
Content:
[ 
    {
     "id": [long],
     "name":[String]
    },
    ...
]



### Menu

####Create menu

POST /rest/menu
Data Params:
 
{   
     "date":[Date],
     "restaurantId":[Long]
}
     
Success Response:
Code: 200 
Content:
 
{
     "id": [long],
     "date":[Date],
     "restaurantId":[Long]
}

#### Get menu by id

GET /rest/menu/{id}
    
Success Response:
Code: 200 
Content:
 
{
     "id": [long],
     "date":[Date],
     "restaurantId":[Long]
}

#### Update menu by id
  
PUT /rest/menu/{id}
      
Data Params:
 
{   
     "date":[Date],
     "restaurantId":[Long]
}
     
Success Response:
Code: 200 
Content:
 
{
     "id": [long],
     "date":[Date],
     "restaurantId":[Long]
}

#### Delete menu by id

DELETE /rest/menu/{id}
    
Code: 200 
 
#### Get all menus dy date
 
GET /rest/menus/{date}
    
Success Response:
Code: 200 
Content:
[ 
    {
        "id": [long],    
        "date":[Date],
        "restaurantId":[Long]
    },
    ...
]


### Dish

####Create dish

POST /rest/dish
Data Params:
 
{   
    "menuId": [Long],
    "mealId": [Long],
    "price": [BigDecimal]
}
     
Success Response:
Code: 200 
Content:
 
{
    "id": [long],
    "menuId": [Long],
    "mealId": [Long],
    "price": [BigDecimal]
}

#### Get dish by id

GET /rest/dish/{id}
    
Success Response:
Code: 200 
Content:
 
{
    "id": [long],
    "menuId": [Long],
    "mealId": [Long],
    "price": [BigDecimal]
}

#### Update dish by id
  
PUT /rest/dish/{id}
      
Data Params:
 
{   
    "menuId": [Long],
    "mealId": [Long],
    "price": [BigDecimal]
}
     
Success Response:
Code: 200 
Content:
 
{
    "id": [long],
    "menuId": [Long],
    "mealId": [Long],
    "price": [BigDecimal]
}

#### Delete dish by id

DELETE /rest/dish/{id}
    
Code: 200 
 
#### Get all dishes dy menu id
 
GET /rest/dishes/{id}
    
Success Response:
Code: 200 
Content:
[ 
    {
        "id": [long],
        "menuId": [Long],
        "mealId": [Long],
        "price": [BigDecimal]
    },
    ...
]


### User

####Create user

POST /rest/user
Data Params:
 
{   
     "name":[String],
     "password":[Long]
}
     
Success Response:
Code: 200 
Content:
 
{
     "id": [long],
     "name":[String],
     "password":[Long]
}

#### Get user by id

GET /rest/user/{id}
    
Success Response:
Code: 200 
Content:
 
{
     "id": [long],
     "name":[String],
     "password":[Long]
}

#### Update user by id
  
PUT /rest/user/{id}
      
Data Params:
 
{   
     "name":[String],
     "password":[Long]
}
     
Success Response:
Code: 200 
Content:
 
{
     "id": [long],
     "name":[String],
     "password":[Long]
}

#### Delete user by id

DELETE /rest/user/{id}
    
Code: 200 
 
#### Get all users
 
GET /rest/users
    
Success Response:
Code: 200 
Content:
[ 
    {
        "id": [long],    
         "name":[String],
         "password":[Long]
    },
    ...
]

#### Get user by name
GET /rest/user/{name}
    
Success Response:
Code: 200 
Content:
{
     "id": [long],
     "name":[String],
     "password":[Long]
}


### Vote

####Create vote

POST /rest/vote
Data Params:
 
{   
     "userId":[Long],
     "menuId":[Long]
}
     
Success Response:
Code: 200 
Content:
 
{
     "id": [long],
     "userId":[Long],
     "menuId":[Long]
}

#### Get vote by id

GET /rest/vote/{id}
    
Success Response:
Code: 200 
Content:
 
{
     "id": [long],
     "userId":[Long],
     "menuId":[Long]
}

#### Update vote by id
  
PUT /rest/vote/{id}
      
Data Params:
 
{   
     "userId":[Long],
     "menuId":[Long]
}
     
Success Response:
Code: 200 
Content:
 
{
     "id": [long],
     "userId":[Long],
     "menuId":[Long]
}

#### Delete vote by id

DELETE /rest/vote/{id}
    
Code: 200 
 
#### Get all votes
 
GET /rest/votes
    
Success Response:
Code: 200 
Content:
[ 
    {
        "id": [long],    
        "userId":[Long],
        "menuId":[Long]
    },
    ...
]

#### Cast vote for menu id for current user
POST /rest/castvote/menu/{menuId}
    
Success Response:
Code: 200 
Content:
{
    "id": [long],    
    "userId":[Long],
    "menuId":[Long]
}



