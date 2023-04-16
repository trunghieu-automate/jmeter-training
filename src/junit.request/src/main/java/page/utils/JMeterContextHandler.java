package page.utils;

import org.apache.jmeter.samplers.Sampler;
import org.apache.jmeter.threads.JMeterContext;
import org.apache.jmeter.threads.JMeterContextService;
import org.apache.jmeter.threads.JMeterVariables;

import java.sql.Time;
import java.time.LocalTime;

/* Class handle getting current thread's num and Jmeter's variables */
public class JMeterContextHandler {
    private JMeterContextHandler() {
    }
    private static Sampler sampler;
    private static JMeterContext context;
    private static JMeterVariables threadVars;

    private static synchronized void getThreadVariables() {
        if (context != null) {
            threadVars = context.getVariables();
        } else {
            System.out.println("None variable's detected");
        }
    }

    public static synchronized String getVar(String varName) {
        getThreadVariables();
        if (threadVars == null) {
            return "";
        }
        try {
            return threadVars.get(varName);
        } catch (Exception e) {
            e.getMessage();
            return new IllegalArgumentException().toString();
        }
    }

    private static synchronized void getCurrentSamplerContext() {
        if (JMeterContextService.getContext() == null) {
            context = null;
            System.out.println("No Thread's context detected");
        } else {
            context = JMeterContextService.getContext();
            getThreadVariables();
            System.out.println(
                    "Current threadNum: " + getThreadNum() +
                            ", with threadName: " + getThreadName());
        }
    }

    public static synchronized void startThread() {
        try {
            JMeterContextService.startTest();
        } catch (NullPointerException e) {
            e.getMessage();
        }
        getCurrentSamplerContext();
        System.out.println("Thread num : " + getThreadNum() + " start at: " + Time.valueOf(LocalTime.now()));
    }

    public static synchronized void endThread() {
        if (context == null) {
            System.out.println("No context is detected to end");
        } else {
            JMeterContextService.endTest();
            context.cleanAfterSample();
            System.out.println("Thread num: " + getThreadNum() + " end at: " + Time.valueOf(LocalTime.now()));
        }
    }

    private static synchronized String getThreadName() {
        if (threadVars == null) {
            return "";
        }
        try {
            return threadVars.getThreadName();
        } catch (Exception e) {
            return new NullPointerException().getMessage();
        }

    }

    private static synchronized int getThreadNum() {
        if (context == null) {
            return 0;
        }
        try {
            return context.getThreadNum();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }

    private static synchronized void getSampler() {
        if (context == null) {
            System.out.println("Non Thread context detected!");
        } else {
            sampler = context.getCurrentSampler();
        }
    }

    public static synchronized String getSamplerName() {
        getSampler();
        if (sampler.getName() == null) {
            return "No sampler name detected";
        } else {
            return sampler.getName();
        }
    }
}