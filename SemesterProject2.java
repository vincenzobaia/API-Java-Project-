package MethodsWeek4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class SemesterProject2 {
    private SemesterProject semesterProject;
    
    private static final Logger logger = LogManager.getLogger(SemesterProject2.class);
    
    public SemesterProject2() {
        this.semesterProject = new SemesterProject();
    }

    public void displayStudentInfo() {//Method to display the top students 
        try {
            int[] studentIds = semesterProject.getStudentId();
            String[] firstNames = semesterProject.getFirstName();
            String[] lastNames = semesterProject.getLastName();
            int[] scienceScores = semesterProject.getScienceScore();
            int[] historyScores = semesterProject.getHistoryScore();
            int[] mathematicsScores = semesterProject.getMathematicsScore();
            int[] englishScores = semesterProject.getEnglishScore();

            int numberOfStudents = studentIds.length;
            double[] totalScores = new double[numberOfStudents];
            double[] percentages = new double[numberOfStudents];

            for (int i = 0; i < numberOfStudents; i++) {
                totalScores[i] = scienceScores[i] + historyScores[i] + mathematicsScores[i] + englishScores[i];
                percentages[i] = (totalScores[i] / 400) * 100;
            }

            System.out.println("Student ID\tFirst Name\tLast Name\tTotal Score\tPercentage");
            //Loops through to display students Ids, names, and total score   
            for (int i = 0; i < numberOfStudents; i++) {
                System.out.println(studentIds[i] + "\t\t" + firstNames[i] + "\t\t" + lastNames[i] + "\t\t" + totalScores[i] + "\t\t" + String.format("%.2f%%", percentages[i]));
            }
        } catch (Exception e) {//Try and catch for errors
            System.out.println("An error occurred while displaying top students: " + e.getMessage());
        }
    }

    public void findPassFailCount() { //Method to find Pass/fail for each subject 
        try {
            int[] studentIds = semesterProject.getStudentId();
            int[] scienceScores = semesterProject.getScienceScore();
            int[] historyScores = semesterProject.getHistoryScore();
            int[] mathematicsScores = semesterProject.getMathematicsScore();
            int[] englishScores = semesterProject.getEnglishScore();

            int numberOfStudents = studentIds.length;
            double[] totalScores = new double[numberOfStudents];

            for (int i = 0; i < numberOfStudents; i++) {
                totalScores[i] = scienceScores[i] + historyScores[i] + mathematicsScores[i] + englishScores[i];
            }

            double passPercentage = 60.0;
            int passCount = 0;
            for (double score : totalScores) {
                if (score >= passPercentage) {
                    passCount++;
                }
            }
            int failCount = numberOfStudents - passCount;
            System.out.println("Pass count: " + passCount + ", Fail count: " + failCount);
        } catch (Exception e) {//Try and catch for errors 
            System.out.println("An error occurred while finding pass/fail count: " + e.getMessage());
        }
    }

    public void findSubjectFailCount() {//Method to find amount of people who failed in each subject 
        try {
            int[] studentIds = semesterProject.getStudentId();
            int[] scienceScores = semesterProject.getScienceScore();
            int[] historyScores = semesterProject.getHistoryScore();
            int[] mathematicsScores = semesterProject.getMathematicsScore();
            int[] englishScores = semesterProject.getEnglishScore();

            int passPercentage = 60;
            int scienceFailCount = 0, historyFailCount = 0, mathematicsFailCount = 0, englishFailCount = 0;
            for (int i = 0; i < studentIds.length; i++) {
                if (scienceScores[i] < passPercentage) {
                    scienceFailCount++;
                }
                if (historyScores[i] < passPercentage) {
                    historyFailCount++;
                }
                if (mathematicsScores[i] < passPercentage) {
                    mathematicsFailCount++;
                }
                if (englishScores[i] < passPercentage) {
                    englishFailCount++;
                }
            }
            System.out.println("Failed in Science: " + scienceFailCount + ", History: " + historyFailCount + ", Mathematics: " + mathematicsFailCount + ", English: " + englishFailCount);
        } catch (Exception e) {//Try and catch for errors
            System.out.println("An error occurred while finding subject fail count: " + e.getMessage());
        }
    }

    public void findPassPercentage() {//Method to find amount of students who passed in each subject 
        try {
            int[] studentIds = semesterProject.getStudentId();
            int[] scienceScores = semesterProject.getScienceScore();
            int[] historyScores = semesterProject.getHistoryScore();
            int[] mathematicsScores = semesterProject.getMathematicsScore();
            int[] englishScores = semesterProject.getEnglishScore();

            int passPercentage = 60;
            int numberOfStudents = studentIds.length;
            double sciencePassPercentage = 0, historyPassPercentage = 0, mathematicsPassPercentage = 0, englishPassPercentage = 0;

            if (numberOfStudents > 0) {
                int sciencePassCount = 0, historyPassCount = 0, mathematicsPassCount = 0, englishPassCount = 0;
                for (int i = 0; i < numberOfStudents; i++) {
                    if (scienceScores[i] >= passPercentage) {
                        sciencePassCount++;
                    }
                    if (historyScores[i] >= passPercentage) {
                        historyPassCount++;
                    }
                    if (mathematicsScores[i] >= passPercentage) {
                        mathematicsPassCount++;
                    }
                    if (englishScores[i] >= passPercentage) {
                        englishPassCount++;
                    }
                }

                sciencePassPercentage = (double) sciencePassCount / numberOfStudents * 100;
                historyPassPercentage = (double) historyPassCount / numberOfStudents * 100;
                mathematicsPassPercentage = (double) mathematicsPassCount / numberOfStudents * 100;
                englishPassPercentage = (double) englishPassCount / numberOfStudents * 100;
            }
            System.out.println("Pass percentage in Science: " + sciencePassPercentage + "%, History: " + historyPassPercentage + "%, Mathematics: " + mathematicsPassPercentage + "%, English: " + englishPassPercentage + "%");
        } catch (Exception e) {//Try and catch for errors
            System.out.println("An error occurred while finding pass percentage: " + e.getMessage());
        }
    }

    public void findFailedMoreThanTwoSubjects() {//Method to find students who failed more than 2 subjects 
        try {
            int[] studentIds = semesterProject.getStudentId();
            int[] scienceScores = semesterProject.getScienceScore();
            int[] historyScores = semesterProject.getHistoryScore();
            int[] mathematicsScores = semesterProject.getMathematicsScore();
            int[] englishScores = semesterProject.getEnglishScore();

            int passPercentage = 60;
            int failedMoreThanTwoSubjects = 0;

            for (int i = 0; i < studentIds.length; i++) {
                int count = 0;
                if (scienceScores[i] < passPercentage) {
                    count++;
                }
                if (historyScores[i] < passPercentage) {
                    count++;
                }
                if (mathematicsScores[i] < passPercentage) {
                    count++;
                }
                if (englishScores[i] < passPercentage) {
                    count++;
                }
                if (count > 2) {
                    failedMoreThanTwoSubjects++;
                }
            }
            System.out.println("Number of students who failed in more than 2 subjects: " + failedMoreThanTwoSubjects);
        } catch (Exception e) {//Try and catch for errors
            System.out.println("An error occurred while finding failed more than two subjects: " + e.getMessage());
        }
    }
    public void displayTopStudentsInEachClass() {//Method for top 10 students in each class 
        try {
            int[] studentIds = semesterProject.getStudentId();
            String[] firstNames = semesterProject.getFirstName();
            String[] lastNames = semesterProject.getLastName();
            int[] scienceScores = semesterProject.getScienceScore();
            int[] historyScores = semesterProject.getHistoryScore();
            int[] mathematicsScores = semesterProject.getMathematicsScore();
            int[] englishScores = semesterProject.getEnglishScore();

            // Display top 10 students in each class
            displayTopStudents("Science", studentIds, firstNames, lastNames, scienceScores);
            System.out.println("**********");
            displayTopStudents("History", studentIds, firstNames, lastNames, historyScores);
            System.out.println("**********");
            displayTopStudents("Mathematics", studentIds, firstNames, lastNames, mathematicsScores);
            System.out.println("**********");
            displayTopStudents("English", studentIds, firstNames, lastNames, englishScores);
        } catch (Exception e) {
            System.out.println("An error occurred while displaying top students in each class: " + e.getMessage());
        }
    }
    private void displayTopStudents(String className, int[] studentIds, String[] firstNames, String[] lastNames, int[] scores) {
    	//Displays the top 10 students for each specific class/subject within the "displayTopStudentsInEachClass" method
        System.out.println("Top 10 Students in " + className + ":\n");
        System.out.println("Student ID\tFirst Name\tLast Name\tTotal Score");
        int count = 0;
        for (int i = 0; i < studentIds.length; i++) {
            if (count >= 10) {
                break;
            }
            if (scores[i] > 0) {
                System.out.println(studentIds[i] + "\t\t" + firstNames[i] + "\t\t" + lastNames[i] + "\t\t" + scores[i]);
                count++;
            }
        }
    }
    public static void main(String[] args) {
        logger.info("Starting application...");
        while(true) {
            try {
                Scanner scanner = new Scanner(System.in);
                SemesterProject2 semesterProject2 = new SemesterProject2();

                System.out.println("Welcome to the Program");

                while (true) {
                    System.out.println("\nSelect an option:");
                    System.out.println("1. Display details of all students");
                    System.out.println("2. Display top students in each class");
                    System.out.println("3. Find the number of students who passed and failed");
                    System.out.println("4. Find the number of students who failed in each subject");
                    System.out.println("5. Find the pass percentage of students in each subject");
                    System.out.println("6. Find the number of students who failed in more than 2 subjects");
                    System.out.println("0. Exit");

                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 0:
                            System.out.println("Exiting Program...");
                            return;
                        case 1:
                            semesterProject2.displayStudentInfo();
                            break;
                        case 2:
                            semesterProject2.displayTopStudentsInEachClass();
                            break;
                        case 3:
                            semesterProject2.findPassFailCount();
                            break;
                        case 4:
                            semesterProject2.findSubjectFailCount();
                            break;
                        case 5:
                            semesterProject2.findPassPercentage();
                            break;
                        case 6:
                            semesterProject2.findFailedMoreThanTwoSubjects();
                            break;
                        default:
                            System.out.println("Invalid choice!");
                            break;
                    }
                }

            } catch (Exception e) {
                System.out.println("Please enter a valid integer: " + e.getMessage());
            }
        }
    }
}