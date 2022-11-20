package com.lqs.demo.Listen;
import love.forte.simboot.annotation.Filter;
import love.forte.simboot.annotation.FilterValue;
import love.forte.simboot.annotation.Listener;
import love.forte.simboot.filter.MatchType;
import love.forte.simbot.event.GroupEvent;
import love.forte.simbot.event.MessageEvent;
import love.forte.simbot.message.AtAll;
import love.forte.simbot.message.Messages;
import love.forte.simbot.message.Text;
import org.springframework.stereotype.Component;

@Component
public class GroupListener {
//    @OnGroup
//    @Filter(value = "/头衔 {{specialTitle}}",matchType = MatchType.REGEX_MATCHES)
//    public void setGroupMemberSpecialTitle(Sender sender, Setter setter, GroupMsg groupMsg, @FilterValue("specialTitle")String specialTitle){
//        System.out.println(groupMsg.getMsg());
//        AccountInfo accountInfo = groupMsg.getAccountInfo();
//        Carrier<String> result = setter.setGroupMemberSpecialTitle(groupMsg.getGroupInfo().getGroupCode(),accountInfo.getAccountCode(),specialTitle);
//
//        sender.sendGroupMsg(groupMsg,"[CAT:quote]头衔 "+specialTitle+" 拿好哦");
//    }
    @Listener
    @Filter(value = "/头衔 {{specialTitle}}",matchType = MatchType.REGEX_MATCHES)
    public void setGroupMemberSpecialTitle(GroupEvent groupEvent, MessageEvent msgEvent, @FilterValue("specialTitle")String specialTitle){
        msgEvent.replyBlocking( " 头衔 "+specialTitle+" 拿好哦");
//        groupEvent.getGroup().sendBlocking("123");
    }
}
