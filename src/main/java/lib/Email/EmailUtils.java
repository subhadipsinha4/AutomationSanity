package lib.Email;

import lib.UnbxdFileUtils;
import org.testng.Assert;

import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public  class EmailUtils {

    private Folder folder;

    private final static String directorypath=System.getProperty("user.dir")+File.separator+"target"+File.separator+"downloads";

    static{

        try {
            Path path = Paths.get(directorypath);
            Files.createDirectory(path);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public enum EmailFolder {
        INBOX("INBOX"),
        SPAM("SPAM");

        private String text;

        private EmailFolder(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }


    /**
     * Connects to email server with credentials provided to read from a given folder of the email application
     *
     * @param username    Email username (e.g. janedoe@email.com)
     * @param password    Email password
     * @param server      Email server (e.g. smtp.email.com)
     * @param emailFolder Folder in email application to interact with
     */
    public Folder setConnection(String username, String password, String server, EmailFolder emailFolder) throws MessagingException {
        Properties props = System.getProperties();

        props.put("mail.store.protocol", "imaps");
        Session session = Session.getInstance(props);
        Store store = session.getStore("imaps");
        store.connect(server, username, password);


        folder = store.getFolder(emailFolder.getText());
        return folder;

    }

    public List<File> downloadFileAttachement(Message message) {

        List<File> files=new ArrayList<>();

        try {

            String contentType = message.getContentType();
            if(contentType.contains("multipart")) {

                Multipart multipart=(Multipart)message.getContent();
                int numberOfParts=multipart.getCount();
                for(int partCount=0;partCount<numberOfParts;partCount++){

                    MimeBodyPart part= (MimeBodyPart) multipart.getBodyPart(partCount);
                        if(part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())){

                            String fileName=directorypath+File.separator+part.getFileName().replace("/","");
                            Assert.assertTrue(UnbxdFileUtils.createFile(fileName));
                            part.saveFile(fileName);
                            files.add(new File(fileName));
                        }
                }
            }
        }
        catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return files;
    }
}
