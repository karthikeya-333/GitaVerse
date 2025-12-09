package com.BG.gitaverse;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DailyEmailScheduler {


    private final EmailService emailService;
    private final UserRepository userRepository;
    private final ShlokaService shlokaService;

    public DailyEmailScheduler(EmailService emailService, UserRepository userRepository, ShlokaService shlokaService) {
        this.emailService = emailService;
        this.userRepository = userRepository;
        this.shlokaService = shlokaService;
    }

    public void sendDailyEmail() {

        List<User> users = userRepository.findAll();

        for(User user: users){

            if(!user.isActive()) continue;

            ShlokaDTO dto = shlokaService.getShloka(user.getCurrentChapter(), user.getCurrentVerse());

            String html = """
    <div style="font-family: Arial, sans-serif; line-height: 1.6; padding: 15px;">
        
        <h2 style="color:#2c3e50;">📖 Bhagavad Gita – Daily Shloka</h2>

        <h3 style="color:#34495e;">Chapter %d, Verse %d</h3>

        <p style="font-size: 18px;">
            <b>%s</b>
        </p>

        <h3 style="color:#2c3e50;">English Translation:</h3>
        <p>%s</p>

        <h3 style="color:#2c3e50;">Telugu Translation:</h3>
        <p>%s</p>

        <hr style="margin-top:20px;">
        <p style="font-size: 12px; color: gray;">
            You are receiving this shloka because you subscribed to Gita Daily.
        </p>

    </div>
    """
                    .formatted(
                            dto.getChapter(),
                            dto.getVerse(),
                            dto.getShlokaText(),
                            dto.getEnglishTranslation(),
                            dto.getTeluguTranslation()
                    );

            emailService.sendEmail(
                    user.getEmail(),
                    "Your Daily Bhagavad Gita Shloka",
                    html
            );
            updateNextShloka(user);
        }
        userRepository.saveAll(users);
    }

    void updateNextShloka(User user){
        int ch = user.getCurrentChapter();
        int v = user.getCurrentVerse();

        int maxVerses = ChapterInfo.VERSES[ch];

        if(ch==18 && v==maxVerses){
            user.setCurrentChapter(1);
            user.setCurrentVerse(1);
        }
        else if(v==maxVerses){
            user.setCurrentChapter(ch+1);
            user.setCurrentVerse(1);
        }
        else{
            user.setCurrentVerse(v+1);
        }

    }

}

