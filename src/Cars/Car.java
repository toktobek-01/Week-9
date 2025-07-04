package Cars;

public class Car {
        private String model;
        private String color;
        private int year;

        public Car() {};

        public Car(String model, String color, int year){
            this.model = model;
            this.color = color;
            this.year = year;
        }
        public String getModel() { return model;}
        public  String getColor() { return color;}
        public int getYear() { return year; }

    public void setModel(String model) { this.model = model; }
    public void setColor(String color) { this.color = color; }
    public void setYear(int year) { this.year = year; }

}
