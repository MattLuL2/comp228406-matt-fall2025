import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class StudentApp extends Application {

    private TextField tfName = new TextField();
    private TextField tfAddress = new TextField();
    private TextField tfCity = new TextField();
    private TextField tfProvince = new TextField();
    private TextField tfPostal = new TextField();
    private TextField tfPhone = new TextField();
    private TextField tfEmail = new TextField();

    private RadioButton rbCS = new RadioButton("Computer Science");
    private RadioButton rbBusiness = new RadioButton("Business");
    private ComboBox<String> cbCourses = new ComboBox<>();
    private ListView<String> lvSelectedCourses = new ListView<>();

    private CheckBox cbActivity1 = new CheckBox("Student Council");
    private CheckBox cbActivity2 = new CheckBox("Volunteer");
    private CheckBox cbActivity3 = new CheckBox("Sports");
    private CheckBox cbActivity4 = new CheckBox("Music/Arts");

    private TextArea taOutput = new TextArea();

    private final ObservableList<String> csCourses = FXCollections.observableArrayList(
            "CS101 - Intro to CS",
            "CS102 - Programming I",
            "CS201 - Data Structures",
            "CS301 - Operating Systems",
            "CS401 - Software Engineering"
    );

    private final ObservableList<String> busCourses = FXCollections.observableArrayList(
            "BUS101 - Intro to Business",
            "BUS201 - Accounting",
            "BUS202 - Marketing",
            "BUS301 - Management",
            "BUS401 - Business Law"
    );

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Student Entry - JavaFX");

        // Form grid
        GridPane form = new GridPane();
        form.setPadding(new Insets(10));
        form.setHgap(8);
        form.setVgap(8);

        form.add(new Label("Full Name:"), 0, 0);
        form.add(tfName, 1, 0);

        form.add(new Label("Address:"), 0, 1);
        form.add(tfAddress, 1, 1);

        form.add(new Label("City:"), 0, 2);
        form.add(tfCity, 1, 2);

        form.add(new Label("Province:"), 0, 3);
        form.add(tfProvince, 1, 3);

        form.add(new Label("Postal Code:"), 0, 4);
        form.add(tfPostal, 1, 4);

        form.add(new Label("Phone:"), 0, 5);
        form.add(tfPhone, 1, 5);

        form.add(new Label("Email:"), 0, 6);
        form.add(tfEmail, 1, 6);

        // Major selection & courses
        ToggleGroup majorGroup = new ToggleGroup();
        rbCS.setToggleGroup(majorGroup);
        rbBusiness.setToggleGroup(majorGroup);

        rbCS.setOnAction(e -> onMajorSelected(true));
        rbBusiness.setOnAction(e -> onMajorSelected(false));

        VBox majorBox = new VBox(8, new Label("Major:"), rbCS, rbBusiness);
        majorBox.setPadding(new Insets(10));

        cbCourses.setPrefWidth(280);
        Button btnAddCourse = new Button("Add Course");
        btnAddCourse.setOnAction(e -> addSelectedCourse());

        VBox courseBox = new VBox(6, new Label("Available courses:"), cbCourses, btnAddCourse,
                new Label("Selected courses:"), lvSelectedCourses);
        courseBox.setPadding(new Insets(10));
        courseBox.setPrefWidth(320);

        // Activities
        VBox activitiesBox = new VBox(6, new Label("Activities:"), cbActivity1, cbActivity2, cbActivity3, cbActivity4);
        activitiesBox.setPadding(new Insets(10));

        // Left area: form
        VBox left = new VBox(10, form, activitiesBox);
        left.setPadding(new Insets(10));

        // Right area: major + courses
        VBox right = new VBox(10, majorBox, courseBox);
        right.setPadding(new Insets(10));

        // Buttons
        Button btnShow = new Button("Show Student Info");
        btnShow.setOnAction(e -> showStudentInfo());

        Button btnClear = new Button("Clear");
        btnClear.setOnAction(e -> clearAll());

        Button btnRemoveCourse = new Button("Remove Course");
        btnRemoveCourse.setOnAction(e -> {
            String sel = lvSelectedCourses.getSelectionModel().getSelectedItem();
            if (sel != null) lvSelectedCourses.getItems().remove(sel);
        });

        Button btnExit = new Button("Exit");
        btnExit.setOnAction(e -> primaryStage.close());

        HBox buttons = new HBox(8, btnShow, btnClear, btnRemoveCourse, btnExit);
        buttons.setAlignment(Pos.CENTER);
        buttons.setPadding(new Insets(10));

        taOutput.setPrefRowCount(10);
        taOutput.setWrapText(true);

        BorderPane root = new BorderPane();
        HBox center = new HBox(12, left, right);
        center.setPadding(new Insets(10));
        root.setCenter(center);
        root.setBottom(new VBox(buttons, taOutput));

        // Default selections
        rbCS.setSelected(true);
        onMajorSelected(true);

        Scene scene = new Scene(root, 900, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void onMajorSelected(boolean csSelected) {
        if (csSelected) {
            cbCourses.setItems(csCourses);
        } else {
            cbCourses.setItems(busCourses);
        }
        cbCourses.getSelectionModel().selectFirst();
        lvSelectedCourses.getItems().clear();
    }

    private void addSelectedCourse() {
        String course = cbCourses.getSelectionModel().getSelectedItem();
        if (course == null || course.trim().isEmpty()) return;
        if (!lvSelectedCourses.getItems().contains(course)) {
            lvSelectedCourses.getItems().add(course);
        } else {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Duplicate course");
            a.setHeaderText(null);
            a.setContentText("This course is already added.");
            a.showAndWait();
        }
    }

    private void showStudentInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Full name: ").append(tfName.getText()).append('\n');
        sb.append("Address: ").append(tfAddress.getText()).append('\n');
        sb.append("City: ").append(tfCity.getText()).append('\n');
        sb.append("Province: ").append(tfProvince.getText()).append('\n');
        sb.append("Postal Code: ").append(tfPostal.getText()).append('\n');
        sb.append("Phone: ").append(tfPhone.getText()).append('\n');
        sb.append("Email: ").append(tfEmail.getText()).append('\n');

        sb.append("Major: ");
        if (rbCS.isSelected()) sb.append("Computer Science"); else sb.append("Business");
        sb.append('\n');

        sb.append("Courses:\n");
        for (String c : lvSelectedCourses.getItems()) {
            sb.append(" - ").append(c).append('\n');
        }

        sb.append("Activities: ");
        boolean anyAct = false;
        if (cbActivity1.isSelected()) { sb.append(cbActivity1.getText()); anyAct = true; }
        if (cbActivity2.isSelected()) { if (anyAct) sb.append(", "); sb.append(cbActivity2.getText()); anyAct = true; }
        if (cbActivity3.isSelected()) { if (anyAct) sb.append(", "); sb.append(cbActivity3.getText()); anyAct = true; }
        if (cbActivity4.isSelected()) { if (anyAct) sb.append(", "); sb.append(cbActivity4.getText()); anyAct = true; }
        if (!anyAct) sb.append("None");
        sb.append('\n');

        taOutput.setText(sb.toString());
    }

    private void clearAll() {
        tfName.clear();
        tfAddress.clear();
        tfCity.clear();
        tfProvince.clear();
        tfPostal.clear();
        tfPhone.clear();
        tfEmail.clear();
        lvSelectedCourses.getItems().clear();
        cbActivity1.setSelected(false);
        cbActivity2.setSelected(false);
        cbActivity3.setSelected(false);
        cbActivity4.setSelected(false);
        taOutput.clear();
        rbCS.setSelected(true);
        onMajorSelected(true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
