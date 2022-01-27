import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;


import java.util.Arrays;
import java.util.stream.Stream;

import static ru.netology.geo.GeoServiceImpl.*;


public class MockTests {
    // проверка адреса
    @ParameterizedTest
    @MethodSource("sourse")
    public void GeoServiceImplTest(String x,Location original){
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location result =  geoService.byIp(x);


     Assertions.assertEquals(original,result);

    }

    public static Stream<Arguments> sourse(){
        return Stream.of(Arguments.of(LOCALHOST,new Location(null, null, null, 0)),
                Arguments.of(MOSCOW_IP,new Location("Moscow", Country.RUSSIA, "Lenina", 15)),
                Arguments.of(NEW_YORK_IP,new Location("New York", Country.USA, " 10th Avenue", 32)),
                Arguments.of("172.32.01.2",new Location("Moscow", Country.RUSSIA, null, 0)));
    }

}
