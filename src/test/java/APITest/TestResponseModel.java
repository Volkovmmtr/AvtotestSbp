package APITest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter   //lombok
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TestResponseModel {
    //Имя переменной должно быть эквивалентно имени ключа JSON файла
    private String value;
}
