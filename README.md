### 일정 API 설계
<div style="overflow-x: auto;">
  
|**기능**            |**Method** |**URL**               |**request**                            |**response**                                     |**상태코드**  |
|--------------------|-----------|----------------------|---------------------------------------|-------------------------------------------------|--------------|
|일정 생성            |`POST`     |`/api/schedules`      |`{"title" : String, "task" : String}`  |`{"id":Long, "title" : String, "task" : String}`  |`200 ok`      |
|일정 전체 조회       |`GET`      |`/api/schedules`      |없음                                   |`[{"id":Long, "title" : String, "task" : String}]` |`200 ok`       |
|일정 단건 조회       |`GET`      |`/api/schedules/{id}` |없음                                   |`{"id":Long, "title" : String, "task" : String}`  |`200 ok`       |
|일정 단건 수정       |`PUT`      |`/api/schedules/{id}` |`{"title" : String, "task" : String}`  |`{"id":Long, "title" : String, "task" : String}`  |`200 ok`       |
|일정 삭제            |`DELETE`   |`/api/schedules/{id}` |없음                                  |없음                                               |`200 ok`      |

</div>

<div style="overflow-x: auto;">

### 유저 API 설계
|**기능**       |**Method** |**URL**             |**request**                                                |**response**                                          |**상태코드**  |
|---------------|-----------|--------------------|-----------------------------------------------------------|------------------------------------------------------|--------------|
|회원가입        |`POST`     |`/api/users/signup` |`{"name" : "String,"email" : String,"password" : String }` |`{"id" : Long, "name" : "String, "email" : String }`  |`200 ok`      |
|로그인          |`POST`     |`/api/users/login` |`{ "email" : String, "password" : String }`                 |`{"id" : Long, "name" : "String, "email" : String }`  |`200 ok`      |
|유저 전체 조회  |`GET`      |`/api/users`       |없음                                                         |`[{"id" : Long, "name" : "String, "email" : String }]`|`200 ok`      |
|유저 단건 조회  |`GET`      |`/api/users/{id}`  |없음                                                         |`{"id" : Long, "name" : "String, "email" : String }`  |`200 ok`      |
|유저 단건 수정  |`PUT`      |`/api/users/{id}`  |`{"name" : "String, "password" : String }`                  |`{"id" : Long, "name" : "String, "email" : String }`  |`200 ok`       |
|유저 삭제       |`DELETE`   |`/api/users/{id}`  |없음                                                        |없음                                                   |`200 ok`       |

</div>

### SQL

```sql
CREATE TABLE user(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    modified_at TIMESTAMP NOT NULL
);

CREATE TABLE schedule(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL,
    task VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    modified_at TIMESTAMP NOT NULL,
    user_id BIGINT NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES user (id)
);


```
### ERD
![image](https://github.com/user-attachments/assets/064bd9f3-9d4c-4496-9c7d-4d8d72de52e4)


