package com.example.texteditor;

import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;

public class editorConfig {

    private int fontSize;
    private String fontFamily;
    private boolean useLigatures;
    private String theme;

    private int codeFontSize;
    private String codeFontFamily;
    private boolean codeUseLigatures;
    private String codeTheme;

    public editorConfig() {
        try (InputStream inputStream = Objects.requireNonNull(MainApplication.class.getResource("config.yaml")).openStream()) {
            Yaml yaml = new Yaml();
            Map<String, Object> data = yaml.load(inputStream);
            this.fontSize = (int) data.get("fontSize");
            this.fontFamily = (String) data.get("fontFamily");
            this.useLigatures = (boolean) data.get("useLigatures");
            this.theme = (String) data.get("theme");
            this.codeFontSize = (int) data.get("codeFontSize");
            this.codeFontFamily = (String) data.get("codeFontFamily");
            this.codeUseLigatures = (boolean) data.get("codeUseLigatures");
            this.codeTheme = (String) data.get("codeTheme");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getFontSize() {
        return fontSize;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public boolean isUseLigatures() {
        return useLigatures;
    }

    public String getTheme() {
        return theme;
    }

    public int getCodeFontSize() {
        return codeFontSize;
    }

    public String getCodeFontFamily() {
        return codeFontFamily;
    }

    public boolean isCodeUseLigatures() {
        return codeUseLigatures;
    }

    public String getCodeTheme() {
        return codeTheme;
    }
}
