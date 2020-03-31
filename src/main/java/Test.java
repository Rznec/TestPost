import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class Test {

    //Новый тест, создавался через Import -> Paste Raw Text
    @org.junit.jupiter.api.Test
    public void test() {
        try {
            HttpResponse<JsonNode> response
                    = Unirest.post("https://gorest.co.in/public-api/users")
                    .header("Authorization", "Bearer sCdldrtCSsvAoaKG6FPZ4MQPYB1lua5ZFzbx")
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .body("{\"first_name\":\"Ivan\",\"last_name\":\"Ivanov\",\"gender\":\"male\",\"email\":\"ivanov@rzn.com\",\"status\":\"active\"}")
                    //Оставил, т.к. сначала не разобрался и делал так, из-за чего не работало, и я решил сделать на REST-assured.
                    //Правда и там не очень получалось. В итоге доделал Unirest.
//                    .queryString("first_name", "Ivan")
//                    .queryString("last_name", "Ivanov")
//                    .queryString("gender", "male")
//                    .queryString("email", "ivanov@rzn.com")
//                    .queryString("status", "active")
                    .asJson();
            Assertions.assertEquals(200, response.getStatus());
            System.out.println(response.getBody());
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
    //Тест из предыдущего задания, создавался через Body -> form-data
    //СОВСЕМ НЕ понимаю что не так. Ссылку разбивал на части, пробовал queryParam, ставил groovy, но безуспешно.
    @org.junit.jupiter.api.Test
    public void test1() {
         Response response = RestAssured.given()
                .header("Authorization", "Bearer F_P4kqdHgfFtNpvQ4lCG_l34KAbgFXqbljvY")
                .param("first_name", "Vasya")
                .param("last_name", "Pupkin")
                .param("gender", "male")
                .param("email", "gamazrzn@gmail.com")
                .param("status", "active")
                .post("https://gorest.co.in/public-api/users");
          Assertions.assertEquals(200, response.getStatusCode());
          response.getBody().prettyPrint();
    }
}

