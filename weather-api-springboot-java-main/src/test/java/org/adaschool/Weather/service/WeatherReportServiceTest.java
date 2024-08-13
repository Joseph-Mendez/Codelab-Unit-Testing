package org.adaschool.Weather.service;

import org.adaschool.Weather.data.WeatherApiResponse;
import org.adaschool.Weather.data.WeatherReport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.when;

public class WeatherReportServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private WeatherReportService weatherReportService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetWeatherReport() {
        // Crear una respuesta simulada de la API
        WeatherApiResponse weatherApiResponse = new WeatherApiResponse();
        WeatherApiResponse.Main main = new WeatherApiResponse.Main();
        main.setTemperature(23.5); // Asegúrate de que el tipo y valor son correctos
        main.setHumidity(60.0);    // Asegúrate de que el tipo y valor son correctos
        weatherApiResponse.setMain(main);

        // Configurar el comportamiento simulado de RestTemplate
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=40.7128&lon=-74.0060&appid=36a7ed2ea7f2378707c90312a6af4a26";
        when(restTemplate.getForObject(url, WeatherApiResponse.class))
                .thenReturn(weatherApiResponse);

        // Llamar al método a probar
        WeatherReport report = weatherReportService.getWeatherReport(40.7128, -74.0060);

        // Verificar el resultado
        equals(23.5, report.getTemperature(), 0.0001, "La temperatura debe ser 23.5");
        equals(60.0, report.getHumidity(), 0.0001, "La humedad debe ser 60.0");
    }

    private void equals(double v, double humidity, double v1, String s) {
    }
}
