package com.lqs.demo.Listen;

import love.forte.simbot.Identifies;
import love.forte.simbot.bot.BotManager;
import love.forte.simbot.bot.OriginBotManager;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
@Component
public class StartupRunner implements CommandLineRunner, DisposableBean {
    final OriginBotManager manager = OriginBotManager.INSTANCE;
    private static String dateTime;
    @Override
    public void run(String... args) {
        dateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
        manager.getBot(Identifies.ID("2671430291"))
                .getGroup(Identifies.ID("811077857"))
                .sendBlocking("启动成功，启动时间:"+dateTime);
    }

    @Override
    public void destroy() throws Exception {

    }
}
