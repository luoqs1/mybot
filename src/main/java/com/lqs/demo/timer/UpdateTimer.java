package com.lqs.demo.timer;

import com.lqs.demo.util.FileUtil;
import love.forte.simbot.Identifies;
import love.forte.simbot.bot.OriginBotManager;
import love.forte.simbot.message.AtAll;
import love.forte.simbot.message.Messages;
import love.forte.simbot.message.Text;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class UpdateTimer {

    final OriginBotManager manager = OriginBotManager.INSTANCE;
    String path = "D:\\xszj.txt";

    @Scheduled(fixedRate = 10_000)
    public void task() {
        long start = 0;
        try{
            start = System.currentTimeMillis();
            Document document = Jsoup.connect("https://book.zongheng.com/showchapter/408586.html")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.5112.102 Safari/537.36")
                    .header("Connection", "keep-alive")
                    .timeout(20*1000).get();
            Element element = document.getElementsByClass("vip col-4").last();
            assert element != null;
            String charterName = element.text();
            String updateTime = element.html().split("更新时间：")[1].split("\">")[0];
            String msg = "[CAT:at,all=true]更新了，章节名字："+charterName+"，更新时间："+updateTime;
            String oldName = FileUtil.readText(path);
            if (!charterName.equals(oldName )){
                FileUtil.writeText(path,charterName+"\n",Boolean.TRUE);
                manager.getBot(Identifies.ID("2671430291"))
                        .getGroup(Identifies.ID("595452505"))
                        .sendBlocking(Messages.toMessages(
                                AtAll.INSTANCE,   Text.of("更新了，章节名字："+charterName+"，更新时间："+updateTime))
                        );
            }
        }catch (Exception e){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
            System.out.println(dateFormat.format(System.currentTimeMillis())+":Time is:"+(System.currentTimeMillis()-start) + "ms");
            e.printStackTrace();
        }
    }


}
