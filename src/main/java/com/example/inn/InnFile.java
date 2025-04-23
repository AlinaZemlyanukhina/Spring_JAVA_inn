package com.example.inn;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InnFile {
    public String extractInnFromFile(String filePath) {
        StringBuilder result = new StringBuilder();
        try (InputStream input = new FileInputStream(filePath)) {
            BodyContentHandler handler = new BodyContentHandler();
            Parser parser = new TikaConfig().getParser();
            ParseContext context = new ParseContext();

            // Парсинг файла
            parser.parse(input, handler, new Metadata(), context);
            String content = handler.toString();

            // Регулярное выражение для поиска ИНН
            String innPattern = "\\b\\d{10}\\b|\\b\\d{12}\\b"; // ИНН может быть 10 или 12 цифр
            Pattern pattern = Pattern.compile(innPattern);
            Matcher matcher = pattern.matcher(content);

            // Сбор найденных ИНН
            List<String> foundInns = new ArrayList<>();
            while (matcher.find()) {
                foundInns.add(matcher.group());
            }

            // Формирование результата
            if (foundInns.isEmpty()) {
                result.append("ИНН не найден.");
            } else {
                result.append("Найденные ИНН: ").append(String.join(", ", foundInns));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Ошибка при обработке файла: " + e.getMessage();
        }
        return result.toString();
    }
}

