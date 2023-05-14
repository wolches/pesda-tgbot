package io.github.wolches.tgbot.alkach.message.text;

import io.github.wolches.tgbot.alkach.persistence.model.chat.Chat;
import io.github.wolches.tgbot.alkach.persistence.model.chat.ChatUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.telegram.telegrambots.meta.api.objects.Message;

@Service
@RequiredArgsConstructor
public class PesdaTextService implements TextMessageProcessingService {

    private static final String YES_REGEXP = "^([Дд][Аа]([.?!])*)$";
    private static final String PESDA = "Пизда.";

    @Override
    public boolean isApplicableInternal(Message message, Chat chat, ChatUser user) {
        return isYes(message.getText());
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public String processMessageInternal(Message message, Chat chat, ChatUser user) {
        return PESDA;
    }

    private boolean isYes(String text) {
        return text.equalsIgnoreCase("да") || text.matches(YES_REGEXP);
    }
}
