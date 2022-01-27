import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static ru.netology.geo.GeoServiceImpl.*;

public class MessageSenderImplTests {

    @ParameterizedTest
    @MethodSource("sourse")
    public void sendTest(String ip,Location location,Country country,String message){
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(ip))
                .thenReturn(location);

        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(country))
                .thenReturn(message);

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String,String> hashMap = new HashMap<>();
        hashMap.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);

        String result = messageSender.send(hashMap);

        Assertions.assertEquals(message,result);
    }


    public static Stream<Arguments> sourse(){
        return Stream.of(Arguments.of(MOSCOW_IP
                        ,new Location("Moscow", Country.RUSSIA, "Lenina", 15),Country.RUSSIA,"Добро пожаловать"),
                Arguments.of(NEW_YORK_IP,new Location("New York", Country.USA, " 10th Avenue", 32),Country.USA,"Welcome"));
    }
}
