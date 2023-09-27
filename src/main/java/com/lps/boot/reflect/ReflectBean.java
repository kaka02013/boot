package com.lps.boot.reflect;

public class ReflectBean {
    private String ClassName;
    private String MethodName;

    public ReflectBean() {
    }

    public ReflectBean(String className, String methodName) {
        this.ClassName = className;
        this.MethodName = methodName;
    }

    public String getClassName() {
        return this.ClassName;
    }

    public void setClassName(String className) {
        this.ClassName = className;
    }

    public String getMethodName() {
        return this.MethodName;
    }

    public void setMethodName(String methodName) {
        this.MethodName = methodName;
    }
}
