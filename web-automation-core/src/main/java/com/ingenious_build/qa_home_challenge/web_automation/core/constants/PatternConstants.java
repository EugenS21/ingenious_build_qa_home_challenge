package com.ingenious_build.qa_home_challenge.web_automation.core.constants;

import lombok.experimental.UtilityClass;

import java.util.regex.Pattern;

@UtilityClass
public class PatternConstants {

    public Pattern LOCATORS_RESOLVER_PATTERN = Pattern.compile("^(ID|XPATH|CLASS_NAME|CSS_SELECTOR|TAG_NAME|LINK_TEXT|NAME|PARTIAL_LINK_TEXT)@(.+)$");

}
