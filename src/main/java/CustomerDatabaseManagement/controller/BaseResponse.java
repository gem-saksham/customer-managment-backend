package CustomerDatabaseManagement.controller;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;




@Getter
@Setter
@AllArgsConstructor
public class BaseResponse {
    private String message;
    private HttpStatus status;
    private Object object;
}
