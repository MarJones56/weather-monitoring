package edu.iu.habahram.weathermonitoring.model;

import org.springframework.stereotype.Component;

@Component
public class StatisticsDisplay
    implements Observer, DisplayElement{

        private float temperature;
        private float humidity;
        private float pressure;

        private Subject weatherData;

            public StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
    }

        @Override
    public String display() {
        String html = "";
        html += String.format("<div style=\"background-image: " +
                "url(/images/sky.webp); " +
                "height: 400px; " +
                "width: 647.2px;" +
                "display:flex;flex-wrap:wrap;justify-content:center;align-content:center;" +
                "\">");
        html += "<section>";
        html += String.format("<h1>Weather Stats</h1><br />");
        html += String.format("<label>Avg. temp: %s</label><br />", temperature);
        html += String.format("<label>Min. temp: %s</label><br />", humidity);
        html += String.format("<label>Max temp: %s</label>", pressure);
        html += "</section>";
        html += "</div>";
        return html;
    }

    @Override
    public String name() {
        return "Weather Stats";
    }

    @Override
    public String id() {
        return "weather-stats";
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
         this.temperature = temperature;
         this.humidity = humidity;
         this.pressure = pressure;
    }

    public void subscribe() {
        weatherData.registerObserver(this);
    }

    public void unsubscribe() {
        weatherData.removeObserver(this);
    }
    }