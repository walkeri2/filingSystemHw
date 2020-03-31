package com.example.codeclan.fileSystem.components;

import com.example.codeclan.fileSystem.models.File;
import com.example.codeclan.fileSystem.models.Folder;
import com.example.codeclan.fileSystem.models.User;
import com.example.codeclan.fileSystem.repositories.FileRepository;
import com.example.codeclan.fileSystem.repositories.FolderRepository;
import com.example.codeclan.fileSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    FileRepository fileRepository;
    @Autowired
    FolderRepository folderRepository;
    @Autowired
    UserRepository userRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){
        User iain = new User("iain");
        userRepository.save(iain);
        Folder codeclan = new Folder("codeclan", iain);
        folderRepository.save(codeclan);

        File homework = new File("file lab", 10, codeclan);
        fileRepository.save(homework);



        iain.addFolder(codeclan);
        userRepository.save(iain);

        codeclan.addFile(homework);
        folderRepository.save(codeclan);




    }
}
