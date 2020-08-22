package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class Main extends Application {
    private Label titlelb, firstNamelb, lastNameLb, yearlb, monthlb , daylb, outputlb;
    private TextField firsNameTf,lastNameTf, yearTf, monthTf, dayTf;
    private Button calculateHeartBate;
    private VBox root, yearBox, monthBox, dayBox;
    private HBox dateHBox;


    @Override
    public void start(Stage primaryStage) throws Exception{
        titlelb = new Label("Heart Rate Calculator");
        titlelb.setStyle("-fx-font:26px Arial");
        firstNamelb = new Label("First Name");
        lastNameLb = new Label("Last Name");
        yearlb = new Label("Year");
        monthlb = new Label("Month");
        daylb = new Label("Day");
        outputlb = new Label();
        outputlb.setStyle("-fx-font: 24px ArialKhaidjah;  -fx-text-fill : red;");
        firsNameTf = new TextField();
        lastNameTf = new TextField();
        yearTf = new TextField();
        monthTf = new TextField();
        dayTf = new TextField();
        calculateHeartBate = new Button("Calculate Heart Beat");
        yearBox = new VBox();
        yearBox.getChildren().addAll(yearlb, yearTf);
        monthBox = new VBox();
        monthBox.getChildren().addAll(monthlb,monthTf);
        dayBox = new VBox();
        dayBox.getChildren().addAll(daylb, dayTf);
        dateHBox =  new HBox();
        dateHBox.getChildren().addAll(yearBox,monthBox,dayBox);
        dateHBox.setSpacing(20);
        root = new VBox();
        root.getChildren().addAll(titlelb, firstNamelb, firsNameTf, lastNameLb, lastNameTf,dateHBox, calculateHeartBate, outputlb);
        calculateHeartBate.setOnAction(e->{
            int year = Integer.parseInt(yearTf.getText());
            String monthText = monthTf.getText();
            int day = Integer.parseInt(dayTf.getText());
            String fullName = firsNameTf.getText() ;
            String lastName = lastNameTf.getText();
            Month month = getMonth(monthText);
            int ageInYear = getAgeInYears(year, month, day);
            double maximumRate = getHeartRate(ageInYear);
            String targetHearRate = getTargetHeartRate(maximumRate);
            String result;
            result = "Name: " + fullName + "\n" + "Last Name: " + lastName + "\n" +
                    "Age: " + ageInYear + "\n"+ "Target HeartRate: " + targetHearRate + "\n" + "Maximum heart rate : "
            + maximumRate;
            outputlb.setText(result);
        });
        root.setSpacing(20);
        root.setPadding(new Insets(20));
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private int getAgeInYears(int year, Month m,int day) {
        LocalDate today = LocalDate.now();
        LocalDate bd = LocalDate.of(year,m,day);
        Period period = Period.between(bd,today);
        return (period.getYears());
    }

    private Month getMonth(String month){
        Month m;
        if(month.equalsIgnoreCase("January")){
            m = Month.JANUARY;
        }else if(month.equalsIgnoreCase("February")){
            m = Month.FEBRUARY;
        }else if(month.equalsIgnoreCase("March")){
            m = Month.MARCH;
        }else if(month.equalsIgnoreCase("april")){
            m = Month.APRIL;
        }
        else if(month.equalsIgnoreCase("may")){
            m = Month.MAY;
        }
        else if(month.equalsIgnoreCase("june")){
            m = Month.JUNE;
        }
        else if(month.equalsIgnoreCase("July")){
            m = Month.JULY;
        }
        else if(month.equalsIgnoreCase("August")){
            m = Month.AUGUST;
        }
        else if(month.equalsIgnoreCase("September")){
            m = Month.SEPTEMBER;
        }
        else if(month.equalsIgnoreCase("October")){
            m = Month.OCTOBER;
        }
        else if(month.equalsIgnoreCase("NOVEMBER")){
            m = Month.NOVEMBER;
        }
        else if(month.equalsIgnoreCase("DECEMBER")){
            m = Month.DECEMBER;
        }
        else {
            m = Month.JANUARY;
        }
        return m;
    }

    private double getHeartRate(int year){
        return 220- year;
    }

    private String getTargetHeartRate(double heartRate)
    {
        return (int) (heartRate * 0.5 ) + " - " + (heartRate * 0.85 );
    }


    public static void main(String[] args) {
        launch(args);
    }
}
