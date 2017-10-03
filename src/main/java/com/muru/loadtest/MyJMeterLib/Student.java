package main.java.com.muru.loadtest.MyJMeterLib;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;

/**
 * Created by muru on Oct-02-17.
 */
public class Student implements Serializable {

    private static final Logger logger = LogManager.getLogger(Student.class);

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    private String studentname;

    public Student() {
    }

    public Student(String studentname) {
        logger.info("New student construction....");
        this.studentname = studentname;
    }
}
