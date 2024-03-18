package org.utl.dsm.MongoBlog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Tags {
    JAVA("Java"),
    PHP("PHP"),
    PYTHON("Python"),
    JAVASCRIPT("JavaScript"),
    HTML("HTML"),
    CSS("CSS"),
    PROGRAMMING("Programming"),
    DEVELOPMENT("Development"),
    CODING("Coding"),
    ALGORITHMS("Algorithms"),
    DATABASES("Databases"),
    GIT("Git"),
    VERSION_CONTROL("Version Control"),
    FRONTEND("Frontend"),
    BACKEND("Backend"),
    WEB("Web"),
    MOBILE("Mobile"),
    FRAMEWORKS("Frameworks"),
    LINUX("Linux"),
    SECURITY("Security");

    private final String label;
}
