import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.stream.Stream;

import static ru.netology.entity.Country.*;

public class LocalizationServiceImplTests {


    @ParameterizedTest
    @MethodSource("sourse")
    public void localTest(Country x, String original){
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String result = localizationService.locale(x);
        Assertions.assertEquals(original,result);
    }

    public static Stream<Arguments> sourse(){
        return Stream.of(Arguments.of(RUSSIA,"Добро пожаловать"),
                Arguments.of(USA,"Welcome"),
                Arguments.of(GERMANY,"Welcome"),
                Arguments.of(BRAZIL,"Welcome"));
    }
}
