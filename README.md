# MongoDbAssignment
Mongo Db crud Operation


 Task2:
 Using SaveAll is better than saving via multiple thread in terms of performance. 
 Primary reason is creating multiple thread to save multiple documents creats overhead on database since everytime we create thread and save using it a connection is established  to database and which is not good in terms of costs memory wise, locking wise and so on. Uisng Multiple threads is like wasting resources insteada  single transaction can do the same thing of saving multiple documents 
