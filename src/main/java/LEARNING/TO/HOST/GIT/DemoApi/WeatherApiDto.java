package LEARNING.TO.HOST.GIT.DemoApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// This is the main, top-level class
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherApiDto {

    private LocationDto location;
    private CurrentWeatherDto current;

    // Getters and Setters for main class
    public LocationDto getLocation() {
        return location;
    }
    public void setLocation(LocationDto location) {
        this.location = location;
    }
    public CurrentWeatherDto getCurrent() {
        return current;
    }
    public void setCurrent(CurrentWeatherDto current) {
        this.current = current;
    }

    // ==========================================================
    // NESTED DTO CLASSES
    // ==========================================================

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LocationDto {

        private String name;
        private String region;
        private String country;
        private String localtime;

        // Getters and Setters
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getRegion() {
            return region;
        }
        public void setRegion(String region) {
            this.region = region;
        }
        public String getCountry() {
            return country;
        }
        public void setCountry(String country) {
            this.country = country;
        }
        public String getLocaltime() {
            return localtime;
        }
        public void setLocaltime(String localtime) {
            this.localtime = localtime;
        }
    }

    // ----------------------------------------------------------

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CurrentWeatherDto {

        @JsonProperty("last_updated")
        private String lastUpdated;

        @JsonProperty("temp_c")
        private double tempC;

        @JsonProperty("feelslike_c")
        private double feelslikeC;

        @JsonProperty("is_day")
        private int isDay; // 1 for day, 0 for night

        private ConditionDto condition;

        @JsonProperty("wind_kph")
        private double windKph;

        @Override
		public String toString() {
			return "CurrentWeatherDto [lastUpdated=" + lastUpdated + ", tempC=" + tempC + ", feelslikeC=" + feelslikeC
					+ ", isDay=" + isDay + ", condition=" + condition + ", windKph=" + windKph + ", windDir=" + windDir
					+ ", humidity=" + humidity + "]";
		}
		@JsonProperty("wind_dir")
        private String windDir;

        private int humidity;

        // Getters and Setters
        public String getLastUpdated() {
            return lastUpdated;
        }
        public void setLastUpdated(String lastUpdated) {
            this.lastUpdated = lastUpdated;
        }
        public double getTempC() {
            return tempC;
        }
        public void setTempC(double tempC) {
            this.tempC = tempC;
        }
        public double getFeelslikeC() {
            return feelslikeC;
        }
        public void setFeelslikeC(double feelslikeC) {
            this.feelslikeC = feelslikeC;
        }
        public int getIsDay() {
            return isDay;
        }
        public void setIsDay(int isDay) {
            this.isDay = isDay;
        }
        public ConditionDto getCondition() {
            return condition;
        }
        public void setCondition(ConditionDto condition) {
            this.condition = condition;
        }
        public double getWindKph() {
            return windKph;
        }
        public void setWindKph(double windKph) {
            this.windKph = windKph;
        }
        public String getWindDir() {
            return windDir;
        }
        public void setWindDir(String windDir) {
            this.windDir = windDir;
        }
        public int getHumidity() {
            return humidity;
        }
        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }
    }

    // ----------------------------------------------------------

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ConditionDto {

        private String text;
        private String icon;

        // Getters and Setters
        public String getText() {
            return text;
        }
        public void setText(String text) {
            this.text = text;
        }
        public String getIcon() {
            return icon;
        }
        public void setIcon(String icon) {
            this.icon = icon;
        }
    }
}