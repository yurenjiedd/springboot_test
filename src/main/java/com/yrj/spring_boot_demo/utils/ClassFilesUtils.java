package com.yrj.spring_boot_demo.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

/**
 * @类描述@：遍历指定包名下所有的类(支持jar)
 * @Author: 余仁杰
 * @Date: 2020/9/4 15:13
 */
@Slf4j
public class ClassFilesUtils {
    public static void main(String[] args) throws Exception {
        String packageName = "com.yrj.spring_boot_demo.test";

        /*Set<String> classNames = getClassName(packageName, true, ".class");
        if (classNames != null) {
            for (String className : classNames) {
                System.out.println(className);
            }
        }*/


        Set<Class> aClass = getClass(packageName);
        for (Class clazz : aClass) {
            System.err.println(clazz.getName());
        }

    }

    /**
     * 获取指定包下的所有类的class名称
     * @param packageName 包名
     * @return
     */
    public static Set<Class> getClass(String packageName){
        Set<String> className = getClassName(packageName, true, ".class");
        Set<Class> classSet = className.stream().map(s -> {
            try {
                return Class.forName(s.substring(0, s.lastIndexOf(".class")));
            } catch (ClassNotFoundException e) {
                log.error("根据" + s + "转换class异常：", e);
                throw new CustomException("根据" + s + "转换class异常");
            }
        }).collect(Collectors.toSet());

        return classSet;
    }

    /**
     * 获取某包下所有类
     * @param packageName 包名
     * @param isRecursion 是否遍历子包
     * @param suffixstr 后綴名
     * @return 类的完整名称
     */
    public static Set<String> getClassName(String packageName, boolean isRecursion ,String suffixstr) {
        Set<String> classNames = null;
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        String packagePath = packageName.replace(".", "/");

        URL url = loader.getResource(packagePath);
        if (url != null) {
            String protocol = url.getProtocol();
            if (protocol.equals("file")) {
                classNames = getClassNameFromDir(url.getPath(), packageName, isRecursion, suffixstr);
            } else if (protocol.equals("jar")) {
                JarFile jarFile = null;
                try{
                    jarFile = ((JarURLConnection) url.openConnection()).getJarFile();
                } catch(Exception e){
                    e.printStackTrace();
                }

                if(jarFile != null){
                    getClassNameFromJar(jarFile.entries(), packageName, isRecursion);
                }
            }
        } else {
            /*从所有的jar包中查找包名*/
            classNames = getClassNameFromJars(((URLClassLoader)loader).getURLs(), packageName, isRecursion);
        }

        return classNames;
    }

    /**
     * 从项目文件获取某包下所有类
     * @param filePath 文件路径
     * @param packageName 包路径
     * @param isRecursion 是否遍历子包
     * @param suffixstr 後綴名
     * @return 类的完整名称
     */
    private static Set<String> getClassNameFromDir(String filePath, String packageName, boolean isRecursion, String suffixstr) {
        Set<String> className = new HashSet<String>();
        try {
            filePath = java.net.URLDecoder.decode(new String(filePath.getBytes("ISO-8859-1"), "UTF-8"), "UTF-8");
            File file = new File(filePath);
            File[] files = file.listFiles();
            for (File childFile : files) {
                if (childFile.isDirectory()) {
                    if (isRecursion) {
                        className.addAll(getClassNameFromDir(childFile.getPath(), packageName+"."+childFile.getName(), isRecursion, suffixstr));
                    }
                } else {
                    String fileName = childFile.getName();
                    if (fileName.endsWith(suffixstr) && !fileName.contains("$")) {
                        //className.add(fileName);
                        className.add(packageName+ "." + fileName);
                    }
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return className;
    }


    /**
     * @param jarEntries
     * @param packageName
     * @param isRecursion
     * @return
     */
    private static Set<String> getClassNameFromJar(Enumeration<JarEntry> jarEntries, String packageName, boolean isRecursion){
        Set<String> classNames = new HashSet<String>();

        while (jarEntries.hasMoreElements()) {
            JarEntry jarEntry = jarEntries.nextElement();
            if(!jarEntry.isDirectory()){
                /*
                 * 这里是为了方便，先把"/" 转成 "." 再判断 ".class" 的做法可能会有bug
                 * (FIXME: 先把"/" 转成 "." 再判断 ".class" 的做法可能会有bug)
                 */
                String entryName = jarEntry.getName().replace("/", ".");
                if (entryName.endsWith(".class") && !entryName.contains("$") && entryName.startsWith(packageName)) {
                    entryName = entryName.replace(".class", "");
                    if(isRecursion){
                        classNames.add(entryName);
                    } else if(!entryName.replace(packageName+".", "").contains(".")){
                        classNames.add(entryName);
                    }
                }
            }
        }



        return classNames;
    }

    /**
     * 从所有jar中搜索该包，并获取该包下所有类
     * @param urls URL集合
     * @param packageName 包路径
     * @param isRecursion 是否遍历子包
     * @return 类的完整名称
     */
    private static Set<String> getClassNameFromJars(URL[] urls, String packageName, boolean isRecursion) {
        Set<String> classNames = new HashSet<String>();

        for (int i = 0; i < urls.length; i++) {
            String classPath = urls[i].getPath();

            //不必搜索classes文件夹
            if (classPath.endsWith("classes/")) {continue;}

            JarFile jarFile = null;
            try {
                jarFile = new JarFile(classPath.substring(classPath.indexOf("/")));
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (jarFile != null) {
                classNames.addAll(getClassNameFromJar(jarFile.entries(), packageName, isRecursion));
            }
        }

        return classNames;
    }
}
