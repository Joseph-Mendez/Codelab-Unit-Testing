package org.adaschool.Weather.controller;

import org.adaschool.Weather.data.WeatherReport;
import org.adaschool.Weather.service.WeatherReportService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class WeatherReportControllerTest {

    @Mock
    private WeatherReportService weatherReportService;

    @InjectMocks
    private WeatherReportController weatherReportController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetWeatherReport() {
        // Arrange
        double latitude = 37.8267;
        double longitude = -122.4233;
        WeatherReport mockWeatherReport = new WeatherReport(); // Ajusta esto según la implementación de WeatherReport
        mockWeatherReport.setTemperature(15.0); // Ajusta esto según la implementación de WeatherReport

        when(weatherReportService.getWeatherReport(latitude, longitude)).thenReturn(mockWeatherReport);

        // Act
        WeatherReport result = weatherReportController.getWeatherReport(latitude, longitude);

        // Assert
        assertEquals(mockWeatherReport, result);
        assertEquals(15.0, result.getTemperature()); // Ajusta esto según la implementación de WeatherReport
    }
}
