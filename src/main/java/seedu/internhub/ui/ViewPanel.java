package seedu.internhub.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.internhub.model.person.Person;

/**
 * A UI component that displays information of a {@code Person}.
 */
public class ViewPanel extends UiPart<Region> {
    private static final String FXML = "ViewPanel.fxml";

    public final Person person;

    @FXML
    private VBox viewPanel;
    @FXML
    private Label companyName;
    @FXML
    private Label jobDescription;
    @FXML
    private Label phone;
    @FXML
    private Label address;
    @FXML
    private Label email;
    @FXML
    private Label tags;
    @FXML
    private Label interviewDate;
    @FXML
    private Label internDuration;
    @FXML
    private Label salary;
    @FXML
    private Label note;

    /**
     * Creates a {@code PersonCode} with the given {@code Person} to display.
     */
    public ViewPanel(Person person) {
        super(FXML);
        this.person = person;
        companyName.setText(person.getCompanyName().fullName);
        jobDescription.setText(person.getJobDescription().value);
        phone.setText(person.getPhone().value);
        address.setText(person.getAddress().value);
        email.setText(person.getEmail().value);
        if ((person.getInterviewDate().toString()).equals("")) {
            interviewDate.setText("Interview Date: -");
        } else {
            interviewDate.setText("Interview Date: " + person.getInterviewDate().toString());
        }
        internDuration.setText(person.getInternDuration().value);
        salary.setText("$" + person.getSalary().value);
        if ((person.getNote().value).equals("")) {
            note.setText("-");
        } else {
            note.setText(person.getNote().value);
        }
        // Tag : use switch case based on the tag name
        switch (person.getTag().getTagShort()) {
            case "NR":
                tags.setStyle(tags.getStyle() + "-fx-background-color: #fdffba"); //yellow
                break;
            case "OA":
                tags.setStyle(tags.getStyle() + "-fx-background-color: #dfbaff"); //purple
                break;
            case "I":
                tags.setStyle(tags.getStyle() + "-fx-background-color: #badaff"); //blue
                break;
            case "R":
                tags.setStyle(tags.getStyle() + "-fx-background-color: #ffbdba"); //red
                break;
            case "O":
                tags.setStyle(tags.getStyle() + "-fx-background-color: #baffdf"); //green
                break;
            default:
                tags.setStyle(tags.getStyle());
                break;
        }
        tags.setText(person.getTag().getTagName());
    }
}
