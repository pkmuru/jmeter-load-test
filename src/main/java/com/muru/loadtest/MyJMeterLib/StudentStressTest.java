package main.java.com.muru.loadtest.MyJMeterLib;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.threads.JMeterContextService;
import org.apache.jmeter.threads.JMeterVariables;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by muru on Oct-02-17.
 */
public class StudentStressTest extends AbstractJavaSamplerClient {
    private static final Logger LOGGER = LogManager.getLogger(StudentStressTest.class);

    private Map<String, String> mapParams = new HashMap<String, String>();

    @Override
    public void setupTest(JavaSamplerContext context) {
        for (Iterator<String> it = context.getParameterNamesIterator(); it.hasNext(); ) {
            String paramName = it.next();
            mapParams.put(paramName, context.getParameter(paramName));
        }
    }

    @Override
    public Arguments getDefaultParameters() {
        Arguments params = new Arguments();

        params.addArgument("name", "edw");

        return params;
    }

    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        SampleResult result = new SampleResult();

        String paramData = mapParams.get("name");


        try {


            JMeterVariables vars = JMeterContextService.getContext().getVariables();
            vars.put("demo", "demoVariableContent");

            result.sampleStart();


            SampleResult childResult = new SampleResult();
            childResult.sampleStart();
            childResult.setSampleLabel("Make Call took 2 seconds --> " + paramData);

            childResult.sampleEnd();
            result.addSubResult(childResult);
            childResult.setSuccessful(true);

            childResult = new SampleResult();
            childResult.sampleStart();
            childResult.setSampleLabel("Conference calltook 5 seconds" + paramData);
            childResult.sampleEnd();
            result.addSubResult(childResult);
            childResult.setSuccessful(true);

            Student student = new Student();
            student.setStudentname(mapParams.get("name") + " " + new Date().getTime());

            //Todo: save
            LOGGER.info("Save----> Student " + mapParams.get("name"));

            result.sampleEnd();


            result.setSuccessful(true);
            result.setSampleLabel("SUCCESS: " + student.getStudentname());

        } catch (Throwable e) {
            result.sampleEnd();
            result.setSampleLabel("FAILED: '" + e.getMessage() + "' || " + e.toString());
            result.setSuccessful(false);

            e.printStackTrace();
            System.out.println("\n\n\n");
        }

        return result;
    }
}

